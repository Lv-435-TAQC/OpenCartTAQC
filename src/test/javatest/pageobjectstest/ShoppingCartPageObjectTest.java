package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageelements.CouponInTable;
import pageelements.VoucherInTable;
import pageobjects.*;
import patterns.ShoppingCartPatterns;
import utils.Constants;
import utils.DBMethods;
import utils.TestData;
import utils.TestScreenRecorder;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ShoppingCartPageObjectTest {
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
    public void makeScreenshots(ITestResult result) throws Exception {
          TestScreenRecorder.stopRecording();
        if (result.getStatus() == ITestResult.FAILURE) {
            ShoppingCartPageObject.makeScreenShotSteps(driver, result.getName());
        } else {
                TestScreenRecorder.deleteRecord();
        }
        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public void closeUp() {
        driver.quit();
    }

    /**
     * <b>TC-01: Test adding product to shopping cart.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Verify, by ID, that iphone contains in Shopping Cart table;
     * </ul>
     * <p>
     * Expected Result: Table of products, in Shopping Cart,
     * contains added product.
     */

    @Test()
    public void testAddProductToShoppingCart() throws Exception {
        TestScreenRecorder.startRecording("testAddProductToShoppingCart");
        String productID = home.addToCartIphone();
        assertTrue(home.goToShoppingCartPage().
                getShoppingProductsList().
                containsKey(productID));
    }

    /**
     * <b>TC-02: Test adding product to shopping cart, use sikuli.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Verify, that iphone contains in Shopping Cart table;
     * </ul>
     * <p>
     * Expected Result: Table of products, in Shopping Cart,
     * contains added product.
     */

    @Test()
    public void testAddProductToShoppingCartUseSikuli() {
        Match match = new HomePageObject(driver).
                addIphoneToShoppingCartSikuly().
                openShoppingCartSikuly().
                finedElementInShoppingCartSikuly(new Pattern(ShoppingCartPatterns.IPHONE_IN_SHOPPING_CART));
        assertNotNull(match);
    }

    /**
     * <b>TC-03: Test changing quantity products, use sikuli</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Write two in quantity cell;
     * <li>5. Verify that total cost increased by 2 times ;
     * </ul>
     * <p>
     * Expected Result: Total cost increased by 2 times.
     */
    @Test()
    public void testChangingQuantityProductsUseSikuli() {
        String actual = new HomePageObject(driver).
                addIphoneToShoppingCartSikuly().
                openShoppingCartSikuly().
                changeQuantityProductsSikuly().
                getTotalCostSikuly().split(TestData.BLANK_SYMBOL)[1];
        String expected = TestData.COST_OF_TWO_IPHONES;
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-04: Test remove product from shopping cart, use siculi.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Click remove iphone;
     * <li>5. Verify that Shopping Cart Page is empty ;
     * </ul>
     * <p>
     * Expected Result: Shopping Cart does not have product,
     * and contains massage.
     */
    @Test()
    public void testRemoveProductFromCartUseSikuli() {
        String actual = new HomePageObject(driver).
                addIphoneToShoppingCartSikuly().
                openShoppingCartSikuly().
                removeProductSikuly();
        assertEquals(actual, TestData.EMPTY_SHOPPING_CART_MESSAGE);
    }

    /**
     * <b>TC-05: Test remove product from shopping cart.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Click remove iphone;
     * <li>5. Verify that Shopping Cart Page is empty ;
     * </ul>
     * <p>
     * Expected Result: Shopping Cart does not have product,
     * and contains massage.
     */

    @Test()
    public void testRemoveProductFromCart() {
        String productID = home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.removeProductFromCart(productID);
        String actual = shoppingCartPageObject.getCartEmptyMassage();
        assertEquals(actual, TestData.EMPTY_SHOPPING_CART_NOTICE);
    }

    /**
     * <b>TC-06: Test changing quantity products.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Write two in quantity cell;
     * <li>5. Verify that total cost increased by 2 times ;
     * </ul>
     * <p>
     * Expected Result: Total cost increased by 2 times.
     */
    @Test()
    public void testChangingQuantityProducts() {
        String productID = home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        String expected = TestData.COST_OF_TWO_IPHONES;
        shoppingCartPageObject.writeProductQuantityInCart(productID, TestData.QUANTITY_PRODUCTS);
        shoppingCartPageObject.updateProductQuantityInCart(productID);
        String actual = shoppingCartPageObject.getTotalCostProductInCart(productID);
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-07: Test changing quantity products (Negative).</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Write invalid data in quantity cell;
     * <li>5. Verify that the value of the product remained unchanged;
     * </ul>
     * <p>
     * Expected Result: The value of the product remained unchanged.
     */
    @DataProvider(name = "invalidDataQuantityProducts")
    public Object[][] createDataQuantityProducts(Method m) {
        return TestData.INVALID_DATA_FOR_TEST_QUANTITY_PRODUCTS;
    }

    @Test(dataProvider = "invalidDataQuantityProducts")  //Bug
    public void testChangingQuantityProductsNegative(String quantity) {
        String productID = home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        String expected = TestData.IPHONE_COST;
        shoppingCartPageObject.writeProductQuantityInCart(productID, quantity);
        shoppingCartPageObject.updateProductQuantityInCart(productID);
        String actual = shoppingCartPageObject.getTotalCostProductInCart(productID);
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-08: Test, using coupon code.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>3. Click on Use Coupon Code Tab;
     * <li>4. Write coupon code in input;
     * <li>5. Click on Apply Coupon;
     * <li>6. Verify that discount is calculated correctly;
     * </ul>
     * <p>
     * Expected Result: The value of discount is calculated correct.
     */
    @Test()
    public void testUseCouponCode() {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode(TestData.COUPON_CODE);
        String expected = TestData.DISCOUNT_COUPON_FOR_IPHONE;
        String actual = home.goToShoppingCartPage().getCouponCode();
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-09: Test, using coupon code with invalid data.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>3. Click on Use Coupon Code Tab;
     * <li>4. Write coupon code in input with invalid;
     * <li>5. Click on Apply Coupon;
     * <li>6. Verify that system will not use the coupon discount;
     * </ul>
     * <p>
     * Expected Result: The coupon discount field did not appear when calculating the total value.
     */
    @DataProvider()
    public Object[][] createData(Method m) {
        return TestData.INVALID_DATA_FOR_TEST_COUPON;
    }

    @Test(dataProvider = "createData", expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
    public void testUseCouponCodeWithInvalidData(String invalidData) {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode(invalidData);
        String expected = TestData.DISCOUNT_COUPON_FOR_IPHONE;
        String actual = home.goToShoppingCartPage().getCouponCode();
        assertNotEquals(actual, expected);
    }

    /**
     * <b>TC-10: Test, fill in estimate shipping and taxes.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>3. Click on Estimate Shipping & Taxes Tab;
     * <li>4. Fill in all inputs;
     * <li>5. Click on Get Quotes button;
     * <li>5. Verify that system showed message about shipping estimate has been applied.
     * </ul>
     * <p>
     * Expected Result: The delivery estimate message is displayed.
     */

    @Test()
    public void testWriteEstimateShippingAndTaxes() {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeEstimateShippingAndTaxes(TestData.SHIPPING_COUNTRY, TestData.SHIPPING_REGION, TestData.POST_CODE);
        String actualResult = shoppingCartPageObject.messageAboutOption();
        assertTrue(actualResult.contains(TestData.NOTICE_ABOUT_SUCCESSFUL_SHIPPING_ESTIMETE));
    }

    /**
     * <b>TC-11: Test, using gift certificate code.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>3. Click on Use Gift Certificate Tab;
     * <li>4. Write Gift Certificate code in input;
     * <li>5. Click on Apply Gift Certificate;
     * <li>6. Verify that discount is displayed correctly;
     * </ul>
     * <p>
     * Expected Result: The value of discount is displayed correctly.
     */

    @Test()
    public void testUseGiftCertificate() {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeGiftCertificate(TestData.GIFT_CERTIFICATE);
        String expected = TestData.DISCOUNT_GIFT_CERTIFICATE_FOR_IPHONE;
        String actual = home.goToShoppingCartPage().getGiftCertificate();
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-12: Test, using gift certificate code.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>3. Click on Use Gift Certificate Tab;
     * <li>4. Write Gift Certificate (invalid) code in input;
     * <li>5. Click on Apply Gift Certificate;
     * <li>6. Verify that discount was not displayed;
     * </ul>
     * <p>
     * Expected Result: The gift certificate discount field did not appear when calculating the total value.
     */
    @DataProvider()
    public Object[][] createDataForGiftCertificate(Method m) {
        return TestData.INVALID_DATA_FOR_TEST_GIFT_CERTIFICATE;
    }

    @Test(dataProvider = "createDataForGiftCertificate", expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
    public void testUseGiftCertificateWithInvalidData(String invalidDataForGift) {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeGiftCertificate(invalidDataForGift);
        String expected = TestData.DISCOUNT_GIFT_CERTIFICATE_FOR_IPHONE;
        String actual = home.goToShoppingCartPage().getGiftCertificate();
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-13: Test, calculate Total Cost With Coupon Code.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>3. Click on Use Coupon Code Tab;
     * <li>4. Write coupon code in input;
     * <li>5. Click on Apply Coupon;
     * <li>6. Verify that total cost is calculated correctly;
     * </ul>
     * <p>
     * Expected Result: The total cost is calculated correctly.
     */

    @Test()
    public void testCalculateTotalCostWithCouponCode() {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode(TestData.COUPON_CODE);
        shoppingCartPageObject.getCouponCode();
        assertEquals(shoppingCartPageObject.getTotalCost(), TestData.COST_OF_IPHONE_USING_COUPON);
    }

    /**
     * <b>TC-14: Test, calculate Total Cost With Gift Certificate.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Click on Use Gift Certificate Tab;
     * <li>5. Write gift certificate code in input;
     * <li>6. Click on Apply Gift Certificate;
     * <li>7. Verify that total cost is calculated correctly;
     * </ul>
     * <p>
     * Expected Result: The total cost is calculated correctly.
     */
    @Test()
    public void testCalculateTotalCostWithGiftCertificate() {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeGiftCertificate(TestData.GIFT_CERTIFICATE);
        shoppingCartPageObject.getGiftCertificate();
        assertEquals(shoppingCartPageObject.getTotalCost(), TestData.COST_OF_IPHONE_USING_GIFT_CERTIFICATE);
    }

    /**
     * <b>TC-15: Test, calculate Total Cost With Coupon Code and Gift Certificate.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart iphone on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Click on Use Coupon Code Tab;
     * <li>5. Write coupon code in input;
     * <li>6. Click on Apply Coupon;
     * <li>7. Click on Use Gift Certificate Tab;
     * <li>8. Write gift certificate code in input;
     * <li>9. Click on Apply Gift Certificate;
     * <li>10. Verify that total cost is calculated correctly;
     * </ul>
     * <p>
     * Expected Result: The total cost is calculated correctly.
     */

    @Test()
    public void checkTheTotalCostWithCouponCodeAndGiftCertificate() {
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.writeCouponCode(TestData.COUPON_CODE).
                getCouponCode();
        shoppingCartPageObject.writeGiftCertificate(TestData.GIFT_CERTIFICATE).
                getGiftCertificateWithWait();
        assertEquals(shoppingCartPageObject.getTotalCost(), TestData.COST_OF_IPHONE_USING_GIFT_CERTIFICATE_AND_COUPON);
    }

    /**
     * <b>TC-16: Test continue shopping.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart MacBook on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Click on Continue Shopping button;
     * <li>5. Click add to cart Iphone;
     * <li>6. Verify, that we are on OpenCart/index.php?route=common/home;
     * </ul>
     * <p>
     * Expected Result: After click continue shopping we check if we can add Iphone to Shopping Cart.
     */
    @Test()
    public void testContinueShopping() {
        home.addToCartMacBook();
        String productId = home.
                goToShoppingCartPage().
                continueShopping().
                addToCartIphone();
        assertEquals(productId, TestData.IPHONE_ID);
    }

    /**
     * <b>TC-17: Test go to Checkout page.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Click add to cart MacBook on OpenCart/index.php?route=common/home;
     * <li>3. Click on Shopping Cart Tab;
     * <li>4. Click on Checkout button;
     * <li>5. Verify, that we are on http://localhost/OpenCart/index.php?route=checkout/checkout;
     * </ul>
     * <p>
     * Expected Result: OpenCart/index.php?route=common/home is the current page and we can add Iphone to Shopping Cart.
     */
    @Test()
    public void testGoToCheckout() {
        home.addToCartMacBook();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        String actual = shoppingCartPageObject.checkout();
        assertEquals(actual, TestData.CHECKOUT_PAGE);
    }

    /**
     * <b>TC-18: Test, ordering a product using the coupon code.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Login on http://localhost/OpenCart/index.php?route=account/login;
     * <li>3. Click add to cart iPhone on OpenCart/index.php?route=common/home;
     * <li>4. Click on Shopping Cart Tab;
     * <li>5. Click on Use Coupon Code Tab;
     * <li>6. Write coupon code in input ;
     * <li>7. Click Checkout button;
     * <li>8. Click Continue on Billing Details Tub;
     * <li>9. Click Continue on Delivery Method Tub;
     * <li>10. Mark  Terms & Conditions on Payment Method Tub;
     * <li>11. Click Continue on Payment Method Tub;
     * <li>12. Click Confirm Order on Confirm Order Tub;
     * <li>13. Login on http://localhost/OpenCart/admin/index.php?route=common/login;
     * <li>14. Click on Sales Tab;
     * <li>15. Click on Orders Tab;
     * <li>16. Click View button on Order row;
     * <li>17. Verify that Total amount is discounted;
     * </ul>
     * <p>
     * Expected Result: Order includes coupon row and total cost is discounted.
     */

    @Test
    public void testOrderingProductUsingCouponCode(){
        TestScreenRecorder.startRecording("testAddProductToShoppingCart");
        DBMethods methods = new DBMethods();
        driver.get(TestData.USER_LOGIN_PAGE);
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.logIn(TestData.USER_NAME, TestData.USER_PASSWORD);
        driver.get(TestData.HOME_PAGE);
        home = new HomePageObject(driver);
        home.addToCartIphone();
        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
        shoppingCartPageObject.
                writeCouponCode(TestData.COUPON_CODE).
                getCouponCode();
        assertEquals(methods.getOrdersTotalCostFromDB(methods.getLastOrderIDFromDB()),
                shoppingCartPageObject.getTotalCost().substring(1) + "00");
        driver.get(TestData.ADMIN_PAGE);///*
        AdminPageObject adminPage = new AdminLoginPageObject(driver).
                logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD);
        AdminOrderDescriptionPageObject orderDescriptionPageObject = adminPage.closeModalWindow().
                getNavigation().
                goToOrdersList().
                getTheOrder(TestData.ORDER_ID_FOR_COUPON_TEST).
                viewOrder();
        assertEquals(orderDescriptionPageObject.getCouponCode(), TestData.COUPON_CODE_FIELD_ON_ORDER_PAGE);
        assertEquals(orderDescriptionPageObject.getCouponDiscountAmount(), TestData.COST_OF_IPHONE_USING_COUPON_WITH_SHIPPING);
    }

    /**
     * <b>TC-19: Test, ordering a product using the gift certificate.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Login on http://localhost/OpenCart/index.php?route=account/login;
     * <li>3. Click add to cart iPhone on OpenCart/index.php?route=common/home;
     * <li>4. Click on Shopping Cart Tab;
     * <li>5. Click on Use Gift Certificate Tab;
     * <li>6. Write gift code in input;
     * <li>7. Click Checkout button;
     * <li>8. Click Continue on Billing Details Tub;
     * <li>9. Click Continue on Delivery Method Tub;
     * <li>10. Mark  Terms & Conditions on Payment Method Tub;
     * <li>11. Click Continue on Payment Method Tub;
     * <li>12. Click Confirm Order on Confirm Order Tub;
     * <li>13. Login on http://localhost/OpenCart/admin/index.php?route=common/login;
     * <li>14. Click on Sales Tab;
     * <li>15. Click on Orders Tab;
     * <li>16. Click View button on Order row;
     * <li>17. Verify that Total amount is discounted;
     * </ul>
     * <p>
     * Expected Result: Order includes gift certificate row and total cost is discounted.
     */

    @Test
    public void testOrderingProductUsingGiftCertificate() {
        driver.get(TestData.USER_LOGIN_PAGE);
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.logIn(TestData.USER_NAME, TestData.USER_PASSWORD);
        driver.get(TestData.HOME_PAGE);
        home = new HomePageObject(driver);
        home.addToCartIphone();
        home.goToShoppingCartPage().
                writeGiftCertificate(TestData.GIFT_CERTIFICATE);
        driver.get(TestData.ADMIN_PAGE);
        AdminPageObject adminPage = new AdminLoginPageObject(driver).
                logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD);
        AdminOrderDescriptionPageObject orderDescriptionPageObject = adminPage.closeModalWindow().
                getNavigation().
                goToOrdersList().
                getTheOrder(TestData.ORDER_ID_FOR_GIFT_CERTIFICATE_TEST).
                viewOrder();
        assertEquals(orderDescriptionPageObject.getGiftCertificateCode(), TestData.GIFT_CERTIFICATE_FIELD_ON_ORDER_PAGE);
        assertEquals(orderDescriptionPageObject.getGiftCertificateAmount(), TestData.COST_OF_IPHONE_USING_GIFT_CERTIFICATE_WITH_SHIPPING);
    }

    /**
     * <b> TC-20: Test, Creating a new voucher.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Login on http://localhost/OpenCart/admin/index.php?route=common/login;
     * <li>3. Close Important Security Notification window;
     * <li>4. Click on Sales Tub;
     * <li>5. Click on Gift Voucher Tub;
     * <li>6. Click on Gift Voucher Tub;
     * <li>7. Click on Add New button;
     * <li>8. Fill in all fields;
     * <li>9. Click on button Save;
     * <li>10. Verify that created voucher is in vouchers table
     * </ul>
     * <p>
     * Expected Result: Voucher is created and showed in the vouchers table.
     */

    @Test(invocationCount = 1)
    public void testCreatingNewVoucher() {
        driver.get(TestData.ADMIN_PAGE);
        AdminPageObject adminPage = new AdminLoginPageObject(driver).
                logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD);
        AdminGiftVouchersPageObject vouchersPage = adminPage.closeModalWindow().
                getNavigation().
                goToVouchersList().
                goToCreationGiftVoucher().
                createNewGiftVoucher(TestData.VOUCHER_CODE, TestData.VOUCHER_FROM_NAME, TestData.VOUCHER_FROM_E_MAIL,
                        TestData.VOUCHER_TO_NAME, TestData.VOUCHER_TO_E_MAIL, TestData.VOUCHER_THEME,
                        TestData.VOUCHER_MESSAGE, TestData.VOUCHER_AMOUNT, TestData.VOUCHER_STATUS);
        assertTrue(vouchersPage.getGiftVouchersTable().containsKey(TestData.VOUCHER_CODE));
        VoucherInTable voucherInTable = (VoucherInTable) vouchersPage.getGiftVouchersTable().get(TestData.VOUCHER_CODE);
        assertEquals(voucherInTable.getAmount(), TestData.VOUCHER_AMOUNT_IN_TABLE);
    }

    /**
     * <b> TC-21: Test, Creating a new coupon.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Login on http://localhost/OpenCart/admin/index.php?route=common/login;
     * <li>3. Close Important Security Notification window;
     * <li>4. Click on Marketing Tub;
     * <li>5. Click on Coupons Tub;
     * <li>7. Click on Add New button;
     * <li>8. Fill in all fields;
     * <li>9. Click on button Save;
     * <li>10. Verify that created coupon is in coupons table
     * </ul>
     * <p>
     * Expected Result: Coupon is created and showed in the coupons table.
     */

    @Test(invocationCount = 1)
    public void testCreatingNewCoupon() {
        driver.get(TestData.ADMIN_PAGE);
        AdminPageObject adminPage = new AdminLoginPageObject(driver).
                logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD);
        AdminCouponsPageObject adminCouponsPageObject = adminPage.
                closeModalWindow().
                getNavigation().
                goToCouponsList().
                goToCreationCoupon().
                createNewCoupon(TestData.COUPON_NAME, TestData.COUPON_CREATING_CODE, TestData.COUPON_TYPE, TestData.COUPON_DISCOUNT,
                        TestData.COUPON_TOTAL_AMOUNT, TestData.COUPON_DATE_START, TestData.COUPON_DATE_END,
                        TestData.COUPON_USES_PER_COUPON, TestData.COUPON_USES_PER_CUSTOMER, TestData.COUPON_STATUS);
        assertTrue(adminCouponsPageObject.getCouponsTable().containsKey(TestData.COUPON_CREATING_CODE));
        CouponInTable coupons = (CouponInTable) adminCouponsPageObject.getCouponsTable().get(TestData.COUPON_CREATING_CODE);
        assertEquals(coupons.getDiscount(), TestData.COUPON_DISCOUNT);
    }

}
