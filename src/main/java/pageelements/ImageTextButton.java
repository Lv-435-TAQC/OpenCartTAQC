package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImageTextButton extends TextButton {


    public ImageTextButton(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public ImageTextButton(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }
}
