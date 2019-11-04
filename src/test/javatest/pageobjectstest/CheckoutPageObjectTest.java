package javatest.pageobjectstest;

import locators.CheckoutBillingDetailsLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageobjects.CheckoutBillingDetailsPageObject;
import pageobjects.HeaderPageObject;
import pageobjects.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class CheckoutPageObjectTest {
    WebDriver driver;
    HeaderPageObject headerPageObject;
    CheckoutBillingDetailsPageObject checkoutBillingDetails;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        headerPageObject = new HeaderPageObject(driver);
  //      driver.get(HOME_PAGE);
        headerPageObject.clickLoginPage();
        checkoutBillingDetails = new CheckoutBillingDetailsPageObject(this.driver);
    }

    @BeforeMethod
    public void getLogin() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerPageObject.clickLoginPage();
        checkoutBillingDetails = new CheckoutBillingDetailsPageObject(this.driver);
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }
}
