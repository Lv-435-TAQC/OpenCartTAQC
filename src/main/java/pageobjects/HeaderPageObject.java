package pageobjects;

import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;

public class HeaderPageObject extends BasePageObject {
    Button openPreview;
    public HeaderPageObject(WebDriver driver) {
        super(driver);
    }

    public PreviewShoppingCart getPreviewShoppingCart(){
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div[3]/div/button")));
        openPreview = new Button(driver,"/html/body/header/div/div/div[3]/div/button");
        openPreview.click();
        return new PreviewShoppingCart(driver);
    }
}
