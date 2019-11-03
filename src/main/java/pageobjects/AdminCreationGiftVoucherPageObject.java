package pageobjects;

import locators.AdminCreationGiftVoucherLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;

public class AdminCreationGiftVoucherPageObject extends BasePageObject {

    private Input code;
    private Input fromName;
    private Input fromEMail;
    private Input toName;
    private Input toEMail;
    private DropDown theme;
    private Input message;
    private Input amount;
    private DropDown status;
    private Button saveGiftVoucher;

    public AdminCreationGiftVoucherPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminGiftVouchersPageObject createNewGiftVoucher(
            String giftCode, String fromName, String fromEMail, String toName,
            String toEMailGift, String theme, String message, String amount, String status) {
        this.writeGiftCode(giftCode).
                writeFromName(fromName).
                writeFromEMail(fromEMail).
                writeToName(toName).
                writeToEMail(toEMailGift).
                writeTheme(theme).
                writeMessage(message).
                writeAmount(amount).
                writeStatus(status).
                saveGiftVoucher();
        return new AdminGiftVouchersPageObject(driver);
    }

    public AdminCreationGiftVoucherPageObject writeGiftCode(String giftCode) {
        this.code = new Input(driver, AdminCreationGiftVoucherLocators.GIFT_CODE);
        this.code.setText(giftCode);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeFromName(String fromNameGift) {
        this.fromName = new Input(driver, AdminCreationGiftVoucherLocators.FROM_NAME);
        this.fromName.setText(fromNameGift);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeFromEMail(String fromEMailGift) {
        this.fromEMail = new Input(driver, AdminCreationGiftVoucherLocators.FROM_E_MAIL);
        this.fromEMail.setText(fromEMailGift);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeToName(String toNameGift) {
        this.toName = new Input(driver, AdminCreationGiftVoucherLocators.TO_NAME);
        this.toName.setText(toNameGift);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeToEMail(String toEMailGift) {
        this.toEMail = new Input(driver, AdminCreationGiftVoucherLocators.TO_E_MAIL);
        this.toEMail.setText(toEMailGift);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeTheme(String themeGift) {
        this.theme = new DropDown(driver, AdminCreationGiftVoucherLocators.THEME);
        this.theme.writeOptionParameter(themeGift);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeMessage(String message) {
        this.message = new Input(driver, AdminCreationGiftVoucherLocators.MESSAGE);
        this.message.setText(message);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeAmount(String amount) {
        this.amount = new Input(driver, AdminCreationGiftVoucherLocators.AMOUNT);
        this.amount.setText(amount);
        return this;
    }

    public AdminCreationGiftVoucherPageObject writeStatus(String status) {
        this.status = new DropDown(driver, AdminCreationGiftVoucherLocators.STATUS);
        this.status.writeOptionParameter(status);
        return this;
    }

    public AdminCreationGiftVoucherPageObject saveGiftVoucher() {
        this.saveGiftVoucher = new Button(driver, AdminCreationGiftVoucherLocators.SAVE_GIFT_VOUCHER);
        this.saveGiftVoucher.click();
        return this;
    }

}
