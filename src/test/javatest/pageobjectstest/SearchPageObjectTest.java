package pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SearchPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SearchPageObjectTest {
    WebDriver driver;
    SearchPageObject search;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.186.129/opencart/index.php?route=product/search");
        search = new SearchPageObject(driver);
    }

    @AfterClass
    public void closeUp() {
       driver.quit();
    }

    /**
     * <b> Description of Precondition.</b>
     *
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
    public void testInputValidProductName() {
        String actual = search
                .inputProductName()
                .clickSearchButton()
                .returnTextFromSearch();
        String expected = ("Search - Mac");
        assertEquals(actual, expected);
    }
    /**
     * <b> Description of Precondition.</b>
     *
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
    public void testInputFalseData() {
        String actual = search
                .inputFalseProductName()
                .clickSearchButton()
                .returnTextFormInvalidSearch();
        String expected = ("Your shopping cart is empty!");
        assertEquals(actual, expected);
    }
    /**
     * <b> Description of Precondition.</b>
     *
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
    public void testUseInSubcategories() {
        String actual = search
                .inputProductName()
                .selectCategories()
                .clickSearchButton()
                .returnTextFromFirstSearchElement();
        String expected = ("MacBook");
        assertEquals(actual, expected);
    }

    /**
     * <b> Description of Precondition.</b>
     *
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
    public void testUseSearchWithDescription() {
        String actual = search
                .inputProductNameForSearchWithProductDescription()
                .searchInDescription()
                .clickSearchButton()
                .returnTextFromFirstSearchElement();
        String expected = ("Canon EOS 5D");
        assertEquals(actual, expected);
    }
    /**
     * <b> Description of Precondition.</b>
     *
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
    public void testSearchWithSubcategoriesButton() {
        String actual = search
                .inputProductName()
                .selectCategories()
                .useInSubcategories()
                .clickSearchButton()
                .returnTextFromFirstSearchElement();
        String expected = ("iMac");
        assertEquals(actual, expected);
    }
    /**
     * <b> Description of Precondition.</b>
     *
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
    public void testFindCategoriesInSearch() {
        Assert.assertTrue(search.returnTextFromFifthElementOfCategories().contentEquals("forTest"));
    }
}