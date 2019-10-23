package pageobjects;

import locators.HomeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;

public class HomePageObject extends BasePageObject {
    public HeaderPageObject headerPageObject;
    public MenuPageObject menuPageObject;
    Button iphoneAddToCart;
    WebElement productIphone;
    Button macBookAddToCart;
    WebElement productMacBook;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.headerPageObject = new HeaderPageObject(driver);
        this.menuPageObject = new MenuPageObject(driver);
    }

    public String addToCartIphone() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomeLocators.ADD_IPHONE)));
        this.productIphone = driver.findElement(By.xpath(HomeLocators.IPHONE_ID));
        this.iphoneAddToCart = new Button(driver, HomeLocators.ADD_IPHONE);
        iphoneAddToCart.click();
        return productIphone.getAttribute("href").split("=")[2];
    }

    public String addToCartMacBook() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomeLocators.ADD_MACBOOK)));
        this.productMacBook = driver.findElement(By.xpath(HomeLocators.MACBOOK_ID));
        this.macBookAddToCart = new Button(driver, HomeLocators.ADD_MACBOOK);
        macBookAddToCart.click();
        return productMacBook.getAttribute("href").split("=")[2];
    }

    public ShoppingCartPageObject goToShoppingCartPage() {
        driver.navigate().to("http://localhost/OpenCart/index.php?route=checkout/cart");
        return new ShoppingCartPageObject(driver);
    }

    public HeaderPageObject getHeaderPageObject() {
        return new HeaderPageObject(driver);
    }
    public MenuPageObject getMenuPageObject(){
        return this.menuPageObject;
    }

    public String getURL() {
        return this.getURL();
    }
}


