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
    private Input inputeFalseNameOfProduct;
    private Input inputeNameOfProduct;
    private Input inputeProductNameForSearchWhithDescription;
    private DropDown categoriesButton;
    private Label returnTextOfInpute;
    private Label returnFalseInpute;
    private Label returnFirstElementOfSearchText;

    public SearchPageObject(WebDriver driver) {
        super(driver);

    }

    public SearchPageObject clickSearchButton() {
        searchButton = new Button(this.driver, SearchLocators.SEARCH_BUTTON_XPATH);
        searchButton.click();
        return new SearchPageObject(this.driver);
    }

    public String returnTextFromSearch() {
        returnTextOfInpute = new Label(this.driver, SearchLocators.RETURN_TEXT_XPATH);
        String textFromInpute = returnTextOfInpute.getText();
        return textFromInpute;
    }

    public String returnTextFormInvalidSearch() {
        returnFalseInpute = new Label(this.driver, SearchLocators.RETURN_TEXT_WITH_FALSE_DATA_XPATH);
        String returnFalseSearch = returnFalseInpute.getText();
        return returnFalseSearch;
    }
    public  String returnTextFromFirstSearchElement(){
        returnFirstElementOfSearchText = new Label(this.driver, SearchLocators.RETURN_FIRST_ELEMENT_NAME_XPATH);
        String returnFirstElementName = returnFirstElementOfSearchText.getText();
        return  returnFirstElementName;
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
    public SearchPageObject inputeProductNameForSearchWhithProductDescription() {
        inputeProductNameForSearchWhithDescription = new Input(this.driver, SearchLocators.INPUTE_SEARCH_TEXT_XPATH);
        inputeProductNameForSearchWhithDescription.setTextForField("New D_SLR");
        return new SearchPageObject(this.driver);
    }

    public SearchPageObject selectCategories() {
        this.categoriesButton = new DropDown(driver, SearchLocators.CATEGORIES_BUTTON_XPATH);
        this.categoriesButton.writOptionParameter("Desktops");
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
