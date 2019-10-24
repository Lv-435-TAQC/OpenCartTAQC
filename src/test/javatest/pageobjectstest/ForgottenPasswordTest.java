package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ForgottenPasswordPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ForgottenPasswordTest {
    WebDriver driver;
    ForgottenPasswordPageObject forgottenPassword;
    public static final String LOGIN_PAGE="http://localhost/opencart/index.php?route=account/login";
    public static final String FORGOTTEN_PAGE="http://localhost/opencart/index.php?route=account/forgotten";
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getForgottenPassword() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(FORGOTTEN_PAGE);
        forgottenPassword = new ForgottenPasswordPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void clickButtonToGoToLoginPage() {
        forgottenPassword.clickBackToLoginPageButton();
        String actual = driver.getCurrentUrl();
        String expected = LOGIN_PAGE;
        assertEquals(actual, expected);
    }
}
