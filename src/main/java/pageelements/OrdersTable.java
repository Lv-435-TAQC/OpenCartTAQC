package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersTable extends BaseElement {
    private HashMap<String, Order> orders;

    public OrdersTable(WebDriver driver, String xpath) {
        super(driver, xpath);
        orders = new HashMap<>();
    }

    public Map<String, Order> ordersList() {
        List<WebElement> tableRow = this.element.findElements(By.tagName("tr"));
        for (int j = 0; j < tableRow.size(); j++) {
            String orderID = tableRow.get(j).findElement(By.xpath("td[2]")).getText();
            String customer = tableRow.get(j).findElement(By.xpath("td[3]")).getText();
            String status = tableRow.get(j).findElement(By.xpath("td[4]")).getText();
            String total = tableRow.get(j).findElement(By.xpath("td[5]")).getText();
            String dateAdded = tableRow.get(j).findElement(By.xpath("td[6]")).getText();
            String dateModified = tableRow.get(j).findElement(By.xpath("td[7]")).getText();
            Button view = new Button(tableRow.get(j), "td[8]/div/div/a");
            Button deleteAndEdit = new Button(tableRow.get(j), "td[8]/div/div/button");
            Button delete = new Button(tableRow.get(j), "td[8]/div/div/ul/li[2]/a");
            Button edit = new Button(tableRow.get(j), "td[8]/div/div/ul/li[1]/a");
            orders.put(orderID, new Order(
                    orderID, customer, status, total, dateAdded, dateModified, view, deleteAndEdit, delete, edit));
        }
        return orders;
    }
}
