package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.HeaderPageObject;
import pageobjects.HomePageObject;
import pageobjects.PreviewShoppingCart;
import utils.Constants;
import utils.TestData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PreviewShoppingCartTest {
    WebDriver driver;
    HomePageObject home;

    @BeforeClass
    public void setUp() {
        System.setProperty(Constants.KEY_TO_DRIVER, Constants.PATH_TO_DRIVER);
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestData.HOME_PAGE);
        home = new HomePageObject(driver);
    }
    @AfterMethod
    public void makeScreenshots(ITestResult result) {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    /**
     * <b>TC-01: Test adding product to preview shopping cart.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on button preview product in cart;
     * <li>4. Verify, that iphone contains in Shopping Cart table;
     * </ul>
     * <p>
     * Expected Result: Table of products, in Shopping Cart,
     * contains added product.
     */
    @Test
    public void testProductInPreviewCart() {
        String productID = home.addToCartIphone();
        HeaderPageObject header = home.getHeaderPageObject();
        PreviewShoppingCart shoppingCartPageObject = header.getPreviewShoppingCart();
        assertTrue(shoppingCartPageObject.getMapProductInCart().containsKey(productID));
    }
    /**
     * <b>TC-05: Test remove product from shopping cart.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on button preview product in cart;
     * <li>4. Click remove iphone;
     * <li>5. Verify that Shopping Cart is empty (on preview button);
     * </ul>
     * <p>
     * Expected Result: Shopping Cart does not have product,
     * and contains massage.
     */
    @Test
    public void testRemoveProductFromShoppingCart() {
        home.addToCartIphone();
        String productID = home.addToCartMacBook();
        HeaderPageObject header = home.getHeaderPageObject();
        PreviewShoppingCart previewShoppingCart = header.getPreviewShoppingCart();
        previewShoppingCart.removeProductFromShoppingCart(productID);
        previewShoppingCart = header.getPreviewShoppingCart();
        assertFalse(previewShoppingCart.getMapProductInCart().containsKey(productID));
    }
}