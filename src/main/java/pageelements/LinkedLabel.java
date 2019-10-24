package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedLabel extends Label {


    public LinkedLabel(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public LinkedLabel(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }

    public LinkedLabel(WebElement element) {
        super(element);
    }

    public Label click() {
        this.element.click();
        return this;
    }

    public String getAttribute(String attribute) {
        return this.element.getAttribute(attribute);
    }
}
