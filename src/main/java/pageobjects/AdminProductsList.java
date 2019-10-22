package pageobjects;

import locators.AdminProductsPageLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.ImageButton;

public class AdminProductsList extends BasePageObject{

    private Button addNewProduct;

    public AdminProductsList(WebDriver driver) {
        super(driver);
    }

     public AddNewProductPageObject goToAddNewProject(){
        addNewProduct = new ImageButton(driver, AdminProductsPageLocators.ADD_NEW_PRODUCT_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
     }
}
