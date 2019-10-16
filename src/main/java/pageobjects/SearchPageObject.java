package pageobjects;

import locators.SearchLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;
import pageelements.Label;


public class SearchPageObject extends BasePageObject {
    private Button searchButton;
    private Input inputeNameOfProduct;
    private DropDown categoriesButton;
    private Button searchInSubcategories;
    private Label returnTextOfInpute;
    private Label returnFalseInpute;
    private Input inputeFalseNameOfProduct;

    public SearchPageObject(WebDriver driver) {
        super(driver);

    }

    public SearchPageObject clickSearchButton() {
        searchButton = new Button(this.driver, SearchLocators.SEARCH_BUTTON_XPATH);
        searchButton.click();
        return new SearchPageObject(this.driver);
    }

    public String returnText() {
        returnTextOfInpute = new Label(this.driver, SearchLocators.RETURN_TEXT_XPATH);
        String textFromInpute = returnTextOfInpute.getText();
        return textFromInpute;
    }

    public String returnFalseText() {
        returnFalseInpute = new Label(this.driver, SearchLocators.RETURN_TEXT_WITH_FALSE_DATA);
        String returnFalseSearch = returnFalseInpute.getText();
        return returnFalseSearch;
    }

    public SearchPageObject inputeFalseProductName() {
        inputeFalseNameOfProduct = new Input(this.driver, SearchLocators.INPUTE_SEARCH_TEXT_XPATH);
        inputeFalseNameOfProduct.setTextForField("cam");
        return new SearchPageObject(this.driver);
    }

    public SearchPageObject inputeProductName() {
        inputeNameOfProduct = new Input(this.driver, SearchLocators.INPUTE_SEARCH_TEXT_XPATH);
        inputeNameOfProduct.setTextForField("Mac");
        return new SearchPageObject(this.driver);
    }


    public SearchPageObject selectCategories() {
        this.categoriesButton = new DropDown(driver, SearchLocators.CATEGORIES_BUTTON_XPATH);
        this.categoriesButton.writOptionParameter("Desktops");
        return new SearchPageObject(this.driver);
    }

    public SearchPageObject useInSubcategories() {
        searchInSubcategories = new Button(this.driver, SearchLocators.SEARCH_IN_SUBCATEGORIES_BUTTON_XPATH);
        searchInSubcategories.click();
        return new SearchPageObject(this.driver);
    }
}
