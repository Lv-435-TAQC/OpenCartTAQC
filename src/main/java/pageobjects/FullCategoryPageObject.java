package pageobjects;

import locators.CategoryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Label;

import java.util.ArrayList;

public class FullCategoryPageObject extends SubCategoryPageObject {
    private Label categoryDescriptionLabel;

    public FullCategoryPageObject(WebDriver driver) {
        super(driver);
        setXpath(CategoryLocators.ALL_PRODUCTS_DIV_LOC);
    }


    public String getTextFromCategoryDescription() {
        categoryDescriptionLabel = new Label(this.driver, CategoryLocators.CATEGORY_DESCRIPTION_LABEL_LOC);
        return categoryDescriptionLabel.getText();
    }

}
