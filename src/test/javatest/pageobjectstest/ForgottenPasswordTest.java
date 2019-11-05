package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ForgottenPasswordPageObject;
import utils.Constants;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ForgottenPasswordTest {
    WebDriver driver;
    ForgottenPasswordPageObject forgottenPassword;

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Home Page on OpenCart.com;
     * <li>3. Click on Login Tab;
     * <li>4. Click on Forgotten password;
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getForgottenPassword() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.FORGOTTEN_PAGE);
        forgottenPassword = new ForgottenPasswordPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    /**
     * <b> TC-1: Test from forgotten password go to login page.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Click button Back on forgotten page;
     * </ul>
     * <p>
     * Expected Result: Open login page
     */

    @Test
    public void clickButtonToGoToLoginPageTest() {
        forgottenPassword.clickBackToLoginPageButton();
        String actual = driver.getCurrentUrl();
        String expected = Constants.LOGIN_PAGE;
        assertEquals(actual, expected);
    }
}
