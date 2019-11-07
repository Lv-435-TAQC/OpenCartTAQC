package pageobjects;

import locators.CheckoutConfirmOrderLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import utils.TestData;

import static locators.CheckoutConfirmOrderLocators.CONFIRM_ORDER;

public class CheckoutConfirmOrderPageObject extends BasePageObject {
    private Button continueButton;

    public CheckoutConfirmOrderPageObject(WebDriver driver) {
        super(driver);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutConfirmOrderLocators.CONFIRM_ORDER)));
    }

    public CheckoutSuccessPageObject clickContinueButtonX() {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONFIRM_ORDER)));
        continueButton = new Button(this.driver, CONFIRM_ORDER);
        continueButton.click();
        if (driver.switchTo().alert() != null) {
            driver.switchTo().alert().accept();
        } else {
            continueButton.click();
        }
        continueButton.click();
        return new CheckoutSuccessPageObject(driver);
    }

    public CheckoutSuccessPageObject clickContinueButtonU() {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONFIRM_ORDER)));
        continueButton = new Button(this.driver, CONFIRM_ORDER);
        continueButton.click();
        return new CheckoutSuccessPageObject(driver);
    }

    public AdminLoginPageObject goToAdminPage() {
        driver.get(TestData.ADMIN_PAGE);
        return new AdminLoginPageObject(driver);
    }
}