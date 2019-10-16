package pageelements;

import org.openqa.selenium.WebDriver;

public class LinkedLabel extends Label {
    public LinkedLabel(WebDriver driver, String xpath) {
        super(driver, xpath);
    }
    public Label click(){
        this.element.click();
        return this;
    }
}
