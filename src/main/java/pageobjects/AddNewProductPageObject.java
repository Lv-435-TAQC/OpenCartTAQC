package pageobjects;

import locators.AddNewProductsLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Input;


public class AddNewProductPageObject extends BasePageObject{

    private Input productName;
    private Input productDescription;
    private Input metaTagTitle;

    public AddNewProductPageObject(WebDriver driver) {
        super(driver);
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
}
