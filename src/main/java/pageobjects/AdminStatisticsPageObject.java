package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Label;

import java.util.ArrayList;
import java.util.List;

import static locators.AdminStatisticsLocators.STATISTICS_ALERT;
import static locators.AdminStatisticsLocators.STATISTICS_TABLE;

public class AdminStatisticsPageObject extends BasePageObject {
    private AdminPageObject adminPageObject;
    private List<AdminStatisticsItem> statistics;
    private Label label;

    public AdminStatisticsPageObject(WebDriver driver) {
        super(driver);
        this.adminPageObject = new AdminPageObject(driver);
        this.statistics = new ArrayList<>();
        this.label = new Label(driver, STATISTICS_ALERT);
    }

    public void setStatistics() {
        this.statistics = this.getListOfItems();
    }

    public List<AdminStatisticsItem> getStatistics() {
        this.setStatistics();
        return statistics;
    }

    public AdminPageObject getAdminPageObject() {
        return this.adminPageObject;
    }

    public List<AdminStatisticsItem> getListOfItems(){
    List<WebElement> list = driver.findElement(By.xpath(STATISTICS_TABLE)).findElements(By.xpath("tr"));

    for (WebElement element: list) {
        String name = element.findElement(By.xpath("td[1]")).getText();
        String value = element.findElement(By.xpath("td[2]")).getText();
        WebElement refresh = element.findElement(By.xpath("td[3]/a"));
        this.statistics.add(new AdminStatisticsItem(driver, name, value, refresh));
    }
    return this.statistics;
    }

    public AdminStatisticsPageObject clickRefresh(int numOfElement){
        this.getStatistics().get(numOfElement).getRefresh().click();
        return new AdminStatisticsPageObject(driver);
    }
}
