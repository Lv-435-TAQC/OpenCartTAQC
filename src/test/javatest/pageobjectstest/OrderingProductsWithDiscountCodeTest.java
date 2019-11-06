package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.AdminOrderDescriptionPageObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.ShoppingCartPageObject;
import utils.Constants;
import utils.DBMethods;
import utils.TestData;
import utils.TestScreenRecorder;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class OrderingProductsWithDiscountCodeTest {
    WebDriver driver;
    LoginPageObject login;

    @BeforeClass
    public void setUp() {
        System.setProperty(Constants.KEY_TO_DRIVER, Constants.PATH_TO_DRIVER);
        driver = new FirefoxDriver();
    }


    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestData.USER_LOGIN_PAGE);
        login = new LoginPageObject(driver);
    }

    @AfterMethod
    public void makeScreenshots(ITestResult result)  {
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

//    @Test
//    public void testOrderingProductUsingCouponCode() {
//       TestScreenRecorder.startRecording("testOrderingProductUsingCouponCode");
//        DBMethods methods = new DBMethods();
//        login.logIn(TestData.USER_NAME, TestData.USER_PASSWORD);
//        HomePageObject home = login.goToHome();
//        home.addToCartIphone();
//        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
//        shoppingCartPageObject.
//                writeCouponCode(TestData.COUPON_CODE).
//                getCouponCode();
//        String totalCostFromShoppingCartPage= shoppingCartPageObject.getTotalCost().substring(1) + "00";
//        AdminOrderDescriptionPageObject orderDescriptionPageObject = shoppingCartPageObject.
//                goCheckoutBillingDetails().
//                clickIWantUseAnExistingAddressButton()
//                .wantUseAnExistingAddressButton()
//                .wantUseAnExistingAddressButton()
//                .deliveryMethodWithCommentsAboutYourOrder("My buy")
//                .paymentMethodWithCommentsAboutYourOrder("I paid")
//                .clickContinueButton().
//                        goToAdminPage().
//                        logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD).
//                        closeModalWindow().
//                        getNavigation().
//                        goToOrdersList().
//                        getTheOrder(new DBMethods().getLastOrderIDFromDB()).
//                        viewOrder();
//        assertEquals(methods.getOrdersTotalCostFromDB(methods.getLastOrderIDFromDB()), totalCostFromShoppingCartPage);
//        assertEquals(orderDescriptionPageObject.getCouponCode(), TestData.COUPON_CODE_FIELD_ON_ORDER_PAGE);
//        assertEquals(orderDescriptionPageObject.getCouponDiscountAmount(), TestData.COST_OF_IPHONE_USING_COUPON_WITH_SHIPPING);
//    }

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

//    @Test
//    public void testOrderingProductUsingGiftCertificate() {
//        TestScreenRecorder.startRecording("GiftCertificate");
//        login.logIn(TestData.USER_NAME, TestData.USER_PASSWORD);
//        HomePageObject home = login.goToHome();
//        home.addToCartIphone();
//        ShoppingCartPageObject shoppingCartPageObject = home.goToShoppingCartPage();
//        shoppingCartPageObject.
//                writeGiftCertificate(TestData.GIFT_CERTIFICATE).
//                getGiftCertificateWithWait();
//        AdminOrderDescriptionPageObject orderDescriptionPageObject = shoppingCartPageObject.
//                goCheckoutBillingDetails().
//                clickIWantUseAnExistingAddressButton()
//                .wantUseAnExistingAddressButton()
//                .wantUseAnExistingAddressButton()
//                .deliveryMethodWithCommentsAboutYourOrder("My buy")
//                .paymentMethodWithCommentsAboutYourOrder("I paid")
//                .clickContinueButton().
//                        goToAdminPage().
//                        logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD).
//                        closeModalWindow().
//                        getNavigation().
//                        goToOrdersList().
//                        getTheOrder(new DBMethods().getLastOrderIDFromDB()).
//                        viewOrder();
//        assertEquals(orderDescriptionPageObject.getGiftCertificateCode(), TestData.GIFT_CERTIFICATE_FIELD_ON_ORDER_PAGE);
//        assertEquals(orderDescriptionPageObject.getGiftCertificateAmount(), TestData.COST_OF_IPHONE_USING_GIFT_CERTIFICATE_WITH_SHIPPING);
//    }

}
