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
import static utils.Constants.*;

public class AdminCategoriesPageObjectTests {
    WebDriver driver;
    AdminLoginPageObject admin;
    AdminNavigationPageObject navigation;

        @BeforeClass
        public void setUp() {
            System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
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

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Page on OpenCart.com;
     * <li>3. Login in Admin;
     * <li>4. Go to Categories;
     * <li>5. Click add Categories;
     * <li>6. Input Categories Name;
     * <li>7. Input Categories Tag;
     * <li>8  Input Categories MetaTag;
     * <li>9. Click Save Category;
     * <li>10. Get Text from Message;
     * <li>11. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Success: You have modified categories!";
     */

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
    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Page on OpenCart.com;
     * <li>3. Login in Admin;
     * <li>4. Go to Categories;
     * <li>5. Click add Categories;
     * <li>6. Input Categories Name;
     * <li>7. Input  Categories MetaTag;
     * <li>8. Click Save Category;
     * <li>9. Get Text from Message;
     * <li>10. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */

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
    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Page on OpenCart.com;
     * <li>3. Login in Admin;
     * <li>4. Go to Categories;
     * <li>5. Click add Categories;
     * <li>6. Input Categories Name;
     * <li>7. Input  Categories MetaTag;
     * <li>8. Click Save Category;
     * <li>9. Get Text from Message;
     * <li>10. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */

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
    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Page on OpenCart.com;
     * <li>3. Login in Admin;
     * <li>4. Go to Categories;
     * <li>5. Click add Categories;
     * <li>6. Input Categories Name;
     * <li>7. Click Save Category;
     * <li>8. Get Text from Message;
     * <li>9. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */

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
