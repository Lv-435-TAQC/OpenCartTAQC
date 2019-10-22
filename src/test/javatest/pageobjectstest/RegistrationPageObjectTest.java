package pageobjectstest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegistrationPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static utils.commonconstants.Constants.*;

public class RegistrationPageObjectTest {

    private WebDriver driver;
    private RegistrationPageObject registrationPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        registrationPageObject = new RegistrationPageObject(driver);
    }

    @BeforeMethod
    public void getToRegistrationPage() {
        registrationPageObject.goToUrl(REGISTRATION_PAGE_URL);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void firstNameFieldNumbersAndSymbolsNegativeTest() {
        registrationPageObject.setDataToFirstNameField("q873458273#%").pushOnContinueButton();
        assertFalse(driver.getPageSource().contains(FIRST_NAME_INVALID_MESSAGE));
    }

    @Test
    public void firstNameFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToFirstNameField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(FIRST_NAME_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void firstNameFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToFirstNameField("alsoiruejthgnsmcbnbksjsnbksdjfsjdnfjsndfjnsdjfnsdjfn")
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(FIRST_NAME_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void lastNameFieldNumbersAndSymbolsNegativeTest() {
        registrationPageObject.setDataToLastNameField("q873458273#%").pushOnContinueButton();
        assertFalse(driver.getPageSource().contains(LAST_NAME_INVALID_MESSAGE));
    }

    @Test
    public void lastNameFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToLastNameField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(LAST_NAME_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void lastNameFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToLastNameField("alsoiruejthgnsmcbnbksjsnbksdjfsjdnfjsndfjnsdjfnsdjfn")
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(LAST_NAME_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void emailFieldInvalidEmailAddressNegativeTest() {
        registrationPageObject.setDataToEmailField("akjdgfjdfkg").pushOnContinueButton();
        assertFalse((Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validity.valid;", registrationPageObject.getFieldEmail().element));
    }

    @Test
    public void emailFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToEmailField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(EMAIL_INVALID_ADDRESS_MESSAGE));
    }

    @Test
    public void telephoneFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToTelephoneField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(TELEPHONE_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void passwordFieldFewerAmountCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToPasswordField("075").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(PASSWORD_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void passwordFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToPasswordField("12345678901234567890123456789012345678901")
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(PASSWORD_INVALID_LENGTH_MESSAGE));
    }

    @Test
    public void passwordConfirmFieldInvalidConfirmationNegativeTest() {
        registrationPageObject
                .setDataToPasswordField("12345").setDataToPasswordConfirmField("085741").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(PASSWORD_CONFIRMATION_MATCH_ERROR_MESSAGE));
    }

    @Test
    public void checkboxPrivacyPolicyClickTest() {
        registrationPageObject.checkOnPrivacyPolicyCheckbox().pushOnContinueButton();
        assertFalse(driver.getPageSource().contains(PRIVACY_POLICY_AGREE_WARNING_MESSAGE));
    }

    @Test(priority = 1)
    public void successfulRegisterTest() {
        registrationPageObject.setDataToFirstNameField("Paprika").setDataToLastNameField("Pepper")
                .setDataToEmailField(new Random().nextInt(1000) + "paprika@paprika.com")
                .setDataToTelephoneField("0794852421").setDataToPasswordField("12345").setDataToPasswordConfirmField("12345")
                .checkOnPrivacyPolicyCheckbox().pushOnContinueButton();
        assertEquals(driver.getCurrentUrl(), SUCCESSFUL_REGISTRATION_URL);
    }

    @Test
    public void successfulRegisterSikuliTest() {
        Screen screen = new Screen();
        Pattern fieldFirstName = new Pattern("src/main/resources/sikulipatterns/fieldFirstName.png");
        Pattern fieldLastName = new Pattern("src/main/resources/sikulipatterns/fieldLastName.png");
        Pattern fieldEmail = new Pattern("src/main/resources/sikulipatterns/fieldEmail.png");
        Pattern fieldTelephone = new Pattern("src/main/resources/sikulipatterns/fieldTelephone.png");
        Pattern labelYourPassword = new Pattern("src/main/resources/sikulipatterns/labelYourPassword.png");
        Pattern fieldPassword = new Pattern("src/main/resources/sikulipatterns/fieldPassword.png");
        Pattern fieldPasswordConfirm = new Pattern("src/main/resources/sikulipatterns/fieldPasswordConfirm.png");
        Pattern checkboxPrivacyPolicy = new Pattern("src/main/resources/sikulipatterns/checkboxPrivacyPolicy.png");
        Pattern buttonContinue = new Pattern("src/main/resources/sikulipatterns/buttonContinue.png");
        Pattern messageOnSuccessfulRegistration = new Pattern(
                "src/main/resources/sikulipatterns/messageOnSuccessfulRegistration.png");
        registrationPageObject.typeTextToPattern(screen, fieldFirstName, "Paprika");
        registrationPageObject.typeTextToPattern(screen, fieldLastName, "Pepper");
        registrationPageObject.typeTextToPattern(screen, fieldEmail,
                new Random().nextInt(1000) + "paprika@paprika.com");
        registrationPageObject.typeTextToPattern(screen, fieldTelephone, "0794852421");
        registrationPageObject.clickOnPattern(screen, labelYourPassword);
        screen.type(Key.PAGE_DOWN);
        registrationPageObject.typeTextToPattern(screen, fieldPassword.exact(), "12345");
        registrationPageObject.typeTextToPattern(screen, fieldPasswordConfirm, "12345");
        registrationPageObject.clickOnPattern(screen, checkboxPrivacyPolicy);
        registrationPageObject.clickOnPattern(screen, buttonContinue);
        assertNotNull(screen.exists(messageOnSuccessfulRegistration));
    }
}
