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
import pageobjects.AdminLoginPageObject;
import pageobjects.RegistrationPageObject;
import utils.DBMethods;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static patterns.RegistrationPatterns.*;
import static utils.Constants.*;


public class RegistrationPageObjectTest {

    private WebDriver driver;
    private RegistrationPageObject registrationPageObject;
    private String email = new Random().nextInt(1000) + "paprika@paprika.com";
    private String password = "12345";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        registrationPageObject = new RegistrationPageObject(driver);
        DBMethods dbMethods = new DBMethods();
        dbMethods.deleteAllUsersFromDB();
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

    private void registerSuccessfully(String emailData) {
        registrationPageObject.setDataToFirstNameField("Paprika").setDataToLastNameField("Pepper")
                .setDataToEmailField(emailData)
                .setDataToTelephoneField("0794852421").setDataToPasswordField(password).setDataToPasswordConfirmField("12345")
                .checkOnPrivacyPolicyCheckbox().pushOnContinueButton().waitForUrlToBe(SUCCESSFUL_REGISTRATION_URL);
    }

    @Test(priority = 1)
    public void successfulRegisterTest() {
        registerSuccessfully(1 + email);
        assertEquals(driver.getCurrentUrl(), SUCCESSFUL_REGISTRATION_URL);
        registrationPageObject.goToUrl(LOGOUT_URL);
    }

    @Test(priority = 1)
    public void successfulRegisterSikuliTest() {
        Screen screen = new Screen();
        Pattern buttonLogout = new Pattern(BUTTON_LOGOUT);
        Pattern labelYourPassword = new Pattern(LABEL_YOUR_PASSWORD);
        Pattern labelYourPersonalDetails = new Pattern(LABEL_YOUR_PERSONAL_DETAILS);
        registrationPageObject.typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 65), "Paprika")
                .typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 110), "Pepper")
                .typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 160),
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

    @Test
    public void registerUserAndCheckSuccessByAdminTest() {
        String emailData = 2 + email;
        registerSuccessfully(emailData);
        AdminLoginPageObject adminLoginPageObject = new AdminLoginPageObject(driver);
        adminLoginPageObject.goToUrl(ADMIN_LOGIN_URL);
        adminLoginPageObject.logIn("admin", "admin").closeModalWindow().getNavigation()
                .goToCustomers().clickOnCustomersSubButton().setDataToEmailField(emailData).clickOnButtonFilter();
        assertTrue(driver.getPageSource().contains(emailData));
        adminLoginPageObject.goToUrl(LOGOUT_URL);
    }
}
