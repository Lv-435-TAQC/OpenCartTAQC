package pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {
    MenuPageObject menuPageObject;
    HeaderPageObject headerPageObject;

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }
}
