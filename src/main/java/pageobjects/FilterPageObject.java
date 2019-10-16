package pageobjects;

import locators.FilterLocators;
import org.openqa.selenium.WebDriver;
import pageelements.DropDown;
import pageelements.ImageTextButton;
import pageelements.Label;
import pageelements.LinkedLabel;


public class FilterPageObject extends BasePageObject {
    private ImageTextButton listButton;
    private ImageTextButton gridButton;
    private LinkedLabel productCompareLabel;
    private Label sortByLabel;
    private DropDown sortByDropDown;
    private Label showLabel;
    private DropDown showDropDown;

    public FilterPageObject(WebDriver driver) {
        super(driver);
    }

    public CategoryPageObject clickListButton() {
        listButton = new ImageTextButton(this.driver, FilterLocators.SHOW_LIST_BUTTON_LOC);
        listButton.click();
        return new CategoryPageObject(this.driver);
    }

    public CategoryPageObject clickGridButton() {
        gridButton = new ImageTextButton(this.driver, FilterLocators.SHOW_GRID_BUTTON_LOC);
        gridButton.click();
        return new CategoryPageObject(this.driver);
    }

    public ProductComparePageObject clickProductCompare() {
        productCompareLabel = new LinkedLabel(this.driver, FilterLocators.PRODUCT_COMPARE_LABEL_LOC);
        productCompareLabel.click();
        return new ProductComparePageObject(this.driver);
    }

    public String getProductCompareText() {
        productCompareLabel = new LinkedLabel(this.driver, FilterLocators.PRODUCT_COMPARE_LABEL_LOC);
        return productCompareLabel.getText();
    }

    public String getSortByLabelText() {
        sortByLabel = new LinkedLabel(this.driver, FilterLocators.SORT_BY_LABEL_LOC);
        return sortByLabel.getText();
    }

    public CategoryPageObject choseSortBySelectorByParam(String param) {
        sortByDropDown = new DropDown(driver, FilterLocators.SORT_BY_SELECTOR_LOC);
        sortByDropDown.writOptionParameter(param);
        return new CategoryPageObject(this.driver);
    }

    public CategoryPageObject choseSortBySelectorByID(int id) {
        sortByDropDown = new DropDown(driver, FilterLocators.SORT_BY_SELECTOR_LOC);
        sortByDropDown.writOrdinalIndex(id);
        return new CategoryPageObject(this.driver);
    }

    public String getShowLabelText() {
        showLabel = new LinkedLabel(this.driver, FilterLocators.SHOW_LABEL_LOC);
        return showLabel.getText();
    }

    public CategoryPageObject choseShowSelectorByParam(String param) {
        showDropDown = new DropDown(driver, FilterLocators.SHOW_SELECTOR_LOC);
        showDropDown.writOptionParameter(param);
        return new CategoryPageObject(this.driver);
    }

    public CategoryPageObject choseShowSelectorByID(int id) {
        showDropDown = new DropDown(driver, FilterLocators.SHOW_SELECTOR_LOC);
        showDropDown.writOrdinalIndex(id);
        return new CategoryPageObject(this.driver);
    }

}
