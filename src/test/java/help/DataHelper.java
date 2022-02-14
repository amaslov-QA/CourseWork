package help;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DataHelper {

    private Faker faker = new Faker();

    private String getValidCardNumber() {
        return "1111 2222 3333 4444";
    }

    private String getInvalidCardNumber() {
        return "5555 6666 7777 8888";
    }


    public String generateMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String date = LocalDate.now().plusMonths(3).format(format);
        return date;
    }

    public String generateYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(3).format(format);
        return date;
    }

    public String generateOwner() {
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        return owner;
    }

    public String generateCVC() {
        return (faker.numerify("###"));
    }

    public String generateOwnerNameWithoutSpace() {
        String owner = faker.name().firstName() + faker.name().lastName();
        return owner;
    }

    public String generateOwnerToUpperCase() {
        String owner = faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase();
        return owner;
    }

    public String generateOwnerToLowerCase() {
        String owner = faker.name().firstName().toLowerCase() + " " + faker.name().lastName().toLowerCase();
        return owner;
    }

    public String generateLastMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String date = LocalDate.now().plusMonths(-3).format(format);
        return date;
    }

    public String generateCurrentMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String date = LocalDate.now().format(format);
        return date;
    }

    public String generateCurrentYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().format(format);
        return date;
    }

    public String generateLastYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(-1).format(format);
        return date;
    }

    public String generateUnrealYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(25).format(format);
        return date;
    }

    public String generatePlusSixYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(6).format(format);
        return date;
    }

    public String generatePlusFiveYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(5).format(format);
        return date;
    }

    public String generatePlusFourYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(4).format(format);
        return date;
    }

    public String generateCVCFourNumbers() {
        return (faker.numerify("####"));
    }

    public String generateCVCTwoNumbers() {
        return (faker.numerify("##"));
    }


    @Value
    public static class CardInfo {
        private String number;
        private String month;
        private String year;
        private String owner;
        private String cvc;

    }

    public CardInfo getValidCardInfo() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), generateOwner(), generateCVC());
    }

    public CardInfo getValidCardInfoWithNameWithoutSpace() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), generateOwnerNameWithoutSpace(), generateCVC());
    }

    public CardInfo getValidCardInfoNameInLatin() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), "Alexander Kerjakov", generateCVC());
    }

    public CardInfo getInvalidCardInfoNameInCyrillic() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), "Салахова Гузель", generateCVC());
    }

    public CardInfo getInvalidCardInfoWithNumbersName() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), "6522224555", generateCVC());
    }

    public CardInfo getInvalidCardInfoWithSpecialName() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), "+*-=№?", generateCVC());
    }

    public CardInfo getInvalidCardInfoWithLatinTwoCharactersName() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), "AN", generateCVC());
    }

    public CardInfo getInvalidCardInfoLastMonth() {
        return new CardInfo(getValidCardNumber(), generateLastMonth(), generateCurrentYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoCurrentMonth() {
        return new CardInfo(getValidCardNumber(), generateCurrentMonth(), generateCurrentYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoNonExistentMonth() {
        return new CardInfo(getValidCardNumber(), "15", generateCurrentYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoMonthWithNonSpecialCharacters() {
        return new CardInfo(getValidCardNumber(), "*/", generateYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoMonthWithAlphabeticCharacters() {
        return new CardInfo(getValidCardNumber(), "cv", generateYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoLastYear() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateLastYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoUnrealYear() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateUnrealYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfo00Year() {
        return new CardInfo(getValidCardNumber(), generateMonth(), "00", generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoNegativeNumberYear() {
        return new CardInfo(getValidCardNumber(), generateMonth(), "-" + generateYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoYearPlusSix() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generatePlusSixYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoYearPlusFive() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generatePlusFiveYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoYearPlusFour() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generatePlusFourYear(), generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoYearWithNonSpecialCharacters() {
        return new CardInfo(getValidCardNumber(), generateMonth(), "*/", generateOwner(), generateCVC());
    }

    public CardInfo getInvalidCardInfoCVCWithNonSpecialCharacters() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), generateOwner(), "*/=");
    }

    public CardInfo getInvalidCardInfoCVCWithLetterCharacters() {
        return new CardInfo(getValidCardNumber(), generateMonth(), generateYear(), generateOwner(), "abw");
    }

    public CardInfo getInvalidCardInfo() {
        return new CardInfo(getInvalidCardNumber(), generateMonth(), generateYear(), generateOwner(), generateCVC());
    }


}
