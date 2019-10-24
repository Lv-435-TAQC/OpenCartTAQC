package pageobjects;

import locators.AdminProductsPageLocators;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.Button;
import pageelements.ImageButton;
import pageelements.Label;
import patterns.AdminProductsPatterns;


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

     public AdminProductsListPageObject findAddedProduct(){
        Pattern productsCheckbox = new Pattern(AdminProductsPatterns.productsCheckbox);
         try {
             screen.click(productsCheckbox.targetOffset(-215,0));
         } catch (FindFailed findFailed) {
             findFailed.printStackTrace();
         }
         return this;
     }

     public AdminProductsListPageObject deleteChosenProduct(){
         Pattern deleteButton = new Pattern(AdminProductsPatterns.deleteButton);
         Pattern okButton = new Pattern(AdminProductsPatterns.okButton);
         try {
             screen.wait(deleteButton,5);
             screen.click(deleteButton);
             screen.wait(okButton,5);
             screen.click();
         } catch (FindFailed findFailed) {
             findFailed.printStackTrace();
         }
         return this;
     }

     public AdminProductsListPageObject closeMessage(){
        Pattern close = new Pattern(AdminProductsPatterns.closeButton);
         try {
             screen.wait(close,5);
             screen.click(close);
         } catch (FindFailed findFailed) {
             findFailed.printStackTrace();
         }
        return this;
     }
}
