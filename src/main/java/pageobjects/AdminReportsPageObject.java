package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.DropDown;

import static locators.AdminReportsLocators.FILTER;

public class AdminReportsPageObject extends BasePageObject {
    private AdminPageObject adminPageObject;
    private DropDown filter;
    private AdminNavigationPageObject adminNavigationPageObject;
    private AdminReportsProductViewedPO adminReportsProductViewedPO;


    public AdminReportsPageObject(WebDriver driver) {
        super(driver);
        this.adminPageObject = new AdminPageObject(driver);
        this.filter = new DropDown(driver, FILTER);
        this.adminNavigationPageObject = new AdminNavigationPageObject(driver);

    }

    public AdminReportsProductViewedPO getAdminReportsProductViewedPO() {
        return adminReportsProductViewedPO;
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
        adminReportsProductViewedPO = new AdminReportsProductViewedPO(driver);
        return this;
    }
}