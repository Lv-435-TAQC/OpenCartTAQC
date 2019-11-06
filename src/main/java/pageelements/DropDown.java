package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {

    private Select select;

    public DropDown(WebDriver driver, String xpathSelect) {
        super(driver, xpathSelect);
        select = new Select(element);
    }

    public DropDown writeOptionParameter(String parameter) {
        select.selectByVisibleText(parameter);
        return this;
    }

    public DropDown writeOrdinalIndex(int ordinalIndex) {
        select.selectByIndex(ordinalIndex);
        return this;
    }

    public Select getElement() {
        return this.select;
    }
}
