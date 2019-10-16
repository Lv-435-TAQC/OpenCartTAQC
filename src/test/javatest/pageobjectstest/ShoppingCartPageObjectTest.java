package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobjects.HomePageObject;
import pageobjects.ShoppingCartPageObject;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ShoppingCartPageObjectTest {
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
        // driver.quit();
    }

    @Test
    public void testAddProductToShoppinCart() {
        String productID = home.addToCart();
        assertTrue(home.goToShoppingCartPage().getShoppinProductsList().containsKey(productID));
    }

    @Test
    public void testRemoveProductFromCart() {
        String productID = home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.removeProductFromCart(productID);
        assertEquals(shoppingCartPageObject.getCartEmptyMassage(), "Your shopping cart is empty!");
    }

    @Test
    public void testChangingQuantityProducts() {
        String productID = home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        String expected = "$246.40";
        shoppingCartPageObject.writeProductQuantityInCart(productID,"2");
        shoppingCartPageObject.updateProductQuantityInCart(productID);
        String actual =shoppingCartPageObject.getTotalCostProductInCart(productID);
        assertEquals(actual, expected);
    }

    @Test(invocationCount = 1)
    public void testUseCouponCode() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode("111");
        String expected = "$-10.10";
        String actual = home.goToShoppingCartPage().getCouponCode();
        assertEquals(actual, expected);
    }


    @DataProvider(name = "invalidData")
    public Object[][] createData(Method m) {
        return new Object[][]{new Object[]{"a111"}, new Object[]{""}};
    }

    @Test(dataProvider = "invalidData", expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
    public void testUseCouponCodeWithInvalidData(String invalidData) {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode(invalidData);
        String expected = "$-10.10";
        String actual = home.goToShoppingCartPage().getCouponCode();
        assertNotEquals(actual, expected);
    }

    @Test(invocationCount = 3)
    public void testWriteEstimateShippingAndTaxes() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeEstimateShippingAndTaxes("Ukraine", 13, "790032");
        String actualResult = shoppingCartPageObject.massageNotise();

        assertTrue(actualResult.contains("Success: Your shipping estimate has been applied"));
    }

    @Test
    public void testWriteGiftCertificate() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeGiftCertificate("333");
        String expected = "$-100.00";
        String actual = home.goToShoppingCartPage().getGiftCertificate();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "invalidDataGift")
    public Object[][] createDataForGiftCertificate(Method m) {
        return new Object[][]{new Object[]{"a333"}, new Object[]{""}, new Object[]{"333a"}};
    }

    @Test(dataProvider = "invalidDataGift", expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
    public void testUseGiftCertificateWithInvalidData(String invalidDataForGift) {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeGiftCertificate(invalidDataForGift);
        String expected = "$-30.00";
        String actual = home.goToShoppingCartPage().getGiftCertificate();
        assertEquals(actual, expected);
    }

    @Test(invocationCount = 1)
    public void checkTheTotalCostWithCouponCode() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode("111");
        shoppingCartPageObject.getCouponCode();
        assertEquals(shoppingCartPageObject.getTotalCost(), "$111.08");
    }

    @Test
    public void checkTheTotalCostWithGiftCertificate() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeGiftCertificate("333");
        shoppingCartPageObject.getGiftCertificate();
        assertEquals(shoppingCartPageObject.getTotalCost(), "$93.20");
    }

    @Test(invocationCount = 1)
    public void checkTheTotalCostWithCouponCodeAndGiftCertificate() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode("111");
        shoppingCartPageObject.getCouponCode();
        shoppingCartPageObject.writeGiftCertificate("333");
        shoppingCartPageObject.getGiftCertificate();
        assertEquals(shoppingCartPageObject.getTotalCost(), "$81.08");
    }

    @Test
    public void testContinueShopping() {
        home.addToCart();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        HomePageObject home = shoppingCartPageObject.continueShopping();
//        String actual = home.getURL();
//        String expected = "http://localhost/OpenCart/index.php?route=common/home";
//        assertEquals(actual, expected);
    }
//
//    @Test
//    public void testCheckout() {
//        assertEquals("","");
//    }

}