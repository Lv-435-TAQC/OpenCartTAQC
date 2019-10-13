package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.ShoppingProductsTable;

public class ShoppingCartPageObject extends BasePageObject {
    ShoppingProductsTable productsTable;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }

}
