package pageobjects;

import locators.AdminCreationCouponLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;

public class AdminCreationCouponPageObject extends BasePageObject {
    private Input couponName;
    private Input couponCode;
    private DropDown couponType;
    private Input discount;
    private Input totalAmount;
    private Button customerLogin;
    private Button freeShipping;
    private Input products;
    private Input category;
    private Input dateStart;
    private Input dateEnd;
    private Input usesPerCoupon;
    private Input usesPerCustomer;
    private DropDown status;
    private Button saveNewCoupon;


    public AdminCreationCouponPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminCouponsPageObject createNewCoupon(
            String couponName, String couponCode, String couponType,
            String discount, String totalAmount, String dateStart,
            String dateEnd, String usesPerCoupon,
            String usesPerCustomer, String status) {
        this.writeCouponName(couponName).
                writeCouponCode(couponCode).
                writeCouponType(couponType).
                writeCouponDiscount(discount).
                writeCouponTotalAmount(totalAmount).
                writeCustomerLogin().
                writeShipping().
                writeDateStart(dateStart).
                writeDateEnd(dateEnd).
                writeUsesPerCoupon(usesPerCoupon).
                writeUsesPerCustomer(usesPerCustomer).
                writeStatus(status).
                saveNewCoupon();
        return new AdminCouponsPageObject(driver);
    }

    public AdminCreationCouponPageObject writeCouponName(String couponName) {
        this.couponName = new Input(driver, AdminCreationCouponLocators.COUPON_NAME);
        this.couponName.setText(couponName);
        return this;
    }

    public AdminCreationCouponPageObject writeCouponCode(String couponCode) {
        this.couponCode = new Input(driver, AdminCreationCouponLocators.COUPON_CODE);
        this.couponCode.setText(couponCode);
        return this;
    }

    public AdminCreationCouponPageObject writeCouponType(String couponType) {
        this.couponType = new DropDown(driver, AdminCreationCouponLocators.COUPON_TYPE);
        this.couponType.writeOptionParameter(couponType);
        return this;
    }


    public AdminCreationCouponPageObject writeCouponDiscount(String couponDiscount) {
        this.discount = new Input(driver, AdminCreationCouponLocators.DISCOUNT);
        this.discount.setText(couponDiscount);
        return this;
    }

    public AdminCreationCouponPageObject writeCouponTotalAmount(String couponTotalAmount) {
        this.totalAmount = new Input(driver, AdminCreationCouponLocators.TOTAL_AMOUNT);
        this.totalAmount.setText(couponTotalAmount);
        return this;
    }


    public AdminCreationCouponPageObject writeCustomerLogin() {
        this.customerLogin = new Button(driver, AdminCreationCouponLocators.CUSTOMER_LOGIN);
        this.customerLogin.click();
        return this;
    }

    public AdminCreationCouponPageObject writeShipping() {
        this.freeShipping = new Button(driver, AdminCreationCouponLocators.SHIPPING);
        this.freeShipping.click();
        return this;
    }


    public AdminCreationCouponPageObject writeProducts(String products) {
        this.products = new Input(driver, AdminCreationCouponLocators.PRODUCTS);
        this.products.setText(products);
        return this;
    }

    public AdminCreationCouponPageObject writeCategory(String category) {
        this.category = new Input(driver, AdminCreationCouponLocators.CATEGORY);
        this.category.setText(category);
        return this;
    }


    public AdminCreationCouponPageObject writeDateStart(String dateStart) {
        this.dateStart = new Input(driver, AdminCreationCouponLocators.DATA_START);
        this.dateStart.setText(dateStart);
        return this;
    }


    public AdminCreationCouponPageObject writeDateEnd(String dateEnd) {
        this.dateEnd = new Input(driver, AdminCreationCouponLocators.DATA_END);
        this.dateEnd.setText(dateEnd);
        return this;
    }


    public AdminCreationCouponPageObject writeUsesPerCoupon(String usesPerCoupon) {
        this.usesPerCoupon = new Input(driver, AdminCreationCouponLocators.USES_PER_COUPON);
        this.usesPerCoupon.setText(usesPerCoupon);
        return this;
    }

    public AdminCreationCouponPageObject writeUsesPerCustomer(String usesPerCustomer) {
        this.usesPerCustomer = new Input(driver, AdminCreationCouponLocators.USES_PER_CUSTOMER);
        this.usesPerCustomer.setText(usesPerCustomer);
        return this;
    }

    public AdminCreationCouponPageObject writeStatus(String status) {
        this.status = new DropDown(driver, AdminCreationCouponLocators.STATUS);
        this.status.writeOptionParameter(status);
        return this;
    }

    public AdminCreationCouponPageObject saveNewCoupon() {
        this.saveNewCoupon = new Button(driver, AdminCreationCouponLocators.SUBMIT);
        this.saveNewCoupon.click();
        return this;
    }

}
