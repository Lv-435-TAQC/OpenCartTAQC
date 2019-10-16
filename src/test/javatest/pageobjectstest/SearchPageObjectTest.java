package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
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
        driver.close();
    }


    @Test
    public void testClickSearchButton() {

    }

    @Test
    public void testInputeProductName() {

        SearchPageObject searchPageObject = search.inputeProductName();

        searchPageObject.clickSearchButton();
        String actual = search.returnText();
        String expected = ("Search - Mac");
        assertEquals(actual, expected);

    }

    @Test
    public void testInputeFalseData() {
        SearchPageObject searchPageObject = search.inputeFalseProductName();
        searchPageObject.clickSearchButton();
        String actual = search.returnFalseText();
        String expected = ("Your shopping cart is empty!");
        assertEquals(actual, expected);
    }

    @Test
    public void testUseInSubcategories() {
    }
}