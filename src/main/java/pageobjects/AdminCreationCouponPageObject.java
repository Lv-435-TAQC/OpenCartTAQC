package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.DropDown;

public class AdminCreationCouponPageObject extends BasePageObject {
    private String couponName;
    private String code;
    private DropDown type;
    private String discount;
    private String totalAmount;
    private String customerLogin;
    private String freeShipping;
    private String products;
    private String category;
    private String dateStart;
    private String dateEnd;
    private String usesPerCoupon;
    private String usesPerCustomer;
    private DropDown Status;
    private Button saveNewCoupon;


    public AdminCreationCouponPageObject(WebDriver driver) {
        super(driver);
    }
}
