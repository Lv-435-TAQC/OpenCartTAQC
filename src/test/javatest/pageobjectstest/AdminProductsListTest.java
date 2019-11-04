package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminLoginPageObject;
import pageobjects.AdminProductsListPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class AdminProductsListTest {

    WebDriver driver;
    AdminLoginPageObject admin;
    AdminProductsListPageObject adminProductsList;

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Login page on OpenCart.com;
     * <li>3. Click on Login button;
     * <li>4. Click Category button;
     * <li>5. Choose Product option;
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        admin = new AdminLoginPageObject(driver);
        admin.goToUrl(ADMIN_LOGIN_URL);
        adminProductsList = new AdminProductsListPageObject(driver);
        admin
                .logIn("admin","123456")
                .closeModalWindow()
                .getNavigation()
                .goToCatalog()
                .goToProducts();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /**
     * <b>TC-01: Positive Test Copy Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Mark Products Checkbox;
     * <li>2. Click Copy Product Button;
     * <li>3. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test(priority = 1)
    public void copyProductTest(){
        String actual =  adminProductsList
                .markCheckbox()
                .clickCopyButton()
                .getTextFromMessage();
        assertTrue(actual.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-02: Positive Test Copy Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Set Name in Filter;
     * <li>2. Set Model in Filter;
     * <li>3. Set Price in Filter;
     * <li>4. Set Quantity in Filter;
     * <li>5. Click Filter button;
     * <li>6. Compare actual and expected Products model;
     * </ul>
     * <p>
     * Expected Result: Apple Cinema 30.
     */

    @Test(priority = 2)
    public void filterTest(){
      String actual = adminProductsList
                .setFilterName("Apple Cinema 30")
                .setFilterModel("Product 15")
                .setFilterPrice("100")
                .setFilterQuantity("990")
                .chooseDisabledOption()
                .clickFilterSubmit()
              .getTextOfProductsModelLabel();
      assertTrue(actual.contains(MODEL_OF_FILTERED_PRODUCT));
    }

    /**
     * <b>TC-03: Positive Test Copy Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Mark Products checkbox;
     * <li>2. Click Delete button;
     * <li>3. Click Yes button;
     * <li>4. Set Quantity in Filter;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void deleteProductBySikuliTest(){
        adminProductsList
                .findAddedProduct()
                .deleteChosenProduct()
                .closeMessage();
    }

    @Test
    public void editProduct(){
        String actual = adminProductsList
                .clickEditButton()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(SUCCESS_CHANGING_PRODUCT));
    }
}
