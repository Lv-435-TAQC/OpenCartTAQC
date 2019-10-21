package pageobjects;

import locators.AddNewProductsLocators;
import locators.AdminProductsPageLocators;
import locators.NavigationLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.TextButton;
import pageobjects.BasePageObject;

public class NavigationPageObject extends BasePageObject {

    private Button products;

    public NavigationPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminProductsList goToProducts(){
        products = new TextButton(driver, NavigationLocators.PRODUCTS_PAGE_BUTTON_LOC).click();
        return new AdminProductsList(driver);
    }

}
