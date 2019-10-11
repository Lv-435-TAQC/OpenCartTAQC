package pageelements;

import org.openqa.selenium.WebDriver;

public class Input extends BaseElement {
    public Input(WebDriver driver, String xpath) {
        super(driver, xpath);
    }
    public Input setTextForField(String text) {
        this.element.sendKeys(text);
        return this;
    }

    public String getText() {
        return this.element.getText();
    }
}
