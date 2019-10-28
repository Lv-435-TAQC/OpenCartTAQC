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

import static org.testng.Assert.assertTrue;

public class AdminProductsListTest {

    WebDriver driver;
    AdminLoginPageObject admin;
    AdminProductsListPageObject list;
    AdminNavigationPageObject nav;

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
        admin.logIn("admin","123456").closeModalWindow();
        nav.goToCatalog().goToProducts();

    }
    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void deleteProductTest(){
        list.findAddedProduct()
                .deleteChosenProduct()
                .closeMessage();
    }
    @Test
    public void checkBox(){
      String actual =  list.markCheckbox()
              .clickCopyButton()
              .getTextFromMessage();
      String expected = "Success: You have modified products!";
    assertTrue(actual.contains(expected));
    }
}
