package pageelements;

import org.openqa.selenium.WebDriver;

public class TextButton extends Button {
    public TextButton(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public String getText(){
        return this.element.getText();
    }
}
