package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;

import java.util.ArrayList;
import java.util.List;

import static locators.AdminReportsLocators.PRODUCT_VIEWED_REPORT_RESET_BUTTON;
import static locators.AdminReportsLocators.PRODUCT_VIEWED_REPORT_TABLE;

public class AdminReportsProductViewedPO extends BasePageObject {

    private Button reset;
    private List<AdminReportsProductViewedItem> viewedItemPOS;

    public AdminReportsProductViewedPO(WebDriver driver) {
        super(driver);
        this.viewedItemPOS = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PRODUCT_VIEWED_REPORT_RESET_BUTTON)));
        this.reset = new Button(driver, PRODUCT_VIEWED_REPORT_RESET_BUTTON);
    }

    public Button getReset() {
        return this.reset;
    }

    public AdminReportsPageObject clickResetAndDeleteItemsFromList(){
        this.getReset().click();
        this.viewedItemPOS.clear();
        return new AdminReportsPageObject(driver);
    }

    public void setItems() {
        this.viewedItemPOS = this.getListOfViewedItems();
    }

    public List<AdminReportsProductViewedItem> getViewedItemPOS() {
        this.setItems();
        return viewedItemPOS;
    }

    public List<AdminReportsProductViewedItem> getListOfViewedItems() {
        List<WebElement> listTr = driver.findElement(By.xpath(PRODUCT_VIEWED_REPORT_TABLE)).findElements(By.xpath("tr"));
        for (WebElement element: listTr ) {
            String name = element.findElement(By.xpath("td[1]")).getText();
            String model = element.findElement(By.xpath("td[2]")).getText();
            String viewed = element.findElement(By.xpath("td[3]")).getText();
            String percent = element.findElement(By.xpath("td[4]")).getText();
            this.viewedItemPOS.add(new AdminReportsProductViewedItem(driver, name, model, viewed, percent));
        }
        return viewedItemPOS;
    }
}
