package pageobjectstest;

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

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
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

    @Test
    public void deleteProductBySikuliTest(){
        adminProductsList
                .findAddedProduct()
                .deleteChosenProduct()
                .closeMessage();
    }

    @Test
    public void copyProductTest(){
        String actual =  adminProductsList
                .markCheckbox()
                .clickCopyButton()
                .getTextFromMessage();
        assertTrue(actual.contains(SUCCESS_CHANGING_PRODUCT));
    }

    @Test
    public void filterTest(){
      String actual = adminProductsList
                .setFilterName("Apple Cinema 30")
                .setFilterModel("Product 15")
                .setFilterPrice("100")
                .setFilterQuantity("990")
                .chooseEnabledOption()
                .clickFilterSubmit()
              .getTextOfProductsModelLabel();
      assertTrue(actual.contains(MODEL_OF_FILTERED_PRODUCT));
    }
}
