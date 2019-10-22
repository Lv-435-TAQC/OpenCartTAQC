package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.BasePageObject;
import pageobjects.NavigationPageObject;

public class AdminPageObject extends BasePageObject {

    private NavigationPageObject navigationPageObject;

    /**
     *
     * @param driver
     */
    public AdminPageObject(WebDriver driver) {
        super(driver);
    }
}
