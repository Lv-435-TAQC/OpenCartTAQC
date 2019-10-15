package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Button;
import pageelements.ProductForPreview;

import java.io.BufferedReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PreviewShoppingCart extends BasePageObject {
    LinkedHashMap< String,ProductForPreview> productsForPreviews;
    Button viewCartButton;
    Button checkoutButton;
    public PreviewShoppingCart(WebDriver driver) {
        super(driver);
        productsForPreviews = new LinkedHashMap<String, ProductForPreview>();
    }
    public LinkedHashMap<String, ProductForPreview> getMapProductInCart(String tableProductsXpath){
        List<WebElement> tableRows = this.driver.findElement(By.xpath(tableProductsXpath)).findElements(By.tagName("tr"));
        for (int i = 0; i< tableRows.size();i++) {
            String name = tableRows.get(i).findElement(By.xpath("td[2]")).getText();
            String count = tableRows.get(i).findElement(By.xpath("td[3]")).getText();
            String cost = tableRows.get(i).findElement(By.xpath("td[4]")).getText();
            WebElement removeButton = tableRows.get(i).findElement(By.xpath("td[5]"));
            productsForPreviews.put(name,new ProductForPreview(name, count, cost, removeButton));
        }
        return productsForPreviews;
    }

}
