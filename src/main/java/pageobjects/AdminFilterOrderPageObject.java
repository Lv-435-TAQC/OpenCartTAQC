package pageobjects;

import locators.AdminFilterOrderLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;

public class AdminFilterOrderPageObject extends BasePageObject {
    private Input orderIdField;
    private Input customerField;
    private Input totalField;
    private Input dateAddedField;
    private Input dateModifiedField;
    private Button filterButton;
    private DropDown selectOrderStatus;

    public AdminFilterOrderPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminFilterOrderPageObject setOrderId(String orderId) {
        orderIdField = new Input(this.driver, AdminFilterOrderLocators.ORDER_ID);
        orderIdField.setText(orderId);
        return this;
    }

    public AdminFilterOrderPageObject setCustomer(String customer) {
        customerField = new Input(this.driver, AdminFilterOrderLocators.CUSTOMER);
        customerField.setText(customer);
        return this;
    }

    public AdminFilterOrderPageObject setTotal(String total) {
        totalField = new Input(this.driver, AdminFilterOrderLocators.TOTAL);
        totalField.setText(total);
        return this;
    }
    public AdminFilterOrderPageObject setDateAdded(String dateAdded) {
        dateAddedField = new Input(this.driver, AdminFilterOrderLocators.DATE_ADDED);
        dateAddedField.setText(dateAdded);
        return this;
    }

    public AdminFilterOrderPageObject setDateModified(String dateModified) {
        dateModifiedField = new Input(this.driver, AdminFilterOrderLocators.DATE_MODIFIED);
        dateModifiedField.setText(dateModified);
        return this;
    }

    public AdminFilterOrderPageObject selectOrderStatus(String orderStatus) {
        selectOrderStatus = new DropDown(this.driver, AdminFilterOrderLocators.ORDER_STATUS);
        selectOrderStatus.writeOptionParameter(orderStatus);
        return this;
    }

    public AdminFilterOrderPageObject clickContinueButton() {
        filterButton = new Button(this.driver, AdminFilterOrderLocators.FILTER);
        filterButton.click();
        return this;
    }


}
