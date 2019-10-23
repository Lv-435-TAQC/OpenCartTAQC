package pageobjects;

import locators.AddNewProductsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Button;
import pageelements.ImageButton;
import pageelements.Input;
import pageelements.TextButton;

import java.util.List;

import static Constants.ONE;
import static Constants.TWO;


public class AddNewProductPageObject extends BasePageObject{

    private List<WebElement> list;
    private Input productName;
    private Input productDescription;
    private Input metaTagTitle;
    private Input productModel;
    private Input productPrice;
    private Input productQuantity;
    private Input productManufactures;
    private Button chooseManufactures;
    private Input productCategories;
    private Button chooseCategory;
    private Button productPhotoButton;
    private Button selectPhotoButton;
    private Button editPhotoButton;
    private Button saveNewProductButton;

    public AddNewProductPageObject(WebDriver driver) {

        super(driver);
    }

    private List<WebElement> createListOfMenuOptions(){
        list = driver.findElements(By.xpath(AddNewProductsLocators.ADD_PRODUCT_MENU_LOC));
        return list;
    }

    public AddNewProductPageObject setProductName(String name){
        productName = new Input(driver, AddNewProductsLocators.PRODUCT_NAME_FIELD_LOC).setText(name);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setDescription(String desc){
        productDescription = new Input(driver,AddNewProductsLocators.PRODUCT_DESK_AREA_LOC).setText(desc);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setMetaTagTitle(String tagTitle){
    metaTagTitle = new Input(driver,AddNewProductsLocators.MEGA_TEG_TITLE_LOC).setText(tagTitle);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setProductModel(String model){
        productModel = new Input(driver,AddNewProductsLocators.MODEL_FIELD_LOC).setText(model);
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
        productPrice = new Input(driver,AddNewProductsLocators.PRICE_FIELD_LOC).setText(price);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setQuantity(String quantity){
        productQuantity = new Input(driver,AddNewProductsLocators.QUANTITY_FIELD_LOC).setText(quantity);
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setManufactures(String manufactures){
        productManufactures = new Input(driver,AddNewProductsLocators.MANUFACTURES_FIELD_LOC).setText(manufactures);
        chooseManufactures = new TextButton(driver,AddNewProductsLocators.CHOOSE_MANUFACTURES_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject setCategories(String categories){
        productCategories = new Input(driver,AddNewProductsLocators.CATEGORIES_FIELD_LOC).setText(categories);
        chooseCategory = new TextButton(driver,AddNewProductsLocators.CHOOSE_CATEGORY_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject clickPhoto(){
        productPhotoButton = new ImageButton(driver,AddNewProductsLocators.PHOTO_LOC).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject editPhoto(){
        editPhotoButton = new ImageButton(driver,AddNewProductsLocators.EDIT_PHOTO_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
    }

    public AddNewProductPageObject selectPhoto(){
        selectPhotoButton = new TextButton(driver,AddNewProductsLocators.SELECT_PHOTO_LOC).click();
        return new AddNewProductPageObject(driver);
    }

    public AdminProductsListPageObject saveNewProduct(){
        saveNewProductButton = new ImageButton(driver,AddNewProductsLocators.SAVE_PRODUCT_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);
    }
}
