package pageobjects;

import locators.AddNewProductsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.*;

import java.util.List;


import static utils.Constants.*;

/**
 * Decription of AddNewProductPageObject class
 * Class contains methods and field for AddNewProjectTests
 */


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

    /**
     * createListOfMenuOptions
     * find all options of menu
     * @return listOfOption
     */
    private List<WebElement> createListOfMenuOptions() {
        list = driver.findElements(By.xpath(AddNewProductsLocators.ADD_PRODUCT_MENU_LOC));
        return list;
    }

    /**
     * setProductName
     * set product name in field
     * @param name - name of product;
     * @return setProductName
     */

    public AddNewProductPageObject setProductName(String name) {
        productName = new Input(driver, AddNewProductsLocators.PRODUCT_NAME_FIELD_LOC).setText(name);
        return this;
    }

    /**
     * setDescription
     * set description in field
     * @param desc - description of product
     * @return AddNewProductPageObject
     */
    public AddNewProductPageObject setDescription(String desc) {
        productDescription = new Input(driver, AddNewProductsLocators.PRODUCT_DESK_AREA_LOC).setText(desc);
        return this;
    }

    /**
     * setMetaTagTitle
     * set description in field
     * @param tagTitle - megaTag of product
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject setMetaTagTitle(String tagTitle) {
        metaTagTitle = new Input(driver, AddNewProductsLocators.MEGA_TEG_TITLE_LOC).setText(tagTitle);
        return this;
    }
    /**
     * setProductModel
     * set model in field
     * @param model - model of product
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject setProductModel(String model) {
        productModel = new Input(driver, AddNewProductsLocators.MODEL_FIELD_LOC).setText(model);
        return this;
    }

    /**
     * clickData
     * click on Data option
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject clickData() {
        this.createListOfMenuOptions().get(ONE).click();
        return this;
    }

    /**
     * clickLinks
     * click on Links option
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject clickLinks() {
        this.createListOfMenuOptions().get(TWO).click();
        return this;
    }

    /**
     * clickImage
     * click on Image option
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject clickImage() {
        this.createListOfMenuOptions().get(EIGHT).click();
        return this;
    }

    /**
     * setPrice
     * set price in field
     * @param price - price of product
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject setPrice(String price) {
        productPrice = new Input(driver, AddNewProductsLocators.PRICE_FIELD_LOC).setText(price);
        return this;
    }

    /**
     * setQuantity
     * set quantity in field
     * @param quantity - quantity of product
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject setQuantity(String quantity) {
        productQuantity = new Input(driver, AddNewProductsLocators.QUANTITY_FIELD_LOC).clearField().setText(quantity);
        return this;
    }

    /**
     * setManufactures
     * select manufactures
     * @param manufactures - manufactures of product
     * @return AddNewProductPageObject
     */
    public AddNewProductPageObject setManufactures(String manufactures) {
        productManufactures = new Input(driver, AddNewProductsLocators.MANUFACTURES_FIELD_LOC).setText(manufactures);
        chooseManufactures = new TextButton(driver, AddNewProductsLocators.CHOOSE_MANUFACTURES_BUTTON_LOC).click();
        return this;
    }

    /**
     *
     * @param categories .
     * @return
     */
    public AddNewProductPageObject setCategories(String categories) {
        productCategories = new Input(driver, AddNewProductsLocators.CATEGORIES_FIELD_LOC).setText(categories);
        chooseCategory = new TextButton(driver, AddNewProductsLocators.CHOOSE_CATEGORY_BUTTON_LOC).click();
        return this;
    }

    /**
     * clickPhoto
     * click on current photo
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject clickPhoto(){
        productPhotoButton = new ImageButton(driver, AddNewProductsLocators.PHOTO_LOC).click();
        return this;
    }

    /**
     * editPhoto
     * click on edit photo button
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject editPhoto(){
        editPhotoButton = new ImageButton(driver, AddNewProductsLocators.EDIT_PHOTO_BUTTON_LOC).click();
        return this;
    }

    /**
     * selectPhoto
     * click on selected photo
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject selectPhoto(){
        selectPhotoButton = new TextButton(driver, AddNewProductsLocators.SELECT_PHOTO_LOC).click();
        return this;
    }

    /**
     * setPhoto
     * click current image
     * click edit photo
     * select photo
     * @return AddNewProductPageObject
     */
    public AddNewProductPageObject setPhoto() {
       this
               .clickImage()
               .clickPhoto()
               .editPhoto()
               .selectPhoto();
        return this;
    }

    /**
     * saveNewProduct
     * click on save new product button
     * @return AdminProductsListPageObject
     */
    public AdminProductsListPageObject saveNewProduct() {
        saveNewProductButton = new ImageButton(driver, AddNewProductsLocators.SAVE_PRODUCT_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);
    }

    /**
     * saveNewProductWithMistake
     * click on save new button with incorrect data;
     * @return AddNewProductPageObject
     */
    public AddNewProductPageObject saveNewProductWithMistake() {
        saveNewProductButton = new ImageButton(driver, AddNewProductsLocators.SAVE_PRODUCT_BUTTON_LOC).click();
        return this;
    }

    /**
     * goBackToList
     * click on back to list button
     * @return AdminProductsListPageObject
     */
    public AdminProductsListPageObject goBackToList(){
        backToListButton = new ImageButton(driver,AddNewProductsLocators.BACK_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);

    }

    /**
     * getMessageFromField
     * get text form message after changing in products
     * @return String fieldMessage
     */

    public String getMessageFromField(){
        fieldMessage = new Label(driver,AddNewProductsLocators.MESSAGE_FOR_FIELDS_LOC).getText();
        return fieldMessage;

    }

    /**
     * fillGeneralFields
     * set all data in general fields
     * @param productName - name of product
     * @param description - description of product
     * @param megaTag - megaTag of product
     * @return AddNewProductPageObject
     */

    public AddNewProductPageObject fillGeneralFields(String productName, String description, String megaTag) {
        this
                .setProductName(productName)
                .setDescription(description)
                .setMetaTagTitle(megaTag);
    return this;
    }

    /**
     * fillDataFields
     * set all data in Data Fields
     * @param model - model of product
     * @param price - price of product
     * @param quantity - quantity of product
     * @return AddNewProductPageObject
     */
    public AddNewProductPageObject fillDataFields(String model,String price,String quantity){
        this
                .clickData()
                .setProductModel(model)
                .setPrice(price)
                .setQuantity(quantity);
        return this;
    }

    /**
     * fillLinksFields
     * set all data in links fields
     * @param manufacturer - manufactures of product
     * @param category - category of product
     * @return
     */
    public AddNewProductPageObject fillLinksFields(String manufacturer ,String category){
        this
                .clickLinks()
                .setManufactures(manufacturer)
                .setCategories(category);
        return this;
    }
}