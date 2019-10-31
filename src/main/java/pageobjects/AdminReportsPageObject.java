package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.DropDown;

import static locators.AdminReportsLocators.FILTER;

public class AdminReportsPageObject extends BasePageObject {
    private AdminPageObject adminPageObject;
    private DropDown filter;
    private AdminNavigationPageObject adminNavigationPageObject;


    public AdminReportsPageObject(WebDriver driver) {
        super(driver);
        this.adminPageObject = new AdminPageObject(driver);
        this.filter = new DropDown(driver, FILTER);
        this.adminNavigationPageObject = new AdminNavigationPageObject(driver);

    }

    public AdminNavigationPageObject getAdminNavigationPageObject() {
        return adminNavigationPageObject;
    }

    public AdminPageObject getAdminPageObject() {
        return adminPageObject;
    }

    public DropDown getFilter() {
        return filter;
    }

    public AdminReportsPageObject clickProductsViewedReport() {
        this.filter.writeOptionParameter("Products Viewed Report");

        return new AdminReportsPageObject(driver);
    }
}