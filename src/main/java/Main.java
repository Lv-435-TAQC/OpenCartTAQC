import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://192.168.186.129/opencart/index.php?route=product/search");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement inputeText = driver.findElement(By.xpath("//*[@id=\"input-search\"]"));
        inputeText.sendKeys("Mac");
        Select cat = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/select")));
        cat.selectByIndex(3);

        WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"button-search\"]"));
        SearchButton.click();


=======
>>>>>>> develop
    }
}
