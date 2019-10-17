package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageObject extends BasePageObject {

    private WebElement fieldFirstName;
    private WebElement fieldLastName;
    private WebElement fieldEmail;
    private WebElement fieldTelephone;
    private WebElement fieldPassword;
    private WebElement fieldPasswordConfirm;
    private WebElement checkboxPrivacyPolicy;
    private WebElement buttonContinue;

    public RegistrationPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPageObject setDataToFirstNameField(String firstName) {
        this.fieldFirstName = driver.findElement(By.name("firstname"));
        this.fieldFirstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPageObject setDataToLastNameField(String lastName) {
        this.fieldLastName = driver.findElement(By.name("lastname"));
        this.fieldLastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPageObject setDataToEmailField(String email) {
        this.fieldEmail = driver.findElement(By.name("email"));
        this.fieldEmail.sendKeys(email);
        return this;
    }

    public RegistrationPageObject setDataToTelephoneField(String telephone) {
        this.fieldTelephone = driver.findElement(By.name("telephone"));
        this.fieldTelephone.sendKeys(telephone);
        return this;
    }

    public RegistrationPageObject setDataToPasswordField(String password) {
        this.fieldPassword = driver.findElement(By.name("password"));
        this.fieldPassword.sendKeys(password);
        return this;
    }

    public RegistrationPageObject setDataToPasswordConfirmField(String passwordConfirm) {
        this.fieldPasswordConfirm = driver.findElement(By.name("confirm"));
        this.fieldPasswordConfirm.sendKeys(passwordConfirm);
        return this;
    }

    public RegistrationPageObject checkOnPrivacyPolicyCheckbox() {
        this.checkboxPrivacyPolicy = driver.findElement(By.name("agree"));
        this.checkboxPrivacyPolicy.click();
        return this;
    }

    public RegistrationPageObject pushOnContinueButton() {
        this.buttonContinue = driver.findElement(By.xpath("//input[@type = 'submit' and @value = 'Continue']"));
        this.buttonContinue.click();
        return this;
    }
}