package pageobjects;

import locators.AdminPageLocators;
import locators.MenuLocators;
import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.ImageButton;


public class AdminPageObject extends BasePageObject {

    private AdminNavigationPageObject navigationPageObject;
    private Button closeButton;
    private Button profileButton;
    private Button yourStoreButton;

    /**
     *
     * @param driver
     */
    public AdminPageObject(WebDriver driver) {
        super(driver);
        this.navigationPageObject = new AdminNavigationPageObject(driver);
    }

    public AdminPageObject closeModalWindow() {
        closeButton = new Button(driver, AdminPageLocators.CLOSE_MODAL_WINDOW_BUTTON).click();
        return new AdminPageObject(driver);
    }

    public AdminNavigationPageObject getNavigation() {
        navigationPageObject = new AdminNavigationPageObject(driver);
        return this.navigationPageObject;
    }
}
