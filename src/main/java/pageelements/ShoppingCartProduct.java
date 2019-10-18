package pageelements;

import org.openqa.selenium.WebElement;

public class ShoppingCartProduct {
    private String productName;
    private String productModel;
    private String productsQuantity;
    private String unitPrice;
    private String totalPrice;
    private WebElement quantityInput;
    private WebElement buttonUpdate;
    private WebElement buttonRemove;

    ShoppingCartProduct(
            String name, String model, String quantity, String utilPrice, String totalPrice,
            WebElement quantityInput, WebElement buttonUpdate, WebElement buttonRemove) {
        this.productName = name;
        this.productModel = model;
        this.productsQuantity = quantity;
        this.unitPrice = utilPrice;
        this.totalPrice = totalPrice;
        this.quantityInput = quantityInput;
        this.buttonUpdate = buttonUpdate;
        this.buttonRemove = buttonRemove;
    }

    public ShoppingCartProduct removeProductsFromCart() {
        this.buttonRemove.click();
        return this;
    }

    public ShoppingCartProduct updateProductsFromCart() {
        this.buttonUpdate.click();
        return this;
    }

    public ShoppingCartProduct clearInputQuantity() {
        this.quantityInput.clear();
        return this;
    }

    public ShoppingCartProduct writeQuantity(String quantity) {
        this.quantityInput.sendKeys(quantity);
        return this;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }
}
