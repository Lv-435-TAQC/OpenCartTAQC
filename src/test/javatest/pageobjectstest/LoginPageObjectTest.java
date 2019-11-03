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

    @Test
    public void clickButtonToGoToRegistrationPageTest() {
        loginPageObject.clickToGoToRegistation();
        String actual = driver.getCurrentUrl();
        String expected = Constants.REGISTRATION_PAGE;
        assertEquals(actual, expected);
    }

    @Test
    public void loginNegativeTest() {
        String actual = loginPageObject.setLogInField("").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    @Test
    public void loginNotInputTheEmailTest() {
        String actual = loginPageObject.setLogInField("").setPasswordField("orysia").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    @Test
    public void loginNotInputThePasswordTest() {
        String actual = loginPageObject.setLogInField("orysita.lviv@gmail.com").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    @Test(priority = 2)
    public void loginValidDateTest() {
        loginPageObject.logIn("orysita.lviv@gmail.com", "orysia");
        String actual = driver.getCurrentUrl();
        String expected = Constants.ACCOUNT_PAGE;
        assertEquals(actual, expected);
    }

    @Test
    public void inputNotCorrectDataTest() {
        String actual = loginPageObject.setLogInField("hahahah@gmail.com").setPasswordField("Uhyyyyyy").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    @Test
    public void goToForgottenPageTest() {
        loginPageObject.goToPageForgottenPassword();
        String actual = driver.getCurrentUrl();
        String expected = Constants.FORGOTTEN_PAGE;
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void sentEmailForgottenPasswordTest() {
        String actual = loginPageObject.forgottenPassword("orysita.lviv@gmail.com").successfulMessage();
        String expected = "An email with a confirmation link has been sent your email address.";
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void sentEmailNotSuccessfulForgottenPasswordTest() {
        String actual = loginPageObject.forgottenPassword("hahahaha@gmail.com").warningMessage();
        String expected = "Warning: The E-Mail Address was not found in our records, please try again!";
        assertEquals(actual, expected);
    }

    @Test(priority = 4)
    public void sikuliTestValidDataTest(){
        Boolean isFound=  loginPageObject.sikuliGoodDate();
        assertTrue(isFound);
    }
    @Test(priority = 3)
    public void sikuliTestNotValidDataTest() {
        Boolean isFound=  loginPageObject.sikuliBadDate();
        assertTrue(isFound);
    }
}
