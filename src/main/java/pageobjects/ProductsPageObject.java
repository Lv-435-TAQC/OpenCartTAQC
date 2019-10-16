package pageobjects;

import locators.ProductLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Label;

public class ProductsPageObject extends BasePageObject {
    private String productLabel;
    public ProductsPageObject(WebDriver driver) {
        super(driver);
    }
    public String getLabelText(){
        productLabel = new Label(driver, ProductLocators.PRODUCTS_LABEL_LOC).getText();
        return productLabel;
    }
}
