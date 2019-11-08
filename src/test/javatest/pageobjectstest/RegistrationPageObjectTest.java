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
import pageobjects.HomePageObject;
import pageobjects.RegistrationPageObject;
import utils.DBMethods;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static patterns.RegistrationPatterns.*;
import static utils.Constants.*;
import static utils.TestData.*;
import static utils.TestData.ADMIN_PASSWORD;


public class RegistrationPageObjectTest {

    private WebDriver driver;
    private RegistrationPageObject registrationPageObject;

    /**
     * <b> Description of precondition</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Before running any tests method deletes all users from DB
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        registrationPageObject = new RegistrationPageObject(driver);
        DBMethods dbMethods = new DBMethods();
        dbMethods.deleteAllUsersFromDB();
    }

    /**
     * <b> Description of precondition</b>
     *
     * <ul>
     * <li>Open registration page on OpenCart.com
     * </ul>
     * <p>
     */

    @BeforeMethod
    public void getToRegistrationPage() {
        registrationPageObject.goToUrl(REGISTRATION_PAGE_URL);
    }

    /**
     * <b> Description of postcondition</b>
     *
     * <ul>
     * <li>Method closes Firefox browser and clears all webdriver-dependent resources
     * </ul>
     * <p>
     */

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    /**
     * <b>TC-01: Negative test for field "First Name"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field char sequence with letters, numbers and special symbols;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: First Name does not appear to be valid!
     */

    @Test
    public void firstNameFieldNumbersAndSymbolsNegativeTest() {
        registrationPageObject.setDataToFirstNameField(CHAR_SEQUENCE_WITH_LETTERS_NUMBERS_SPECIAL_SYMBOLS)
                .pushOnContinueButton();
        assertFalse(driver.getPageSource().contains(FIRST_NAME_INVALID_MESSAGE));
    }

    /**
     * <b>TC-02: Negative test for field "First Name"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write nothing to field;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: First Name must be between 1 and 32 characters!
     */

