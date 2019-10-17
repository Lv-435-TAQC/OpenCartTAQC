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
    WebElement productIpnone;
    Button macBookAddToCart;
    WebElement productMacBook;

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public String addToCartIphone() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]")));
        this.productIpnone = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[2]/h4/a"));
        this.iphoneAddToCart = new Button(driver, "/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]");
        iphoneAddToCart.click();
        return productIpnone.getAttribute("href").split("=")[2];
    }

    public String addToCartMacBook() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/div[3]/button[1]")));
        this.productMacBook = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/h4/a"));
        this.macBookAddToCart = new Button(driver, "/html/body/div[2]/div[2]/div/div[2]/div[1]/div/div[3]/button[1]");
        macBookAddToCart.click();
        return productMacBook.getAttribute("href").split("=")[2];
    }

    public ShoppingCartPageObject goToShoppingCartPage() {
        driver.navigate().to("http://localhost/OpenCart/index.php?route=checkout/cart");
        return new ShoppingCartPageObject(driver);
    }

    public HeaderPageObject goToHeaderPage() {
        return new HeaderPageObject(driver);
    }

    public String getURL() {
        return this.getURL();
    }
}


