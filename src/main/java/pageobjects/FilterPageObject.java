package pageobjects;

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

    public FilterPageObject clickListButton() {
        listButton = new ImageTextButton(this.driver, );
        listButton.click();
        return this;
    }

    public FilterPageObject clickGridButton() {
        gridButton = new ImageTextButton(this.driver, );
        gridButton.click();
        return this;
    }

    public FilterPageObject clickProductCompare() {
        productCompareLabel = new LinkedLabel(this.driver, );
        productCompareLabel.click();
        return this;
    }
    public String getProductCompareText(){
        productCompareLabel = new LinkedLabel(this.driver, );
        return productCompareLabel.getText();
    }
    public String getSortByLabelText(){
        sortByLabel = new LinkedLabel(this.driver, );
        return sortByLabel.getText();
    }
    public CategoryPageObject choseSortBySelectorByParam(String param){
        sortByDropDown = new DropDown(driver,);
        sortByDropDown.writOptionParameter(param);
        return new CategoryPageObject(this.driver);
    }
    public CategoryPageObject choseSortBySelectorByID(int id){
        sortByDropDown = new DropDown(driver,);
        sortByDropDown.writOrdinalIndex(id);
        return new CategoryPageObject(this.driver);
    }
    public String getShowLabelText(){
        showLabel = new LinkedLabel(this.driver, );
        return showLabel.getText();
    }
    public CategoryPageObject choseShowSelectorByParam(String param){
        showDropDown = new DropDown(driver,);
        showDropDown.writOptionParameter(param);
        return new CategoryPageObject(this.driver);
    }
    public CategoryPageObject choseShowSelectorByID(int id){
        showDropDown = new DropDown(driver,);
        showDropDown.writOrdinalIndex(id);
        return new CategoryPageObject(this.driver);
    }

}
