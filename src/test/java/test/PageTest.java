package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import help.DataHelper;
import org.junit.jupiter.api.Test;
import page.OrderPage;

import static com.codeborne.selenide.Selenide.open;

public class PageTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void shouldAuthorizationIsSuccessful() {
        Configuration.holdBrowserOpen = true;
        val cardInfo = new DataHelper().getValidCardInfo();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getNotificationOk();

    }
    @Test
    void shouldCardInfoWithNameWithoutSpace() {
        Configuration.holdBrowserOpen = true;
        val cardInfo = new DataHelper().getValidCardInfoWithNameWithoutSpace();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getNotificationNo();

    }

}

