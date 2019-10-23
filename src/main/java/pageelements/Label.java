package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement {


    public Label(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public Label(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }

    public Label(WebElement element) {
        super(element);
    }

    public String getText() {
        return this.element.getText();
    }
}
