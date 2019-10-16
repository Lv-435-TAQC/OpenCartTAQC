package pageelements;

import org.openqa.selenium.WebElement;

public class ProductForPreview {
        String name;
        String count;
        String cost;
        WebElement removeButton;
        public  ProductForPreview(String name, String count, String cost, WebElement removeWebElement){
            this.name = name;
            this.count = count;
            this.cost = cost;
            this.removeButton= removeWebElement;
        }
        public void removeProduct(){
            removeButton.click();
        }

}
