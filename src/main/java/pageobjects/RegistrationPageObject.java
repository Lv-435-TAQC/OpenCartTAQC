package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Checkbox;
import pageelements.Input;

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
        this.fieldFirstName = new Input(driver, "//input[@name = 'firstname']");
        this.fieldFirstName.setTextForField(firstName);
        return this;
    }

    public RegistrationPageObject setDataToLastNameField(String lastName) {
        this.fieldLastName = new Input(driver, "//input[@name = 'lastname']");
        this.fieldLastName.setTextForField(lastName);
        return this;
    }

    public RegistrationPageObject setDataToEmailField(String email) {
        this.fieldEmail = new Input(driver, "//input[@name = 'email']");
        this.fieldEmail.setTextForField(email);
        return this;
    }

    public RegistrationPageObject setDataToTelephoneField(String telephone) {
        this.fieldTelephone = new Input(driver, "//input[@name = 'email']");
        this.fieldTelephone.setTextForField(telephone);
        return this;
    }

    public RegistrationPageObject setDataToPasswordField(String password) {
        this.fieldPassword = new Input(driver, "//input[@name = 'password']");
        this.fieldPassword.setTextForField(password);
        return this;
    }

    public RegistrationPageObject setDataToPasswordConfirmField(String passwordConfirm) {
        this.fieldPasswordConfirm = new Input(driver, "//input[@name = 'confirm']");
        this.fieldPasswordConfirm.setTextForField(passwordConfirm);
        return this;
    }

    public RegistrationPageObject checkOnPrivacyPolicyCheckbox() {
        this.checkboxPrivacyPolicy = new Checkbox(driver, "//input[@name = 'agree']");
        this.checkboxPrivacyPolicy.clickOnCheckbox();
        return this;
    }

    public RegistrationPageObject pushOnContinueButton() {
        this.buttonContinue = new Button(driver, "//input[@type = 'submit' and @value = 'Continue']");
        this.buttonContinue.click();
        return this;
    }
}