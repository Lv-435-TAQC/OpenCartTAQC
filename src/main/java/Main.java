import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.CategoryPageObject;

public class Main {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://192.168.92.128/opencart/index.php?route=product/category&path=20");
        CategoryPageObject pg = new CategoryPageObject(driver);
        pg.clickToImageByNumberOfProduct(1);

    }

}
