package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoppingProductsTable extends BaseElement {
    private List<ShoppingCartPruduct> shoppingCartPruducts;
    public ShoppingProductsTable(WebDriver driver, String xpath) {
        super(driver, xpath);
        shoppingCartPruducts = new ArrayList<ShoppingCartPruduct>();
    }
    public List<ShoppingCartPruduct> createProductsList(){
        System.out.println("function start");
        List<WebElement> tableRow = this.element.findElements(By.tagName("tr"));
        for (int i= 0; i < tableRow.size();i++) {
            String productName = tableRow.get(0).findElement(By.xpath("td[2]")).getText();
            String productModel = tableRow.get(0).findElement(By.xpath("td[3]")).getText();
            WebElement input = tableRow.get(0).findElement(By.xpath("td[4]")).findElement(By.tagName("div")).findElement(By.tagName("input"));
            WebElement ButtonConteiner = tableRow.get(0).findElement(By.xpath("td[4]")).findElement(By.tagName("div")).findElement(By.tagName("span"));
            WebElement buttonUpdate = ButtonConteiner.findElements(By.tagName("button")).get(0);
            WebElement buttonRemove = ButtonConteiner.findElements(By.tagName("button")).get(1);
            String producsUnitPrice = tableRow.get(0).findElement(By.xpath("td[5]")).getText();
            String producsTotalPrice = tableRow.get(0).findElement(By.xpath("td[6]")).getText();
            shoppingCartPruducts.add(new ShoppingCartPruduct(
                    productName, productModel, input.getText(), producsUnitPrice, producsTotalPrice, input, buttonUpdate, buttonRemove));
        }
        return shoppingCartPruducts;
    }

}
