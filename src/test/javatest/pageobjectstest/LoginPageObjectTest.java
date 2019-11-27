package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HeaderPageObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import utils.Constants;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class LoginPageObjectTest {
    WebDriver driver;
    HeaderPageObject headerPageObject;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Home Page on OpenCart.com;
     * <li>3. Click on Login Tab;
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        headerPageObject = new HeaderPageObject(driver);
        homePageObject = new HomePageObject(driver);
        driver.get(Constants.HOME_PAGE);
        homePageObject.headerPageObject.clickLoginPage();
        loginPageObject = new LoginPageObject(this.driver);
    }

    @BeforeMethod
    public void getLogin() {
        headerPageObject.clickLoginPage();
        loginPageObject = new LoginPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    /**
     * <b>TC-1: Test Button Registration</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Click button go to Registration page;
     * </ul>
     * <p>
     * Expected Result: Open Registration page
     */

    @Test
    public void clickButtonToGoToRegistrationPage() {
        loginPageObject.clickToGoToRegistration();
        String actual = driver.getCurrentUrl();
        String expected = Constants.REGISTRATION_PAGE;
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-2: Authentication </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login date from Authentication
     * <li> 2. Input password date from Authentication
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password." or correct login with correct date
     */

    @DataProvider(name = "AuthenticationUser")
    public Object[][] createDataForLoginPage(Method m) {
        return new Object[][]{
                new Object[]{"orysia.benko@gmail.com", ""}
                , new Object[]{"", "Orysia"}
                , new Object[]{"", ""}
                , new Object[]{"orysita.lviv521311@gmail.com", "fdgfdfg"}
                , new Object[]{"Uhyyyyyyy", "Aaaaaaa"}
        };
    }

    @Test(dataProvider = "AuthenticationUser", priority = 1)
    public void LoginTest(String login, String password) {
        String actual = loginPageObject.
                goToUrl(LOGOUT_URL)
                .goToHomePage()
                .getHeaderPageObject()
                .clickLoginPage()
                .setLogInField(login)
                .setPasswordField(password)
                .clickNextButton()
                .warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    /**
     * <b>TC-3: Test Forgotten password button</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click button Forgotten password;
     * </ul>
     * <p>
     * Expected Result: Open Forgotten password page
     */
    @Test
    public void goToForgottenPageTest() {
        loginPageObject.goToPageForgottenPassword();
        String actual = driver.getCurrentUrl();
        String expected = Constants.FORGOTTEN_PAGE;
        assertEquals(actual, expected);
    }


    @DataProvider(name = "ForgottenPassword")
    public Object[][] createDataForLoginPa1ge(Method m) {
        return new Object[][]{new Object[]{""}
                , new Object[]{"orysia123.benko@gmail.com"}
                , new Object[]{"Uhyyyyyyy"}
                , new Object[]{""}
        };
    }

    /**
     * <b>TC-3: Test Forgotten password with not correct date</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click linked text Forgotten password;
     * <li> 2. Input email from ForgottenPassword;
     * <li> 3. Click Sent;
     * </ul>
     * <p>
     * Expected Result: Open Forgotten password page
     */

    @Test(dataProvider = "ForgottenPassword")
    public void sentEmailNotSuccessfulForgottenPasswordTest(String email) {
        String actual = loginPageObject.forgottenPassword(email).warningMessage();
        assertEquals(actual, WARNING_NOT_CORRECT_EMAIL);
    }

    /**
     * <b>TC-3: Test Forgotten password with correct date</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click linked text Forgotten password;
     * <li> 2. Input email from ForgottenPassword;
     * <li> 3. Click Sent;
     * </ul>
     * <p>
     * Expected Result: An email with a confirmation link has been sent your email address.
     */

    @Test()
    public void sentEmailSuccessfulForgottenPasswordTest() {
        String actual = loginPageObject.forgottenPassword("orysia.benko@gmail.com").successfulMessage();
        assertEquals(actual, WARNING_CORRECT_EMAIL);
    }

    /**
     * <b>TC-4: Correct date(login, password) used SIKULI </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = "orysita.lviv+1@gmail.com"
     * <li> 2. Input password = "orysia"
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: My account Page
     */

    @Test(priority = 2)
    public void sikuliTestValidDataTest() {
        Boolean isFound = loginPageObject.sikuliGoodDate();
        assertTrue(isFound);
    }
}