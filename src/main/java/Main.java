import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HeaderPageObject;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost/shop/";
        driver.get(baseUrl);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/div[2]/ul/li[4]/a")));
        HeaderPageObject hp = new HeaderPageObject(driver);
        hp.goToRegistrationPage();




    }

}
