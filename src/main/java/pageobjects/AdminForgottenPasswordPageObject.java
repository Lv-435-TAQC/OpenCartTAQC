package pageobjects;

import locators.AdminForgottenPasswordLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.Input;
import pageelements.Label;

public class AdminForgottenPasswordPageObject extends BasePageObject {
    private Input loginFieldForgot;
    private Button continueButton;
    private Button backToLoginButton;
    private Label warningMessage;

    public AdminForgottenPasswordPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminForgottenPasswordPageObject setEmailFieldForgotten(String loginName) {
        loginFieldForgot = new Input(this.driver, AdminForgottenPasswordLocators.INPUT_EMAIL_FIELD_FOR_ADMIN_FORGOTTEN_PASSWORD_PAGE);
        loginFieldForgot.setTextForField(loginName);

        return this;
    }

    public AdminForgottenPasswordPageObject clickContinueButton() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(AdminForgottenPasswordLocators.INPUT_EMAIL_FIELD_FOR_ADMIN_FORGOTTEN_PASSWORD_PAGE)));
        continueButton = new Button(this.driver, AdminForgottenPasswordLocators.CONTINUE_FORGOTTEN_PAGE_BUTTON);
        continueButton.click();
        return this;
    }

    public AdminLoginPageObject clickBackToLoginPageButton() {
        backToLoginButton = new Button(this.driver, AdminForgottenPasswordLocators.FROM_ADMIN_FORGOTTEN_PASSWORD_PAGE_BACK_TO_LOGIN_PAGE);
        backToLoginButton.click();
        return new AdminLoginPageObject(this.driver);
    }

    public AdminForgottenPasswordPageObject warningMessage() {
        warningMessage = new Label(this.driver, AdminForgottenPasswordLocators.WARNING_MESSAGE_FORGOTTEN_PASSWORD_ADMIN_PAGE);
        warningMessage.getText();
        return this;
    }
}
