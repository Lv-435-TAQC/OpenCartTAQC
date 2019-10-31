package pageobjects;

import locators.OrdersTableLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Order;
import pageelements.OrdersTable;

import java.util.Map;

public class AdminOrdersPageObject extends BasePageObject {
    OrdersTable ordersTable;

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
}
