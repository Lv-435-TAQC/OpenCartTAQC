package pageobjects;

import locators.ForgottenPasswordLocators;
import locators.LoginLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import pageelements.Button;
import pageelements.Input;
import pageelements.Label;
import pageelements.LinkedLabel;
import patterns.LoginProductPatterns;

public class LoginPageObject extends BasePageObject {
    Screen screen = new Screen();
    private Input loginField;
    private Input passwordField;
    private Button nextButton;
    private Button registrationButton;
    private LinkedLabel forgottenPassword;
    private Label warningMessage;
    private Label successfulMessage;

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public MyAccountPageObject logIn(String loginName, String password) {
        this
                .setLogInField(loginName)
                .setPasswordField(password)
                .clickNextButton();
        return new MyAccountPageObject(driver);
    }

    public LoginPageObject setLogInField(String loginName) {
        loginField = new Input(this.driver, LoginLocators.INPUT_EMAIL_FIELD);
        loginField.setText(loginName);
        return this;
    }

    public LoginPageObject setPasswordField(String password) {
        passwordField = new Input(this.driver, LoginLocators.INPUT_PASSWORD_FIELD);
        passwordField.setText(password);
        return this;
    }

    public LoginPageObject clickNextButton() {
        nextButton = new Button(this.driver, LoginLocators.LOGIN_BUTTON);
        nextButton.click();
        return this;
    }

    public RegistrationPageObject clickToGoToRegistration() {
        registrationButton = new Button(this.driver, LoginLocators.NEW_USER_CONTINUE_BUTTON);
        registrationButton.click();
        return new RegistrationPageObject(driver);
    }

    public ForgottenPasswordPageObject goToPageForgottenPassword() {
        forgottenPassword = new LinkedLabel(this.driver, ForgottenPasswordLocators.FORGOTTEN_PASSWORD_TEXT);
        forgottenPassword.click();
        return new ForgottenPasswordPageObject(driver);
    }

    public String warningMessage() {
        warningMessage = new Label(this.driver, LoginLocators.WARNING_MESSAGE);
        return this.warningMessage.getText();
    }

    public LoginPageObject forgottenPassword(String loginName) {
        this
                .goToPageForgottenPassword()
                .setEmailFieldForgotten(loginName)
                .clickContinueButton();

        return new LoginPageObject(driver);
    }

    public String successfulMessage() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ForgottenPasswordLocators.SENT_INFORMATION_FOR_FORGOTTEN_PASSWORD)));
        successfulMessage = new Label(this.driver, ForgottenPasswordLocators.SENT_INFORMATION_FOR_FORGOTTEN_PASSWORD);
        return this.successfulMessage.getText();
    }

    public Boolean testSikuliBad() {
        screen.type(LoginProductPatterns.email, "orysita.benko@gmail.com");
        screen.type(LoginProductPatterns.password, "orysia");
        try {
            screen.click(LoginProductPatterns.button);
            screen.find(LoginProductPatterns.date);
            return true;
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            return false;
        }
    }

    public Boolean testSikuliGood() {
        screen.type(LoginProductPatterns.email, "orysia.benko@gmail.com");
        screen.type(LoginProductPatterns.password, "orysia");
        try {
            screen.click(LoginProductPatterns.button);
            screen.find(LoginProductPatterns.account);
            return true;
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            return false;
        }
    }
}