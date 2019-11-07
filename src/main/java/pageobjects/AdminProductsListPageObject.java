package pageobjects;

import locators.AdminProductsPageLocators;
import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.*;
import patterns.AdminProductsPatterns;

import java.util.List;

import static utils.Constants.ONE;
import static utils.Constants.TWO;

/**
 * Description of AddNewProductPageObject class
 * Class contains methods and field for AddNewProjectTests
 */

public class AdminProductsListPageObject extends BasePageObject{

    private Button addNewProductButton;
    private Button deleteProductButton;
    private Checkbox mainCheckbox;

    public AdminProductsListPageObject(WebDriver driver) {
        super(driver);
    }

    /**
     * goToAddNewProduct
     * click add new product button
     * @return AddNewProductPageObject
     */

     public AddNewProductPageObject goToAddNewProduct(){
        addNewProductButton = new ImageButton(driver, AdminProductsPageLocators.ADD_NEW_PRODUCT_BUTTON_LOC).click();
        return new AddNewProductPageObject(driver);
     }

    /**
     * getTextFromMessage
     * get text from message about changing product
     * @return String
     */

     public String getTextFromMessage(){
        new WebDriverWait(driver, 30).
                 until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdminProductsPageLocators.SUCCESSFUL_ADDING_MESSAGE_LOC)));
        return new Label(driver, AdminProductsPageLocators.SUCCESSFUL_ADDING_MESSAGE_LOC).getText();
     }

    /**
     * markCheckbox
     * mark main checkbox in products list
     * @return AdminProductsListPageObject
     */
     public AdminProductsListPageObject markCheckbox(){
       mainCheckbox = new Checkbox(driver,AdminProductsPageLocators.CHECKBOX_LOC).clickOnCheckbox();
        return this;
     }

    /**
     * deleteProduct
     * click delete product button
     * accept alert
     * @return AdminProductsListPageObject
     */

    public AdminProductsListPageObject deleteProduct(){
        deleteProductButton = new ImageButton(driver,AdminProductsPageLocators.DELETE_BUTTON_LOC).click();
        driver.switchTo().alert().accept();
        return this;
    }

}
