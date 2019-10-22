package pageobjects;

import locators.AdminNavigationLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.TextButton;

public class AdminNavigationPageObject extends BasePageObject {

    private Button products;
    private Button catalog;

    public AdminNavigationPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminNavigationPageObject goToCatalog(){
            catalog = new TextButton(driver, AdminNavigationLocators.CATALOG_BUTTON_LOC).click();
            return new AdminNavigationPageObject(driver);
    }

    public AdminProductsList goToProducts(){
        products = new TextButton(driver, AdminNavigationLocators.PRODUCTS_PAGE_BUTTON_LOC).click();
        return new AdminProductsList(driver);
    }

}
