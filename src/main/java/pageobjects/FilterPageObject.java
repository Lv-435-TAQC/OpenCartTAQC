package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.ImageTextButton;
import pageelements.Label;
import pageelements.LinkedLabel;


public class FilterPageObject extends BasePageObject {
    private ImageTextButton listButton;
    private ImageTextButton gridButton;
    private LinkedLabel productCompareLabel;
    private Label sortByLabel;

    public FilterPageObject(WebDriver driver) {
        super(driver);
    }
}
