package pageobjects;

import org.openqa.selenium.WebDriver;
import org.stringtemplate.v4.ST;
import pageelements.Button;
import pageelements.Input;
import pageobjects.BasePageObject;
import pageobjects.NavigationPageObject;

public class AdminPageObject extends BasePageObject {

    private AdminNavigationPageObject navigationPageObject;

    public AdminPageObject(WebDriver driver) {
        super(driver);
    }
    public AdminPageObject goToAdminPage(String loginInputPath, String passwordInputPath){
        Input login = new Input(driver,"");
        Input password = new Input(driver,"");
        Button buttonLogin = new Button(driver,"");
        login.setTextForField(loginInputPath);
        password.setTextForField(passwordInputPath);
        buttonLogin.click();
        return this;
    }
}
