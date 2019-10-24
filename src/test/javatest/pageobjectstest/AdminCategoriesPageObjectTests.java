package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AdminCategoriesPageObjectTests {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminCategoriesPageObject search;
    AdminNavigationPageObject navigation;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.186.129/opencart/admin/index.php?route=common/dashboard&user_token=ZMuBLJtL0IzVqWvTS8J1UUvWCEwiVh2s");
        search = new AdminCategoriesPageObject(driver);
        admin = new AdminLoginPageObject(driver);
        navigation = new AdminNavigationPageObject(driver);
        admin.logIn("admin", "admin").closeModalWindow();


    }

        @AfterClass
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void testAddNewCategoriesToList() {

        navigation.goToCatalog()
                .goToCategories()
                .addNewCategories()
                .inputCategoriesName()
                .inputMetaTagOfCategories()
                .inputMetaTagDescriptionOfCategories()
                .inputMetaTagKeywordsOfCategories()
                .saveNewCategories();
        String actual = search.getTextFromMessageOfCategories();
        String expected = ("Success: You have modified categories!\n" + "×");
        assertEquals(actual, expected);

    }

        @Test
    public void testDeleteCategoriesFromCategoriesList() {
    }
}