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
import static patterns.RegistrationPatterns.*;
import static utils.Constants.*;


public class RegistrationPageObjectTest {

    private WebDriver driver;
    private RegistrationPageObject registrationPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", PATH_TO_DRIVER);
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

    @Test(priority = 2)
    public void successfulRegisterTest() {
        registrationPageObject.setDataToFirstNameField("Paprika").setDataToLastNameField("Pepper")
                .setDataToEmailField(new Random().nextInt(1000) + "paprika@paprika.com")
                .setDataToTelephoneField("0794852421").setDataToPasswordField("12345").setDataToPasswordConfirmField("12345")
                .checkOnPrivacyPolicyCheckbox().pushOnContinueButton().waitForUrlToBe(SUCCESSFUL_REGISTRATION_URL);
        assertEquals(driver.getCurrentUrl(), SUCCESSFUL_REGISTRATION_URL);
        registrationPageObject.goToUrl(LOGOUT_URL);
    }

    @Test(priority = 1)
    public void successfulRegisterSikuliTest() {
        Screen screen = new Screen();
        Pattern buttonLogout = new Pattern(BUTTON_LOGOUT);
        Pattern labelYourPassword = new Pattern(LABEL_YOUR_PASSWORD);
        registrationPageObject.typeTextToPattern(screen, new Pattern(FIELD_FIRST_NAME), "Paprika")
                .typeTextToPattern(screen, new Pattern(FIELD_LAST_NAME), "Pepper")
                .typeTextToPattern(screen, new Pattern(FIELD_EMAIL),
                        new Random().nextInt(1000) + "paprika@paprika.com")
                .typeTextToPattern(screen, new Pattern(FIELD_TELEPHONE), "0794852421")
                .clickOnPattern(screen, labelYourPassword);
        screen.type(Key.PAGE_DOWN);
        registrationPageObject.typeTextToPattern(screen, labelYourPassword.targetOffset(300, 60), "12345")
                .typeTextToPattern(screen, labelYourPassword.targetOffset(300, 100), "12345")
                .clickOnPattern(screen, new Pattern(CHECKBOX_PRIVACY_POLICY))
                .clickOnPattern(screen, new Pattern(BUTTON_CONTINUE));
        assertNotNull(screen.exists(new Pattern(MESSAGE_ON_SUCCESSFUL_REGISTRATION)));
        screen.type(Key.PAGE_DOWN);
        registrationPageObject.waitForPattern(screen, buttonLogout, 10)
                .clickOnPattern(screen, buttonLogout)
                .waitForPattern(screen, new Pattern(MESSAGE_ON_SUCCESSFUL_LOGOUT), 10);
    }
}
