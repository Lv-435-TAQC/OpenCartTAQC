package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static locators.WishListLocators.WISH_LIST_TABLE;
import static locators.WishListLocators.WISH_LIST_URL;


public class WishListPageObject extends BasePageObject {
    public HeaderPageObject header;
    public MenuPageObject menu;
    public HashMap<String, WishListItemPageObject> items;

    public WishListPageObject(WebDriver driver) {
        super(driver);
        this.header = new HeaderPageObject(driver);
        this.menu = new MenuPageObject(driver);

    }

    public ItemPageObject itemImageClick(String id){
        HashMap<String, WishListItemPageObject> items = getListItems();
        items.get(id).image.click();
        return new ItemPageObject(driver);
    }

    public ItemPageObject itemProductNameClick(String id){
        HashMap<String, WishListItemPageObject> items = getListItems();
        items.get(id).productName.click();
        return new ItemPageObject(driver);
    }

    public WishListPageObject removeItemFromWishList(String id){
        HashMap<String, WishListItemPageObject> items = getListItems();
        items.get(id).remove.click();
        items.remove(id);
        return this;
    }

    public BasePageObject addItemToCart(String id){
        HashMap<String, WishListItemPageObject> items = getListItems();
        items.get(id).addToCart.click();
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals(WISH_LIST_URL)){
            return this;
        }else {
            return new ItemPageObject(driver);
        }
    }

    public HashMap<String, WishListItemPageObject> getListItems(){
        HashMap<String, WishListItemPageObject> items = new HashMap<String, WishListItemPageObject>();
        List<WebElement> listTr = driver.findElement(By.xpath(WISH_LIST_TABLE)).findElements(By.xpath("tr"));

        for (WebElement element: listTr ) {
            String id = element.findElement(By.xpath("td[2]/a")).getAttribute("href").split("=")[2];
            WebElement image = element.findElement(By.xpath("td[1]/a"));
            WebElement productName = element.findElement(By.xpath("td[2]"));
            WebElement addToCart = element.findElement(By.xpath("td[6]/button"));
            WebElement remove = element.findElement(By.xpath("td[6]/a"));
            items.put(id,new WishListItemPageObject(driver, image, productName, addToCart, remove));
        }
        return items;
    }
}


