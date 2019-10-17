package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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


    @Test
    public void testInputeValidProductName() {
        SearchPageObject searchPageObject = search.inputeProductName();
        searchPageObject.clickSearchButton();
        String actual = search.returnTextFromSearch();
        String expected = ("Search - Mac");
        assertEquals(actual, expected);
    }
    @Test
    public void testInputeFalseData() {
        SearchPageObject searchPageObject = search.inputeFalseProductName();
        searchPageObject.clickSearchButton();
        String actual = search.returnTextFormInvalidSearch();
        String expected = ("Your shopping cart is empty!");
        assertEquals(actual, expected);
    }
    @Test
    public void testUseInSubcategories() {
        search.inputeProductName();
        search.selectCategories();
        search.clickSearchButton();
        String actual = search.returnTextFromFirstSearchElement();
        String expected = ("MacBook");
        assertEquals(actual, expected);
    }
    @Test
    public void testUseSearcWhithDescription() {
        search.inputeProductNameForSearchWhithProductDescription();
        search.searchInDescription();
        search.clickSearchButton();
        String actual = search.returnTextFromFirstSearchElement();
        String expected = ("Canon EOS 5D");
        assertEquals(actual, expected);
    }
    @Test
    public void testSearchWithSubcategoriesButton() {
        search.inputeProductName();
        search.selectCategories();
        search.useInSubcategories();
        search.clickSearchButton();
        String actual = search.returnTextFromFirstSearchElement();
        String expected = ("iMac");
        assertEquals(actual, expected);
    }
}