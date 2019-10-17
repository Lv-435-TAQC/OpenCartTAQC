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
    WebElement element;
    WishListPageObject wishList;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    LoginPageObject loginPageObject;
    MenuPageObject menu;
    CategoryPageObject categoryPageObject;
    HeaderPageObject headerPageObject;
    ItemPageObject itemPageObject;


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
        menu.goToMacDesktops();
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.generateProductsPageObject().clickAddToWishList(1);
        Boolean expected = element.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]")).isDisplayed();
        assertTrue(expected);
    }

    @Test
    public void addItemToWishListFromItemObject(){
        menu.goToMacDesktops();
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.generateProductsPageObject().clickToLinkedNameOfProduct(1);
       //TODO Marta need to write her metods - itemPageObject.clickAdd
        Boolean expected = element.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]")).isDisplayed();
        assertTrue(expected);
    }

    @Test
    public void addItemFromWishListToChoppingCart(){
        menu.goToMacDesktops();
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.generateProductsPageObject().clickAddToWishList(1);
        headerPageObject.goToWishList().addItemToCart("41");
        Boolean expected = element.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]")).isDisplayed();
        assertTrue(expected);
    }

    @Test
    public void addItemWithParametersFromWishListToChoppingCart(){
        menu.goToMacDesktops();
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.generateProductsPageObject().clickAddToWishList(1);
        headerPageObject.goToWishList().addItemToCart("42");
        String actual = driver.getCurrentUrl();
        String expected = "http://192.168.152.128/opencart/index.php?route=product/product&product_id=42";
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}