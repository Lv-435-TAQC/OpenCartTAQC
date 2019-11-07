package pageobjectstest;

import entity.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.CompareProductPageObject;
import pageobjects.MenuPageObject;
import utils.Constants;
import utils.ProductEntityData;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CompareProductPageObjectRemoveTest {
    WebDriver driver;
    MenuPageObject menuPageObject;
    CompareProductPageObject compareProductPageObject;

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

    @AfterMethod
    public void cleanCookie() {
        driver.manage().deleteAllCookies();

    }

    @BeforeMethod
    public void addProductsToCompare() {
        compareProductPageObject = menuPageObject.showAllDesktops()
                .generateProductsPageObjects()
                .generateProductsList()
                .clickCompareThisProductByProduct(ProductEntityData.canonEOS5D)
                .clickCompareThisProductByProduct(ProductEntityData.iPhone)
                .clickCompareThisProductByProduct(ProductEntityData.HPLP3065)
                .clickCompareThisProductByProduct(ProductEntityData.macBook)
                .getFilterPageObject()
                .clickProductCompare();
    }

    @DataProvider(name = "positionOfProduct")
    public Object[][] createDataForRemovingOneProduct(Method m) {
        return new Object[][]{
                new Object[]{0}
                , new Object[]{1}
                , new Object[]{2}
                , new Object[]{3}
        };
    }

    /**
     * <b>TC-01: Test removing one product from compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Add data to compare list;
     * <li>4. Find product;
     * <li>5. Click remove button under this product;
     * <li>6. Comparing expected number of products with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct number of actual product;
     */
    @Test(dataProvider = "positionOfProduct")
    public void removeOneProductFromComparePageTest(Integer position) {
        ArrayList<Product> product = compareProductPageObject.getProductList();
        Integer expected = 3;
        Integer actual = compareProductPageObject
                .clickRemoveButton(product.get(position))
                .getProductList()
                .size();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "positionOfTwoProducts")
    public Object[][] createDataForRemovingTwoProducts(Method m) {
        return new Object[][]{
                new Object[]{0, 1}
                , new Object[]{0, 2}
                , new Object[]{0, 3}
                , new Object[]{1, 2}
                , new Object[]{1, 3}
                , new Object[]{2, 3}
        };
    }

    /**
     * <b>TC-02: Test removing two products from compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Add data to compare list;
     * <li>4. Find product;
     * <li>5. Click remove button under this product;
     * <li>6. Find second product;
     * <li>7. Click remove button under this product;
     * <li>8. Comparing expected number of products with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct number of actual product;
     */
    @Test(dataProvider = "positionOfTwoProducts")
    public void removeTwoProductsFromComparePageTest(Integer firstPosition, Integer secondPosition) {
        ArrayList<Product> product = compareProductPageObject.getProductList();
        Integer expected = 2;
        Integer actual = compareProductPageObject
                .clickRemoveButton(product.get(firstPosition))
                .clickRemoveButton(product.get(secondPosition))
                .getProductList()
                .size();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "positionOfThreeProducts")
    public Object[][] createDataForRemovingThreeProducts(Method m) {
        return new Object[][]{
                new Object[]{0, 1, 2}
                , new Object[]{0, 2, 3}
                , new Object[]{0, 1, 3}
                , new Object[]{1, 2, 3}
        };
    }

    /**
     * <b>TC-03: Test removing three products from compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Add data to compare list;
     * <li>4. Find product;
     * <li>5. Click remove button under this product;
     * <li>6. Find second product;
     * <li>7. Click remove button under this product;
     * <li>8. Find third product;
     * <li>9. Click remove button under this product;
     * <li>10. Comparing expected number of products with actual;
     * </ul>
     * <p>
     * Expected Result: User can see correct number of actual product;
     */
    @Test(dataProvider = "positionOfThreeProducts")
    public void removeThreeProductsFromComparePageTest(Integer firstPosition, Integer secondPosition, Integer thirdPosition) {
        ArrayList<Product> product = compareProductPageObject.getProductList();
        Integer expected = 1;
        Integer actual = compareProductPageObject
                .clickRemoveButton(product.get(firstPosition))
                .clickRemoveButton(product.get(secondPosition))
                .clickRemoveButton(product.get(thirdPosition))
                .getProductList()
                .size();
        Assert.assertEquals(actual, expected);
    }

    /**
     * <b>TC-04: Test removing three products from compare list.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Add data to compare list;
     * <li>4. Find product;
     * <li>5. Click remove button under this product;
     * <li>6. Find second product;
     * <li>7. Click remove button under this product;
     * <li>8. Find third product;
     * <li>9. Click remove button under this product;
     * <li>10. Find last product;
     * <li>11. Click remove button under this product;
     * <li>11. Checking expected empty page;
     * </ul>
     * <p>
     * Expected Result: User can see page without products;
     */
    @Test
    public void removeAllProductsFromComparePageTest() {
        ArrayList<Product> product = compareProductPageObject.getProductList();
        String expected = "Your shopping cart is empty";
        String actual = compareProductPageObject
                .clickRemoveButton(product.get(0))
                .clickRemoveButton(product.get(1))
                .clickRemoveButton(product.get(2))
                .clickRemoveButton(product.get(3))
                .getTextAboutEmptyPage();
        Assert.assertTrue(actual.contains(expected));
    }

}
