package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListItem extends BasePageObject{

    private WebElement image;
    private WebElement productName;
    private WebElement addToCart;
    private WebElement remove;


    public WishListItem(WebDriver driver, WebElement image, WebElement productName, WebElement addToCart, WebElement remove) {
        super(driver);
        this.image = image;
        this.productName = productName;
        this.addToCart = addToCart;
        this.remove = remove;
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getRemove() {
        return remove;
    }
}
