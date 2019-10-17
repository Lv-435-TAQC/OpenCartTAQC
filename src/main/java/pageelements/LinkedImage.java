package pageelements;

import org.openqa.selenium.WebDriver;

public class LinkedImage extends BaseElement {
    public LinkedImage(WebDriver driver, String xpath) {
        super(driver, xpath);
    }
    public LinkedImage click(){
        this.element.click();
        return this;
    }
}
