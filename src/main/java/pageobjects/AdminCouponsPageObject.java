package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.Button;

public class AdminCouponsPageObject extends BasePageObject {
    private Button addNewCoupons;
    public AdminCouponsPageObject(WebDriver driver) {
        super(driver);
    }
    public AdminCreationCouponPageObject goToCreationCoupon(){
        this.addNewCoupons = new Button(driver, "/html/body/div/div/div[1]/div/div/a").click();
        return new AdminCreationCouponPageObject(driver);
    }
}
