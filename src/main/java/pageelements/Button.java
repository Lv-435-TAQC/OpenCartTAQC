package pageelements;

import org.openqa.selenium.WebDriver;

public class Button extends BaseElement {

    public Button(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public Button click() {
        this.element.click();
        return this;
    }
}
