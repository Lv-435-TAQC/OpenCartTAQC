package pageobjects;

import locators.AdminGiftVouchersLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;

public class AdminGiftVouchersPageObject extends BasePageObject {
    Button addNewVoucher;
    public AdminGiftVouchersPageObject(WebDriver driver) {
        super(driver);
    }
    public AdminCreationGiftVoucherPageObject goToCreationGiftVoucher(){
        addNewVoucher = new Button(driver, AdminGiftVouchersLocators.ADD_NEW_VOUCHER).click();
        return new AdminCreationGiftVoucherPageObject(driver);
    }

}
