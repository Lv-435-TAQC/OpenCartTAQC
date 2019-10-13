import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.ShoppingProductsTable;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Code for run and testing my part of work!!!
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/OpenCart");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]")));
        WebElement add = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]"));
        WebElement add2 = driver.findElement(By.xpath("(//span[contains(.,'Add to Cart')])[1]"));
        add.click();
        add2.click();
        WebElement enter = driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md'][contains(.,'Shopping Cart')]"));
        enter.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"content\"]/form")));
        ShoppingProductsTable table = new ShoppingProductsTable(driver, "//div[@id=\"content\"]/form/div/table/tbody");

        System.out.println(table.createProductsList().size());
        System.out.println(table.createProductsList().get(0).productName);
        System.out.println(table.createProductsList().get(1).productName);
        table.createProductsList().get(0).removeProductsFromCart();


        System.out.println("end");
    }
}
