package javatest.pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import static locators.WishListLocators.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WishListPageObjectTest {
    WebDriver driver = new FirefoxDriver();
    WishListPageObject wishList;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    MenuPageObject menu;
    CategoryPageObject categoryPageObject;
    HeaderPageObject headerPageObject;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver.get(LOGIN_PAGE_URL);
        headerPageObject = new HeaderPageObject(driver);
        headerPageObject.goToLoginPage().logIn(LOGIN_NAME, LOGIN_PASSWORD);
        wait = new WebDriverWait(driver, 10);
    }

    @BeforeMethod
    public void getHome() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu\"]/div[2]")));
        menu = new MenuPageObject(driver);
    }

    @Test
    public void addItemToWishListFromMenu(){
        menu.showAllDesktops();
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.generateProductsPageObject().clickAddToWishList(1);
        String actual = categoryPageObject.getTextFromAlertLabel();
        String expected = "Success: You have added Apple Cinema 30\" to your wish list!";
        assertTrue(actual.contains(expected));
    }

    @Test
    public void addItemToWishListFromItemObject(){
        menu.showAllDesktops();
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.generateProductsPageObject().clickToLinkedNameOfProduct(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
       //TODO Marta need to write her method - itemPageObject.clickAddToWishList
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
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}