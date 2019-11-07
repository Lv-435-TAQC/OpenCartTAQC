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
    private AbstractCategoryPageObject abstractCategoryPageObject;


    public FilterPageObject(WebDriver driver, AbstractCategoryPageObject categoryPageObject) {
        super(driver);
        abstractCategoryPageObject = categoryPageObject;
    }

    /**
     * Default wrapper for click on List button
     *
     * @return instance of category page object
     */
    public AbstractCategoryPageObject clickListButton() {
        listButton = new ImageTextButton(this.driver, FilterLocators.SHOW_LIST_BUTTON_LOC);
        listButton.click();
        return new SubCategoryPageObject(this.driver);
    }

    /**
     * Default wrapper for click on Grid button
     *
     * @return instance of category page object
     */
    public AbstractCategoryPageObject clickGridButton() {
        gridButton = new ImageTextButton(this.driver, FilterLocators.SHOW_GRID_BUTTON_LOC);
        gridButton.click();
        return abstractCategoryPageObject;
    }

    /**
     * Default wrapper for click on Product Compare linked label
     *
     * @return instance of compare product page object
     */
    public CompareProductPageObject clickProductCompare() {
        productCompareLabel = new LinkedLabel(this.driver, FilterLocators.PRODUCT_COMPARE_LABEL_LOC);
        productCompareLabel.click();
        return new CompareProductPageObject(this.driver);
    }

    /**
     * Text getter from Product Compare linked label
     *
     * @return text from label
     */
    public String getProductCompareText() {
        productCompareLabel = new LinkedLabel(this.driver, FilterLocators.PRODUCT_COMPARE_LABEL_LOC);
        return productCompareLabel.getText();
    }

    /**
     * Text getter from SortBy label
     *
     * @return text from label
     */
    public String getSortByLabelText() {
        sortByLabel = new LinkedLabel(this.driver, FilterLocators.SORT_BY_LABEL_LOC);
        return sortByLabel.getText();
    }

    /**
     * Wrapper for drop dawn selector of sorting method by name
     *
     * @param param - name of point in drop down selector
     * @return instance of category page object
     */
    public AbstractCategoryPageObject choseSortBySelectorByParam(String param) {
        sortByDropDown = new DropDown(driver, FilterLocators.SORT_BY_SELECTOR_LOC);
        sortByDropDown.writeOptionParameter(param);
        return abstractCategoryPageObject;
    }

    /**
     * Wrapper for drop dawn selector of sorting method by id
     *
     * @param id - id of point in drop down selector
     * @return instance of category page object
     */
    public AbstractCategoryPageObject choseSortBySelectorByID(int id) {
        sortByDropDown = new DropDown(driver, FilterLocators.SORT_BY_SELECTOR_LOC);
        sortByDropDown.writeOrdinalIndex(id);
        return abstractCategoryPageObject;
    }

    /**
     * Text getter from Show label
     *
     * @return text from label
     */
    public String getShowLabelText() {
        showLabel = new LinkedLabel(this.driver, FilterLocators.SHOW_LABEL_LOC);
        return showLabel.getText();
    }

    /**
     * Wrapper for drop dawn selector for number of product method by name
     *
     * @param param - name of point in drop down selector
     * @return instance of category page object
     */

    public AbstractCategoryPageObject choseShowSelectorByParam(String param) {
        showDropDown = new DropDown(driver, FilterLocators.SHOW_SELECTOR_LOC);
        showDropDown.writeOptionParameter(param);
        return abstractCategoryPageObject;
    }

    /**
     * Wrapper for drop dawn selector for number of product method by id
     *
     * @param id - id of point in drop down selector
     * @return instance of category page object
     */
    public AbstractCategoryPageObject choseShowSelectorByID(int id) {
        showDropDown = new DropDown(driver, FilterLocators.SHOW_SELECTOR_LOC);
        showDropDown.writeOrdinalIndex(id);
        return abstractCategoryPageObject;
    }

}
