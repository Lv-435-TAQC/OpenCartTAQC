package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HeaderPageObject;
import pageobjects.LoginPageObject;
import utils.Constants;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageObjectTest {
    WebDriver driver;
    HeaderPageObject headerPageObject;
    LoginPageObject loginPageObject;

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
        driver.get(Constants.HOME_PAGE);
        headerPageObject.clickLoginPage();
        loginPageObject = new LoginPageObject(this.driver);
    }

    @BeforeMethod
    public void getLogin() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
     * <b>TC-2: Not correct date(login, password) </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = ""
     * <li> 2. Input password = ""
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password."
     */

    @Test
    public void loginNegativeTest() {
        String actual = loginPageObject.setLogInField("").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    /**
     * <b>TC-3: Not correct date(login, password) </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = ""
     * <li> 2. Input password = "orysia"
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password."
     */

    @Test
    public void loginNotInputTheEmailTest() {
        String actual = loginPageObject.setLogInField("").setPasswordField("orysia").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    /**
     * <b>TC-4: Not correct date(login, password) </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = "orysita.lviv+1@gmail.com"
     * <li> 2. Input password = ""
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password."
     */

    @Test
    public void loginNotInputThePasswordTest() {
        String actual = loginPageObject.setLogInField("orysita.lviv@gmail.com").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    /**
     * <b>TC-5: Correct date(login, password) </b>
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
    public void LoginValidDate() {
        loginPageObject.logIn("orysita.lviv+1@gmail.com", "orysia");
        String actual = driver.getCurrentUrl();
        String expected = Constants.ACCOUNT_PAGE;
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-6: Not correct date(login, password) </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = "hahahah@gmail.com"
     * <li> 2. Input password = "Uhyyyyyy"
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password."
     */

    @Test
    public void inputNotCorrectDataTest() {
        String actual = loginPageObject.setLogInField("hahahah@gmail.com").setPasswordField("Uhyyyyyy").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    /**
     * <b>TC-7: Test Forgotten password button</b>
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

    /**
     * <b>TC-8: sent Email Forgotten Password </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Forgotten password button
     * <li> 2. Input login = "orysita.lviv@gmail.com"
     * <li> 3. Click continue button
     * </ul>
     * <p>
     * Expected Result: "An email with a confirmation link has been sent your email address."
     */

    @Test(priority = 1)
    public void sentEmailForgottenPasswordTest() {
        String actual = loginPageObject.forgottenPassword("orysita.lviv@gmail.com").successfulMessage();
        String expected = "An email with a confirmation link has been sent your email address.";
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-9: Not correct date for sent email forgotten password </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click Forgotten password button
     * <li> 2. Input login = "hahahaha@gmail.com"
     * <li> 3. Click continue button
     * </ul>
     * <p>
     * Expected Result: "Warning: The E-Mail Address was not found in our records, please try again!"
     */

    @Test(priority = 1)
    public void sentEmailNotSuccessfulForgottenPasswordTest() {
        String actual = loginPageObject.forgottenPassword("hahahaha@gmail.com").warningMessage();
        String expected = "Warning: The E-Mail Address was not found in our records, please try again!";
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-10: Correct date(login, password) used SIKULI </b>
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

    @Test(priority = 4)
    public void sikuliTestValidDataTest() {
        Boolean isFound = loginPageObject.sikuliGoodDate();
        assertTrue(isFound);
    }

    /**
     * <b>TC-11: Not correct date(login, password) used SIKULI </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = "orysia.benko@gmail.com"
     * <li> 2. Input password = "orysia"
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password."
     */

    @Test(priority = 3)
    public void sikuliTestNotValidDataTest() {
        Boolean isFound = loginPageObject.sikuliBadDate();
        assertTrue(isFound);
    }
}
