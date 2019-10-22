package pageobjects;


import org.openqa.selenium.WebDriver;
import locators.AdminCategoriesLocators;
import pageelements.Button;
import pageelements.Label;

public class AdminCategoriesPageObject extends BasePageObject{

    private Button addNewCategoriesButton;
    private Button deleteCategoriesButton;
    private Button rebuildCategoriesPage;
    private Button chooseCategories;
    private Button editSomethingToCategories;
    private Label  returnTextFromCategoriesListElement;

    public AdminCategoriesPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminCategoriesPageObject addNewCategories(){
        addNewCategoriesButton = new Button(driver, AdminCategoriesLocators.ADD_NEW_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }
    public AdminCategoriesPageObject deleteCategoriesFromCategoriesList(){
        deleteCategoriesButton = new Button(driver, AdminCategoriesLocators.DELETE_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }
    public AdminCategoriesPageObject rebuildOnCategoriesPage(){
        rebuildCategoriesPage = new Button(driver, AdminCategoriesLocators.REBUILD_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }
    public AdminCategoriesPageObject chooseCategoriesFromCategoriesList(){
        chooseCategories = new Button(driver, AdminCategoriesLocators.CHOOSE_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }
    public AdminCategoriesPageObject changeSomethingInCategories(){
        editSomethingToCategories = new Button(driver, AdminCategoriesLocators.EDIT_SOMETHING_TO_CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }
    public String returnTextElementFromListOfCategories() {
        returnTextFromCategoriesListElement = new Label(this.driver, AdminCategoriesLocators.RETURN_TEXT_FROM_CATEGORIES_LIST_LOC);
        String textFromCategoriesList = returnTextFromCategoriesListElement.getText();
        return textFromCategoriesList;
    }


}


