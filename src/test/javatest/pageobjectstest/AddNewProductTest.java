package javatest.pageobjectstest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class AddNewProductTest {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminProductsListPageObject adminProductsList;
    AddNewProductPageObject addProduct;
    BasePageObject home;

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
        adminProductsList = new AdminProductsListPageObject(driver);
        home = new HomePageObject(driver);
        addProduct = new AddNewProductPageObject(driver);
        admin = new AdminLoginPageObject(driver);
        admin.goToUrl(ADMIN_LOGIN_URL);
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
     * <b>TC-01: Positive Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */
    @Test
    public void checkRequiredFieldsWithCorrectDataTest(){
         String actualMessage = adminProductsList
                 .goToAddNewProduct()
                 .setProductName("test123324")
                 .setMetaTagTitle("test12321")
                 .clickData()
                 .setProductModel("test")
                 .clickLinks()
                 .saveNewProduct()
                 .getTextFromMessage();
         assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-02: Positive Test For Required Fields with Numbers.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void checkRequiredFieldWithNumbersDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("23413245643")
                .setMetaTagTitle("1232435436")
                .clickData()
                .setProductModel("1243245346")
                .clickLinks()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-03: Positive Test For Required Fields With Symbols.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void checkRequiredFieldWithSymbolsDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("+_++_+^#$%^")
                .setMetaTagTitle("+_)(*&^%")
                .clickData()
                .setProductModel("_)(*&^%$#@")
                .clickLinks()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-04: Positive Test For Required Fields with spaces.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void checkRequiredFieldWithSpaceDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("   ")
                .setMetaTagTitle("    ")
                .clickData()
                .setProductModel("    ")
                .clickLinks()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-05: Negative Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Click on Product Name field;
     * <li>3. Click Save Product button;
     * <li>4. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:"Product Name must be greater than 1 and less than 255 characters".
     */

    @Test(priority = 1)
    public void checkProductNameWithoutDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("")
                .saveNewProductWithMistake()
                .getMessageFromField();
        addProduct.goBackToList();
        assertTrue(actualMessage.contains(NEGATIVE_MESSAGE_FOR_FIELD));
    }

    /**
     * <b>TC-06: Positive Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Click on Mega Tag field;
     * <li>3. Click Save Product button;
     * <li>4. Compare actual and expected messages;
     * </ul>
     * <p>
     * "Warning: "Product Name must be greater than 1 and less than 255 characters".
     */

    @Test(priority = 1)
    public void checkMegaTagFieldWithoutDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setMetaTagTitle("")
                .saveNewProductWithMistake()
                .getMessageFromField();
        addProduct.goBackToList();
        assertTrue(actualMessage.contains(NEGATIVE_MESSAGE_FOR_FIELD));
    }

    /**
     * <b>TC-7: Negative Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Click on Product Model field;
     * <li>3. Click Save Product button;
     * <li>4. Compare actual and expected messages;
     * </ul>
     * <p>
     * "Warning: "Product Name must be greater than 1 and less than 255 characters".
     */

    @Test(priority = 1)
    public void checkProductModelWithoutDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .clickData()
                .setProductModel("")
                .saveNewProductWithMistake()
                .getMessageFromField();
        addProduct.goBackToList();
        assertTrue(actualMessage.contains(NEGATIVE_MESSAGE_FOR_FIELD));
    }

}