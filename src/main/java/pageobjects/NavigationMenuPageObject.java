package pageobjects;

import locators.CategoryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.LinkedLabel;

import java.util.List;

public class NavigationMenuPageObject extends BasePageObject {
    List<LinkedLabel> navigationMenu;

    public NavigationMenuPageObject(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> generateMenuWebElements() {
        List<WebElement> elements = driver.findElements(By.xpath(CategoryLocators.NAVIGATION_MENU_LOC));
        return elements;
    }

    /**
     * Generator of navigation menu structure
     * @return instance of this object
     */
    private NavigationMenuPageObject generateMenu() {
        List<WebElement> elements = generateMenuWebElements();
        for (int i = 0; i < elements.size(); i++) {
            navigationMenu.add(new LinkedLabel(elements.get(i)));
        }
        return this;
    }

    /**
     * Wrapper for click on menu point
     * @param item - name of point
     * @return instance of category page object
     */
    public CategoryPageObject clickOnMenuByItem(String item) {
        String xpath = CategoryLocators.ALL_PRODUCTS_DIV_LOC;
        generateMenu();
        for (int i = 0; i < navigationMenu.size(); i++) {
            if (navigationMenu.get(i).getText().contains(item)) {
                if (navigationMenu.get(i).getText().contains("-")) {
                    xpath = CategoryLocators.SUB_PRODUCTS_DIV_LOC;
                    navigationMenu.get(i).click();
                } else {
                    navigationMenu.get(i).click();
                }
            } else {
                navigationMenu.get(0).click();
            }
        }
        return new CategoryPageObject(this.driver, xpath);
    }

}
