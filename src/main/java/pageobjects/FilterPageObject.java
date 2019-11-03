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
    private String xpath;

    public FilterPageObject(WebDriver driver, String xpath) {
        super(driver);
        this.xpath = xpath;
    }

    public CategoryPageObject clickListButton() {
        listButton = new ImageTextButton(this.driver, FilterLocators.SHOW_LIST_BUTTON_LOC);
        listButton.click();
        return new CategoryPageObject(this.driver, xpath);
    }

    public CategoryPageObject clickGridButton() {
        gridButton = new ImageTextButton(this.driver, FilterLocators.SHOW_GRID_BUTTON_LOC);
        gridButton.click();
        return new CategoryPageObject(this.driver, xpath);
    }

    public CompareProductPageObject clickProductCompare() {
        productCompareLabel = new LinkedLabel(this.driver, FilterLocators.PRODUCT_COMPARE_LABEL_LOC);
        productCompareLabel.click();
        return new CompareProductPageObject(this.driver);
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
        sortByDropDown.writeOptionParameter(param);
        return new CategoryPageObject(this.driver, xpath);
    }

    public CategoryPageObject choseSortBySelectorByID(int id, String xpath) {
        sortByDropDown = new DropDown(driver, FilterLocators.SORT_BY_SELECTOR_LOC);
        sortByDropDown.writeOrdinalIndex(id);
        return new CategoryPageObject(this.driver, xpath);
    }

    public String getShowLabelText() {
        showLabel = new LinkedLabel(this.driver, FilterLocators.SHOW_LABEL_LOC);
        return showLabel.getText();
    }

    public CategoryPageObject choseShowSelectorByParam(String param) {
        showDropDown = new DropDown(driver, FilterLocators.SHOW_SELECTOR_LOC);
        showDropDown.writeOptionParameter(param);
        return new CategoryPageObject(this.driver, xpath);
    }

    public CategoryPageObject choseShowSelectorByID(int id) {
        showDropDown = new DropDown(driver, FilterLocators.SHOW_SELECTOR_LOC);
        showDropDown.writeOrdinalIndex(id);
        return new CategoryPageObject(this.driver, xpath);
    }

}
