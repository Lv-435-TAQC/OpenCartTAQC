package javatest.pageobjectstest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminNewCategoriesPageObject;
import pageobjects.AdminCategoriesPageObject;

import pageobjects.*;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static utils.Constants.ADMIN_LOGIN2_URL;
import static utils.Constants.ADMIN_LOGIN_URL;

public class AdminCategoriesPageObjectTests {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminNavigationPageObject navigation;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        @BeforeMethod
        public void getHome() {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            admin = new AdminLoginPageObject(driver);
            admin.goToUrl(ADMIN_LOGIN2_URL);
            admin.logIn("admin", "admin").closeModalWindow();
            navigation = new AdminNavigationPageObject(driver);
        }

        @AfterClass
        public void closeUp() {
            driver.quit();
        }

        @Test
        public void testAddNewCategoriesToList(){
            String actual = navigation.goToCatalog()
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
        public void testAddNewCategoriesWithAllFalseData(){
            String actual = navigation
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
        public void testAddNewCategoriesWithFalseName() {
            String actual = navigation
                    .goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("")
                    .inputMetaTagOfCategories("fsf")
                    .inputMetaTagDescriptionOfCategories("")
                    .inputMetaTagKeywordsOfCategories("")
                    .saveNewCategories()
                    .getTextFromMessageInNewCategories();
            String expected = ("Warning: Please check the form carefully for errors!");
            assertTrue(actual.contains(expected));
        }

        @Test
        public void testAddNewCategoriesWithFalseTag() {
            String actual = navigation
                    .goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("gfasf")
                    .inputMetaTagOfCategories("")
                    .inputMetaTagDescriptionOfCategories("")
                    .inputMetaTagKeywordsOfCategories("")
                    .saveNewCategories()
                    .getTextFromMessageInNewCategories();
            String expected = ("Warning: Please check the form carefully for errors!");
            assertTrue(actual.contains(expected));
        }
    }
