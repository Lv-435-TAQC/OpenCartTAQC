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

    /**
     * Wrapper for click on Product image
     *
     * @return instance of item info page object
     */
    public ItemInfoPageObject clickProductImage() {
        productImage = new LinkedImage(elementToParse, ProductUnitLocators.IMAGE_LOC);
        productImage.click();
        return new ItemInfoPageObject(driver);
    }

    /**
     * Wrapper for click on Product name
     *
     * @return instance of item info page object
     */
    public ItemInfoPageObject clickLinkedProductName() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.LINKED_NAME_LOC);
        linkedProductName.click();
        return new ItemInfoPageObject(driver);
    }

    /**
     * Wrapper for click on "ADD TO CARD" button
     *
     * @return instance of item info page object
     */
    public ItemInfoPageObject clickAddToCardButton() {
        addToCartButton = new ImageTextButton(elementToParse, ProductUnitLocators.ADD_TO_CARD_BUTTON_LOC);
        addToCartButton.click();
        return new ItemInfoPageObject(driver);
    }

    /**
     * Text getter with description of product
     *
     * @return description of product
     */
    public String getDescriptionOfProduct() {
        descriptionOfProduct = new Label(elementToParse, ProductUnitLocators.DESCRIPTION_OF_PRODUCT_LOC);
        String summary = descriptionOfProduct.getText();
        return summary.substring(0, summary.length() - 2);
    }

    /**
     * Text getter and cast to Double type actual value from label with price
     *
     * @return price in double type
     */
    public Double getPrice() {
        priceOfProduct = new Label(elementToParse, ProductUnitLocators.NEW_PRICE_LOC);
        String price = priceOfProduct.getText().replaceAll("Ex Tax:", "").replaceAll(",", "");
        return Double.parseDouble(price.substring(1, price.indexOf(" ")));
    }

    /**
     * Wrapper for click on "Add to Wish List" button
     *
     * @param xpath - xpath for category po structure
     * @return instance of  category page object
     */
    public CategoryPageObject clickAddToWishList(String xpath) {
        addToWishListButton = new ImageButton(elementToParse, ProductUnitLocators.ADD_TO_WISH_LIST_BUTTON_LOC);
        addToWishListButton.click();
        return new CategoryPageObject(this.driver, xpath);
    }

    /**
     * Wrapper for click on "Compare this Product" button
     *
     * @param xpath - xpath for category po structure
     * @return instance of  category page object
     */
    public CategoryPageObject clickCompareThisProduct(String xpath) {
        compareThisProductButton = new ImageButton(elementToParse, ProductUnitLocators.COMPARE_THIS_PRODUCT_BUTTON_LOC);
        compareThisProductButton.click();
        return new CategoryPageObject(this.driver, xpath);
    }

    /**
     * Text getter with name of product
     *
     * @return name of product
     */
    public String getNameOfProduct() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.LINKED_NAME_LOC);
        return linkedProductName.getText();
    }

    /**
     * Id getter from attribute in link for product
     *
     * @return id of product
     */
    public Integer getIdOfProduct() {
        linkedProductName = new LinkedLabel(elementToParse, ProductUnitLocators.HREF_NAME_LOC);
        return Integer.parseInt(linkedProductName.getAttribute("href").split("=")[3].replace("&sort", ""));
    }
}
