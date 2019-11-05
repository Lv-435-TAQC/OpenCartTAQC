package pageobjects;

import locators.CheckoutDeliveryMethodLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;

public class CheckoutDeliveryMethodPageObject extends BasePageObject {
    private Input addCommentsAboutYourOrderField;
    private Button continueButton;
    private Button flatShippingRate;

    public CheckoutDeliveryMethodPageObject(WebDriver driver) {
        super(driver);
    }

    public CheckoutPaymentMethodPageObject deliveryMethodWithCommentsAboutYourOrder(String addCommentsAboutYourOrder) {
        this
                .clickFlatShippingRateButton()
                .setCommentsAboutYourOrder(addCommentsAboutYourOrder)
                .clickContinueButton();
        return new CheckoutPaymentMethodPageObject(driver);
    }

    public CheckoutPaymentMethodPageObject deliveryMethodWithoutCommentsAboutYourOrder() {
        this
                .clickFlatShippingRateButton()
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
        continueButton = new Button(this.driver, CheckoutDeliveryMethodLocators.CONTINUE_DELIVERY_METHOD);
        continueButton.click();
        return new CheckoutPaymentMethodPageObject(driver);

    }
}
