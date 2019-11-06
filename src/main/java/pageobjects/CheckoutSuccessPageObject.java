package pageobjects;

import locators.AdminFilterOrderLocators;
import locators.CheckoutSuccessLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.Label;

public class CheckoutSuccessPageObject extends BasePageObject {
    private Label successMessageLabel;
    private Button continueButton;

    public CheckoutSuccessPageObject(WebDriver driver) {super(driver);}

    public CheckoutSuccessPageObject clickContinueButton() {
        continueButton = new Button(this.driver, CheckoutSuccessLocators.CONTINUE);
        continueButton.click();
        return this;
    }

    public String successMessage() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutSuccessLocators.SUCCESS_MESSAGE)));
        successMessageLabel = new Label(this.driver, CheckoutSuccessLocators.SUCCESS_MESSAGE);

        return successMessageLabel.getText();
    }

    public  AdminPageObject goToAdmainPage()
    {
        return new AdminPageObject(driver);
    }
}