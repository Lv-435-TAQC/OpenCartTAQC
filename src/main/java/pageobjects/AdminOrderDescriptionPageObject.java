package pageobjects;

import locators.AdminOrderDescriptionLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Label;

public class AdminOrderDescriptionPageObject extends BasePageObject {
    private Label coupon;
    private Label couponDiscountAmount;
    private Label giftCertificate;
    private Label giftCertificateDiscountAmount;

    public AdminOrderDescriptionPageObject(WebDriver driver) {
        super(driver);
    }

    public String getCouponCode() {
        coupon = new Label(driver, AdminOrderDescriptionLocators.COUPON_CODE);
        return coupon.getText();
    }

    public String getCouponDiscountAmount() {
        couponDiscountAmount = new Label(driver, AdminOrderDescriptionLocators.TOTAL_COST);
        return couponDiscountAmount.getText();
    }

    public String getGiftCertificateCode() {
        giftCertificate = new Label(driver, AdminOrderDescriptionLocators.GIFT_CERTIFICATE_CODE);
        return giftCertificate.getText();
    }

    public String getGiftCertificateAmount() {
        giftCertificateDiscountAmount = new Label(driver, AdminOrderDescriptionLocators.TOTAL_COST);
        return giftCertificateDiscountAmount.getText();
    }

}
