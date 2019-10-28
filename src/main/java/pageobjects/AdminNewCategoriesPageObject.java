package pageobjects;

import locators.AdminAddCategoriesLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;
import pageelements.Label;


public class AdminNewCategoriesPageObject extends BasePageObject {

    private Button saveNewCategories;
    private Input nameOfCategories;
    private Input metaTag;
    private Input descriptionOfCategories;
    private Input metaTagDescription;
    private Input metaTagKeywords;
    private Label getTextFromMessageInNewCategories;

    public AdminNewCategoriesPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminCategoriesPageObject saveNewCategories() {
        saveNewCategories = new Button(driver, AdminAddCategoriesLocators.SAVE_NEW_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    public AdminNewCategoriesPageObject inputCategoriesName(String name) {
        nameOfCategories = new Input(this.driver, AdminAddCategoriesLocators.NAME_OF_CATEGORIES_INPUT_LOC).setText(name);
        return this;
    }

    public AdminNewCategoriesPageObject inputMetaTagOfCategories(String name) {
        metaTag = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_TITLE_INPUT_LOC).setText(name);
        return this;
    }

    public AdminNewCategoriesPageObject inputDescriptionOfCategories() {
        descriptionOfCategories = new Input(this.driver, AdminAddCategoriesLocators.DESCRIPTION_OF_CATEGORIES_INPUT_LOC);
        descriptionOfCategories.setText("TEST");
        return this;
    }

    public AdminNewCategoriesPageObject inputMetaTagDescriptionOfCategories(String name) {
        metaTagDescription = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_DESCRIPTION_INPUT_LOC).setText(name);
        return this;
    }

    public AdminNewCategoriesPageObject inputMetaTagKeywordsOfCategories(String name) {
        metaTagKeywords = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_KEYWORDS_INPUT_LOC).setText(name);
        return this;
    }


}
