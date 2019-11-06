package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HeaderPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static utils.Constants.*;

public class HeaderPageObjectTest {
    WebDriver driver;
    HeaderPageObject header;


    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        header = new HeaderPageObject(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void euroCurrencyTest() {
        String actual = header.chooseEuroCurrency().getTextFromItems();
        assertTrue(actual.contains(EURO_CURRENCY));
    }

    @Test
    public void dollarCurrencyTest() {
        String actual = header.chooseDollarCurrency().getTextFromItems();
        assertTrue(actual.contains(DOLLAR_CURRENCY));
    }

    @Test
    public void poundCurrencyTest() {
        String actual = header.choosePoundCurrency().getTextFromItems();
        assertTrue(actual.contains(POUND_CURRENCY));
    }

    @Test
    public void testLoginPage() {
        header.clickLoginPage();
        String actual = header.getTextFromSecondTape();
        assertEquals(actual, LOGIN);
    }

    @Test
    public void testRegistrationPage() {
        header.clickRegistrationPage();
        String actual = header.getTextFromSecondTape();
        assertEquals(actual, REGISTER);
    }

    @Test
    public void testWishListPage(){
        header.clickWishList();
        String actual = header.getTextFromSecondTape();
        assertEquals(actual,LOGIN);
    }

    @Test
    public void testShoppingCartPage(){
        header.clickShoppingCartPage();
         String actual = header.getTextFromFirstTape();
         assertEquals(actual,SHOPPING_CART);
    }

    @Test
    public void testCheckoutPage(){
        header.goToCheckoutCartPage();
        String actual = header.getTextFromFirstTape();
        assertEquals(actual,SHOPPING_CART);
    }
}

