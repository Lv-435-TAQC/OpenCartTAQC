package javatest.pageobjectstest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminLoginPageObject;
import pageobjects.AdminNavigationPageObject;
import pageobjects.AdminProductsListPageObject;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

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
        driver.get("http://localhost/shop/admin/index.php?route=common/login");
        adminProductsList = new AdminProductsListPageObject(driver);
        admin = new AdminLoginPageObject(driver);
        admin
                .logIn("admin","123456")
                .closeModalWindow().getNavigation()
                .goToCatalog()
                .goToProducts();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void addNewProductTest(){
   String actual = adminProductsList
                .goToAddNewProduct()
                .setProductName("Apple iPad Pro")
                .setMetaTagTitle("tablet")
                .setDescription("Apple iPad Pro 12.9 64Gb Wi-Fi+4G (Space Gray) 2018")
                .clickData()
                .setProductModel("iPad Pro")
                .setPrice("999")
                .setQuantity("50")
                .clickLinks()
                .setManufactures("Apple")
                .setCategories("Tablets")
                .clickImage()
                .setPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Success: You have modified products!";
        assertTrue(actual.contains(expected));

    }

    @Test(priority = 2)
    public void addNewProductNegativeTest(){
        String actual = adminProductsList
                .goToAddNewProduct()
                .setProductName("")
                .setMetaTagTitle("Xiaomi")
                .setDescription("Great product!!!")
                .clickData()
                .setProductModel("N-234s")
                .setPrice("199")
                .setQuantity("100")
                .clickLinks()
                .setManufactures("Sony")
                .setCategories("Tablets")
                .clickImage()
                .setPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
    }

    @Test
     public void editProduct(){
        String actual = adminProductsList
                .clickEditButton()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Success: You have modified products!";
        assertTrue(actual.contains(expected));
     }

    @Test
     public void editWithoutName(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
     }

    @Test
    public void editWithoutMegaTag(){
        String actual = adminProductsList
                .clickEditButton()
                .clearMetaTagTitle()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void editWithoutModel(){
        String actual = adminProductsList
                .clickEditButton()
                .clickData()
                .clearProductModel()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void editWithoutNameAndMegaTag(){
        String actual = adminProductsList
                .clickEditButton()
                .clearProductName()
                .clearMetaTagTitle()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
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
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
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
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
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
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));
    }
}
