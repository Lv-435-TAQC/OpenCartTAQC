package pageobjects;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public abstract class BasePageObject {
    protected WebDriver driver;
    MenuPageObject menuPageObject;
    HeaderPageObject headerPageObject;

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

    public void goToUrl(String url) {
        driver.get(url);
    }


}
