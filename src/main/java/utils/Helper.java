package utils;

import org.openqa.selenium.WebDriver;
import pageobjects.AbstractCategoryPageObject;
import pageobjects.EmptyCategoryPageObject;
import pageobjects.FullCategoryPageObject;
import pageobjects.SubCategoryPageObject;

public class Helper {
    public static AbstractCategoryPageObject choseCategoryPageObjectForMenu(WebDriver driver, String menuItem) {
        AbstractCategoryPageObject result = null;
        if (menuItem.contains("(0)")) {
            result = new EmptyCategoryPageObject(driver);
        } else if (menuItem.contains("All")) {
            result = new FullCategoryPageObject(driver);
        } else if (Integer.parseInt(menuItem.substring(menuItem.length() - 3, menuItem.length() - 1)) >= 1){
            result = new SubCategoryPageObject(driver);
        } else{
            result = new SubCategoryPageObject(driver);
        }
            return result;
    }
}
