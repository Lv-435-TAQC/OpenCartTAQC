package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedImage extends BaseElement {

    public LinkedImage(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public LinkedImage(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }

    public LinkedImage click(){
        this.element.click();
        return this;
    }
}
