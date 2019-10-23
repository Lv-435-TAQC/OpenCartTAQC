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

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginPageObjectTest {
    public static final String HOME_PAGE = "http://192.168.184.130/opencart/index.php?route=common/home";
    public static final String REGISTRATION_PAGE = "http://192.168.184.130/opencart/index.php?route=account/register";
    public static final String FORGOTTEN_PAGE = "http://192.168.184.130/opencart/index.php?route=account/forgotten";
    public static final String ACCOUNT_PAGE = "http://192.168.184.130/opencart/index.php?route=account/account";
    WebDriver driver;
    HeaderPageObject headerPageObject;
    LoginPageObject loginPageObject;
    String warningMessage1 = "Warning: No match for E-Mail Address and/or Password.";
    String warningMessage2 = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        headerPageObject = new HeaderPageObject(driver);
        driver.get(HOME_PAGE);
        headerPageObject.goToLoginPage();
        loginPageObject = new LoginPageObject(this.driver);
    }

    @BeforeMethod
    public void getLogin() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerPageObject.goToLoginPage();
        loginPageObject = new LoginPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void clickButtonToGoToRegistrationPage() {
        loginPageObject.clickToGoToRegistation();
        String actual = driver.getCurrentUrl();
        String expected = REGISTRATION_PAGE;
        assertEquals(actual, expected);
    }

    @Test
    public void LoginNegative() {
        String actual = loginPageObject.setLogInField("").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(warningMessage1.equalsIgnoreCase(actual) ? warningMessage1 : warningMessage2, actual);
    }

    @Test
    public void LoginNotInputTheEmail() {
        String actual = loginPageObject.setLogInField("").setPasswordField("orysia").clickNextButton().warningMessage();
        Assert.assertEquals(warningMessage1.equalsIgnoreCase(actual) ? warningMessage1 : warningMessage2, actual);
    }

    @Test
    public void LoginNotInputThePassword() {
        String actual = loginPageObject.setLogInField("orysita.lviv@gmail.com").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(warningMessage1.equalsIgnoreCase(actual) ? warningMessage1 : warningMessage2, actual);
    }

    @Test(priority = 2)
    public void LoginValidDate() {
        loginPageObject.logIn("orysita.lviv@gmail.com", "orysia");
        String actual = driver.getCurrentUrl();
        String expected = ACCOUNT_PAGE;
        assertEquals(actual, expected);
    }

    @Test
    public void InputNotCorrectData() {
        String actual = loginPageObject.setLogInField("hahahah@gmail.com").setPasswordField("Uhyyyyyy").clickNextButton().warningMessage();
        Assert.assertEquals(warningMessage1.equalsIgnoreCase(actual) ? warningMessage1 : warningMessage2, actual);
    }

    @Test
    public void GoToForgottenPage() {
        loginPageObject.goToPageForgottenPassword();
        String actual = driver.getCurrentUrl();
        String expected = FORGOTTEN_PAGE;
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void SentEmailForgottenPassword() {
        String actual = loginPageObject.forgottenPassword("orysita.lviv@gmail.com").successfulMessage();
        String expected = "An email with a confirmation link has been sent your email address.";
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void SentEmailNotSuccessfulForgottenPassword() {
        String actual = loginPageObject.forgottenPassword("hahahaha@gmail.com").warningMessage();
        String expected = "Warning: The E-Mail Address was not found in our records, please try again!";
        assertEquals(actual, expected);
    }
}
