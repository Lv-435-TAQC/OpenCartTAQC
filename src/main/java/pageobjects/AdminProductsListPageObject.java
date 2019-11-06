package pageobjects;

import locators.AdminProductsPageLocators;
import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.*;
import patterns.AdminProductsPatterns;

import java.util.List;

import static utils.Constants.ONE;
import static utils.Constants.TWO;


public class AdminProductsListPageObject extends BasePageObject{

    private List<WebElement> list;
    private Button addNewProductButton;
    private Button copyProductButton;
    private Button editProductButton;
    private Button deleteProductButton;
    private Input filterNameField;
    private Input filterModelField;
    private Input filterPriceField;
    private Input filterQuantityField;
    private Button submitFilterButton;
    private Checkbox mainCheckbox;
    private String productLabel;
    Screen screen = new Screen();

    public AdminProductsListPageObject(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> createList(String xpath){
        list = driver.findElements(By.xpath(xpath));
        return list;
    }

     public AddNewProductPageObject goToAddNewProduct(){
        addNewProductButton = new ImageButton(driver, AdminProductsPageLocators.ADD_NEW_PRODUCT_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
     }

     public String getTextFromMessage(){
        new WebDriverWait(driver, 30).
                 until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdminProductsPageLocators.SUCCESSFUL_ADDING_MESSAGE_LOC)));
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

     public AdminProductsListPageObject markCheckbox(){
       mainCheckbox = new Checkbox(driver,AdminProductsPageLocators.CHECKBOX_LOC).clickOnCheckbox();
        return this;
     }

     public AdminProductsListPageObject clickCopyButton(){
        copyProductButton = new ImageButton(driver,AdminProductsPageLocators.COPY_BUTTON_LOC).click();
        return this;
     }

     public AddNewProductPageObject clickEditButton(){
        editProductButton = new ImageButton(driver,AdminProductsPageLocators.EDIT_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
     }

     public AdminProductsListPageObject setFilterName(String name){
        filterNameField = new Input(driver,AdminProductsPageLocators.FILTER_NAME_FIELD_LOC).setText(name);
        return this;
     }

    public AdminProductsListPageObject setFilterModel(String model){
        filterModelField = new Input(driver,AdminProductsPageLocators.FILTER_MODEL_FIELD_LOC).setText(model);
        return this;
    }

    public AdminProductsListPageObject setFilterPrice(String price){
        filterPriceField = new Input(driver,AdminProductsPageLocators.FILTER_PRICE_FIELD_LOC).setText(price);
        return this;
    }

    public AdminProductsListPageObject setFilterQuantity(String quantity){
        filterQuantityField = new Input(driver,AdminProductsPageLocators.FILTER_QUANTITY_FIELD_LOC).setText(quantity);
        return this;
    }

    public AdminProductsListPageObject clickFilterSubmit(){
        submitFilterButton = new ImageButton(driver,AdminProductsPageLocators.FILTER_SUBMIT_BUTTON_LOC).click();
        return this;
    }

    public String getTextOfProductsModelLabel(){
        productLabel = new Label(driver,AdminProductsPageLocators.NAME_OF_ADDED_PRODUCTS).getText();
        return productLabel;
    }

    public AdminProductsListPageObject deleteProduct(){
        deleteProductButton = new ImageButton(driver,AdminProductsPageLocators.DELETE_BUTTON_LOC).click();
        driver.switchTo().alert().accept();
        return this;
    }

}
