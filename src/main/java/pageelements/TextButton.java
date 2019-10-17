package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextButton extends Button {


    public TextButton(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public TextButton(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }

    public String getText(){
        return this.element.getText();
    }
}
