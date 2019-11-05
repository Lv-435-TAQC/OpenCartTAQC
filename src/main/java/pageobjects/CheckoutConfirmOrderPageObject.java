package pageobjects;

import locators.CheckoutConfirmOrderLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import pageelements.Button;
import patterns.LoginPatterns;

public class CheckoutConfirmOrderPageObject extends BasePageObject {
    Screen screen = new Screen();
    Boolean isTrue = false;
    private Button continueButton;

    public CheckoutConfirmOrderPageObject(WebDriver driver) {
        super(driver);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutConfirmOrderLocators.CONFIRM_ORDER)));
    }

    public CheckoutSuccessPageObject clickContinueButton(){
        continueButton = new Button(this.driver, CheckoutConfirmOrderLocators.CONFIRM_ORDER);
        continueButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(driver.switchTo().alert()!=null) {
            sikuliAlertError();
        }
        else {
            continueButton = new Button(this.driver, CheckoutConfirmOrderLocators.CONFIRM_ORDER);
            continueButton.click();
        }
        continueButton = new Button(this.driver, CheckoutConfirmOrderLocators.CONFIRM_ORDER);
        continueButton.click();
        return new CheckoutSuccessPageObject(driver);
    }


    public CheckoutConfirmOrderPageObject sikuliAlertError() {
        isTrue = true;
      //  screen.wait(LoginPatterns.ALERT);
        try {
            screen.click(LoginPatterns.ALERT);
            return new CheckoutConfirmOrderPageObject(driver);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            return new CheckoutConfirmOrderPageObject(driver);
        }
    }
}
