package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.BasePageObject;

public class NavigationPageObject extends BasePageObject {
    private OrdersPageObject ordersPageObject;

    public NavigationPageObject(WebDriver driver) {
        super(driver);
    }
}
