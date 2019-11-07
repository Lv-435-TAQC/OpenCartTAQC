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
     * <li>4. Click on Login Tab;
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
                        .logIn(LAST_MAIL, "orysia")
                        .myAccountText();
        assertEquals(actual, MY_ACCOUNT_TEXT);
    }

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
