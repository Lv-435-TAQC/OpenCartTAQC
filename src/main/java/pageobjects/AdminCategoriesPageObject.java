package pageobjects;


import locators.AdminAddCategoriesLocators;
import org.openqa.selenium.WebDriver;
import locators.AdminCategoriesLocators;
import pageelements.Button;
import pageelements.Label;
/**
 *  Description Of Admin Categories Page Object.
 * Contains  Methods:
 * addNewCategoriesButton (button for opening NewCategoryPage)
 * deleteCategoryButton(button bor deleting chosen category)
 * rebuildCategoryPage(button for refreshing categories list)
 * chooseCategories(button for choosing category)
 *editSomethingToCategories(button for editing category)
 *returnTextFromCategoriesListElement(label that return text from message when you add or edit category)
 *getTextFromMessageInCategories(label that return  text from message when test data incorrect)
 */
public class AdminCategoriesPageObject extends BasePageObject {

    private Button addNewCategoriesButton;
    private Button deleteCategoriesButton;
    private Button rebuildCategoriesPage;
    private Button chooseCategories;
    private Button editSomethingToCategories;
    private Label returnTextFromCategoriesListElement;
    private Label getTextFromMessageInCategories;


    public AdminCategoriesPageObject(WebDriver driver) {
        super(driver);
    }

    /**
     *getTextFromMessageInNewCategories
     * @return string field from message
     */
    public String getTextFromMessageInNewCategories() {
        return new Label(driver, AdminAddCategoriesLocators.RETURN_TEXT_FROM_MESSAGE_IN_NEW_CATEGORIES_LOC).getText();
    }

    /**
     *addNewCategories
     * click on addCategory button
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject addNewCategories() {
        addNewCategoriesButton = new Button(driver, AdminCategoriesLocators.ADD_NEW_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }

    /**
     * getTextFromMessageOfCategories
     * get text when someone add or edit category
     * @return string field from message
     */
    public String getTextFromMessageOfCategories() {
        getTextFromMessageInCategories = new Label(this.driver, AdminCategoriesLocators.RETURN_TEXT_FROM_MESSAGE_LOC);
        return getTextFromMessageInCategories.getText();
    }

    /**
     * deleteCategoriesFromCategoriesList
     * delete chosen category
     * @return AdminCategoriesPageObject
     */
    public AdminCategoriesPageObject deleteCategoriesFromCategoriesList() {
        deleteCategoriesButton = new Button(driver, AdminCategoriesLocators.DELETE_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    /**
     * rebuildOnCategoriesPage
     * refresh categories list
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject rebuildOnCategoriesPage() {
        rebuildCategoriesPage = new Button(driver, AdminCategoriesLocators.REBUILD_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }

    /**
     * chooseCategoriesFromCategoriesList
     * select category from categories list
     * @return AdminCategoriesPageObject
     */
    public AdminCategoriesPageObject chooseCategoriesFromCategoriesList() {
        chooseCategories = new Button(driver, AdminCategoriesLocators.CHOOSE_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    /**
     * changeSomethingInCategories
     * edit something to category
     * @return AdminNewCategoriesPageObject
     */
    public AdminNewCategoriesPageObject changeSomethingInCategories() {
        editSomethingToCategories = new Button(driver, AdminCategoriesLocators.EDIT_SOMETHING_TO_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }

    /**
     * getTextOfElementFromListOfCategories
     * @return string field from message
     */
    public String getTextOfElementFromListOfCategories() {
        returnTextFromCategoriesListElement = new Label(this.driver, AdminCategoriesLocators.RETURN_TEXT_FROM_CATEGORIES_LIST_LOC);
        return returnTextFromCategoriesListElement.getText();
    }
}


