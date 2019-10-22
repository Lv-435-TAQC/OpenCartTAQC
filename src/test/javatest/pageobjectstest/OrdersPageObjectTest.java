package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.AdminPageObject;
import pageobjects.ShoppingCartPageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class OrdersPageObjectTest {
    WebDriver driver;
    AdminPageObject adminPage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/OpenCart/admin");
        adminPage = new AdminPageObject(driver);
    }

    @AfterMethod
    public void makeScreenshots(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            ShoppingCartPageObject.makeScreenShotSteps(driver, result.getName());
        }
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void closeUp() {

        //driver.quit();
    }

    @Test(invocationCount = 1)
    public void goToAdminPage() {

    }
}