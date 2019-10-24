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

import static org.testng.Assert.*;


import java.util.concurrent.TimeUnit;

public class AddNewProductTest {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminNavigationPageObject nav;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/shop/admin/index.php?route=common/login");
        admin = new AdminLoginPageObject(driver);
        nav = new AdminNavigationPageObject(driver);
        admin.logIn("admin","123456").closeModalWindow();

    }
    @AfterClass
    public void tearDown() {

//        driver.quit();
    }
    @Test
    public void addNewProductTest(){
    String actual = nav.goToCatalog()
                .goToCatalog()
                .goToProducts()
                .goToAddNewProduct()
                .setProductName("PC")
                .setMetaTagTitle("pc")
                .setDescription("Great product!!!")
                .clickData()
                .setProductModel("N-234s")
                .setPrice("199")
                .setQuantity("100")
                .clickLinks()
                .setManufactures("Sony")
                .setCategories("Tablets")
                .clickImage()
                .clickPhoto()
                .editPhoto()
                .selectPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Success: You have modified products!";
        assertTrue(actual.contains(expected));

    }
    @Test
    public void addNewProductNegativeTest(){
        String actual = nav.goToCatalog()
                .goToCatalog()
                .goToProducts()
                .goToAddNewProduct()
                .setProductName("")
                .setMetaTagTitle("pc")
                .setDescription("Great product!!!")
                .clickData()
                .setProductModel("N-234s")
                .setPrice("199")
                .setQuantity("100")
                .clickLinks()
                .setManufactures("Sony")
                .setCategories("Tablets")
                .clickImage()
                .clickPhoto()
                .editPhoto()
                .selectPhoto()
                .saveNewProduct()
                .getTextFromMessage();
        String expected = "Warning: Please check the form carefully for errors!";
        assertTrue(actual.contains(expected));

    }
    @Test
    public void deleteProductTest() throws FindFailed {
       nav.goToCatalog()
                .goToProducts()
                .findAddedProduct()
                .deleteChosenProduct()
                .closeMessage();

    }
}
