package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListElements {
    protected WebDriver driver;
    protected List<WebElement> elementsList;
    protected String xpath;

    public ListElements(WebDriver driver, String xpath) {
        this.driver = driver;
        this.xpath = xpath;
        elementsList = driver.findElements(By.xpath(xpath));
    }
}
