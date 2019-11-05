package pageobjects;

import locators.CheckoutBillingDetailsLocators;
import locators.CheckoutConfirmOrderLocators;
import locators.LoginLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.Label;

public class CheckoutConfirmOrderPageObject extends BasePageObject {
    private Button continueButton;
private Label successMessage;
    public CheckoutConfirmOrderPageObject(WebDriver driver) {
        super(driver);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutConfirmOrderLocators.CONFIRM_ORDER)));
    }

    public CheckoutConfirmOrderPageObject clickContinueButton() {
        continueButton = new Button(this.driver, CheckoutConfirmOrderLocators.CONFIRM_ORDER);
        continueButton.click();
        return this;
    }

    public String succssessMessage()
    {
        successMessage = new Label(this.driver, CheckoutConfirmOrderLocators.SUCCSSESS_ORDER);
        return this.successMessage.getText();
    }
}
