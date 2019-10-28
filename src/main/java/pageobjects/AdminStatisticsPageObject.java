package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static locators.AdminCategoriesLocators.STATISTICS_TABLE;

public class AdminStatisticsPageObject extends BasePageObject {

    private List<AdminStatisticsItemPageObject> statistics;

    public AdminStatisticsPageObject(WebDriver driver) {
        super(driver);
    }

    public List<AdminStatisticsItemPageObject> getListOfItems(){
    this.statistics = new ArrayList<>();
    List<WebElement> list = driver.findElement(By.xpath(STATISTICS_TABLE)).findElements(By.xpath("tr"));

    for (WebElement element: list) {
        String name = element.findElement(By.xpath("td[1]")).getText();
        String value = element.findElement(By.xpath("td[2]")).getText();
        WebElement refresh = element.findElement(By.xpath("td[3]/a"));
        this.statistics.add(new AdminStatisticsItemPageObject(driver, name, value, refresh));
    }
    return this.statistics;
    }
}
