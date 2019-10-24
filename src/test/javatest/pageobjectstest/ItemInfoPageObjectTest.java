package pageobjectstest;

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


public class ItemInfoPageObjectTest {
    WebDriver driver;
    ItemInfoPageObject item;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/opencart/index.php?route=product/product&path=57&product_id=49");
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
     *
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

    @Test
    public void testItemDescriptionTab() {
        item.clickItemDescriptionTab();
        item.findTextField();

        Assert.assertTrue(item.descriptionTextField.getText().contains("Samsung Galaxy Tab"));
        Assert.assertFalse(item.descriptionTextField.getText().contentEquals(""));
    }


    /**
     * <b>TC-02: Test Item Review Tab.</b>
     *
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
     **<li>10. Verify that User can Submit entered Review;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */



    @Test
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
     * <b>TC-03: Test Add Item to the WishList.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Add Item to the WishList button;
     * <li>4. Verify that Item was successfully added to the WishList;
     * </ul>
     * <p>
     * Expected Result: Item was  added to the WishList;
     */

    @Test
    public void testAddItemToTheWishList(){
        item.addToWishList();
        item.verifySuccessNotification();

    }

    /**
     * <b>TC-04: Test Add Item to the WishList.</b>
     *
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

    @Test
    public void testCompareItems(){
        item.compareItems();
        item.verifySuccessNotification();
    }

    /**
     * <b>TC-05: Test that User is able to enter Items Quantity.</b>
     *
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


    @Test
    public void testItemsQuantityInputField(){
        item.enterItemsQuantity();
    }


    /**
     * <b>TC-06: Test Add Item to the Cart.</b>
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

    @Test
    public void testAddToCArt(){
        item.addToCart();
        item.verifySuccessNotification();
    }


    /**
     * <b>TC-06: Test that User can navigate to the Home page.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Item Description Page on OpenCart.com;
     * <li>3. Click on Home page button;
     * <li>4. Verify that User was successfully navigated to the Home page;
     * </ul>
     * <p>
     * Expected Result: User was navigated to the Home page;
     */


    @Test
    public void testGoToHomePage(){
        item.findNavigationBar();
        item.goToHomePage();
    }

}