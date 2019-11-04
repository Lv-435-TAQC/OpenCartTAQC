package pageobjects;

import locators.ProductUnitLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.*;

public class ProductUnitPageObject extends BasePageObject {
    private LinkedImage productImage;
    private LinkedLabel linkedProductName;
    private Label descriptionOfProduct;
    private Label priceOfProduct;
    private ImageTextButton addToCartButton;
    private ImageButton addToWishListButton;
    private ImageButton compareThisProductButton;
    private WebElement elementToParse;

    public ProductUnitPageObject(WebDriver driver, WebElement elementToParse) {
        super(driver);
        this.elementToParse = elementToParse;
    }

    public ItemInfoPageObject clickProductImage() {
        productImage = new LinkedImage(elementToParse, ProductUnitLocators.IMAGE_LOC);
        productImage.click();
        return new ItemInfoPageObject(driver);
    }

    public ItemInfoPageObject clickLinkedProductName() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.LINKED_NAME_LOC);
        linkedProductName.click();
        return new ItemInfoPageObject(driver);
    }

    public ItemInfoPageObject clickAddToCardButton() {
        addToCartButton = new ImageTextButton(elementToParse, ProductUnitLocators.ADD_TO_CARD_BUTTON_LOC);
        addToCartButton.click();
        return new ItemInfoPageObject(driver);
    }

    public String getDescriptionOfProduct() {
        descriptionOfProduct = new Label(elementToParse, ProductUnitLocators.DESCRIPTION_OF_PRODUCT_LOC);
        return descriptionOfProduct.getText().replaceAll("..", "");
    }

    public String getPrice() {
        priceOfProduct = new Label(elementToParse, ProductUnitLocators.NEW_PRICE_LOC);
        System.out.println(priceOfProduct.getText());
        String price = priceOfProduct.getText().replaceAll("Ex Tax:", "").replaceAll(",", "");
        System.out.println(price);
        return price.substring(1, price.indexOf(" "));
    }

    public CategoryPageObject clickAddToWishList(String xpath) {
        addToWishListButton = new ImageButton(elementToParse, ProductUnitLocators.ADD_TO_WISH_LIST_BUTTON_LOC);
        addToWishListButton.click();
        return new CategoryPageObject(this.driver, xpath);
    }

    public CategoryPageObject clickCompareThisProduct(String xpath) {
        compareThisProductButton = new ImageButton(elementToParse, ProductUnitLocators.COMPARE_THIS_PRODUCT_BUTTON_LOC);
        compareThisProductButton.click();
        return new CategoryPageObject(this.driver, xpath);
    }

    public String getNameOfProduct() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.LINKED_NAME_LOC);
        return linkedProductName.getText();
    }

    public Integer getIdOfProduct() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.HREF_NAME_LOC);
        return Integer.parseInt(linkedProductName.getAttribute("href").split("=")[3]);
    }
}
