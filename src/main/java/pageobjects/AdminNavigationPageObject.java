package pageobjects;

import locators.AdminNavigationLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.TextButton;

public class AdminNavigationPageObject extends BasePageObject {

    private Button products;
    private Button catalog;
    private Button categories;
    private Button salesGroup;
    private Button vouchersCategory;
    private Button vouchrs;
    private Button marketing;
    private Button coupons;


    public AdminNavigationPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminNavigationPageObject goToCatalog() {
        catalog = new TextButton(driver, AdminNavigationLocators.CATALOG_BUTTON_LOC).click();
        return this;
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
        marketing= new Button(driver, AdminNavigationLocators.MARKETING_CATEGORY).click();
        coupons = new Button(driver, AdminNavigationLocators.COUPONS).click();
        return new AdminCouponsPageObject(driver);
    }


}
