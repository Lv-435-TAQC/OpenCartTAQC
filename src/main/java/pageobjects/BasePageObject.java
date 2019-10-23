package pageobjects;

import org.openqa.selenium.WebDriver;

import static utils.commonconstants.Constants.BASE_URL;

public abstract class BasePageObject {

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public BasePageObject goToUrl(String url) {
        driver.get(url);
        return this;
    }

    public HomePageObject goToHomePage() {
        driver.get(BASE_URL);
        return new HomePageObject(driver);
    }
}
