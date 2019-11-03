package pageobjects;

import locators.OrdersTableLocators;
import org.openqa.selenium.WebDriver;
import pageelements.LinkedLabel;
import pageelements.Order;
import pageelements.OrdersTable;

import java.util.Map;

public class AdminOrdersPageObject extends BasePageObject {
    OrdersTable ordersTable;
    private LinkedLabel ordersLabel;

    public AdminOrdersPageObject(WebDriver driver) {
        super(driver);
    }

    public Map<String, Order> getOrdersList() {
        ordersTable = new OrdersTable(driver, OrdersTableLocators.ORDERS_TABLE);
        return ordersTable.ordersList();
    }

    public Order getTheOrder(String orderID) {
        return getOrdersList().get(orderID);
    }
    public AdminOrdersPageObject clickOrdersLinkedLabel() {
        ordersLabel = new LinkedLabel(this.driver,  OrdersTableLocators.ORDERS);
        ordersLabel.click();
        return this;
    }
}
