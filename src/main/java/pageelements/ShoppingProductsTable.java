package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class ShoppingProductsTable extends BaseElement {
    private HashMap<String,ShoppingCartPruduct> shoppingCartPruducts;

    public ShoppingProductsTable(WebDriver driver, String xpath) {
        super(driver, xpath);
        shoppingCartPruducts = new HashMap<String, ShoppingCartPruduct>();
    }

    public HashMap<String,ShoppingCartPruduct> productsListInCart() {
        List<WebElement> tableRow = this.element.findElements(By.tagName("tr"));
        for (int i = 0; i < tableRow.size(); i++) {
            String productID = tableRow.get(i).findElement(By.xpath("td[2]")).findElement(By.xpath("a")).getAttribute("href").split("=")[2];
            String productName = tableRow.get(i).findElement(By.xpath("td[2]")).getText();
            String productModel = tableRow.get(i).findElement(By.xpath("td[3]")).getText();
            WebElement input = tableRow.get(i).findElement(By.xpath("td[4]")).findElement(By.tagName("div")).findElement(By.tagName("input"));
            WebElement ButtonConteiner = tableRow.get(i).findElement(By.xpath("td[4]")).findElement(By.tagName("div")).findElement(By.tagName("span"));
            WebElement buttonUpdate = ButtonConteiner.findElements(By.tagName("button")).get(0);
            WebElement buttonRemove = ButtonConteiner.findElements(By.tagName("button")).get(1);
            String producsUnitPrice = tableRow.get(i).findElement(By.xpath("td[5]")).getText();
            String producsTotalPrice = tableRow.get(i).findElement(By.xpath("td[6]")).getText();
            shoppingCartPruducts.put(productID,new ShoppingCartPruduct(
                    productName, productModel, input.getText(), producsUnitPrice, producsTotalPrice, input, buttonUpdate, buttonRemove));
        }
        return shoppingCartPruducts;
    }

}
