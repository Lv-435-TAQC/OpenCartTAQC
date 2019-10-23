package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageelements.Input;

public class AdminCreationGiftVoucherPageObject extends BasePageObject {
    Input code;
    Input fromName;
    Input fromEMail;
    Input toName;
    Input toEMail;
    Select theme;
    Input message;
    Input amount;
    Select Status;
    public AdminCreationGiftVoucherPageObject(WebDriver driver) {
        super(driver);
    }

}
