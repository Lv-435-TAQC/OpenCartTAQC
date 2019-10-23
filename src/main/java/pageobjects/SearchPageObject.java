package pageobjects;

import locators.SearchLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;
import pageelements.Label;


public class SearchPageObject extends BasePageObject {
    private Button searchButton;
    private Button searchInSubcategories;
    private Button searchInDescriptionButton;
    private Input inputFalseNameOfProduct;
    private Input inputNameOfProduct;
    private Input inputProductNameForSearchWithDescription;
    private DropDown categoriesButton;
    private Label returnTextOfInput;
    private Label returnFalseInput;
    private Label returnFirstElementOfSearchText;
    private Label returnFifthElementOfCategories;

    public SearchPageObject(WebDriver driver) {
        super(driver);

    }

    public SearchPageObject clickSearchButton() {
        searchButton = new Button(this.driver, SearchLocators.SEARCH_BUTTON_XPATH);
        searchButton.click();
        return new SearchPageObject(this.driver);
    }

    public String returnTextFromSearch() {
        returnTextOfInput = new Label(this.driver, SearchLocators.RETURN_TEXT_XPATH);
        String textFromInput = returnTextOfInput.getText();
        return textFromInput;
    }

    public String returnTextFormInvalidSearch() {
        returnFalseInput = new Label(this.driver, SearchLocators.RETURN_TEXT_WITH_FALSE_DATA_XPATH);
        String returnFalseSearch = returnFalseInput.getText();
        return returnFalseSearch;
    }
    public  String returnTextFromFirstSearchElement(){
        returnFirstElementOfSearchText = new Label(this.driver, SearchLocators.RETURN_FIRST_ELEMENT_NAME_XPATH);
        String returnFirstElementName = returnFirstElementOfSearchText.getText();
        return  returnFirstElementName;
    }
    public String returnTextFromFifthElementOfCategories(){
        returnFifthElementOfCategories = new Label(this.driver, SearchLocators.FIFTH_ELEMENT_OF_CATEGORIES);
        String returnFifthElementCategories = returnFifthElementOfCategories.getText();
        return  returnFifthElementCategories;
    }

    public SearchPageObject inputFalseProductName() {
        inputFalseNameOfProduct = new Input(this.driver, SearchLocators.INPUT_SEARCH_TEXT_XPATH);
        inputFalseNameOfProduct.setText("cam");
        return new SearchPageObject(this.driver);
    }

    public SearchPageObject inputProductName() {
        inputNameOfProduct = new Input(this.driver, SearchLocators.INPUT_SEARCH_TEXT_XPATH);
        inputNameOfProduct.setText("Mac");
        return new SearchPageObject(this.driver);
    }
    public SearchPageObject inputProductNameForSearchWithProductDescription() {
        inputProductNameForSearchWithDescription = new Input(this.driver, SearchLocators.INPUT_SEARCH_TEXT_XPATH);
        inputProductNameForSearchWithDescription.setText("New D_SLR");
        return new SearchPageObject(this.driver);
    }

    public SearchPageObject selectCategories() {
        this.categoriesButton = new DropDown(driver, SearchLocators.CATEGORIES_BUTTON_XPATH);
        this.categoriesButton.writeOptionParameter("Desktops");
        return new SearchPageObject(this.driver);
    }
    public SearchPageObject searchInDescription() {
        searchInDescriptionButton = new Button(this.driver, SearchLocators.SEARCH_IN_PRODUCT_DESCRIPTION_BUTTON_XPATH);
        searchInDescriptionButton.click();
        return new SearchPageObject(this.driver);
    }

    public SearchPageObject useInSubcategories() {
        searchInSubcategories = new Button(this.driver, SearchLocators.SEARCH_IN_SUBCATEGORIES_BUTTON_XPATH);
        searchInSubcategories.click();
        return new SearchPageObject(this.driver);
    }
}
