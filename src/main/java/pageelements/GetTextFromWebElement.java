package pageelements;

import org.openqa.selenium.WebDriver;

public class GetTextFromWebElement extends BaseElement {

    public GetTextFromWebElement(WebDriver driver, String xpath){
        super(driver,xpath);
    }
    public String getText(){
        return element.getText();
    }
}
