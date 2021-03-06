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
import static utils.Constants.*;

public class AdminCategoriesPageObjectTests {
    WebDriver driver;
    AdminLoginPageObject AdminLoginPageObject;
    AdminNavigationPageObject AdminNavigationPageObject;
    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Admin Login page on OpenCart.com;
     * <li>3. Click on Login button;
     * </ul>
     * <p>
     */
        @BeforeClass
        public void setUp() {
            System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
            driver = new FirefoxDriver();
        }

        @BeforeMethod
        public void getHome() {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AdminLoginPageObject = new AdminLoginPageObject(driver);
            AdminLoginPageObject.goToUrl(ADMIN_LOGIN2_URL);
            AdminLoginPageObject.logIn("admin", "admin").closeModalWindow();
            AdminNavigationPageObject = new AdminNavigationPageObject(driver);
        }

        @AfterClass
        public void closeUp() {
            driver.quit();
        }

    /**
     * <b> Positive Test Add Category.</b>
     *
     * scenario:
     * <ul>
     * <li>1. Login in Admin;
     * <li>2. Go to Categories;
     * <li>3. Click add Categories;
     * <li>4. Input Categories Name;
     * <li>5. Input Categories Tag;
     * <li>6  Input Categories MetaTag;
     * <li>7. Click Save Category;
     * <li>8. Get Text from Message;
     * <li>9. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Success: You have modified categories!";
     */

        @Test
        public void addNewCategoriesToList(){
            String actualMessage = AdminNavigationPageObject.goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("forTest")
                    .inputMetaTagOfCategories("just test")
                    .inputMetaTagDescriptionOfCategories("Name")
                    .inputMetaTagKeywordsOfCategories("Test")
                    .saveNewCategories().getTextFromMessageOfCategories();
            assertTrue(actualMessage.contains(ADMIN_CATEGORIES_SUCCESSFUL_MESSAGE));
        }
    /**
     * <b> Negative Test Add Category With All False Test Data.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Login in Admin;
     * <li>2. Go to Categories;
     * <li>3. Click add Categories;
     * <li>4. Leave Categories Name Field Blank ;
     * <li>5. Leave  Categories MetaTag Field Blank;
     * <li>6. Click Save Category;
     * <li>7. Get Text from Message;
     * <li>8. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */

        @Test
        public void addNewCategoriesWithAllFalseData(){
            String actualMessage = AdminNavigationPageObject
                    .goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("")
                    .inputMetaTagOfCategories("")
                    .inputMetaTagDescriptionOfCategories("")
                    .inputMetaTagKeywordsOfCategories("")
                    .saveNewCategories()
                    .getTextFromMessageInNewCategories();
            assertTrue(actualMessage.contains(ADMIN_CATEGORIES_UNSUCCESSFUL_MESSAGE));
        }
    /**
     * <b> Negative Test Add Category With False Name.</b>
     *
     * Scenario:
     * <ul>;
     * <li>1. Login in Admin;
     * <li>2. Go to Categories;
     * <li>3. Click add Categories;
     * <li>4. Leave Categories Name Field Blank;
     * <li>7. Input  Categories MetaTag;
     * <li>8. Click Save Category;
     * <li>9. Get Text from Message;
     * <li>10. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */

        @Test
        public void addNewCategoriesWithFalseName() {
            String actualMessage = AdminNavigationPageObject
                    .goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("")
                    .inputMetaTagOfCategories("fsf")
                    .inputMetaTagDescriptionOfCategories("")
                    .inputMetaTagKeywordsOfCategories("")
                    .saveNewCategories()
                    .getTextFromMessageInNewCategories();
            assertTrue(actualMessage.contains(ADMIN_CATEGORIES_UNSUCCESSFUL_MESSAGE));
        }
    /**
     * <b> Negative Test With False MetaTag.</b>
     *
     * Scenario:
     * <li>1. Login in Admin;
     * <li>2. Go to Categories;
     * <li>3. Click add Categories;
     * <li>4. Input Categories Name;
     * <li>5. Leave Categories MetaTag Field Blank;
     * <li>6. Click Save Category;
     * <li>7. Get Text from Message;
     * <li>8. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */

        @Test
        public void addNewCategoriesWithFalseMetaTag() {
            String actualMessage = AdminNavigationPageObject
                    .goToCatalog()
                    .goToCategories()
                    .addNewCategories()
                    .inputCategoriesName("gfasf")
                    .inputMetaTagOfCategories("")
                    .inputMetaTagDescriptionOfCategories("")
                    .inputMetaTagKeywordsOfCategories("")
                    .saveNewCategories()
                    .getTextFromMessageInNewCategories();
            assertTrue(actualMessage.contains(ADMIN_CATEGORIES_UNSUCCESSFUL_MESSAGE));
        }
    /**
     * <b> Edit Name In Category.</b>
     *
     * Scenario:
     * <li>1. Login in Admin;
     * <li>2. Go to Categories;
     * <li>3. Click Edit Button Categories;
     * <li>4. Input Categories Name;
     * <li>5. Click Save Category;
     * <li>7. Get Text from Message;
     * <li>8. Compare Expected with Text from Message;
     * </ul>
     * <p>
     *  Expected Result: "Warning: Please check the form carefully for errors!";
     */
        @Test
        public void editSomethingToCategory() {
            String actualMessage = AdminNavigationPageObject
                    .goToCatalog()
                    .goToCategories()
                    .changeSomethingInCategories()
                    .inputCategoriesName("dsada")
                    .inputMetaTagDescriptionOfCategories("dafazf")
                    .saveNewCategories()
                    .getTextFromMessageOfCategories();
            assertTrue(actualMessage.contains(ADMIN_CATEGORIES_SUCCESSFUL_MESSAGE));
        }
    }
