package javatest.pageobjectstest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddNewProductPageObject;
import pageobjects.AdminLoginPageObject;
import pageobjects.AdminProductsListPageObject;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class AddNewProductTest {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminProductsListPageObject adminProductsList;
    AddNewProductPageObject addProduct;

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
     * <b>TC-01: Positive Test Adding New Product.</b>
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
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void addNewProductTest() {
        String actual = adminProductsList
                .goToAddNewProduct()
                .fillGeneralFields("Apple iPad Pro", APPLE_DESCRIPTION,"tablet")
                .fillDataFields("iPad Pro", "999", "50")
                .fillLinksFields("Apple", "Tablets")
                .setPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-02: Negative Test Adding New Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill General fields except Product Name;
     * <li>3. Fill Data fields;
     * <li>4. Fill Links fields;
     * <li>5. Set Photo;
     * <li>6. Click Save Product button ;
     * <li>7. Compare actual and expected messages;
     * <li>8. Click back to List button;
     * </ul>
     * <p>
     * "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void addNewProductNegativeTest() {
        String actual = adminProductsList
                .goToAddNewProduct()
                .setDescription(APPLE_DESCRIPTION)
                .setMetaTagTitle("tablet")
                .fillDataFields("iPad Pro", "999", "50")
                .fillLinksFields("Apple", "Tablets")
                .setPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-03: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Name;
     * <li>3. Clear Mega Tag;
     * <li>4. Clear Model;
     * <li>5. Click Save Product button ;
     * <li>6. Compare actual and expected messages;
     * <li>7. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void editWithoutNameAndMegaTagAndModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .clearMetaTagTitle()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-04: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Name;
     * <li>3. Click Save Product button ;
     * <li>4. Compare actual and expected messages;
     * <li>5. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void editWithoutMegaTagAndModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clearMetaTagTitle()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-05: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Name;
     * <li>3. Clear Model;
     * <li>4. Click Save Product button ;
     * <li>5. Compare actual and expected messages;
     * <li>6. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void editWithoutNameAndModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-06: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Name;
     * <li>3. Clear Mega Tag;
     * <li>4. Click Save Product button ;
     * <li>5. Compare actual and expected messages;
     * <li>6. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void editWithoutNameAndMegaTag(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .clearMetaTagTitle()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-07: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Model;
     * <li>3. Click Save Product button ;
     * <li>4. Compare actual and expected messages;
     * <li>5. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void editWithoutModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-08: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Mega Tag;
     * <li>3. Click Save Product button ;
     * <li>4. Compare actual and expected messages;
     * <li>5. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */

    @Test
    public void editWithoutMegaTag(){
        String actual = adminProductsList
                .clickEditButton()
                .clearMetaTagTitle()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-09: Negative Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Clear Name;
     * <li>3. Click Save Product button ;
     * <li>4. Compare actual and expected messages;
     * <li>5. Click back to List button;
     * </ul>
     * <p>
     * Expected Result: "Warning: Please check the form carefully for errors!.
     */
    @Test
    public void editWithoutName(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .saveNewProduct()
                .getTextFromMessage();
        addProduct.goBackToList();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-10: Positive Test Editing Product.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Edit Product Button;
     * <li>2. Click Save Product button ;
     * <li>3. Compare actual and expected messages;
     * </ul>
     * <p>
     * Success: You have modified products.
     */

    @Test
     public void editProduct(){
        String actual = adminProductsList
                .clickEditButton()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(SUCCESS_CHANGING_PRODUCT));
     }
}
