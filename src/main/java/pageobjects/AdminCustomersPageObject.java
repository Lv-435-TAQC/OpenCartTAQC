package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;

import static locators.AdminCustomersLocators.BUTTON_FILTER;
import static locators.AdminCustomersLocators.FIELD_EMAIL_XPATH;

public class AdminCustomersPageObject extends BasePageObject {

    private Input fieldEmail;
    private Button buttonFilter;

    public AdminCustomersPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminCustomersPageObject setDataToEmailField(String email) {
        this.fieldEmail = new Input(driver, FIELD_EMAIL_XPATH);
        this.fieldEmail.setText(email);
        return this;
    }

    public AdminCustomersPageObject clickOnButtonFilter() {
        this.buttonFilter = new Button(driver, BUTTON_FILTER);
        this.buttonFilter.click();
        return this;
    }
}
