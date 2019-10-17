package pageobjects;

import locators.ProductUnitLocators;
import org.openqa.selenium.By;
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
    }

    public ItemPageObject clickProductImage() {
        productImage = (LinkedImage) elementToParse.findElement(By.xpath(ProductUnitLocators.IMAGE_LOC));
        productImage.click();
        return new ItemPageObject(driver);
    }

    public ItemPageObject clickLinkedProductName() {
        linkedProductName = (LinkedLabel) elementToParse.findElement(By.xpath(ProductUnitLocators.LINKED_NAME_LOC));
        linkedProductName.click();
        return new ItemPageObject(driver);
    }

    public ItemPageObject clickAddToCardButton() {
        addToCartButton = (ImageTextButton) elementToParse.findElement(By.xpath(ProductUnitLocators.ADD_TO_CARD_BUTTON_LOC));
        addToCartButton.click();
        return new ItemPageObject(driver);
    }

    public String getDescriptionOfProduct() {
        descriptionOfProduct = (Label) elementToParse.findElement(By.xpath(ProductUnitLocators.DESCRIPTION_OF_PRODUCT_LOC));
        return descriptionOfProduct.getText();
    }

    public String getNewPrice() {
        priceNew = (Label) elementToParse.findElement(By.xpath(ProductUnitLocators.NEW_PRICE_LOC));
        return priceNew.getText();
    }

    public String getOldPrice() {
        priceOld = (Label) elementToParse.findElement(By.xpath(ProductUnitLocators.OLD_PRICE_LOC));
        return priceOld.getText();
    }

    public String getExTax() {
        exTax = (Label) elementToParse.findElement(By.xpath(ProductUnitLocators.EX_TAX_LOC));
        return exTax.getText();
    }

    public CategoryPageObject clickAddToWishList() {
        addToWishListButton = (ImageButton) elementToParse.findElement(By.xpath(ProductUnitLocators.ADD_TO_WISH_LIST_BUTTON_LOC));
        addToWishListButton.click();
        return new CategoryPageObject(this.driver);
    }

    public CategoryPageObject clickCompareThisProduct() {
        compareThisProductButton = (ImageButton) elementToParse.findElement(By.xpath(ProductUnitLocators.COMPARE_THIS_PRODUCT_BUTTON_LOC));
        compareThisProductButton.click();
        return new CategoryPageObject(this.driver);
    }
    public String getNameOfProduct(){
        linkedProductName = (LinkedLabel) elementToParse.findElement(By.xpath(ProductUnitLocators.LINKED_NAME_LOC));
        return linkedProductName.getText();
    }

}
