package pageobjects;

import locators.CategoryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CategoryPageObject extends BasePageObject {

    ArrayList<ProductUnitPageObject> products;
    HeaderPageObject headerPageObject;
    MenuPageObject menuPageObject;
    FilterPageObject filterPageObject;


    public CategoryPageObject(WebDriver driver) {
        super(driver);
        filterPageObject = new FilterPageObject(this.driver);
    }


    public ArrayList<WebElement> getAllProductsElementsFromPage() {
        ArrayList<WebElement> elements = new ArrayList<WebElement>();
        elements.addAll(this.driver.findElements(By.xpath(CategoryLocators.ALL_PRODUCTS_DIV_LOC)));
        return elements;
    }

    public CategoryPageObject generateProductsPageObject() {
        ArrayList<WebElement> elements = getAllProductsElementsFromPage();
        for (int i = 0; i < elements.size(); i++) {
            products.add(new ProductUnitPageObject(this.driver, elements.get(i)));
        }
        return this;
    }

    public ItemPageObject clickToImageByNumberOfProduct(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickProductImage();
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject clickToLinkedNameOfProduct(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickLinkedProductName();
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject clickToAddToCard(int numberOfProduct) {
        products.get(numberOfProduct-1).clickAddToCardButton();
        return new ItemPageObject(this.driver);
    }

    public CategoryPageObject clickAddToWishList(int numberOfProduct) {
        products.get(numberOfProduct-1).clickAddToWishList();
        return this;
    }

    public CategoryPageObject clickCompareThisProduct(int numberOfProduct) {
        products.get(numberOfProduct-1).clickCompareThisProduct();
        return this;
    }

    public String getNameOfProduct(int numberOfProduct) {
        return products.get(numberOfProduct).getNameOfProduct();
    }

    public String getDescriptionOfProduct(int numberOfProduct) {
        return products.get(numberOfProduct-1).getDescriptionOfProduct();
    }

    public String getOldPrice(int numberOfProduct) {
        return products.get(numberOfProduct-1).getOldPrice();
    }

    public String getNewPrice(int numberOfProduct) {
        return products.get(numberOfProduct-1).getNewPrice();
    }

    public String getExTax(int numberOfProduct) {
        return products.get(numberOfProduct-1).getExTax();
    }

    public CategoryPageObject clickListButton() {
        filterPageObject.clickListButton();
        return this;
    }

    public CategoryPageObject clickGridButton() {
        filterPageObject.clickGridButton();
        return this;
    }

    public CategoryPageObject clickProductCompere() {
        filterPageObject.clickProductCompare();
        return this;
    }

    public CategoryPageObject choseSortBySelectorByParam(String param) {
        filterPageObject.choseSortBySelectorByParam(param);
        return this;
    }

    public CategoryPageObject choseSortBySelectorByID(int id) {
        filterPageObject.choseSortBySelectorByID(id);
        return this;
    }

    public CategoryPageObject choseShowSelectorByParam(String param) {
        filterPageObject.choseShowSelectorByParam(param);
        return this;
    }

    public CategoryPageObject choseShowSelectorByID(int id) {
        filterPageObject.choseShowSelectorByID(id);
        return this;
    }

    public String getShowLabelText() {
        return filterPageObject.getShowLabelText();
    }

    public String getSortByLabelText() {
        return filterPageObject.getSortByLabelText();
    }

    public String getProductCompareText() {
        return filterPageObject.getProductCompareText();
    }

    public ArrayList<ProductUnitPageObject> getProducts() {
        return products;
    }
}
