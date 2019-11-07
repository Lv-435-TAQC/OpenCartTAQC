package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.MyAccountPageObject;
import utils.Constants;

import static org.testng.Assert.assertEquals;
import static utils.Constants.*;

public class MyAccountTest {
    WebDriver driver;
    HomePageObject homePageObject;
    MyAccountPageObject myAccountPageObject;

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Home Page on OpenCart.com;
     * <li>3. Click on Login Tab;
     * <li>4. Enter username, password and Click login ;
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.get(Constants.HOME_PAGE);
        homePageObject = new HomePageObject(driver);
        homePageObject.goToHomePage()
                .getHeaderPageObject()
                .clickLoginPage()
                .logIn(FIRST_MAIL, FIRST_PASSWORD);
        myAccountPageObject = new MyAccountPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }


    /**
     * <b>TC-1: Change phoneNumber in user Account </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Edit your account information
     * <li> 2. Input new telephone number
     * <li> 3. Click Continue button
     * </ul>
     * <p>
     * Expected Result: Success: Your account has been successfully updated.
     */

    @Test
    public void changeNumberPhoneTest() {
        String actual =
                myAccountPageObject
                        .clickGoToChangeInformation()
                        .setTelephoneField("0634889600")
                        .clickContinueButton()
                        .successfulMessageChangeInformation();
        assertEquals(actual, SUCSSES_INFORMATION_CHANGE);
    }

    /**
     * <b>TC-2: Change name in user Account </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Edit your account information
     * <li> 2. Input new first name
     * <li> 3. Input new last name
     * <li> 4. Click Continue button
     * </ul>
     * <p>
     * Expected Result: Success: Your account has been successfully updated.
     */

    @Test
    public void changeNameTest() {
        String actual =
                myAccountPageObject
                        .clickGoToChangeInformation()
                        .setFirstNameField("Orysia")
                        .setLastNameField("Benko")
                        .clickContinueButton()
                        .successfulMessageChangeInformation();
        assertEquals(actual, SUCSSES_INFORMATION_CHANGE);
    }

    /**
     * <b>TC-3: Change Email And After Login </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Edit your account information
     * <li> 2. Input new email
     * <li> 3. Click Continue button
     * <li> 4. Log out
     * <li> 5. Go to home page
     * <li> 6. Click on Login Tab;
     * <li> 7. Enter new username, password and Click login;
     * </ul>
     * <p>
     * Expected Result: My Account
     */

    @Test(priority = 1)
    public void changeEmailAndAfterLoginTest() {
        String actual =
                myAccountPageObject
                        .clickGoToChangeInformation()
                        .setEmailField(LAST_MAIL)
                        .clickContinueButton()
                        .goToUrl(LOGOUT_URL)
                        .goToHomePage()
                        .getHeaderPageObject()
                        .clickLoginPage()
                        .logIn(LAST_MAIL, FIRST_PASSWORD)
                        .myAccountText();
        assertEquals(actual, MY_ACCOUNT_TEXT);
    }

    /**
     * <b>TC-4: Change Email And Password And After Login </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Edit your account information
     * <li> 2. Input new email
     * <li> 3. Click Continue button
     * <li> 4. Click Change your password
     * <li> 5. Input new email
     * <li> 6. Click Continue button
     * <li> 7. Log out
     * <li> 8. Go to home page
     * <li> 9. Click on Login Tab;
     * <li> 10. Enter new username, new password and Click login;
     * </ul>
     * <p>
     * Expected Result: My Account
     */

    @Test(priority = 2)
    public void changeEmailAndPasswordAfterLoginTest() {
        String actual =
                myAccountPageObject
                        .clickGoToChangeInformation()
                        .setEmailField(FIRST_MAIL)
                        .clickContinueButton()
                        .clickGoToChangePassword()
                        .setOldPasswordField(LAST_PASSWORD)
                        .setNewPasswordField(LAST_PASSWORD)
                        .clickContinueNewPasswordButton()
                        .goToUrl(LOGOUT_URL)
                        .goToHomePage()
                        .getHeaderPageObject()
                        .clickLoginPage()
                        .logIn(FIRST_MAIL, LAST_PASSWORD)
                        .myAccountText();
        assertEquals(actual, MY_ACCOUNT_TEXT);
    }

    /**
     * <b>TC-5: Change Email And Password And After Login </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Change your password
     * <li> 2. Input new password
     * <li> 3. Input confirm password
     * <li> 4. Click Continue button
     * <li> 5. Log out
     * <li> 6. Go to home page
     * <li> 7. Click on Login Tab;
     * <li> 8. Enter new username, new password and Click login;
     * </ul>
     * <p>
     * Expected Result: Success: Your password has been successfully updated.
     */

    @Test(priority = 3)
    public void changePasswordTest() {
        String actual = myAccountPageObject
                .clickGoToChangePassword()
                .setOldPasswordField(FIRST_PASSWORD)
                .setNewPasswordField(FIRST_PASSWORD)
                .clickContinueNewPasswordButton()
                .successfulMessageChangePassword();
        assertEquals(actual, SUCSSES_PASWORD_CHANGE);
    }
}