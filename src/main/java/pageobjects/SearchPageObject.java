package pageobjects;

import locators.SearchLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;


public class SearchPageObject extends BasePageObject {
    private Button searchButton;
    private Input inputeNameOfProduct;
    private DropDown  categoriesButton;



    public SearchPageObject(WebDriver driver) {
        super(driver);

    }

    public SearchPageObject clickSearchButton() {
        searchButton = new Button(this.driver, SearchLocators.SEARCH_BUTTON_XPATH);
        searchButton.click();
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


}
