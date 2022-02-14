package help;

import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DBHelper {
    private DBHelper() {}

    private static final QueryRunner runner = new QueryRunner();
    private static final Connection conn = connect();

    @SneakyThrows
    public static Connection connect() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app-db", "app", "pass");
    }

    @SneakyThrows
    public static String getCode() {
        return runner.query(conn, "SELECT DISTINCT LAST_VALUE(code) over (ORDER BY created ASC\n" +
                "    RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) FROM auth_codes", new ScalarHandler<>());
    }

    @SneakyThrows
    public static void deleteCode() {
        runner.execute(conn, "DELETE FROM auth_codes WHERE created < NOW() - INTERVAL 0 MINUTE");
        runner.execute(conn, "DELETE FROM card_transactions WHERE created < NOW() - INTERVAL 0 MINUTE");
        runner.execute(conn, "DELETE FROM cards WHERE cards.number IS NOT NULL");
        runner.execute(conn, "DELETE FROM users WHERE login IS NOT NULL");
    }
}
