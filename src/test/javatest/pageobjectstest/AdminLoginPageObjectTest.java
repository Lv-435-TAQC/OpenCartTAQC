package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobjects.AdminLoginPageObject;
import utils.Constants;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static utils.Constants.ADMIN_PASS;
import static utils.Constants.PASSWORD;

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
        driver.get(Constants.ADMIN_PAGE);
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
     * <b>TC-1: AuthenticationAdmin without correct date</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login date from AuthenticationAdmin
     * <li> 2. Input password date from AuthenticationAdmin
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result: "Warning: No match for E-Mail Address and/or Password." or correct login with correct date
     */

    @DataProvider(name = "AuthenticationAdmin")
    public Object[][] createDataForLoginAdmin(Method m) {
        return new Object[][]{new Object[]{"", "orysia"}
                , new Object[]{"admin", ""}
                , new Object[]{"orysita.lviv+1@gmail.com", " "}
                , new Object[]{"orysita.lviv+1@gmail.com", "fdgfdfg"}
                , new Object[]{"orysita.lviv+1@gmail.com", "orysia"}
                , new Object[]{"", ""}
        };
    }

    @Test(dataProvider = "AuthenticationAdmin")
    public void adminLoginTest(String login, String password) {
        adminLoginPageObject.logIn(login, password);
        String actual = driver.getCurrentUrl();
        String expected = Constants.ADMIN_PAGE;
        assertEquals(actual, expected);
    }


    /**
     * <b>TC-1: Authentication Admin test correct date</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Input login date
     * <li> 2. Input password date
     * <li> 3. Click Login button
     * </ul>
     * <p>
     * Expected Result:
     */

    @Test()
    public void adminPositiveLoginTest() {
        adminLoginPageObject.logIn(ADMIN_PASS, PASSWORD);
    }
}