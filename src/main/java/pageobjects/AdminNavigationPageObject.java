package pageobjects;

import locators.AdminNavigationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.TextButton;

import static locators.AdminNavigationLocators.CUSTOMERS_BUTTON_XPATH;
import static locators.AdminNavigationLocators.CUSTOMERS_SUB_BUTTON_XPATH;

public class AdminNavigationPageObject extends BasePageObject {

    private Button products;
    private Button catalog;
    private Button categories;
    private Button salesGroup;
    private Button vouchersCategory;
    private Button vouchrs;
    private Button marketing;
    private Button coupons;
    private Button customersButton;
    private Button customersSubButton;


    public AdminNavigationPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminNavigationPageObject goToCatalog() {
        catalog = new TextButton(driver, AdminNavigationLocators.CATALOG_BUTTON_LOC).click();
        return new AdminNavigationPageObject(driver);
    }

    public AdminProductsListPageObject goToProducts() {
        products = new TextButton(driver, AdminNavigationLocators.PRODUCTS_PAGE_BUTTON_LOC).click();
        return new AdminProductsListPageObject(driver);
    }

    public AdminCategoriesPageObject goToCategories() {
        categories = new TextButton(driver, AdminNavigationLocators.CATEGORIES_BUTTON_LOC).click();
        return new AdminCategoriesPageObject(driver);
    }

    public AdminGiftVouchersPageObject goToVouchersList() {
        salesGroup = new Button(driver, AdminNavigationLocators.SALIS_GROUP).click();
        vouchersCategory = new Button(driver, AdminNavigationLocators.VOUCHERS_CATEGORY).click();
        vouchrs = new Button(driver, AdminNavigationLocators.VOUCHERS).click();
        return new AdminGiftVouchersPageObject(driver);
    }

    public AdminCouponsPageObject goToCouponsList() {
        marketing = new Button(driver, AdminNavigationLocators.MARKETING_CATEGORY).click();
        coupons = new Button(driver, AdminNavigationLocators.COUPONS).click();
        return new AdminCouponsPageObject(driver);
    }

    public AdminNavigationPageObject goToCustomers() {
        customersButton = new Button(driver, CUSTOMERS_BUTTON_XPATH).click();
        return this;
    }

    public AdminCustomersPageObject clickOnCustomersSubButton() {
        customersSubButton = new Button(driver, CUSTOMERS_SUB_BUTTON_XPATH).click();
        return new AdminCustomersPageObject(driver);
    }
}
