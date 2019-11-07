package pageobjects;

import locators.CheckoutDeliveryMethodLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.Input;

public class CheckoutDeliveryMethodPageObject extends BasePageObject {
    private Input addCommentsAboutYourOrderField;
    private Button continueButton;
    private Button flatShippingRate;

    public CheckoutDeliveryMethodPageObject(WebDriver driver) {
        super(driver);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutDeliveryMethodLocators.INPUT_COMMENTS_ABOUT_YOUR_ORDER_DELIVERY)));
    }

    public CheckoutPaymentMethodPageObject deliveryMethodWithCommentsAboutYourOrder(String addCommentsAboutYourOrder) {
        this
              //  .clickFlatShippingRateButton()
                .setCommentsAboutYourOrder(addCommentsAboutYourOrder)
                .clickContinueButton();
        return new CheckoutPaymentMethodPageObject(driver);
    }

    public CheckoutPaymentMethodPageObject deliveryMethodWithoutCommentsAboutYourOrder() {
        this
               // .clickFlatShippingRateButton()
                .clickContinueButton();
        return new CheckoutPaymentMethodPageObject(driver);
    }

    public CheckoutDeliveryMethodPageObject setCommentsAboutYourOrder(String addCommentsAboutYourOrder) {
        addCommentsAboutYourOrderField = new Input(this.driver, CheckoutDeliveryMethodLocators.INPUT_COMMENTS_ABOUT_YOUR_ORDER_DELIVERY);
        addCommentsAboutYourOrderField.setText(addCommentsAboutYourOrder);
        return this;
    }

    public CheckoutDeliveryMethodPageObject clickFlatShippingRateButton() {
        flatShippingRate = new Button(this.driver, CheckoutDeliveryMethodLocators.FLAT_SHIPPING_RATE);
        flatShippingRate.click();
        return this;
    }

    public CheckoutPaymentMethodPageObject clickContinueButton() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutDeliveryMethodLocators.CONTINUE_DELIVERY_METHOD)));
        continueButton = new Button(this.driver, CheckoutDeliveryMethodLocators.CONTINUE_DELIVERY_METHOD);
        continueButton.click();
        return new CheckoutPaymentMethodPageObject(driver);

    }
}
