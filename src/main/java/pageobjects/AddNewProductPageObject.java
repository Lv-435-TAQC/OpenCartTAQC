package pageobjects;

import locators.AddNewProductsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Input;

import java.util.List;

import static utils.commonconstants.Constants.ONE;
import static utils.commonconstants.Constants.TWO;


public class AddNewProductPageObject extends BasePageObject{

    private List<WebElement> list;
    private Input productName;
    private Input productDescription;
    private Input metaTagTitle;
    private Input productModel;
    private Input productPrice;
    private Input productQuantity;

    public AddNewProductPageObject(WebDriver driver) {

        super(driver);
    }

    private List<WebElement> createListOfMenuOptions(){
        list = driver.findElements(By.xpath(AddNewProductsLocators.ADD_PRODUCT_MENU_LOC));
        return list;
    }

    public AddNewProductPageObject setProductName(String name){
        productName = new Input(driver, AddNewProductsLocators.PRODUCT_NAME_FIELD_LOC).setTextForField(name);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setDescription(String desc){
        productDescription = new Input(driver,AddNewProductsLocators.PRODUCT_DESK_AREA_LOC).setTextForField(desc);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setMetaTagTitle(String tagTitle){
    metaTagTitle = new Input(driver,AddNewProductsLocators.MEGA_TEG_TITLE_LOC).setTextForField(tagTitle);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setProductModel(String model){
        productModel = new Input(driver,AddNewProductsLocators.MODEL_FIELD_LOC).setTextForField(model);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject clickData(){
        this.createListOfMenuOptions().get(ONE).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject clickLinks(){
        this.createListOfMenuOptions().get(TWO).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject clickImage(){
        this.createListOfMenuOptions().get(8).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setPrice(String price){
        productPrice = new Input(driver,AddNewProductsLocators.PRICE_FIELD_LOC).setTextForField(price);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setQuantity(String quantity){
        productQuantity = new Input(driver,AddNewProductsLocators.QUANTITY_FIELD_LOC).setTextForField(quantity);
        return new AddNewProductPageObject(driver);
    }

}
