package pageobjects;

import locators.AdminPageLocators;
import org.openqa.selenium.WebDriver;

import org.stringtemplate.v4.ST;
import pageelements.Button;

import pageelements.Input;
import pageobjects.BasePageObject;
import pageobjects.NavigationPageObject;


public class AdminPageObject extends BasePageObject {

    private AdminNavigationPageObject navigationPageObject;
    private Button closeButton;

    /**
     *
     * @param driver
     */
    public AdminPageObject(WebDriver driver) {
        super(driver);
        navigationPageObject = new AdminNavigationPageObject(driver);
    }

    public AdminPageObject closeModalWindow() {
        closeButton = new Button(driver, AdminPageLocators.CLOSE_MODAL_WINDOW_BUTTON).click();
        return new AdminPageObject(driver);
    }

    public AdminNavigationPageObject getNavigation(){
        navigationPageObject = new AdminNavigationPageObject(driver);
        return navigationPageObject;
    }

}
