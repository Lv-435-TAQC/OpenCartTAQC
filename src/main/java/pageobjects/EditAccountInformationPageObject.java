package pageobjects;

import locators.EditAcountInformationLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;

public class EditAccountInformationPageObject extends BasePageObject {
    private Input firstNameField;
    private Input lastNameField;
    private Input emailField;
    private Input phoneField;
    private Button continueButton;
    private Button backButton;

    public EditAccountInformationPageObject(WebDriver driver) {
        super(driver);
    }

    public EditAccountInformationPageObject setFirstNameField(String firstName) {
        firstNameField = new Input(this.driver, EditAcountInformationLocators.FIRST_NAME);
        firstNameField.clearField();
        firstNameField.setText(firstName);
        return this;
    }

    public EditAccountInformationPageObject setLastNameField(String lastName) {
        lastNameField = new Input(this.driver, EditAcountInformationLocators.LAST_NAME);
        lastNameField.clearField();
        lastNameField.setText(lastName);
        return this;
    }

    public EditAccountInformationPageObject setEmailField(String email) {
        emailField = new Input(this.driver, EditAcountInformationLocators.EMAIL);
        emailField.clearField();
        emailField.setText(email);
        return this;
    }

    public EditAccountInformationPageObject setTelephoneField(String phone) {
        phoneField = new Input(this.driver, EditAcountInformationLocators.TELEPHONE);
        phoneField.clearField();
        phoneField.setText(phone);
        return this;
    }

    public MyAccountPageObject clickContinueButton() {
        continueButton = new Button(this.driver, EditAcountInformationLocators.CONTINUE);
        continueButton.click();
        return new MyAccountPageObject(driver);
    }

    public MyAccountPageObject clickBackToAccountPageButton() {
        backButton = new Button(this.driver, EditAcountInformationLocators.BACK);
        backButton.click();
        return new MyAccountPageObject(driver);
    }
}
