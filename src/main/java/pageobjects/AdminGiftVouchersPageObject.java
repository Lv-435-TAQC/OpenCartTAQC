package pageobjects;

import locators.AdminGiftVouchersLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;

public class AdminGiftVouchersPageObject extends BasePageObject {
    private Button addNewVoucher;
    public AdminGiftVouchersPageObject(WebDriver driver) {
        super(driver);
    }
    public AdminCreationGiftVoucherPageObject goToCreationGiftVoucher(){
        this.addNewVoucher = new Button(driver, AdminGiftVouchersLocators.ADD_NEW_VOUCHER).click();
        return new AdminCreationGiftVoucherPageObject(driver);
    }

}
