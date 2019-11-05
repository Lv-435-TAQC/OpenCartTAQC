package pageobjects;


import locators.AdminAddCategoriesLocators;
import org.openqa.selenium.WebDriver;
import locators.AdminCategoriesLocators;
import pageelements.Button;
import pageelements.Label;

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
    public String getTextFromMessageInNewCategories() {
        return new Label(driver, AdminAddCategoriesLocators.RETURN_TEXT_FROM_MESSAGE_IN_NEW_CATEGORIES_LOC).getText();
    }

    public AdminNewCategoriesPageObject addNewCategories() {
        addNewCategoriesButton = new Button(driver, AdminCategoriesLocators.ADD_NEW_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }

    public String getTextFromMessageOfCategories() {
        getTextFromMessageInCategories = new Label(this.driver, AdminCategoriesLocators.RETURN_TEXT_FROM_MESSAGE_LOC);
        return getTextFromMessageInCategories.getText();
    }

    public AdminCategoriesPageObject deleteCategoriesFromCategoriesList() {
        deleteCategoriesButton = new Button(driver, AdminCategoriesLocators.DELETE_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    public AdminNewCategoriesPageObject rebuildOnCategoriesPage() {
        rebuildCategoriesPage = new Button(driver, AdminCategoriesLocators.REBUILD_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }

    public AdminCategoriesPageObject chooseCategoriesFromCategoriesList() {
        chooseCategories = new Button(driver, AdminCategoriesLocators.CHOOSE_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    public AdminNewCategoriesPageObject changeSomethingInCategories() {
        editSomethingToCategories = new Button(driver, AdminCategoriesLocators.EDIT_SOMETHING_TO_CATEGORIES_BUTTON_LOC).click();
        return new AdminNewCategoriesPageObject(driver);
    }

    public String getTextOfElementFromListOfCategories() {
        returnTextFromCategoriesListElement = new Label(this.driver, AdminCategoriesLocators.RETURN_TEXT_FROM_CATEGORIES_LIST_LOC);
        return returnTextFromCategoriesListElement.getText();
    }
}


