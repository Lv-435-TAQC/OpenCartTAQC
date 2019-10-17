package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class ShoppingProductsTable extends BaseElement {
    private HashMap<String, ShoppingCartProduct> shoppingCartProducts;

    public ShoppingProductsTable(WebDriver driver, String xpath) {
        super(driver, xpath);
        shoppingCartProducts = new HashMap<String, ShoppingCartProduct>();
    }

    public HashMap<String, ShoppingCartProduct> productsListInCart() {
        List<WebElement> tableRow = this.element.findElements(By.tagName("tr"));
        for (int i = 0; i < tableRow.size(); i++) {
            String productID = tableRow.get(i).findElement(By.xpath("td[2]")).findElement(By.xpath("a")).getAttribute("href").split("=")[2];
            String productName = tableRow.get(i).findElement(By.xpath("td[2]")).getText();
            String productModel = tableRow.get(i).findElement(By.xpath("td[3]")).getText();
            WebElement input = tableRow.get(i).findElement(By.xpath("td[4]")).findElement(By.tagName("div")).findElement(By.tagName("input"));
            WebElement ButtonContainer = tableRow.get(i).findElement(By.xpath("td[4]")).findElement(By.tagName("div")).findElement(By.tagName("span"));
            WebElement buttonUpdate = ButtonContainer.findElements(By.tagName("button")).get(0);
            WebElement buttonRemove = ButtonContainer.findElements(By.tagName("button")).get(1);
            String productsUnitPrice = tableRow.get(i).findElement(By.xpath("td[5]")).getText();
            String productsTotalPrice = tableRow.get(i).findElement(By.xpath("td[6]")).getText();
            shoppingCartProducts.put(productID,new ShoppingCartProduct(
                    productName, productModel, input.getText(), productsUnitPrice, productsTotalPrice, input, buttonUpdate, buttonRemove));
        }
        return shoppingCartProducts;
    }

}
