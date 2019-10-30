package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.DropDown;

import java.util.ArrayList;
import java.util.List;

import static locators.AdminReportsLocators.FILTER;
import static locators.AdminReportsLocators.PRODUCT_VIEWED_TABLE;

public class AdminReportsPageObject extends BasePageObject {
    private AdminPageObject adminPageObject;
    private DropDown filter;
    private List<AdminReportsProductViewedItemPO> items;

    public AdminReportsPageObject(WebDriver driver) {
        super(driver);
        this.adminPageObject = new AdminPageObject(driver);
        this.filter = new DropDown(driver, FILTER);
        this.items = new ArrayList<>();
    }

    public AdminPageObject getAdminPageObject() {
        return adminPageObject;
    }

    public DropDown getFilter() {
        return filter;
    }

    public List<AdminReportsProductViewedItemPO> getItems() {
        return this.getListOfViewedItems();
    }

    public List<AdminReportsProductViewedItemPO> clickProductsViewedReport() {
        this.filter.writeOptionParameter("Products Viewed Report");
        return this.getItems();
    }

    public List<AdminReportsProductViewedItemPO> getListOfViewedItems() {
        List<WebElement> listTr = driver.findElement(By.xpath(PRODUCT_VIEWED_TABLE)).findElements(By.xpath("tr"));
        for (WebElement element: listTr ) {
            String name = element.findElement(By.xpath("td[1]")).getText();
            String model = element.findElement(By.xpath("td[2]")).getText();
            String viewed = element.findElement(By.xpath("td[3]")).getText();
            String percent = element.findElement(By.xpath("td[4]")).getText();
            this.items.add(new AdminReportsProductViewedItemPO(driver, name, model, viewed, percent));
        }
        return items;
    }
}