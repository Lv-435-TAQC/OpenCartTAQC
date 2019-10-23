package pageobjects;

import locators.AdminNavigationLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.TextButton;

public class AdminNavigationPageObject extends BasePageObject {

    private Button products;
    private Button catalog;
    private Button categories;

    public AdminNavigationPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminNavigationPageObject goToCatalog(){
            catalog = new TextButton(driver, AdminNavigationLocators.CATALOG_BUTTON_LOC).click();
            return new AdminNavigationPageObject(driver);
    }

    public AdminProductsListPageObject goToProducts(){
        products = new TextButton(driver, AdminNavigationLocators.PRODUCTS_PAGE_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);
    }

    public AdminProductsListPageObject goToCategories(){
        categories = new TextButton(driver, AdminNavigationLocators.CATEGORIES_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);
    }

}
