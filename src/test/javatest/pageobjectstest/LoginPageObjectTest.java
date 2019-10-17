package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPageObject;
import utils.commonconstants.URLConstants;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginPageObjectTest {
    WebDriver driver;
    LoginPageObject loginPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getLogin() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URLConstants.LOGIN_PAGE);
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
        String expected = URLConstants.REGISTRATION_PAGE;
        assertEquals(actual, expected);
    }
    String warn1 = "Warning: No match for E-Mail Address and/or Password.";
    String warn2 = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    @Test
    public void LoginNegative() {
        String actual = loginPageObject.setLogInField("").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(warn1.equalsIgnoreCase(actual )?warn1:warn2 , actual );
    }

    @Test
    public void LoginNotInputTheEmail() {
        String actual = loginPageObject.setLogInField("").setPasswordField("orysia").clickNextButton().warningMessage();
        Assert.assertEquals(warn1.equalsIgnoreCase(actual )?warn1:warn2 , actual );
    }

    @Test
    public void LoginNotInputThePassword() {
        String actual = loginPageObject.setLogInField("orysita.lviv@gmail.com").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(warn1.equalsIgnoreCase(actual )?warn1:warn2 , actual );
    }

    @Test(priority = 1)
    public void LoginValidDate() {
        loginPageObject.logIn("orysita.lviv@gmail.com", "orysia");
        String actual = driver.getCurrentUrl();
        String expected = URLConstants.ACCOUNT_PAGE;
        assertEquals(actual, expected);
    }
    @Test
    public void InputNotCorrectData() {
        String actual = loginPageObject.setLogInField("hahahah@gmail.com").setPasswordField("Uhyyyyyy").clickNextButton().warningMessage();
        Assert.assertEquals(warn1.equalsIgnoreCase(actual )?warn1:warn2 , actual );
    }
    @Test
    public void GoTOForgottenPage() {
        loginPageObject.goToPageForgottenPassword();
        String actual = driver.getCurrentUrl();
        String expected = URLConstants.FORGOTTEN_PAGE;
        assertEquals(actual, expected);
    }
}
