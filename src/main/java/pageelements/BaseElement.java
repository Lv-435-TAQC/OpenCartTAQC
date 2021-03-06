package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BaseElement {
    protected WebDriver driver;
    public WebElement element;
    protected String xpath;

    public BaseElement(WebDriver driver, String xpath) {
        this.driver = driver;
        this.xpath = xpath;
        element = driver.findElement(By.xpath(xpath));
    }

    public BaseElement(WebElement elementToParse, String xpath) {
        this.xpath = xpath;
        element = elementToParse.findElement(By.xpath(xpath));
    }

    public BaseElement(WebElement element) {
        this.element = element;
    }
}
