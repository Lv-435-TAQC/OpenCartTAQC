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
        String actual =navigation.goToCatalog()
                .goToCategories()
                .addNewCategories()
                .inputCategoriesName("forTest")
                .inputMetaTagOfCategories("just test")
                .inputMetaTagDescriptionOfCategories("Name")
                .inputMetaTagKeywordsOfCategories("Test")
                .saveNewCategories().getTextFromMessageOfCategories();
        String expected = ("Success: You have modified categories!");
        assertTrue(actual.contains(expected));
    }

        @Test
    public void testAddNewCategoriesWithFalseData() {
            String actual= navigation
                    .goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("")
                    .inputMetaTagOfCategories("")
                    .inputMetaTagDescriptionOfCategories("")
                    .inputMetaTagKeywordsOfCategories("")
                    .saveNewCategories()
                    .getTextFromMessageInNewCategories();
            String expected = ("Warning: Please check the form carefully for errors!");
            assertTrue(actual.contains(expected));
    }
    @Test
    public  void testDeleteCategories(){
        navigation.goToCategories()
                .changeSomethingInCategories();
    }
}