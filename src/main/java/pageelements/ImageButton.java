package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImageButton extends Button {


    public ImageButton(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public ImageButton(WebElement elementToParse, String xpath) {
        super(elementToParse, xpath);
    }
}
