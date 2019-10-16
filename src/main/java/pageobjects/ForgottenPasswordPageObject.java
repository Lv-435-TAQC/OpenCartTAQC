package pageobjects;

import locators.ForgottenPasswordLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;

public class ForgottenPasswordPageObject extends BasePageObject {
    private Input loginFieldForgot;
    private Button continueButton;
    private Button backToLoginButton;

    public ForgottenPasswordPageObject(WebDriver driver) {
        super(driver);
    }

    public ForgottenPasswordPageObject setEmailFieldForgotten(String loginName) {
        loginFieldForgot = new Input(this.driver, ForgottenPasswordLocators.INPUT_EMAIL_FIELD_FOR_FORGOTTEN_PASSWORD_PAGE);
        loginFieldForgot.setTextForField(loginName);
        return this;
    }

    public ForgottenPasswordPageObject clickContinueButton() {
        continueButton = new Button(this.driver, ForgottenPasswordLocators.CONTINUE_FORGOTTEN_PAGE_BUTTON);
        continueButton.click();
        return this;
    }

    public ForgottenPasswordPageObject clickBackToLoginPageButton() {
        backToLoginButton = new Button(this.driver, ForgottenPasswordLocators.FROM_FORGOTTEN_PASSWORD_PAGE_BACK_TO_LOGIN_PAGE);
        backToLoginButton.click();
        return this;
    }
}