    @Test
    public void firstNameFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToFirstNameField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(FIRST_NAME_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-03: Negative test for field "First Name"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field char sequence length of which is more than 32 chars;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: First Name must be between 1 and 32 characters!
     */

    @Test
    public void firstNameFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToFirstNameField(BIG_LENGTH_CHAR_SEQUENCE)
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(FIRST_NAME_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-04: Negative test for field "Last Name"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field char sequence with letters, numbers and special symbols;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: Last Name does not appear to be valid!
     */

    @Test
    public void lastNameFieldNumbersAndSymbolsNegativeTest() {
        registrationPageObject.setDataToLastNameField(CHAR_SEQUENCE_WITH_LETTERS_NUMBERS_SPECIAL_SYMBOLS)
                .pushOnContinueButton();
        assertFalse(driver.getPageSource().contains(LAST_NAME_INVALID_MESSAGE));
    }

    /**
     * <b>TC-05: Negative test for field "Last Name"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write nothing to field;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: Last Name must be between 1 and 32 characters!
     */

    @Test
    public void lastNameFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToLastNameField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(LAST_NAME_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-06: Negative test for field "Last Name"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field char sequence length of which is more than 32 chars;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: Last Name must be between 1 and 32 characters!
     */

    @Test
    public void lastNameFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToLastNameField(BIG_LENGTH_CHAR_SEQUENCE)
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(LAST_NAME_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-07: Negative test for field "E-Mail"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field char sequence without the "@" symbol and domain name;
     * <li>2. Click on button "Continue";
     * <li>3. Check the validity of input data;
     * </ul>
     * <p>
     * Expected Result: Browser HTML5 popup hint with text "Please enter an email address"
     */

    @Test
    public void emailFieldInvalidEmailAddressNegativeTest() {
        registrationPageObject.setDataToEmailField(INVALID_CHAR_SEQUENCE_FOR_EMAIL).pushOnContinueButton();
        assertFalse((Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validity.valid;", registrationPageObject.getFieldEmail().element));
    }

    /**
     * <b>TC-08: Negative test for field "E-Mail"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write nothing to field;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: E-Mail Address does not appear to be valid!
     */

    @Test
    public void emailFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToEmailField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(EMAIL_INVALID_ADDRESS_MESSAGE));
    }

    /**
     * <b>TC-09: Negative test for field "Telephone"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write nothing to field;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: Telephone must be between 3 and 32 characters!
     */

    @Test
    public void telephoneFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToTelephoneField("").pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(TELEPHONE_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-10: Negative test for field "Password"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field number sequence with the length of three symbols;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message;
     * </ul>
     * <p>
     * Expected Result: Password must be between 4 and 20 characters!
     */

    @Test
    public void passwordFieldFewerAmountCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToPasswordField(TOO_SMALL_NUMBER_SEQUENCE_FOR_PASSWORD).pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(PASSWORD_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-11: Negative test for field "Password"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field char sequence length of which is more than 20 chars;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message
     * </ul>
     * <p>
     * Expected Result: Password must be between 4 and 20 characters!
     */

    @Test
    public void passwordFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToPasswordField(TOO_BIG_NUMBER_SEQUENCE_FOR_PASSWORD)
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(PASSWORD_INVALID_LENGTH_MESSAGE));
    }

    /**
     * <b>TC-12: Negative test for field "Password Confirm"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field "Password" char sequence;
     * <li>2. Write to field "Password Confirm" another char sequence;
     * <li>2. Click on button "Continue";
     * <li>3. Check the presence of error message
     * </ul>
     * <p>
     * Expected Result: Password confirmation does not match password!
     */

    @Test
    public void passwordConfirmFieldInvalidConfirmationNegativeTest() {
        registrationPageObject
                .setDataToPasswordField(PASSWORD_FOR_REGISTRATION)
                .setDataToPasswordConfirmField(INVALID_PASSWORD_CONFIRM_NUMBER_SEQUENCE)
                .pushOnContinueButton();
        assertTrue(driver.getPageSource().contains(PASSWORD_CONFIRMATION_MATCH_ERROR_MESSAGE));
    }

    /**
     * <b>TC-13: Negative test for checkbox "I have read and agree to the Privacy Policy"</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on checkbox;
     * <li>2. Click on button "Continue";
     * <li>3. Check the absence of error message
     * </ul>
     * <p>
     * Expected Result: Absence of message: Warning: You must agree to the Privacy Policy!
     */

    @Test
    public void checkboxPrivacyPolicyClickTest() {
        registrationPageObject.checkOnPrivacyPolicyCheckbox().pushOnContinueButton();
        assertFalse(driver.getPageSource().contains(PRIVACY_POLICY_AGREE_WARNING_MESSAGE));
    }

    /**
     * Method registers a new user to the OpenCart system using selenium script.
     * After successful registration the script will logout the user
     * @param emailData email, which will be written to the "E-Mail" field
     */

    private void registerSuccessfully(String emailData) {
        registrationPageObject.setDataToFirstNameField(USER_FIRST_NAME_FOR_REGISTRATION)
                .setDataToLastNameField(USER_LAST_NAME_FOR_REGISTRATION)
                .setDataToEmailField(emailData).setDataToTelephoneField(USER_TELEPHONE_FOR_REGISTRATION)
                .setDataToPasswordField(PASSWORD_FOR_REGISTRATION).setDataToPasswordConfirmField(PASSWORD_FOR_REGISTRATION)
                .checkOnPrivacyPolicyCheckbox().pushOnContinueButton().waitForUrlToBe(SUCCESSFUL_REGISTRATION_URL);
    }

    /**
     * <b>TC-14: Test of successful registration</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field "First Name" valid data;
     * <li>2. Write to field "Last Name" valid data;
     * <li>3. Write to field "E-Mail" valid data;
     * <li>4. Write to field "Telephone" valid data;
     * <li>5. Write to field "Password" valid data;
     * <li>6. Write to field "Password Confirm" valid data;
     * <li>7. Click on checkbox "I have read and agree to the Privacy Policy";
     * <li>8. Click on button "Continue";
     * <li>9. Check if page changed to a successful registration page;
     * <li>10. Logout from an account;
     * </ul>
     * <p>
     * Expected Result: The URL of the page will change to a successful registration page URL
     */

    @Test(priority = 1)
    public void successfulRegisterTest() {
        registerSuccessfully(1 + EMAIL_FOR_REGISTRATION);
        assertEquals(driver.getCurrentUrl(), SUCCESSFUL_REGISTRATION_URL);
        registrationPageObject.goToUrl(LOGOUT_URL);
    }

    /**
     * <b>TC-15: Test of successful registration using Sikuli script</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field "First Name" valid data;
     * <li>2. Write to field "Last Name" valid data;
     * <li>3. Write to field "E-Mail" valid data;
     * <li>4. Write to field "Telephone" valid data;
     * <li>5. Write to field "Password" valid data;
     * <li>6. Write to field "Password Confirm" valid data;
     * <li>7. Click on checkbox "I have read and agree to the Privacy Policy";
     * <li>8. Click on button "Continue";
     * <li>9. Check the presence of successful registration message;
     * <li>10. Logout from an account;
     * </ul>
     * <p>
     * Expected Result: Your Account Has Been Created!
     */

    @Test(priority = 1)
    public void successfulRegisterSikuliTest() {
        Screen screen = new Screen();
        Pattern buttonLogout = new Pattern(BUTTON_LOGOUT);
        Pattern labelYourPassword = new Pattern(LABEL_YOUR_PASSWORD);
        Pattern labelYourPersonalDetails = new Pattern(LABEL_YOUR_PERSONAL_DETAILS);
        registrationPageObject
                .typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 65), USER_FIRST_NAME_FOR_REGISTRATION)
                .typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 110), USER_LAST_NAME_FOR_REGISTRATION)
                .typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 160), EMAIL_FOR_REGISTRATION)
                .typeTextToPattern(screen, labelYourPersonalDetails.targetOffset(300, 215), USER_TELEPHONE_FOR_REGISTRATION)
                .clickOnPattern(screen, labelYourPassword);
        screen.type(Key.PAGE_DOWN);
        registrationPageObject.typeTextToPattern(screen, labelYourPassword.targetOffset(300, 60), USER_PASSWORD)
                .typeTextToPattern(screen, labelYourPassword.targetOffset(300, 100), USER_PASSWORD)
                .clickOnPattern(screen, new Pattern(CHECKBOX_PRIVACY_POLICY))
                .clickOnPattern(screen, new Pattern(BUTTON_CONTINUE));
        assertNotNull(screen.exists(new Pattern(MESSAGE_ON_SUCCESSFUL_REGISTRATION)));
        screen.type(Key.PAGE_DOWN);
        registrationPageObject.waitForPattern(screen, buttonLogout, 10)
                .clickOnPattern(screen, buttonLogout)
                .waitForPattern(screen, new Pattern(MESSAGE_ON_SUCCESSFUL_LOGOUT), 10);
    }

    /**
     * <b>TC-16: Test of successfully registered user presence in the customers list of OpenCart admin section</b>
     *
     * Scenario:
     * <ul>
     * <li>1.  Write to field "First Name" valid data;
     * <li>2.  Write to field "Last Name" valid data;
     * <li>3.  Write to field "E-Mail" valid data;
     * <li>4.  Write to field "Telephone" valid data;
     * <li>5.  Write to field "Password" valid data;
     * <li>6.  Write to field "Password Confirm" valid data;
     * <li>7.  Click on checkbox "I have read and agree to the Privacy Policy";
     * <li>8.  Click on button "Continue";
     * <li>9.  Go to admin login page;
     * <li>10. Write to field "Username" valid data;
     * <li>11. Write to field "Password" valid data;
     * <li>12. Close notification window;
     * <li>13. Click on section "Customers";
     * <li>14. Click on subsection "Customers";
     * <li>15. Write to field "E-Mail" valid data;
     * <li>16. Click on button "Filter";
     * <li>17. Check if filter result is correct;
     * <li>18. Logout from an account;
     * </ul>
     * <p>
     * Expected Result: Correct account details presence
     */

    @Test
    public void registerUserAndCheckSuccessByAdminTest() {
        String emailData = 2 + EMAIL_FOR_REGISTRATION;
        registerSuccessfully(emailData);
        AdminLoginPageObject adminLoginPageObject = new AdminLoginPageObject(driver);
        adminLoginPageObject.goToUrl(ADMIN_LOGIN_URL);
        adminLoginPageObject.logIn(ADMIN_NAME, ADMIN_PASSWORD).closeModalWindow().getNavigation()
                .goToCustomers().clickOnCustomersSubButton().setDataToEmailField(emailData).clickOnButtonFilter();
        assertTrue(driver.getPageSource().contains(emailData));
        adminLoginPageObject.goToUrl(LOGOUT_URL);
    }

    /**
     * <b>TC-17: Test of user login after successful registration</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Write to field "First Name" valid data;
     * <li>2. Write to field "Last Name" valid data;
     * <li>3. Write to field "E-Mail" valid data;
     * <li>4. Write to field "Telephone" valid data;
     * <li>5. Write to field "Password" valid data;
     * <li>6. Write to field "Password Confirm" valid data;
     * <li>7. Click on checkbox "I have read and agree to the Privacy Policy";
     * <li>8. Click on button "Continue";
     * <li>9. Logout from an account;
     * <li>10. Click on "My Account" header section;
     * <li>11. Click on "Login" option;
     * <li>12. Write to field "E-Mail Address" valid data;
     * <li>13. Write to field "Password" valid data;
     * <li>14. Check if loaded page is a successful login page;
     * <li>15. Logout from an account;
     * </ul>
     * <p>
     * Expected Result: The URL of the page will change to a successful login page URL
     */

    @Test
    public void successfullyRegisterAndLoginTest() {
        String emailData = 3 + EMAIL_FOR_REGISTRATION;
        registerSuccessfully(emailData);
        registrationPageObject.goToUrl(LOGOUT_URL);
        new HomePageObject(driver).getHeaderPageObject()
                .clickLoginPage()
                .logIn(emailData, PASSWORD_FOR_REGISTRATION);
        assertEquals(driver.getCurrentUrl(), ACCOUNT_PAGE);
        registrationPageObject.goToUrl(LOGOUT_URL);
    }
}
