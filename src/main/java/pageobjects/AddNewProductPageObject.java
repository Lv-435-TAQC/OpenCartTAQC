package pageobjects;

import locators.AddNewProductsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.*;

import java.util.List;


import static utils.Constants.*;



public class AddNewProductPageObject extends BasePageObject {

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
    private Button backToListButton;
    private String fieldMessage;

    public AddNewProductPageObject(WebDriver driver) {

        super(driver);
    }

    private List<WebElement> createListOfMenuOptions() {
        list = driver.findElements(By.xpath(AddNewProductsLocators.ADD_PRODUCT_MENU_LOC));
        return list;
    }

    public AddNewProductPageObject setProductName(String name) {
        productName = new Input(driver, AddNewProductsLocators.PRODUCT_NAME_FIELD_LOC).setText(name);
        return this;
    }

    public AddNewProductPageObject clearProductName() {
        productName = new Input(driver, AddNewProductsLocators.PRODUCT_NAME_FIELD_LOC).clearField();
        return this;
    }

    public AddNewProductPageObject setDescription(String desc) {
        productDescription = new Input(driver, AddNewProductsLocators.PRODUCT_DESK_AREA_LOC).setText(desc);
        return this;
    }

    public AddNewProductPageObject setMetaTagTitle(String tagTitle) {
        metaTagTitle = new Input(driver, AddNewProductsLocators.MEGA_TEG_TITLE_LOC).setText(tagTitle);
        return this;
    }

    public AddNewProductPageObject clearMetaTagTitle() {
        metaTagTitle = new Input(driver, AddNewProductsLocators.MEGA_TEG_TITLE_LOC).clearField();
        return this;
    }

    public AddNewProductPageObject setProductModel(String model) {
        productModel = new Input(driver, AddNewProductsLocators.MODEL_FIELD_LOC).setText(model);
        return this;
    }

    public AddNewProductPageObject clearProductModel() {
        productModel = new Input(driver, AddNewProductsLocators.MODEL_FIELD_LOC).clearField();
        return this;
    }

    public AddNewProductPageObject clickData() {
        this.createListOfMenuOptions().get(ONE).click();
        return this;
    }

    public AddNewProductPageObject clickLinks() {
        this.createListOfMenuOptions().get(TWO).click();
        return this;
    }

    public AddNewProductPageObject clickImage() {
        this.createListOfMenuOptions().get(EIGHT).click();
        return this;
    }

    public AddNewProductPageObject setPrice(String price) {
        productPrice = new Input(driver, AddNewProductsLocators.PRICE_FIELD_LOC).setText(price);
        return this;
    }

    public AddNewProductPageObject setQuantity(String quantity) {
        productQuantity = new Input(driver, AddNewProductsLocators.QUANTITY_FIELD_LOC).clearField().setText(quantity);
        return this;
    }

    public AddNewProductPageObject setManufactures(String manufactures) {
        productManufactures = new Input(driver, AddNewProductsLocators.MANUFACTURES_FIELD_LOC).setText(manufactures);
        chooseManufactures = new TextButton(driver, AddNewProductsLocators.CHOOSE_MANUFACTURES_BUTTON_LOC).click();
        return this;
    }

    public AddNewProductPageObject setCategories(String categories) {
        productCategories = new Input(driver, AddNewProductsLocators.CATEGORIES_FIELD_LOC).setText(categories);
        chooseCategory = new TextButton(driver, AddNewProductsLocators.CHOOSE_CATEGORY_BUTTON_LOC).click();
        return this;
    }

    public AddNewProductPageObject clickPhoto(){
        productPhotoButton = new ImageButton(driver, AddNewProductsLocators.PHOTO_LOC).click();
        return this;
    }

    public AddNewProductPageObject editPhoto(){
        editPhotoButton = new ImageButton(driver, AddNewProductsLocators.EDIT_PHOTO_BUTTON_LOC).click();
        return this;
    }

    public AddNewProductPageObject selectPhoto(){
        selectPhotoButton = new TextButton(driver, AddNewProductsLocators.SELECT_PHOTO_LOC).click();
        return this;
    }

    public AddNewProductPageObject setPhoto() {
       this
               .clickImage()
               .clickPhoto()
               .editPhoto()
               .selectPhoto();
        return this;
    }

    public AdminProductsListPageObject saveNewProduct() {
        saveNewProductButton = new ImageButton(driver, AddNewProductsLocators.SAVE_PRODUCT_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);
    }

    public AddNewProductPageObject saveNewProductWithMistake() {
        saveNewProductButton = new ImageButton(driver, AddNewProductsLocators.SAVE_PRODUCT_BUTTON_LOC).click();
        return this;
    }

    public AdminProductsListPageObject goBackToList(){
        backToListButton = new ImageButton(driver,AddNewProductsLocators.BACK_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);

    }

    public String getMessageFromField(){
        fieldMessage = new Label(driver,AddNewProductsLocators.MESSAGE_FOR_FIELDS_LOC).getText();
        return fieldMessage;

    }

    public AddNewProductPageObject fillGeneralFields(String productName, String description, String megaTag) {
        this
                .setProductName(productName)
                .setDescription(description)
                .setMetaTagTitle(megaTag);
    return this;
    }

    public AddNewProductPageObject fillDataFields(String model,String price,String quantity){
        this
                .clickData()
                .setProductModel(model)
                .setPrice(price)
                .setQuantity(quantity);
        return this;
    }
    public AddNewProductPageObject fillLinksFields(String manufacturer ,String category){
        this
                .clickLinks()
                .setManufactures(manufacturer)
                .setCategories(category);
        return this;
    }
}