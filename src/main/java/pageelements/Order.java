package pageelements;

import org.openqa.selenium.WebDriver;
import pageobjects.AdminOrderDescriptionPageObject;

public class Order {
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
            String orderID, String customer, String status, String total, String dateAdded,
            String dateModified, Button view, Button deleteAndEdit, Button delete, Button edit) {
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

    public AdminOrderDescriptionPageObject viewOrder(WebDriver driver) {
        view.click();
        return new AdminOrderDescriptionPageObject(driver);
    }
}
