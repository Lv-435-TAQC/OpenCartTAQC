package pageobjects;

import org.openqa.selenium.WebDriver;
import pageelements.Button;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WishListPageObject extends BasePageObject {
    public HeaderPageObject header;
    public static Map<Integer, WishListItem> items;

    public WishListPageObject(WebDriver driver) {
        super(driver);
    }

    public WishListPageObject removeFromWishList(WishListItem item){
        for(Iterator<Map.Entry<Integer, WishListItem>> it = items.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, WishListItem> entry = it.next();
            if(entry.getKey().equals(item.id)) {
                it.remove();
            }
        }
        return this;
    }

    private class WishListItem extends BasePageObject{
        public Integer id;
        public String image;
        public String productName;
        public Button addToCart;
        public Button remove;



        public WishListItem(WebDriver driver,Integer id, String image, String productName) {
            super(driver);
            this.id = id;
            this.image = image;
            this.productName = productName;
            this.addToCart = new Button(driver, "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[6]/button/i");
            this.remove = new Button(driver, "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[6]/a/i");
        }
    }
}


