package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static locators.WishListLocators.WISH_LIST_TABLE;


public class WishListPageObject extends BasePageObject {
    public HeaderPageObject header;
    public HashMap<String, WishListItemPageObject> items;

    public WishListPageObject(WebDriver driver) {
        super(driver);
        this.header = new HeaderPageObject(driver);
    }

    public HashMap<String, WishListItemPageObject> removeItemFromWishList(String id){
        HashMap<String, WishListItemPageObject> items = getListItems();
        items.get(id).remove.click();
        items.remove(id);
        return items;
    }

    public WishListPageObject addItemToCart(String id){
        HashMap<String, WishListItemPageObject> items = getListItems();
        items.get(id).addToCart.click();
        return this;
    }

    public HashMap<String, WishListItemPageObject> getListItems(){
        HashMap<String, WishListItemPageObject> items = new HashMap<String, WishListItemPageObject>();
        List<WebElement> listTr = driver.findElement(By.xpath(WISH_LIST_TABLE)).findElements(By.xpath("tr"));

        for (WebElement element: listTr ) {
            String id = element.findElement(By.xpath("td[2]/a")).getAttribute("href").split("=")[2];
            String image = element.findElement(By.xpath("td[1]/a")).getAttribute("href").toString();
            String productName = element.findElement(By.xpath("td[2]")).getText().toString();
            WebElement addToCart = element.findElement(By.xpath("td[6]/button"));
            WebElement remove = element.findElement(By.xpath("td[6]/a"));
            items.put(id,new WishListItemPageObject(driver, image, productName, addToCart, remove));
        }
        return items;
    }
}


