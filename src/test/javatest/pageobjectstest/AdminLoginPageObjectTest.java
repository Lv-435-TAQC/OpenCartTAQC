package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminLoginPageObject;
import utils.Constants;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AdminLoginPageObjectTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPageObject;
    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Page on OpenCart.com;
     * </ul>
     * <p>
     */
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(Constants.HOME_PAGE);
    }

    @BeforeMethod
    public void getLogin() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        adminLoginPageObject = new AdminLoginPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    /**
     * <b>TC-1: Not correct date(login, password) </b>
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
    public void adminLoginNegativeTest() {
        String actual = adminLoginPageObject.setLogInField("").setPasswordField("").clickNextButton().warningMessage();
        Assert.assertEquals(Constants.WARNING_MESSAGE_1.equalsIgnoreCase(actual) ? Constants.WARNING_MESSAGE_1 : Constants.WARNING_MESSAGE_2, actual);
    }

    /**
     * <b>TC-2: Correct date(login, password) </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login = "admin"
     * <li> 2. Input password = "orysia"
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: Admin Page
     */

    @Test(priority = 1)
    public void adminLoginValidDate() {
        adminLoginPageObject.logIn("orysita.lviv+1@gmail.com", "orysia");
        String actual = driver.getCurrentUrl();
        String expected = Constants.ACCOUNT_PAGE;
        assertEquals(actual, expected);
    }
}
