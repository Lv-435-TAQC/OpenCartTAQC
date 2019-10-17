package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;

public class HomePageObject extends BasePageObject {
    public HeaderPageObject headerPageObject;
    public HeaderPageObject menuPageObject;
    Button iphoneAddToCart;
    WebElement product;


    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public String addToCart(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]")));
        this.product = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[2]/h4/a"));
        this.iphoneAddToCart = new Button(driver,"/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]");
        iphoneAddToCart.click();
        return product.getAttribute("href").split("=")[2];
    }
    public void  putProductToCart() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]")));
        WebElement add = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]"));
        WebElement add2 = driver.findElement(By.xpath("(//span[contains(.,'Add to Cart')])[1]"));
        add.click();
        add2.click();
    }
    public ShoppingCartPageObject goToShoppingCartPage(){
        driver.navigate().to("http://localhost/OpenCart/index.php?route=checkout/cart");
        return new ShoppingCartPageObject(driver);
    }
}
