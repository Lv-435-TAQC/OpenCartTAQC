package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SearchPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static utils.Constants.*;

public class SearchPageObjectTest {
    WebDriver driver;
    SearchPageObject search;

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SEARCH_URL);
        search = new SearchPageObject(driver);
    }

    @AfterClass
    public void closeUp() {
       driver.quit();
    }

    /**
     * <b> Search With Valid Name.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open  Page on OpenCart.com;
     * <li>3. Go to Search;
     * <li>4. Input Product Name;
     * <li>5. Click Search Button;
     * <li>6. Get Text from Message;
     * <li>7. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Search - Mac";
     */

    @Test
    public void inputValidProductName() {
        String actual = search
                .inputProductName()
                .clickSearchButton()
                .returnTextFromSearch();
        String expectedMessage = ("Search - Mac");
        assertEquals(actual, expectedMessage);
    }
    /**
     * <b> Search With Invalid Data.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open  Page on OpenCart.com;
     * <li>3. Go to Search;
     * <li>4. Input False in Product Name;
     * <li>5. Click Search Button;
     * <li>6. Get Text from Message;
     * <li>7. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Your shopping cart is empty!";
     */

    @Test
    public void inputFalseData() {
        String actual = search
                .inputFalseProductName()
                .clickSearchButton()
                .returnTextFormInvalidSearch();
        String expectedMessage = ("Your shopping cart is empty!");
        assertEquals(actual, expectedMessage);
    }
    /**
     * <b> Search Product With SubCategory Button.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open  Page on OpenCart.com;
     * <li>3. Go to Search;
     * <li>4. Input Data in Product Name;
     * <li>5. Select Category;
     * <li>6. Click Search Button;
     * <li>7. Get Text from First Element of Search;
     * <li>8. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "MacBook";
     */

    @Test
    public void useInSubcategories() {
        String actual = search
                .inputProductName()
                .selectCategories()
                .clickSearchButton()
                .returnTextFromFirstSearchElement();
        String expectedFirstProduct = ("MacBook");
        assertEquals(actual, expectedFirstProduct);
    }

    /**
     * <b> Search Product With Description .</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open  Page on OpenCart.com;
     * <li>3. Go to Search;
     * <li>4. Input Data in Product Name;
     * <li>5. Click Description Button;
     * <li>6. Click Search Button;
     * <li>7. Get Text from First Element of Search;
     * <li>8. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Canon EOS 5D";
     */

    @Test
    public void useSearchWithDescription() {
        String actual = search
                .inputProductNameForSearchWithProductDescription()
                .searchInDescription()
                .clickSearchButton()
                .returnTextFromFirstSearchElement();
        String expectedFirstProduct = ("Canon EOS 5D");
        assertEquals(actual, expectedFirstProduct);
    }
    /**
     * <b> Search Product Whit SubCategory Button.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open  Page on OpenCart.com;
     * <li>3. Go to Search;
     * <li>4. Input Data in Product Name;
     * <li>5. Click Search With Subcategory  Button;
     * <li>6. Click Search Button;
     * <li>7. Get Text from First Element of Search;
     * <li>8. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "iMac";
     */

    @Test
    public void searchWithSubcategoriesButton() {
        String actual = search
                .inputProductName()
                .selectCategories()
                .useInSubcategories()
                .clickSearchButton()
                .returnTextFromFirstSearchElement();
        String expectedFirstProduct = ("iMac");
        assertEquals(actual, expectedFirstProduct);
    }
    /**
     * <b> Search Category On User Page.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open  Page on OpenCart.com;
     * <li>3. Go to Search;
     * <li>4. Get Text from First Element of Search;
     * <li>5. Compare Expected with Text Categories;
     * </ul>
     * <p>
     *  Expected Result: "forTest";
     */

    @Test
    public void findCategoriesInSearch() {
        Assert.assertTrue(search.returnTextFromFifthElementOfCategories().contentEquals("forTestdsada"));
    }
}