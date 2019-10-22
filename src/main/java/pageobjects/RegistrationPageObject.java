package pageobjects;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.Button;
import pageelements.Checkbox;
import pageelements.Input;

import static locators.RegistrationLocators.*;

public class RegistrationPageObject extends BasePageObject {

    private Input fieldFirstName;
    private Input fieldLastName;
    private Input fieldEmail;
    private Input fieldTelephone;
    private Input fieldPassword;
    private Input fieldPasswordConfirm;
    private Checkbox checkboxPrivacyPolicy;
    private Button buttonContinue;

    public RegistrationPageObject(WebDriver driver) {
        super(driver);
    }

    public RegistrationPageObject setDataToFirstNameField(String firstName) {
        this.fieldFirstName = new Input(driver, FIRST_NAME_FIELD_XPATH);
        this.fieldFirstName.setTextForField(firstName);
        return this;
    }

    public RegistrationPageObject setDataToLastNameField(String lastName) {
        this.fieldLastName = new Input(driver, LAST_NAME_FIELD_XPATH);
        this.fieldLastName.setTextForField(lastName);
        return this;
    }

    public RegistrationPageObject setDataToEmailField(String email) {
        this.fieldEmail = new Input(driver, EMAIL_FIELD_XPATH);
        this.fieldEmail.setTextForField(email);
        return this;
    }

    public RegistrationPageObject setDataToTelephoneField(String telephone) {
        this.fieldTelephone = new Input(driver, TELEPHONE_FIELD_XPATH);
        this.fieldTelephone.setTextForField(telephone);
        return this;
    }

    public RegistrationPageObject setDataToPasswordField(String password) {
        this.fieldPassword = new Input(driver, PASSWORD_FIELD_XPATH);
        this.fieldPassword.setTextForField(password);
        return this;
    }

    public RegistrationPageObject setDataToPasswordConfirmField(String passwordConfirm) {
        this.fieldPasswordConfirm = new Input(driver, PASSWORD_CONFIRM_FIELD_XPATH);
        this.fieldPasswordConfirm.setTextForField(passwordConfirm);
        return this;
    }

    public RegistrationPageObject checkOnPrivacyPolicyCheckbox() {
        this.checkboxPrivacyPolicy = new Checkbox(driver, PRIVACY_POLICY_CHECKBOX_XPATH);
        this.checkboxPrivacyPolicy.clickOnCheckbox();
        return this;
    }

    public RegistrationPageObject pushOnContinueButton() {
        this.buttonContinue = new Button(driver, CONTINUE_BUTTON_XPATH);
        this.buttonContinue.click();
        return this;
    }

    public Input getFieldEmail() {
        return fieldEmail;
    }

    public void typeTextToPattern(Screen screen, Pattern pattern, String text) {
        try {
            screen.type(pattern, text);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void clickOnPattern(Screen screen, Pattern pattern) {
        try {
            screen.click(pattern);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}