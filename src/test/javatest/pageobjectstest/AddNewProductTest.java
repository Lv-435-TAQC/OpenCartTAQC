package javatest.pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminNavigationPageObject;
import pageobjects.AdminPageObject;

import static org.testng.Assert.*;


import java.util.concurrent.TimeUnit;

public class AddNewProductTest {
    WebDriver driver;
    AdminPageObject admin;
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
        admin = new AdminPageObject(driver);
        nav = new AdminNavigationPageObject(driver);
        driver.findElement(By.xpath("//*[@id=\"input-username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-security\"]/div/div/div[1]/button")));

    }
    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
    @Test
    public void addNewProduct(){
        admin.closeModalWindow();
       String actual =  nav.goToCatalog()
                .goToCatalog()
                .goToProducts()
                .goToAddNewProduct()
                .setProductName("tablet")
                .setMetaTagTitle("tag")
                .setDescription("Great product!!!")
                .clickData()
                .setProductModel("tablet")
                .setPrice("199")
                .setQuantity("100")
                .clickLinks()
                .setManufactures("Xiaomi")
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
}
