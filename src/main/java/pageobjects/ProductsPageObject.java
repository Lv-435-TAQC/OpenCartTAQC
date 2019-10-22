package pageobjects;

import locators.ProductLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Label;

public class ProductsPageObject extends BasePageObject {
    private String categoryNameLabel;
    public ProductsPageObject(WebDriver driver) {
        super(driver);
    }
    public String getCategoryName(){
        categoryNameLabel = new Label(driver, ProductLocators.PRODUCTS_LABEL_LOC).getText();
        return categoryNameLabel;
    }
}
