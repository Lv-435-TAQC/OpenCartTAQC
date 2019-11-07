package pageobjects;

import locators.ForgottenPasswordLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.Input;
import pageelements.Label;

public class ForgottenPasswordPageObject extends BasePageObject {
    private Input loginFieldForgot;
    private Button continueButton;
    private Button backToLoginButton;
    private Label warningMessage;

    public ForgottenPasswordPageObject(WebDriver driver) {
        super(driver);
    }

    public ForgottenPasswordPageObject setEmailFieldForgotten(String loginName) {
        loginFieldForgot = new Input(this.driver, ForgottenPasswordLocators.INPUT_EMAIL_FIELD_FOR_FORGOTTEN_PASSWORD_PAGE);
        loginFieldForgot.clearField();
        loginFieldForgot.setText(loginName);

        return this;
    }

    public ForgottenPasswordPageObject clickContinueButton() {
        WebElement explicitWait = (new WebDriverWait(driver,10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ForgottenPasswordLocators.INPUT_EMAIL_FIELD_FOR_FORGOTTEN_PASSWORD_PAGE)));
        continueButton = new Button(this.driver, ForgottenPasswordLocators.CONTINUE_FORGOTTEN_PAGE_BUTTON);
        continueButton.click();
        return this;
    }

    public LoginPageObject clickBackToLoginPageButton() {
        backToLoginButton = new Button(this.driver, ForgottenPasswordLocators.FROM_FORGOTTEN_PASSWORD_PAGE_BACK_TO_LOGIN_PAGE);
        backToLoginButton.click();
        return new LoginPageObject(this.driver);
    }

    public ForgottenPasswordPageObject warningMessage() {
        warningMessage = new Label(this.driver, ForgottenPasswordLocators.WARNING_MESSAGE_FORGOTTEN_PASSWORD_PAGE);
        warningMessage.getText();
        return this;
    }
}
