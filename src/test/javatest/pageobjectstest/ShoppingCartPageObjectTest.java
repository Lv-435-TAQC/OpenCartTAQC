package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePageObject;
import pageobjects.ShoppingCartPageObject;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ShoppingCartPageObjectTest  {
    WebDriver driver;
    HomePageObject home;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/OpenCart");
        home = new HomePageObject(driver);

    }
    @AfterClass
    public void closeUp() {
      //  driver.close();
    }

    @Test
    public void testAddProductToShoppinCart() {
        String productID = home.addToCart();
        assertTrue(home.goToShoppingCartPage().getShoppinProductsList().containsKey( productID));
    }

    @Test
    public void testUseCouponCode() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode("111");
        String expected = "$-10.10";
        String actual = home.goToShoppingCartPage().getCouponCode();
        assertEquals(actual,expected);
    }
    @Test(
            expectedExceptions =  org.openqa.selenium.NoSuchElementException.class
            )
    public void testUseCouponCodeWithInvalidData() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode("a111");
        String expected = "$-10.10";
        String actual = home.goToShoppingCartPage().getCouponCode();
       assertNotEquals(actual,expected);
    }

    @Test
    public void testWriteEstimateShippingAndTaxes() {
        assertEquals("","");
    }

    @Test
    public void testChooseFletRate() {
        assertEquals("","");
    }

    @Test
    public void testWriteGiftCertificate() {
        assertEquals("","");
    }

    @Test
    public void testContinueShopping() {
        assertEquals("","");
    }

    @Test
    public void testCheckout() {
        assertEquals("","");
    }

    @Test
    public void testGetSubTotalCost() {
        assertEquals("","");
    }

    @Test
    public void testGetCouponCode() {
        assertEquals("","");
    }

    @Test
    public void testGetEcoTax() {
        assertEquals("","");
    }

    @Test
    public void testGetVAT() {
        assertEquals("","");
    }

    @Test
    public void testGetGiftCertificate() {
        assertEquals("","");
    }

    @Test
    public void testGetTotalCost() {
        assertEquals("","");
    }

    @Test
    public void testMassageNotise() {
        assertEquals("","");
    }
}