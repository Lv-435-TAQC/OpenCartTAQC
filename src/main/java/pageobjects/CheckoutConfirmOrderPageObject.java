package pageobjects;

import locators.CheckoutConfirmOrderLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import pageelements.Button;
import utils.TestData;

import static locators.CheckoutConfirmOrderLocators.CONFIRM_ORDER;

public class CheckoutConfirmOrderPageObject extends BasePageObject {
    Screen screen = new Screen();
    Boolean isTrue = false;
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.switchTo().alert() != null) {
            driver.switchTo().alert().accept();
        } else {
//            continueButton = new Button(this.driver, CONFIRM_ORDER);
            continueButton.click();
        }
//        continueButton = new Button(this.driver, CONFIRM_ORDER);
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
