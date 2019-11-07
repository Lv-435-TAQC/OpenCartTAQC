package pageobjects;

import locators.AdminLoginLocators;
import locators.ForgottenPasswordLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;
import pageelements.Label;
import pageelements.LinkedLabel;

public class AdminLoginPageObject extends BasePageObject {
    private Input loginField;
    private Input passwordField;
    private Button nextButton;
    private LinkedLabel forgottenPassword;
    private Label warningMessage;

    public AdminLoginPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminPageObject logIn(String loginName, String password) {
        this
                .setLogInField(loginName)
                .setPasswordField(password)
                .clickNextButton();
        return new AdminPageObject(driver);
    }


    public AdminLoginPageObject setLogInField(String loginName) {
        loginField = new Input(this.driver, AdminLoginLocators.INPUT_ADMIN_EMAIL_FIELD);
        loginField.setText(loginName);
        return this;
    }

    public AdminLoginPageObject setPasswordField(String password) {
        passwordField = new Input(this.driver, AdminLoginLocators.INPUT_PASSWORD_FIELD);
        passwordField.setText(password);
        return this;
    }

    public AdminLoginPageObject clickNextButton() {
        nextButton = new Button(this.driver, AdminLoginLocators.LOGIN_BUTTON);
        nextButton.click();
        return this;
    }

    public AdminForgottenPasswordPageObject goToPageForgottenPassword() {
        forgottenPassword = new LinkedLabel(this.driver, ForgottenPasswordLocators.FORGOTTEN_PASSWORD_TEXT);
        forgottenPassword.click();
        return new AdminForgottenPasswordPageObject(driver);
    }

    public String warningMessage() {
        warningMessage = new Label(this.driver, AdminLoginLocators.WARNING_MESSAGE);
        return this.warningMessage.getText();
    }

    public AdminLoginPageObject forgottenPassword(String loginName) {
        this
                .goToPageForgottenPassword()
                .setEmailFieldForgotten(loginName)
                .clickContinueButton();

        return new AdminLoginPageObject(driver);
    }
}
