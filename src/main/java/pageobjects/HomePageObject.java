package pageobjects;

import locators.HomeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.Button;
import patterns.ShoppingCartPatterns;

public class HomePageObject extends BasePageObject {
    public HeaderPageObject headerPageObject;
    public HeaderPageObject menuPageObject;
    private Button iphoneAddToCart;
    private WebElement productIphone;
    private Button macBookAddToCart;
    private WebElement productMacBook;
    private Screen screen;
    private Pattern iphoneAddToCartButton;
    private Pattern scroll;
    private Pattern openShoppingCartButton;

    public HomePageObject(WebDriver driver) {
        super(driver);
        screen = new Screen();
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
    public HomePageObject addIphoneToShoppingCartSikuly() {
        iphoneAddToCartButton = new Pattern(ShoppingCartPatterns.IPHONE_ADD_TO_CART_BUTTON).targetOffset(10, 180);
        scroll = new Pattern(ShoppingCartPatterns.SCROLL);

        try {
            screen.wait(scroll, 20);
            screen.type(Key.PAGE_DOWN);
            screen.find(iphoneAddToCartButton).click();
        } catch (Exception ex) {
            System.out.println("Exception in addIphoneToShoppingCartSikuly()");
        }

        return this;
    }
    public ShoppingCartPageObject openShoppingCartSikuly(){
        openShoppingCartButton = new Pattern(ShoppingCartPatterns.OPEN_SHOPPIN_CART_BUTTON);
        try {
        screen.wait(openShoppingCartButton, 20).click();
        } catch (Exception ex) {
            System.out.println("Exception in openShoppingCartSikuly()");
        }
        return new ShoppingCartPageObject(driver);
    }

    public HeaderPageObject goToHeaderPage() {
        return new HeaderPageObject(driver);
    }

    public String getURL() {
        return this.getURL();
    }
}


