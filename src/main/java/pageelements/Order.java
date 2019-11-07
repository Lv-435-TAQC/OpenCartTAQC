package pageelements;

import org.openqa.selenium.WebDriver;
import pageobjects.AdminOrderDescriptionPageObject;
import pageobjects.BasePageObject;

/**
 *  The class is created to describe the order item in orders table.
 */

public class Order {
    private WebDriver driver;
    private String orderID;
    private String customer;
    private String status;
    private String total;
    private String dateAdded;
    private String dateModified;
    private Button view;
    private Button deleteAndEdit;
    private Button delete;
    private Button edit;

    public Order(
            WebDriver driver, String orderID, String customer, String status, String total, String dateAdded,
            String dateModified, Button view, Button deleteAndEdit, Button delete, Button edit) {
        this.driver = driver;
        this.orderID = orderID;
        this.customer = customer;
        this.status = status;
        this.total = total;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.view = view;
        this.deleteAndEdit = deleteAndEdit;
        this.delete = delete;
        this.edit = edit;
    }

    public Order removeOrder() {
        deleteAndEdit.click();
        delete.click();
        return this;
    }
    /**
     * This method opens the order page.
     * @return AdminOrderDescriptionPage
     */
    public AdminOrderDescriptionPageObject viewOrder() {
        view.click();
        return new AdminOrderDescriptionPageObject(driver);
    }
}
