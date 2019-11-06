package pageobjects;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import utils.TestData;

import static utils.Constants.BASE_ADMIN_URL;
import static utils.Constants.BASE_URL;
import static utils.Constants.*;

public abstract class BasePageObject {

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean findPatternByScreen(Screen screen, Pattern pattern) {
        Boolean b = true;
        try {
            screen.find(pattern);
        } catch (FindFailed findFailed) {
            b = false;
        }
        return b;
    }

    public BasePageObject goToUrl(String url) {
        driver.get(url);
        return this;
    }

    public HomePageObject goToHomePage() {
        driver.get(BASE_URL);
        return new HomePageObject(driver);
    }

//    public HomePageObject goToHomeUrlPage() {
//        driver.get(HOME_PAGE);
//        return new HomePageObject(driver);
//    }
}
