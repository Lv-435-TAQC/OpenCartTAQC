package pageobjects;

import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.Label;
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
    Label msgEmptyCart;
    public PreviewShoppingCart(WebDriver driver) {
        super(driver);
        productsForPreviews = new LinkedHashMap<String, ProductForPreview>();
    }
    public LinkedHashMap<String, ProductForPreview> getMapProductInCart(){
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ShoppingCartLocators.TABLE_PRODUCTS_FOR_PREVIEW_CART)));
        List<WebElement> tableRows = this.driver.findElement(By.xpath(ShoppingCartLocators.TABLE_PRODUCTS_FOR_PREVIEW_CART)).findElements(By.tagName("tr"));
        for (int i = 0; i< tableRows.size();i++) {
            String productID = tableRows.get(i).findElement(By.xpath("td[2]")).findElement(By.xpath("a")).getAttribute("href");
            productID = productID.split("=")[2];
            String name = tableRows.get(i).findElement(By.xpath("td[2]")).getText();
            String count = tableRows.get(i).findElement(By.xpath("td[3]")).getText();
            String cost = tableRows.get(i).findElement(By.xpath("td[4]")).getText();
            WebElement removeButton = tableRows.get(i).findElement(By.xpath("td[5]"));
            productsForPreviews.put(productID,new ProductForPreview(name, count, cost, removeButton));
        }
        return productsForPreviews;
    }
    public PreviewShoppingCart removeProductFromShoppingCart(String idProduct){
        LinkedHashMap<String, ProductForPreview> productMap= getMapProductInCart();
        productMap.get(idProduct).removeProduct();
        return this;
    }
    public String getMassageFromEmptyCart(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/div/div/div[3]/div/ul/li/p")));
        msgEmptyCart = new Label(driver,"/html/body/header/div/div/div[3]/div/ul/li/p");
        return msgEmptyCart.getText();
    }

}
