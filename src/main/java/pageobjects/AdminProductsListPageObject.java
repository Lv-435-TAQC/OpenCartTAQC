package pageobjects;

import locators.AdminProductsPageLocators;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.Button;
import pageelements.ImageButton;
import pageelements.Label;
import patterns.AdminProductsPatterns;
import patterns.ShoppingCartPatterns;

public class AdminProductsListPageObject extends BasePageObject{

    private Button addNewProduct;
    Screen screen = new Screen();

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

     public AdminProductsListPageObject findAddedProduct() throws FindFailed{
        Pattern productsCheckbox = new Pattern(AdminProductsPatterns.productsCheckbox);
        screen.type(Key.PAGE_DOWN);
        screen.click(productsCheckbox.targetOffset(-140,0));
               return this;
     }

     public AdminProductsListPageObject deleteChosenProduct() throws FindFailed {
         Pattern deleteButton = new Pattern(AdminProductsPatterns.deleteButton);
         Pattern okButton = new Pattern(AdminProductsPatterns.okButton);
         screen.type(Key.PAGE_UP);
         screen.wait(deleteButton,5);
         screen.click(deleteButton);
         screen.wait(okButton,5);
         screen.click();
         return this;
     }

     public AdminProductsListPageObject closeMessage() throws FindFailed {
        Pattern close = new Pattern(AdminProductsPatterns.closeButton);
         screen.wait(close,5);
         screen.click(close);
        return this;
     }
}
