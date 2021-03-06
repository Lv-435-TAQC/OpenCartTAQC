package javatest.pageobjectstest;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ItemInfoPageObject;
import java.util.concurrent.TimeUnit;

import static locators.ItemLocators.TABLET_IMAGE;
import static org.testng.Assert.assertTrue;

public class ItemInfoPageObjectTest {
    WebDriver driver;
    ItemInfoPageObject item;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//       driver = new FirefoxDriver();
        driver = new ChromeDriver();
        item = new ItemInfoPageObject(driver);
    }


    /**
     * <b>Pre-Conditions</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Navigate to the OpenCart.com;
     * <li>2. Select Tablets Category form the tool bar;
     * <li>3. Select any Tablet form the uploaded list;
     * </ul>
     */


    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/opencart/index.php?route=common/home");
        item.openTabletsMenu();
        item.selectTablet();
        item = new ItemInfoPageObject(driver);

    }


    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }


    /**
     * <b>TC-01: Test Item Description Tab.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Item Description Tab;
     * <li>4. Verify that Item's Description is displayed on the Tab;
     * <li>5. Verify that corresponding description was uploaded;
     * <li>6. Verify that Item's Description Text Field couldn't be empty;
     * </ul>
     * <p>
     * Expected Result: Item's Description field is displayed and
     * correctly uploaded for the selected item.
     */

    @Test(testName = "TC-01",
            description = "Test Item Description Tab",
            groups = {"webui", "system", "regression"})
    public void testItemDescriptionTab() {
        item.clickItemDescriptionTab();
        item.findTextField();

        Assert.assertTrue(item.descriptionTextField.getText().contains("Samsung Galaxy Tab"));
        Assert.assertFalse(item.descriptionTextField.getText().contentEquals(""));

    }


    /**
     * <b>TC-02: Test Item Review Tab.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Item Review Tab;
     * <li>4. Verify that Name text field is displayed;
     * <li>5. Verify that User can edit Name field;
     * <li>6. Verify that Review text field is displayed;
     * <li>7. Verify that User can edit Review field;
     * <li>8. Verify that Score field is displayed;
     * <li>9. Verify that User can select any score from the list;
     * *<li>10. Verify that User can Submit entered Review;
     * </ul>
     * <p>
     * Expected Result: User should be able to submit a review;
     */


    @Test(testName = "TC-02",
            description = "Test Item Review Tab.",
            groups = {"webui", "system", "regression"})
    public void testItemReviewTab() {
        item.clickItemReviewTab();
        item.enterName();
        item.enterReview();
        item.findScoreField();
        item.selectHighestScoreButton();
        item.highestRatingScoreButton.isSelected();
        item.clickSubmitReviewButton();

    }

    /**
     * <b>TC-03: Verify that Item could be added to the WishList.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Add Item to the WishList button;
     * <li>4. Verify that Item was successfully added to the WishList;
     * </ul>
     * <p>
     * Expected Result: Item was successfully added to the WishList;
     */

    @Test(testName = "TC-03",
            description = "Verify that Item could be added to the WishList.",
            groups = {"webui", "system", "regression"})
    public void testAddItemToTheWishList() {
        item.addToWishList();
        item.verifySuccessNotification();
    }

    /**
     * <b>TC-04: </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Add Item to the CompareList button;
     * <li>4. Verify that Item was successfully added to the CompareList;
     * </ul>
     * <p>
     * Expected Result: Item was  added to the CompareList;
     */

    @Test(testName = "TC-04",
            description = "Verify that Item could be added to the WishList.",
            groups = {"webui", "system", "regression"})
    public void testCompareItems() {
        item.compareItems();
        item.verifySuccessNotification();
    }

    /**
     * <b>TC-05: Verify that User is able to enter Items Quantity.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Enter number of Items in the 'Quantity' field;
     * <li>4. Verify that number of Items was successfully entered;
     * </ul>
     * <p>
     * Expected Result: Item was added to the Cart;
     */


    @Test(testName = "TC-05",
            description = "Verify that User is able to enter Items Quantity.",
            groups = {"webui", "system", "regression"})
    public void testItemsQuantityInputField() {
        item.enterItemsQuantity();
    }


    /**
     * <b>TC-06: Verify that Item could be added to the Cart</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Add Item to the Cart button;
     * <li>4. Verify that Item was successfully added to the Cart;
     * </ul>
     * <p>
     * Expected Result: Item was added to the Cart;
     */

    @Test(testName = "TC-06",
            description = "Test Add Item to the Cart",
            groups = {"webui", "system", "regression"})
    public void testAddToCArt() {
        item.addToCart();
        item.verifySuccessNotification();
    }


/**
 * <b>TC-06: Verify that selected Item corresponds the selected category</b>
 *
 * Scenario:
 * <ul>
 * <li>1. Open Firefox browser;
 * <li>2. Open Item Description Page on OpenCart.com;
 * <li>3. Click on Add Item to the Cart button;
 * <li>4. Verify that Item was successfully added to the Cart;
 * </ul>
 * <p>
 * Expected Result: Item was added to the Cart;
 */


    //@Test(priority = 1)
//    public void sikulitest(){
//        Boolean isFound = item.findSelectedItemByImage(TABLET_IMAGE);
//        assertTrue(isFound);
//    }


}
