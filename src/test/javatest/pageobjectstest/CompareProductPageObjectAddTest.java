package pageobjectstest;

import entity.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AbstractCategoryPageObject;
import pageobjects.SubCategoryPageObject;
import pageobjects.MenuPageObject;
import utils.Constants;
import utils.ProductEntityData;

import java.util.ArrayList;

public class CompareProductPageObjectAddTest {
    WebDriver driver;
    MenuPageObject menuPageObject;
    AbstractCategoryPageObject categoryPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", Constants.PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.get(Constants.BASE_URL);
        menuPageObject = new MenuPageObject(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @BeforeMethod
    public void cleanCookie() {
        driver.manage().deleteAllCookies();
        categoryPageObject = menuPageObject.showAllDesktops();
    }

    /**
     * <b>TC-01: Test adding one product to compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Find product Canon EOS 5D;
     * <li>4. Click compare this product button ;
     * <li>5. Click on linked label product compare;
     * <li>6. Find product;
     * <li>7. Comparing expected with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct actual product;
     */
    @Test
    public void addingOneProductToCompareListTest() {
        Product expected = ProductEntityData.canonEOS5D;
        Product actual = categoryPageObject
                .generateProductsPageObjects()
                .clickCompareThisProductByProduct(expected)
                .getFilterPageObject()
                .clickProductCompare()
                .getProductList()
                .get(0);
        Assert.assertTrue(actual.equals(expected));
    }

    /**
     * <b>TC-02: Test adding two product to compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Find product Canon EOS 5D;
     * <li>4. Click compare this product button ;
     * <li>5. Find product iPhone;
     * <li>6. Click compare this product button ;
     * <li>7. Click on linked label product compare;
     * <li>8. Find products;
     * <li>9. Comparing expected Products with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct actual products;
     */
    @Test
    public void addingTwoProductToCompareListTest() {
        ArrayList<Product> expected = ProductEntityData.twoProducts;
        ArrayList<Product> actual = categoryPageObject
                .generateProductsPageObjects()
                .clickCompareThisProductByProduct(expected.get(0))
                .clickCompareThisProductByProduct(expected.get(1))
                .getFilterPageObject()
                .clickProductCompare()
                .getProductList();
        expected.sort(Product::compareTo);
        actual.sort(Product::compareTo);
        Assert.assertTrue(actual.equals(expected));
    }

    /**
     * <b>TC-03: Test adding three product to compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Find product Canon EOS 5D;
     * <li>4. Click compare this product button ;
     * <li>5. Find product iPhone;
     * <li>6. Click compare this product button ;
     * <li>7. Find product HP LP3065;
     * <li>8. Click compare this product button ;
     * <li>9. Click on linked label product compare;
     * <li>10. Find products;
     * <li>11. Comparing expected Products with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct actual products;
     */
    @Test
    public void addingThreeProductToCompareListTest() {
        ArrayList<Product> expected = ProductEntityData.threeProducts;
        ArrayList<Product> actual = categoryPageObject
                .generateProductsPageObjects()
                .clickCompareThisProductByProduct(expected.get(0))
                .clickCompareThisProductByProduct(expected.get(1))
                .clickCompareThisProductByProduct(expected.get(2))
                .getFilterPageObject()
                .clickProductCompare()
                .getProductList();
        expected.sort(Product::compareTo);
        actual.sort(Product::compareTo);
        Assert.assertTrue(actual.equals(expected));
    }

    /**
     * <b>TC-04: Test adding four product to compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Find product Canon EOS 5D;
     * <li>4. Click compare this product button ;
     * <li>5. Find product iPhone;
     * <li>6. Click compare this product button ;
     * <li>7. Find product HP LP3065;
     * <li>8. Click compare this product button ;
     * <li>9. Find product HTC Touch HD;
     * <li>10. Click compare this product button ;
     * <li>11. Click on linked label product compare;
     * <li>12. Find products;
     * <li>13. Comparing expected Products with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct actual products;
     */
    @Test
    public void addingFourProductToCompareListTest() {
        ArrayList<Product> expected = ProductEntityData.fourProducts;
        ArrayList<Product> actual = categoryPageObject
                .generateProductsPageObjects()
                .clickCompareThisProductByProduct(expected.get(0))
                .clickCompareThisProductByProduct(expected.get(1))
                .clickCompareThisProductByProduct(expected.get(2))
                .clickCompareThisProductByProduct(expected.get(3))
                .getFilterPageObject()
                .clickProductCompare()
                .getProductList();
        expected.sort(Product::compareTo);
        actual.sort(Product::compareTo);
        Assert.assertTrue(actual.equals(expected));
    }

}
