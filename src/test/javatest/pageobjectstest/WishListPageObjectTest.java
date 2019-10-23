package pageobjectstest;

import locators.CategoryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.*;

import java.io.IOException;

import static locators.WishListLocators.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WishListPageObjectTest {
    WebDriver driver;
    WishListPageObject wishList;
    WebDriverWait wait;
    MenuPageObject menu;
    CategoryPageObject categoryPageObject;
    HeaderPageObject headerPageObject;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(LOGIN_PAGE_URL);
        headerPageObject = new HeaderPageObject(driver);
        headerPageObject.goToLoginPage().logIn(LOGIN_NAME, LOGIN_PASSWORD);
        menu = new MenuPageObject(driver);
        menu.goToMacDesktops();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]")).click();
    }

    @BeforeMethod
    public void getHome() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu\"]/div[2]")));
        menu = new MenuPageObject(driver);
    }

    @AfterMethod
    public void makeScreenshots(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            WishListPageObject.makeScreenShotSteps(driver, result.getName());
        }
    }

    @Test
    public void findIMacImgOnCategoryPage(){
        menu.goToMacDesktops();
        Screen screen = new Screen();
        Pattern pattern = new Pattern("E:\\Папка для sikuli/imac.png");
        Boolean isFound = WishListPageObject.findImageInScreen(screen, pattern);
        assertTrue(isFound);
    }

    @Test
    public void addItemToWishListFromMenu(){
        menu.showAllDesktops();
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        categoryPageObject.generateProductsPageObjects().clickAddToWishListByNumberOfProduct(1);
        String actual = categoryPageObject.getTextFromAlertLabel();
        String expected = "Success: You have added Apple Cinema 30\" to your wish list!";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void addItemToWishListFromItemObject(){
        menu.showAllDesktops();
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        categoryPageObject.generateProductsPageObjects().clickToLinkedNameByNumberOfProduct(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")));
        ItemInfoPageObject itemInfoPageObject = new ItemInfoPageObject(driver);
        itemInfoPageObject.addToWishList();
        String actual = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
        String expected = "Success: You have added Apple Cinema 30\" to your wish list!";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void addItemFromWishListToChoppingCart(){
        headerPageObject.goToWishList().addItemToCart("41");
        wishList = new WishListPageObject(driver);
        String actual = wishList.getTextFromAlertLabel();
        String expected = "Success: You have added iMac to your shopping cart!";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void addItemWithParametersFromWishListToChoppingCart(){
        headerPageObject.goToWishList().addItemToCart("42");
        String actual = driver.getCurrentUrl();
        String expected = "http://192.168.152.128/opencart/index.php?route=product/product&product_id=42";
        assertEquals(actual, expected);
    }

    @Test
    public void removeItemFromWishList(){
        wishList = headerPageObject.goToWishList().removeItemFromWishList("41");
        Boolean expected = wishList.getMapOfItems().containsKey("41") ? Boolean.FALSE : Boolean.TRUE;
        assertTrue(expected);
    }

    @Test
    public void goToItemByImageFromWishList(){
        headerPageObject.goToWishList().itemImageClick("42");
        String actual = driver.getCurrentUrl();
        String expected = "http://192.168.152.128/opencart/index.php?route=product/product&product_id=42";
        assertEquals(actual, expected);
    }

    @Test
    public void goToItemByProductNameFromWishList(){
        headerPageObject.goToWishList().itemProductNameClick("42");
        String actual = driver.getCurrentUrl();
        String expected = "http://192.168.152.128/opencart/index.php?route=product/product&product_id=42";
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}