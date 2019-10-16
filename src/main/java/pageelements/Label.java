package pageelements;

import org.openqa.selenium.WebDriver;

public class Label extends BaseElement {

    public Label(WebDriver driver, String xpath){
        super(driver,xpath);
    }
    public String getText(){
        return element.getText();
    }
}
