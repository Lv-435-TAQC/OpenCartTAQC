package javatest.pageobjectstest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static utils.Constants.*;

public class AdminChangingProductsTests {
    WebDriver driver;
    AdminLoginPageObject adminLogin;
    AdminProductsListPageObject adminProductsList;
    AddNewProductPageObject addProduct;
    BasePageObject home;
    AdminPageObject admin;

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
    @BeforeMethod
    public void getHome(){
        adminProductsList = new AdminProductsListPageObject(driver);
        home = new HomePageObject(driver);
        addProduct = new AddNewProductPageObject(driver);
        adminLogin = new AdminLoginPageObject(driver);
        adminLogin.goToUrl(ADMIN_LOGIN_URL);
        adminLogin
                .logIn("admin","123456")
                .closeModalWindow()
                .getNavigation()
                .goToCatalog()
                .goToProducts();

    }

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /**
     * <b>TC-01: End To End Test Adding and Add To Shopping Card Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill General fields;
     * <li>3. Fill Data fields;
     * <li>4. Fill Links fields;
     * <li>5. Set Photo;
     * <li>6. Click Save new Product button ;
     * <li>7. Compare actual and expected messages;
     * <li>8. Go to Home page;
     * <li>9. Click on Tablets button in Menu;
     * <li>10. Add Product in Shopping Card;
     * </ul>
     * <p>
     * Expected Result: Product will be added in Shopping Card.
     */

    @Test
    public void addNewProductAndAddingToShoppingCardEndToEndTest() {
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .fillGeneralFields("Apple iPad Pro", APPLE_DESCRIPTION, "tablet")
                .fillDataFields("iPad Pro", "999", "50")
                .fillLinksFields("Apple", "Tablets")
                .setPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
        home
                .goToHomePage()
                .getMenuPageObject()
                .goToTablets()
                .clickAddToCardByNameOfProduct("Apple iPad Pro");
    }

    /**
     * <b>TC-02: End To End Test Deleting all Products and check Category.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Main checkbox;
     * <li>2. Click delete button;
     * <li>3. Access alert;
     * <li>4. Go To Home Page;
     * <li>5. Click on Tablets in menu;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Message: There are no products to list in this category.
     */

        @Test(priority = 1)
        public void deleteProductAndAddingToShoppingCardNegativeTest() {
        adminProductsList
                       .markCheckbox()
                      .deleteProduct();
              String actual = home
                      .goToHomePage()
                      .getMenuPageObject()
                      .goToTablets()
                      .getMessageAboutProducts();
              assertEquals(actual,MESSAGE_IN_CATEGORY);
    }
    
}