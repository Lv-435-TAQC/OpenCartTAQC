package pageobjects;

import locators.CheckoutPaymentMethodLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Checkbox;
import pageelements.Input;


public class CheckoutPaymentMethodPageObject extends BasePageObject {
    private Input addCommentsAboutYourOrderField;
    private Button continueButton;
    private Button cashOnDelivery;
    private Checkbox termsAndConditions;

    public CheckoutPaymentMethodPageObject(WebDriver driver) {
        super(driver);
    }

    public CheckoutConfirmOrderPageObject paymentMethodWithCommentsAboutYourOrder(String addCommentsAboutYourOrder) {
        this
                .clickFlatShippingRateButton()
                .setCommentsAboutYourOrder(addCommentsAboutYourOrder)
                .checkOnPrivacyPolicyCheckbox()
                .clickContinueButton();
        return new CheckoutConfirmOrderPageObject(driver);
    }

    public CheckoutConfirmOrderPageObject paymentMethodWithoutCommentsAboutYourOrder() {
        this
                .clickFlatShippingRateButton()
                .checkOnPrivacyPolicyCheckbox()
                .clickContinueButton();
        return new CheckoutConfirmOrderPageObject(driver);
    }

    public CheckoutPaymentMethodPageObject setCommentsAboutYourOrder(String addCommentsAboutYourOrder) {
        addCommentsAboutYourOrderField = new Input(this.driver, CheckoutPaymentMethodLocators.INPUT_COMMENTS_ABOUT_YOUR_ORDER_PAYMENT);
        addCommentsAboutYourOrderField.setText(addCommentsAboutYourOrder);
        return this;
    }

    public CheckoutPaymentMethodPageObject clickFlatShippingRateButton() {
        cashOnDelivery = new Button(this.driver, CheckoutPaymentMethodLocators.CASH_ON_DELIVERY);
        cashOnDelivery.click();
        return this;
    }

    public CheckoutConfirmOrderPageObject clickContinueButton() {
        continueButton = new Button(this.driver, CheckoutPaymentMethodLocators.CONTINUE_PAYMENT_METHOD);
        continueButton.click();
        return new CheckoutConfirmOrderPageObject(driver);
    }
    public CheckoutPaymentMethodPageObject checkOnPrivacyPolicyCheckbox() {
        termsAndConditions = new Checkbox(driver, CheckoutPaymentMethodLocators.TERMS_AND_CONDITIONS);
        termsAndConditions.clickOnCheckbox();
        return this;
    }
}