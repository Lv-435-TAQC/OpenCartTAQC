package pageobjectstest;

import entity.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CategoryPageObject;
import pageobjects.MenuPageObject;
import utils.Constants;

public class CompareProductObjectTest {
    WebDriver driver;
    MenuPageObject menuPageObject;
    CategoryPageObject categoryPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", Constants.PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.get(Constants.BASE_URL);
        menuPageObject = new MenuPageObject(driver);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.close();
//    }

    @BeforeMethod
    public void cleanCookie() {
        driver.manage().deleteAllCookies();
        categoryPageObject = menuPageObject.showAllDesktops();
    }

    @Test
    public void addingOneProductToCompareListTest() {
        Product expected = categoryPageObject
                .generateProductsPageObjects()
                .generateProductsList()
                .getProducts()
                .get(1);
        Product actual = categoryPageObject
                .clickCompareThisProductByProduct(expected)
                .getFilterPageObject()
                .clickProductCompare()
                .getProductList()
                .get(0);
        Assert.assertTrue(actual.equals(expected));
    }
}
