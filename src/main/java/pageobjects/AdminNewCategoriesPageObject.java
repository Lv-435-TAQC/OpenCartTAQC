package pageobjects;

import locators.AdminAddCategoriesLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;
import pageelements.Label;
/**
 *  Description Of Admin New Categories Page Object.
 * Contains  Methods
 * saveNewCategories(button to save category)
 * nameOfCategories(input name for category )
 * metaTag (input metaTag for category)
 * descriptionOfCategories (input description for category)
 * metaTagDescription(input metaTag description for  category)
 * metaTagKeywords(input metaTag keywords for category)
 */
public class AdminNewCategoriesPageObject extends BasePageObject {

    private Button saveNewCategories;
    private Input nameOfCategories;
    private Input metaTag;
    private Input descriptionOfCategories;
    private Input metaTagDescription;
    private Input metaTagKeywords;
    private Label getTextFromMessageInNewCategories;
    private Label getTextFromCategoryNameField;

    public AdminNewCategoriesPageObject(WebDriver driver) {
        super(driver);
    }
    public String getTextOfCategoryName() {
        getTextFromCategoryNameField = new Label(this.driver, AdminAddCategoriesLocators.NAME_OF_CATEGORIES_INPUT_LOC);
        return getTextFromCategoryNameField.getText();
    }

    /**
     * inputCategoriesName
     * input  name for category
     * @param name
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject inputCategoriesName(String name ) {
        nameOfCategories = new Input(this.driver, AdminAddCategoriesLocators.NAME_OF_CATEGORIES_INPUT_LOC).setText(name);
        return this;
    }

    /**
     * saveNewCategories
     * button to save new category
     * @return AdminCategoriesPageObject
     */
        public AdminCategoriesPageObject saveNewCategories() {
        saveNewCategories = new Button(driver, AdminAddCategoriesLocators.SAVE_NEW_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    /**
     * inputMetaTagOfCategories
     * input metaTag for category
     * @param name
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject inputMetaTagOfCategories(String name) {
        metaTag = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_TITLE_INPUT_LOC).setText(name);
        return this;
    }

    /**
     * inputDescriptionOfCategories
     * input description for category
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject inputDescriptionOfCategories(String name ) {
        descriptionOfCategories = new Input(this.driver, AdminAddCategoriesLocators.DESCRIPTION_OF_CATEGORIES_INPUT_LOC).setText(name);
        return this;
    }

    /**
     * inputMetaTagDescriptionOfCategories
     * input metaTag description for category
     * @param name
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject inputMetaTagDescriptionOfCategories(String name) {
        metaTagDescription = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_DESCRIPTION_INPUT_LOC).setText(name);
        return this;
    }

    /**
     * inputMetaTagKeywordsOfCategories
     * input metaTag keywords for category
     * @param name
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject inputMetaTagKeywordsOfCategories(String name) {
        metaTagKeywords = new Input(this.driver, AdminAddCategoriesLocators.META_TAG_KEYWORDS_INPUT_LOC).setText(name);
        return this;
    }
}
