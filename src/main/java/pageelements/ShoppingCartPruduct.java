package pageelements;

import org.openqa.selenium.WebElement;

public class ShoppingCartPruduct {
    public String productName;
    public String productModel;
    public String producsQuantity;
    public String unitPrice;
    public String totalPrice;
    private WebElement quantityInput;
    private WebElement buttonUpdate;
    private WebElement buttonRemove;
    ShoppingCartPruduct(
            String name, String model, String quantyty, String utilPrice, String totalPrice,
            WebElement quantytyInput,WebElement buttonUpdate, WebElement buttonRemove ){
        this.productName = name;
        this.productModel = model;
        this.producsQuantity = quantyty;
        this.unitPrice = utilPrice;
        this.totalPrice = totalPrice;
        this.quantityInput = quantytyInput;
        this.buttonUpdate = buttonUpdate;
        this.buttonRemove = buttonRemove;
    }
     public ShoppingCartPruduct removeProductsFromCart(){
        this.buttonRemove.click();
        return this;
    }
    public ShoppingCartPruduct updateProductsFromCart(){
        this.buttonUpdate.click();
        return this;
    }
    public ShoppingCartPruduct clearInputQuantyty(){
        this.quantityInput.clear();
        return this;
    }
    public ShoppingCartPruduct writeQuantyty(String quantity){
        this.quantityInput.sendKeys(quantity);
        return this;
    }
    public String getTotalPrice(){
        return this.totalPrice;
    }
}
