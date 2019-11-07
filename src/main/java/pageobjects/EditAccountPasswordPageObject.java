package pageobjects;

import locators.EditAccountPasswordLocators;
import locators.EditAcountInformationLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;

public class EditAccountPasswordPageObject extends BasePageObject {
    private Input oldPasswordField;
    private Input newPasswordField;
    private Button continueButton;
    private Button backButton;

    public EditAccountPasswordPageObject(WebDriver driver) {
        super(driver);
    }

    public EditAccountPasswordPageObject setOldPasswordField(String oldPassword) {
        oldPasswordField = new Input(this.driver, EditAccountPasswordLocators.OLD_PASSWORD);
        oldPasswordField.clearField();
        oldPasswordField.setText(oldPassword);
        return this;
    }

    public EditAccountPasswordPageObject setNewPasswordField(String newPassword) {
        newPasswordField = new Input(this.driver, EditAccountPasswordLocators.NEW_PASSWORD);
        newPasswordField.clearField();
        newPasswordField.setText(newPassword);
        return this;
    }

    public MyAccountPageObject clickContinueNewPasswordButton() {
        continueButton = new Button(this.driver,EditAccountPasswordLocators.CONTINUE);
        continueButton.click();
        return new MyAccountPageObject(driver);
    }

    public MyAccountPageObject clickBackToAccountPageFromPasswordPageButton() {
        backButton = new Button(this.driver, EditAccountPasswordLocators.BACK);
        backButton.click();
        return new MyAccountPageObject(driver);
    }

}
