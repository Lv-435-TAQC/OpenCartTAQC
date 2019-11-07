package pageobjects;

import locators.ForgottenPasswordLocators;
import locators.MyAccountLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Label;
import pageelements.LinkedLabel;

public class MyAccountPageObject extends BasePageObject {
    private HeaderPageObject headerPageObject;
    private MenuPageObject menuPageObject;
    private Label successfulMessage;
    private Label myAccount;
    private LinkedLabel goToChangeInformationLabel;
    private LinkedLabel goToChangePasswordLabel;
    public MyAccountPageObject(WebDriver driver) {
        super(driver);
        this.headerPageObject = new HeaderPageObject(driver);
        this.menuPageObject = new MenuPageObject(driver);
    }

    public HeaderPageObject getHeaderPageObject(){
        return this.headerPageObject;
    }

    public MenuPageObject getMenuPageObject(){
        return this.menuPageObject;
    }

    public String successfulMessageChangeInformation() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(MyAccountLocators.SUCCESS_CHANGE_INFORMATION)));
        successfulMessage = new Label(this.driver, MyAccountLocators.SUCCESS_CHANGE_INFORMATION);
        return this.successfulMessage.getText();
    }

    public String successfulMessageChangePassword() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(MyAccountLocators.SUCCESS_CHANGE_PASSWORD)));
        successfulMessage = new Label(this.driver, MyAccountLocators.SUCCESS_CHANGE_PASSWORD);
        return this.successfulMessage.getText();
    }

    public EditAccountInformationPageObject clickGoToChangeInformation() {
        goToChangeInformationLabel = new LinkedLabel(this.driver, MyAccountLocators.EDIT_INFORMATION);
        goToChangeInformationLabel.click();
        return new EditAccountInformationPageObject(driver);
    }

    public EditAccountPasswordPageObject clickGoToChangePassword() {
        goToChangePasswordLabel = new LinkedLabel(this.driver, MyAccountLocators.CHANGE_PASSWORD);
        goToChangePasswordLabel.click();
        return new EditAccountPasswordPageObject(this.driver);
    }

    public String myAccountText()
    {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(MyAccountLocators.MY_ACCOUNT_LABEL)));
       myAccount = new Label(this.driver, MyAccountLocators.MY_ACCOUNT_LABEL);
        System.out.println(myAccount.getText());
        return this.myAccount.getText();
    }
}
