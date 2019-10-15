package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.Label;

public class ProductsPageObject extends BasePageObject {
    private Label productLabel;
    public ProductsPageObject(WebDriver driver) {
        super(driver);
    }
    public String getLabelText(){
        return productLabel.getText();
    }
}
