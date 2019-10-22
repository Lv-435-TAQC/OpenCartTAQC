package pageobjects;

import locators.AdminPageLocators;
import org.openqa.selenium.WebDriver;

import pageelements.Button;
import pageelements.Input;


public class AdminPageObject extends BasePageObject {

    private AdminNavigationPageObject navigationPageObject;
    private Button closeButton;

    public AdminPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminPageObject goToAdminPage(String loginInputPath, String passwordInputPath){
        Input login = new Input(driver,"");
        Input password = new Input(driver,"");
        Button buttonLogin = new Button(driver,"");
        login.setText(loginInputPath);
        password.setText(passwordInputPath);
        buttonLogin.click();
        return this;


    public AdminPageObject closeModalWindow(){
        closeButton = new Button(driver, AdminPageLocators.CLOSE_MODAL_WINDOW_BUTTON).click();
        return new AdminPageObject(driver);

    }
}
