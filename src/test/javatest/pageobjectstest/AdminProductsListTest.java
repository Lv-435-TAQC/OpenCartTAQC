package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminLoginPageObject;
import pageobjects.AdminNavigationPageObject;
import pageobjects.AdminProductsListPageObject;
import pageobjects.NavigationPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AdminProductsListTest {

    WebDriver driver;
    AdminLoginPageObject admin;
    AdminProductsListPageObject list;

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
        admin = new AdminLoginPageObject(driver);
        list = new AdminProductsListPageObject(driver);
        admin.logIn("admin","123456").closeModalWindow().getNavigation().goToCatalog().goToProducts();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void deleteProductBySikuliTest(){
        list.findAddedProduct()
                .deleteChosenProduct()
                .closeMessage();
    }
    @Test
    public void deleteProductTest(){
      String actual =  list.markCheckbox()
              .clickCopyButton()
              .getTextFromMessage();
      String expected = "Success: You have modified products!";
      assertTrue(actual.contains(expected));
    }

    @Test
    public void filterTest(){
      String actual = list
                .setFilterName("Apple Cinema 30")
                .setFilterModel("Product 15")
                .setFilterPrice("100")
                .setFilterQuantity("990")
                .chooseEnabledOption()
                .clickFilterSubmit()
              .getTextOfProductsModelLabel();
      String expected = "Apple Cinema 30";
      assertTrue(actual.contains(expected));

    }
}
