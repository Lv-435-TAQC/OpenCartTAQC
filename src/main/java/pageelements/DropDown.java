package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {
    Select select;

    public DropDown(WebDriver driver, String xpathSelect) {
        super(driver, xpathSelect);
        select = new Select(element);
    }


    public DropDown writOptionParameter(String parameter) {
        select.selectByVisibleText(parameter);
        return this;
    }

    public DropDown writOrdinalIndex(int ordinalIndex) {
        select.selectByIndex(ordinalIndex);
        return this;
    }
}
