package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListItemPageObject extends BasePageObject{

    public WebElement image;
    public WebElement productName;
    public WebElement addToCart;
    public WebElement remove;


    public WishListItemPageObject(WebDriver driver, WebElement image, WebElement productName, WebElement addToCart, WebElement remove) {
        super(driver);
        this.image = image;
        this.productName = productName;
        this.addToCart = addToCart;
        this.remove = remove;
    }
}
