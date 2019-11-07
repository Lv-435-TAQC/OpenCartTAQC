package pageobjects;

import locators.CheckoutPaymentMethodLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutPaymentMethodLocators.CONTINUE_PAYMENT_METHOD)));
        this
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
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutPaymentMethodLocators.TERMS_AND_CONDITIONS)));

        cashOnDelivery = new Button(this.driver, CheckoutPaymentMethodLocators.CASH_ON_DELIVERY);
        cashOnDelivery.click();
        return this;
    }

    public CheckoutConfirmOrderPageObject clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckoutPaymentMethodLocators.CONTINUE_PAYMENT_METHOD)));
        continueButton = new Button(this.driver, CheckoutPaymentMethodLocators.CONTINUE_PAYMENT_METHOD);
        try {
            Thread.sleep(5000);
            continueButton.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new CheckoutConfirmOrderPageObject(driver);
    }

    public CheckoutPaymentMethodPageObject checkOnPrivacyPolicyCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CheckoutPaymentMethodLocators.TERMS_AND_CONDITIONS)));
        termsAndConditions = new Checkbox(driver, CheckoutPaymentMethodLocators.TERMS_AND_CONDITIONS);
        termsAndConditions.clickOnCheckbox();
        return this;
    }
}
