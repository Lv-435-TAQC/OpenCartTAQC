package javatest.pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageobjects.WishListPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class WishListPageObjectTest {
    WebDriver driver;
    WishListPageObject wishList;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://192.168.152.128/opencart");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-email\"]")));

        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("ngardzhalo@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("vmnataliia");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input[1]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//*[@id=\"wishlist-total\"]/span")));
        driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
    }

    @BeforeMethod
    public void getHome() {

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }


}