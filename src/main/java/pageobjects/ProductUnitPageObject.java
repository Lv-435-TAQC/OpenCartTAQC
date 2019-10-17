package pageobjects;

import locators.ProductUnitLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.*;

public class ProductUnitPageObject extends BasePageObject {
    private LinkedImage productImage;
    private LinkedLabel linkedProductName;
    private Label descriptionOfProduct;
    private Label priceNew;
    private Label priceOld;
    private Label exTax;
    private ImageTextButton addToCartButton;
    private ImageButton addToWishListButton;
    private ImageButton compareThisProductButton;
    private WebElement elementToParse;

    public ProductUnitPageObject(WebDriver driver, WebElement elementToParse) {
        super(driver);
        this.elementToParse = elementToParse;
    }

    public ItemPageObject clickProductImage() {
        productImage = new LinkedImage(elementToParse, ProductUnitLocators.IMAGE_LOC);
        productImage.click();
        return new ItemPageObject(driver);
    }

    public ItemPageObject clickLinkedProductName() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.LINKED_NAME_LOC);
        linkedProductName.click();
        return new ItemPageObject(driver);
    }

    public ItemPageObject clickAddToCardButton() {
        addToCartButton = new ImageTextButton(elementToParse, ProductUnitLocators.ADD_TO_CARD_BUTTON_LOC);
        addToCartButton.click();
        return new ItemPageObject(driver);
    }

    public String getDescriptionOfProduct() {
        descriptionOfProduct = new Label(elementToParse, ProductUnitLocators.DESCRIPTION_OF_PRODUCT_LOC);
        return descriptionOfProduct.getText();
    }

    public String getNewPrice() {
        priceNew = new Label(elementToParse, ProductUnitLocators.NEW_PRICE_LOC);
        return priceNew.getText();
    }

    public String getOldPrice() {
        priceOld = new Label(elementToParse, ProductUnitLocators.OLD_PRICE_LOC);
        return priceOld.getText();
    }

    public String getExTax() {
        exTax = new Label(elementToParse, ProductUnitLocators.EX_TAX_LOC);
        return exTax.getText();
    }

    public CategoryPageObject clickAddToWishList() {
        addToWishListButton = new ImageButton(elementToParse, ProductUnitLocators.ADD_TO_WISH_LIST_BUTTON_LOC);
        addToWishListButton.click();
        return new CategoryPageObject(this.driver);
    }

    public CategoryPageObject clickCompareThisProduct() {
        compareThisProductButton = new ImageButton(elementToParse, ProductUnitLocators.COMPARE_THIS_PRODUCT_BUTTON_LOC);
        compareThisProductButton.click();
        return new CategoryPageObject(this.driver);
    }

    public String getNameOfProduct() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.LINKED_NAME_LOC);
        return linkedProductName.getText();
    }

}
