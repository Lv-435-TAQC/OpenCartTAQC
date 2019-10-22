package javatest.pageobjectstest;

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

    @Test
    public void testInputValidProductName() {
        String actual = search
                .inputProductName()
                .clickSearchButton()
                .returnTextFromSearch();
        String expected = ("Search - Mac");
        assertEquals(actual, expected);
    }
    @Test
    public void testInputFalseData() {
        String actual = search
                .inputFalseProductName()
                .clickSearchButton()
                .returnTextFormInvalidSearch();
        String expected = ("Your shopping cart is empty!");
        assertEquals(actual, expected);
    }
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
    @Test(priority = 1)
    public void testSikuli() throws FindFailed {
        Screen screen = new Screen();
        String categoriesSelect = "D:\\sikuliScreenshot\\categories.PNG";
        String laptopsAndNote = "D:\\sikuliScreenshot\\Mac.PNG";
        screen.click(categoriesSelect);
        screen.click(laptopsAndNote);
        search.returnTextFromFifthElementOfCategories();
        Assert.assertTrue(search.returnTextFromFifthElementOfCategories().contentEquals("Laptops & Notebooks"));
    }
}