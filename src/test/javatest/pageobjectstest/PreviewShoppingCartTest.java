package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HeaderPageObject;
import pageobjects.HomePageObject;
import pageobjects.PreviewShoppingCart;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class PreviewShoppingCartTest {
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
        driver.quit();
    }
    @Test
    public void testGetMapProductInCart() {
        String productID = home.addToCartIphone();
        HeaderPageObject header = home.goToHeaderPage();
        PreviewShoppingCart shoppingCartPageObject = header.getPreviewShoppingCart();
        assertTrue(shoppingCartPageObject.getMapProductInCart().containsKey(productID));
    }

    @Test
    public void testRemoveProductFromShoppingCart() {
        home.addToCartIphone();
        String productID = home.addToCartMacBook();
        HeaderPageObject header = home.goToHeaderPage();
        PreviewShoppingCart previewShoppingCart = header.getPreviewShoppingCart();
        previewShoppingCart.removeProductFromShoppingCart(productID);
        previewShoppingCart = header.getPreviewShoppingCart();
        assertFalse(previewShoppingCart.getMapProductInCart().containsKey(productID));
    }
}