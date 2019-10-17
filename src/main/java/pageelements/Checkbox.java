package pageelements;

import org.openqa.selenium.WebDriver;

public class Checkbox extends BaseElement{

    public Checkbox(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public Checkbox clickOnCheckbox() {
        this.element.click();
        return this;
    }
}
