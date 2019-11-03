package pageobjects;

import locators.CheckoutConfirmOrderLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;

public class CheckoutConfirmOrderPageObject extends BasePageObject {
    private Button continueButton;

    public CheckoutConfirmOrderPageObject(WebDriver driver) {
        super(driver);
    }

    public CheckoutConfirmOrderPageObject clickContiuneButton() {
        continueButton = new Button(this.driver, CheckoutConfirmOrderLocators.CONFIRM_ORDER);
        continueButton.click();
        return this;
    }

}
