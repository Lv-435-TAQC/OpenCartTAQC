package pageobjects;

import locators.AdminAddCategoriesLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;


public class AdminNewCategoriesPageObject extends BasePageObject {

    private Button saveNewCategories;
    private Input  nameOfCategories;
    private Input  metaTag;
    private Input  descriptionOfCategories;
    private Input  metaTagDescription;
    private Input  metaTagKeywords;

    public AdminNewCategoriesPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminNewCategoriesPageObject saveNewCategories(){
        saveNewCategories = new Button(driver, AdminAddCategoriesLocators.SAVE_NEW_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }
    public AdminNewCategoriesPageObject inputCategoriesName() {
        nameOfCategories = new Input(this.driver, AdminAddCategoriesLocators.NAME_OF_CATEGORIES_INPUT_LOC);
        nameOfCategories.setText("forTest");
        return new AdminNewCategoriesPageObject(this.driver);
    }
    public AdminNewCategoriesPageObject inputMetaTagOfCategories() {
        metaTag = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_TITLE_INPUT_LOC);
        metaTag.setText("justTest");
        return new AdminNewCategoriesPageObject(this.driver);
    }

    public AdminNewCategoriesPageObject inputDescriptionOfCategories() {
        descriptionOfCategories = new Input(this.driver, AdminAddCategoriesLocators.DESCRIPTION_OF_CATEGORIES_INPUT_LOC);
        descriptionOfCategories.setText("TEST");
        return new AdminNewCategoriesPageObject(this.driver);
    }
    public AdminNewCategoriesPageObject inputMetaTagDescriptionOfCategories() {
        metaTagDescription = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_DESCRIPTION_INPUT_LOC);
        metaTagDescription.setText("TEST");
        return new AdminNewCategoriesPageObject(this.driver);
    }
    public AdminNewCategoriesPageObject inputMetaTagKeywordsOfCategories() {
        metaTagKeywords = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_KEYWORDS_INPUT_LOC);
        metaTagKeywords.setText("TEST");
        return new AdminNewCategoriesPageObject(this.driver);
    }


}
