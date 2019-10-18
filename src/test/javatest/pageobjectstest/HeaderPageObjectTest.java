package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HeaderPageObject;
import pageobjects.MenuPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class HeaderPageObjectTest {
    WebDriver driver;
    HeaderPageObject header;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/shop");
        header = new HeaderPageObject(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void euroCurrencyTest() {
        String actual = header.chooseEuroCurrency().getTextFromItems();
        String expected = "€";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void dollarCurrencyTest() {
        String actual = header.chooseDollarCurrency().getTextFromItems();
        String expected = "$";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void poundCurrencyTest() {
        String actual = header.choosePoundCurrency().getTextFromItems();
        String expected = "£";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void testLoginPage() {
        header.goToLoginPage();
        String actual = header.getTextFromSecondTape();
        String expected = "Login";
        assertEquals(actual, expected);
    }

    @Test
    public void testRegistrationPage() {
        header.goToRegistrationPage();
        String actual = header.getTextFromSecondTape();
        String expected = "Register";
        assertEquals(actual, expected);
    }

    @Test
    public void testWishListPage(){
        header.goToWishList();
        String actual = header.getTextFromSecondTape();
        String expected = "Login";
        assertEquals(actual,expected);
    }

    @Test
    public void testShoppingCartPage(){
    header.goToShoppingCartPage();
    String actual = header.getTextFromFirstTape();
    String expected = "Shopping Cart";
    assertEquals(actual,expected);
    }

    @Test
    public void testCheckoutPage(){
        header.goToCheckoutCartPage();
        String actual = header.getTextFromFirstTape();
        String expected = "Shopping Cart";
        assertEquals(actual,expected);
    }
}

