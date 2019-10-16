package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static locators.WishListLocators.WISH_LIST_TABLE;


public class WishListPageObject extends BasePageObject {
    public HeaderPageObject header;
    public HashMap<String, WishListItem> items;

    public WishListPageObject(WebDriver driver) {
        super(driver);
        this.header = new HeaderPageObject(driver);
    }

    public HashMap<String, WishListItem> removeItemFromWishList(HashMap<String,WishListItem> items, String id){
        items.get(id).remove.click();
        items.remove(id);
        return items;
    }

    public WishListPageObject addItemToCart(HashMap<String,WishListItem> items, String id){
        items.get(id).addToCart.click();
        return this;
    }

    public HashMap<String, WishListItem> getListItems(){
        HashMap<String, WishListItem> items = new HashMap<String, WishListItem>();
        List<WebElement> listTr = driver.findElement(By.xpath(WISH_LIST_TABLE)).findElements(By.xpath("tr"));

        for (WebElement element: listTr ) {
            String id = element.findElement(By.xpath("td[2]/a")).getAttribute("href").split("=")[2];
            String image = element.findElement(By.xpath("td[1]/a")).getAttribute("href").toString();
            String productName = element.findElement(By.xpath("td[2]")).getText().toString();
            WebElement addToCart = element.findElement(By.xpath("td[6]/button"));
            WebElement remove = element.findElement(By.xpath("td[6]/a"));
            items.put(id,new WishListItem(driver, image, productName, addToCart, remove));
        }
        return items;
    }

    public class WishListItem extends BasePageObject{
        public String image;
        public String productName;
        public WebElement addToCart;
        public WebElement remove;


        public WishListItem(WebDriver driver, String image, String productName, WebElement addToCart, WebElement remove) {
            super(driver);
            this.image = image;
            this.productName = productName;
            this.addToCart = addToCart;
            this.remove = remove;
        }
    }
}


