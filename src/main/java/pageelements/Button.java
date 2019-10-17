package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public Button(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }

    public Button click() {
        this.element.click();
        return this;
    }
}
