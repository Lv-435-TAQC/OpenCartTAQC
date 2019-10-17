package pageelements;

import org.openqa.selenium.WebDriver;

public class TextFromWebElement extends BaseElement {

    public TextFromWebElement(WebDriver driver, String xpath){
        super(driver,xpath);
    }
    public String getText(){
        return element.getText();
    }
}
