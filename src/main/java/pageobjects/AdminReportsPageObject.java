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
    private AdminNavigationPageObject adminNavigationPageObject;
    private List<AdminReportsProductViewedItemPO> viewedItemPOS;

    public AdminReportsPageObject(WebDriver driver) {
        super(driver);
        this.adminPageObject = new AdminPageObject(driver);
        this.filter = new DropDown(driver, FILTER);
        this.adminNavigationPageObject = new AdminNavigationPageObject(driver);
        this.viewedItemPOS = new ArrayList<>();
    }

    public void setItems() {
        this.viewedItemPOS = this.getListOfViewedItems();
    }

    public AdminNavigationPageObject getAdminNavigationPageObject() {
        return adminNavigationPageObject;
    }

    public AdminPageObject getAdminPageObject() {
        return adminPageObject;
    }

    public DropDown getFilter() {
        return filter;
    }

    public List<AdminReportsProductViewedItemPO> getViewedItemPOS() {
         this.setItems();
         return viewedItemPOS;
    }

    public AdminReportsPageObject clickProductsViewedReport() {
        this.filter.writeOptionParameter("Products Viewed Report");
        this.getViewedItemPOS();
        return new AdminReportsPageObject(driver);
    }

    public List<AdminReportsProductViewedItemPO> getListOfViewedItems() {
        List<WebElement> listTr = driver.findElement(By.xpath(PRODUCT_VIEWED_TABLE)).findElements(By.xpath("tr"));
        for (WebElement element: listTr ) {
            String name = element.findElement(By.xpath("td[1]")).getText();
            String model = element.findElement(By.xpath("td[2]")).getText();
            String viewed = element.findElement(By.xpath("td[3]")).getText();
            String percent = element.findElement(By.xpath("td[4]")).getText();
            this.viewedItemPOS.add(new AdminReportsProductViewedItemPO(driver, name, model, viewed, percent));
        }
        return viewedItemPOS;
    }
}