package pageobjects;

import locators.AddNewProductsLocators;
import locators.AdminProductsPageLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.ImageButton;
import pageelements.Label;

public class AdminProductsListPageObject extends BasePageObject{

    private Button addNewProduct;

    public AdminProductsListPageObject(WebDriver driver) {
        super(driver);
    }

     public AddNewProductPageObject goToAddNewProduct(){
        addNewProduct = new ImageButton(driver, AdminProductsPageLocators.ADD_NEW_PRODUCT_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
     }

     public String getTextFromMessage(){
        return new Label(driver, AdminProductsPageLocators.SUCCESSFUL_ADDING_MESSAGE_LOC).getText();
     }
}
