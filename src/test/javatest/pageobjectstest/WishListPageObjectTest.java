package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.HomePageObject;
import pageobjects.WishListPageObject;
import utils.DBConnector;
import utils.DBRequest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;
import static utils.DBConstants.*;

public class WishListPageObjectTest {
    public static final String LOGIN_NAME = "ngardzhalo@gmail.com";
    public static final String LOGIN_PASSWORD = "vmnataliia";
    WebDriver driver;
    DBConnector connector;
    DBRequest request;
    HomePageObject homePageObject;

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Delete all products from Wish List in Database;
     * <li>2. Add products to Wish List in Database;
     * <li>3. Open Firefox browser;
     * <li>4. Open Home Page on OpenCart.com;
     * <li>5. Click on Login Tab;
     * <li>6. Enter username, password and Click Login Tab;
     * <li>7. Click on Home Tab;
     * <li>8. Open Shopping Cart;
     * <li>9. Delete all products in Shopping Cart;
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        connector = new DBConnector();
        connector.getConnectionMariaDB(MARIA_DB_DRIVER, MARIA_DB_URL, MARIA_DB_USER_NAME, MARIA_DB_PASSWORD);
        request = new DBRequest();
        request.deleteDataFromDB(DELETE_ALL_FROM_ORDER, connector.getStatement());
        request.deleteDataFromDB(DELETE_ALL_FROM_WISH_LIST, connector.getStatement());
        request.insertDataToDB(INSERT_TO_WISH_LIST,connector.getStatement());
        homePageObject = new HomePageObject(driver);
        homePageObject.goToHomePage()
                .getHeaderPageObject()
                .clickLoginPage()
                .logIn(LOGIN_NAME, LOGIN_PASSWORD)
                .getHeaderPageObject()
                .clickShoppingCartPage()
                .determineIfTableExistsAndRemoveAll();
    }
    @BeforeMethod
    public void getHome() {
        homePageObject.goToHomePage();
    }

    @AfterMethod
    public void makeScreenshots(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            WishListPageObject.makeScreenShotSteps(driver, result.getName());
        }
        homePageObject.getHeaderPageObject().clickShoppingCartPage().determineIfTableExistsAndRemoveAll();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    /**
     * <b>TC-01: Test Wish List Item's with Image Apple.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Open Wish List Page;
     * <li>3. Verify that Item Apple is in Wish List;
     * </ul>
     * <p>
     * Expected Result: Item's image Apple is present in Wish List.
     */

    @Test
    public void findItemImgInWishListWithSikuli(){
        Boolean isFound = homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .findImageInScreen(SIKULI_IMAGE_WISH_LIST_APPLE);
        assertTrue(isFound);
    }

    /**
     * <b>TC-02: Test Wish List Alert on Category Page.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Menu/AllDesktops Tab;
     * <li>2. Add Apple Item to Wish List;
     * <li>3. Verify that Alert is displayed;
     * </ul>
     * <p>
     * Expected Result: Alert is displayed with text "Success: Added to Wish List".
     */

    @Test
    public void addItemToWishListFromMenu(){
        String actual = homePageObject
                .getMenuPageObject()
                .showAllDesktops()
                .generateProductsPageObjects()
                .clickAddToWishListByNumberOfProduct(ONE)
                .getTextFromAlertLabel();
        assertTrue(actual.contains(ALERT_WISH_LIST_SUCCESS));
    }

    /**
     * <b>TC-03: Test Wish List Alert on Item Page.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Menu/AllDesktops Tab;
     * <li>2. Click on Apple Name Tab;
     * <li>3. Add Apple Item to Wish List;
     * <li>4. Verify that Alert is displayed;
     * </ul>
     * <p>
     * Expected Result: Alert is displayed with text "Success: Added to Wish List".
     */

    @Test
    public void addItemToWishListFromItemObject(){
        String actual = homePageObject
                .getMenuPageObject()
                .showAllDesktops()
                .generateProductsPageObjects()
                .clickToLinkedNameByNumberOfProduct(ONE)
                .addToWishList()
                .verifySuccessNotification()
                .getTextSuccessNotification();
        assertTrue(actual.contains(ALERT_WISH_LIST_SUCCESS));
    }

    /**
     * <b>TC-04: Test Adding Item Without Parameters to Shopping Cart.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Add IMac Item to Shopping Cart;
     * <li>3. Verify that Alert is displayed;
     * </ul>
     * <p>
     * Expected Result: Alert is displayed with text "Success: Added to Shopping Cart".
     */

    @Test
    public void addItemWithoutParametersFromWishListToChoppingCart(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .addItemToCart(WISH_LIST_ID_41);
        WishListPageObject wishList = new WishListPageObject(driver);
        String actual = wishList.getTextFromAlertLabel();
        assertTrue(actual.contains(ALERT_WISH_LIST_SUCCESS));
    }

    /**
     * <b>TC-05: Test Adding Item With Parameters to Shopping Cart.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Add Apple Item to Shopping Cart;
     * <li>3. Verify that Current URL is on Item Page;
     * </ul>
     * <p>
     * Expected Result: Current URL is with Item's ID = 42.
     */

    @Test
    public void addItemWithParametersFromWishListToChoppingCart(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .addItemToCart(WISH_LIST_ID_42);
        String actual = driver.getCurrentUrl();
        assertTrue(actual.contains(WISH_LIST_ID_42));
    }

    /**
     * <b>TC-06: Test Removing Item from Wish List.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Remove IMac Item from Wish List;
     * <li>3. Get Map Items in new Wish List;
     * <li>4. Verify that Item with ID = 41 isn't in Wish List;
     * </ul>
     * <p>
     * Expected Result: Item with ID = 41 isn't in Wish List.
     */

    @Test
    public void removeItemFromWishList(){
        Boolean expected = homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .removeItemFromWishList(WISH_LIST_ID_41)
                .getMapOfItems()
                .containsKey(WISH_LIST_ID_41);
        assertFalse(expected);
    }

    /**
     * <b>TC-07: Test Transition from Wish List to Item Page by Image.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Click Apple's Image Tab;
     * <li>3. Verify that Current URL is with ID = 42;
     * </ul>
     * <p>
     * Expected Result: Current URL is with Item's ID = 42.
     */

    @Test
    public void goToItemByImageFromWishList(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .clickItemImage(WISH_LIST_ID_42);
        String actual = driver.getCurrentUrl();
        assertTrue(actual.contains(WISH_LIST_ID_42));
    }

    /**
     * <b>TC-08: Test Transition from Wish List to Item Page by Name.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Click Apple's Name Tab;
     * <li>3. Verify that Current URL is with ID = 42;
     * </ul>
     * <p>
     * Expected Result: Current URL is with Item's ID = 42.
     */

    @Test
    public void goToItemByProductNameFromWishList(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .clickItemProductName(WISH_LIST_ID_42);
        String actual = driver.getCurrentUrl();
        assertTrue(actual.contains(WISH_LIST_ID_42));
    }

    /**
     * <b>TC-09: Test purchase product selected from Wish List.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Wish List Tab;
     * <li>2. Click add to Cart on Product with ID=40;
     * <li>1. Click on Shopping Cart Tab;
     * <li>1. Go to Checkout Billing Details;
     * <li>1. Use an Existing Address Billing Details and Click Continue;
     * <li>1. Use Delivery Method Without Comments About Your Order and Click Continue;
     * <li>1. Use Payment Method Without Comments About Your Order and Click Continue;
     * <li>1. Click Continue on Confirm Order;
     * <li>1. Get Data about Price in Order from Database;
     * </ul>
     * <p>
     * Expected Result: Current Price from Order is equal to Price in same Order from Database.
     */

    @Test(invocationCount = 1)
    public void buyingProductsFromWishListAndCheckingPurchaseInDatabase (){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .addItemToCart(WISH_LIST_ID_40)
                .goToHomePage()
                .getHeaderPageObject()
                .clickShoppingCartPage()
                .goCheckoutBillingDetails()
                .continueWantUseAnExistingAddressBillingDetailsPageButton()
                .continueWantUseAnExistingAddressButton()
                .deliveryMethodWithoutCommentsAboutYourOrder()
                .paymentMethodWithoutCommentsAboutYourOrder()
                .clickContinueButtonU();
        String actual = request
                .getDataFromDBOneParameters(GET_FROM_ORDER2, connector.getStatement(), "total")
                .get(ZERO);
        Assert.assertEquals(actual,PRICE_FOR_IPHONE);
    }
}