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

public class AddNewProductTest {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminProductsListPageObject adminProductsList;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        adminProductsList = new AdminProductsListPageObject(driver);
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
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }


    @Test
     public void editProduct(){
        String actual = adminProductsList
                .clickEditButton()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(SUCCESS_CHANGING_PRODUCT));
     }

    @Test
     public void editWithoutName(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
     }

    @Test
    public void editWithoutMegaTag(){
        String actual = adminProductsList
                .clickEditButton()
                .clearMetaTagTitle()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    @Test
    public void editWithoutModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    @Test
    public void editWithoutNameAndMegaTag(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .clearMetaTagTitle()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    @Test
    public void editWithoutNameAndModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

    @Test
    public void editWithoutMegaTagAndModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clearMetaTagTitle()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }

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
        assertTrue(actual.contains(UNSUCCESSFUL_CHANGING_PRODUCT));
    }
}
