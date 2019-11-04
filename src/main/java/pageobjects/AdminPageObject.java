package pageobjects;

import locators.AdminPageLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;


public class AdminPageObject extends BasePageObject {

    private AdminNavigationPageObject navigationPageObject;
    private Button closeButton;

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
