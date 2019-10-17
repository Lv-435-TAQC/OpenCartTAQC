package javatest.pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageobjects.LoginPageObject;
import pageobjects.WishListPageObject;

import java.util.concurrent.TimeUnit;

import static locators.WishListLocators.*;
import static org.testng.Assert.*;

public class WishListPageObjectTest {
    WebDriver driver;
    WishListPageObject wishList;
    WebDriverWait wait;
    LoginPageObject loginPageObject;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(LOGIN_PAGE_URL);
        wait = new WebDriverWait(driver, 10);

        loginPageObject = new LoginPageObject(driver);
        loginPageObject.logIn(LOGIN_NAME, LOGIN_PASSWORD);
    }

    @BeforeMethod
    public void getHome() {

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }




}