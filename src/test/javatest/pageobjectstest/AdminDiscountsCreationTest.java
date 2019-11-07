package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageelements.CouponInTable;
import pageelements.VoucherInTable;
import pageobjects.AdminCouponsPageObject;
import pageobjects.AdminGiftVouchersPageObject;
import pageobjects.AdminLoginPageObject;
import pageobjects.ShoppingCartPageObject;
import utils.Constants;
import utils.TestData;
import utils.TestScreenRecorder;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AdminDiscountsCreationTest {
    WebDriver driver;
    AdminLoginPageObject loginPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty(Constants.KEY_TO_DRIVER, Constants.PATH_TO_DRIVER);
        driver = new FirefoxDriver();
    }


    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestData.ADMIN_PAGE);
        loginPageObject = new AdminLoginPageObject(driver);
    }

    @AfterMethod
    public void makeScreenshots(ITestResult result) {
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
        TestScreenRecorder.startRecording("testCreatingNewVoucher");
        AdminGiftVouchersPageObject vouchersPage = loginPageObject.logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD)
                .closeModalWindow()
                .getNavigation()
                .goToVouchersList()
                .goToCreationGiftVoucher()
                .createNewGiftVoucher(TestData.VOUCHER_CODE, TestData.VOUCHER_FROM_NAME, TestData.VOUCHER_FROM_E_MAIL,
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
        TestScreenRecorder.startRecording("testCreatingNewCoupon");
        AdminCouponsPageObject adminCouponsPageObject = loginPageObject.logIn(TestData.ADMIN_NAME, TestData.ADMIN_PASSWORD)
                .closeModalWindow()
                .getNavigation()
                .goToCouponsList()
                .goToCreationCoupon()
                .createNewCoupon(TestData.COUPON_NAME, TestData.COUPON_CREATING_CODE, TestData.COUPON_TYPE, TestData.COUPON_DISCOUNT,
                        TestData.COUPON_TOTAL_AMOUNT, TestData.COUPON_DATE_START, TestData.COUPON_DATE_END,
                        TestData.COUPON_USES_PER_COUPON, TestData.COUPON_USES_PER_CUSTOMER, TestData.COUPON_STATUS);
        assertTrue(adminCouponsPageObject.getCouponsTable().containsKey(TestData.COUPON_CREATING_CODE));
        CouponInTable coupons = (CouponInTable) adminCouponsPageObject.getCouponsTable().get(TestData.COUPON_CREATING_CODE);
        assertEquals(coupons.getDiscount(), TestData.COUPON_DISCOUNT);
    }
}
