package pageobjectstest;

import entity.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    public void cleanCookie(){
        driver.manage().deleteAllCookies();
    }

    @Test
    public void addingOneProductToCompareListTest(){
        categoryPageObject = menuPageObject.showAllDesktops();
        Product expected = categoryPageObject
                .generateProductsList()
                .getProducts()
                .get(1);
        System.out.println(expected);
        Product actual = categoryPageObject
                .clickCompareThisProductByProduct(expected)
                .getFilterPageObject()
                .clickProductCompare()
                .getProductList()
                .get(0);
        System.out.println(actual);
        Assert.assertTrue(actual.equals(expected));
    }
}
