package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.*;
import org.testng.*;
import org.testng.annotations.*;
import pageobjects.*;

import static locators.WishListLocators.*;
import static org.testng.Assert.assertTrue;

public class WishListPageObjectTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePageObject homePageObject;


    /**
    *
    *
    *
    *
     */

    @BeforeClass
    public void setUp() {
        //remove magic string
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver();
        homePageObject = new HomePageObject(driver);
        homePageObject.goToHomePage()
                .getHeaderPageObject()
                .clickLoginPage()
                .logIn(LOGIN_NAME, LOGIN_PASSWORD)
                .getMenuPageObject()
                .clickMacDesktops()
                .generateProductsPageObjects()
                .clickAddToWishListByNumberOfProduct(1);
    }
    @BeforeMethod
    public void getHome() {
        homePageObject.goToHomePage();
    }
    @AfterMethod
    public void makeScreenshots(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            WishListPageObject.makeScreenShotSteps(driver, result.getName());
        }
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void findIMacImgInWishList(){
        Pattern pattern = new Pattern("E:\\Папка для sikuli/imac.png");
        Boolean isFound = WishListPageObject
                .findImageInScreen(homePageObject
                        .getHeaderPageObject()
                        .clickWishList()
                        .doScreen(), pattern);
        assertTrue(isFound);
    }
    @Test
    public void addItemToWishListFromMenu(){
        String actual = homePageObject
                .getMenuPageObject()
                .showAllDesktops()
                .generateProductsPageObjects()
                .clickAddToWishListByNumberOfProduct(1)
                .getTextFromAlertLabel();
        String expected = "Success: You have added to your wish list!";
        assertTrue(actual.contains(expected));
    }
    @Test
    public void addItemToWishListFromItemObject(){
        String actual = homePageObject
                .getMenuPageObject()
                .showAllDesktops()
                .generateProductsPageObjects()
                .clickAddToWishListByNumberOfProduct(1)
                .clickToLinkedNameByNumberOfProduct(1)
                .addToWishList()
                .verifySuccessNotification()
                .getTextSuccessNotification();
        String expected = "Success: You have added to your wish list!";
        assertTrue(actual.contains(expected));
    }
    @Test
    public void addItemFromWishListToChoppingCart(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .addItemToCart("41");
        WishListPageObject wishList = new WishListPageObject(driver);
        String actual = wishList.getTextFromAlertLabel();
        String expected = "Success: You have added to your shopping cart!";
        assertTrue(actual.contains(expected));
    }
    @Test
    public void addItemWithParametersFromWishListToChoppingCart(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .addItemToCart("42");
        String actual = driver.getCurrentUrl();
        String expected = "product&product_id=42";
        assertTrue(actual.contains(expected));
    }
    @Test
    public void removeItemFromWishList(){
        homePageObject = new HomePageObject(driver);
        Boolean expected = homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .removeItemFromWishList("41")
                .getMapOfItems()
                .containsKey("41")
                ? Boolean.FALSE : Boolean.TRUE;
        assertTrue(expected);
    }
    @Test
    public void goToItemByImageFromWishList(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .itemImageClick("42");
        String actual = driver.getCurrentUrl();
        String expected = "product&product_id=42";
        assertTrue(actual.contains(expected));
    }
    @Test
    public void goToItemByProductNameFromWishList(){
        homePageObject
                .getHeaderPageObject()
                .clickWishList()
                .itemProductNameClick("42");
        String actual = driver.getCurrentUrl();
        String expected = "product&product_id=42";
        assertTrue(actual.contains(expected));
    }
}