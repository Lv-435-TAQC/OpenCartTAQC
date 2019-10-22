package pageobjects;

import locators.CategoryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Label;

import java.util.ArrayList;
import java.util.List;

public class CategoryPageObject extends BasePageObject {
    private Label categoryNameLabel;
    private List<WebElement> elements;
    private Label alertLabel;
    private ArrayList<ProductUnitPageObject> products;
    private FilterPageObject filterPageObject;
    private String productsXpath;

    public CategoryPageObject(WebDriver driver, String productsXpath) {
        super(driver);
        this.productsXpath = productsXpath;
        filterPageObject = new FilterPageObject(this.driver);
    }


    private List<WebElement> getAllProductsElementsFromPage() {
        elements = driver.findElements(By.xpath(productsXpath));
        return elements;
    }

    public CategoryPageObject generateProductsPageObject() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productsXpath)));
        products = new ArrayList<ProductUnitPageObject>();
        getAllProductsElementsFromPage();
        for (int i = 0; i < elements.size(); i++) {
            products.add(new ProductUnitPageObject(this.driver, elements.get(i)));
        }
        return this;
    }

    public ItemInfoPageObject clickToImageByNumberOfProduct(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickProductImage();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickToLinkedNameOfProduct(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickLinkedProductName();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickToAddToCard(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickAddToCardButton();
        return new ItemInfoPageObject(this.driver);
    }

    public CategoryPageObject clickAddToWishList(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickAddToWishList();
        return this;
    }

    public CategoryPageObject clickCompareThisProduct(int numberOfProduct) {
        products.get(numberOfProduct - 1).clickCompareThisProduct();
        return this;
    }

    public String getNameOfProduct(int numberOfProduct) {
        return products.get(numberOfProduct-1).getNameOfProduct();
    }

    public String getDescriptionOfProduct(int numberOfProduct) {
        return products.get(numberOfProduct - 1).getDescriptionOfProduct();
    }

    public String getOldPrice(int numberOfProduct) {
        return products.get(numberOfProduct - 1).getOldPrice();
    }

    public String getNewPrice(int numberOfProduct) {
        return products.get(numberOfProduct - 1).getNewPrice();
    }

    public String getExTax(int numberOfProduct) {
        return products.get(numberOfProduct - 1).getExTax();
    }

    public CategoryPageObject clickListButton() {
        filterPageObject.clickListButton();
        generateProductsPageObject();
        return this;
    }

    public CategoryPageObject clickGridButton() {
        filterPageObject.clickGridButton();
        generateProductsPageObject();
        return this;
    }

    public CategoryPageObject clickProductCompere() {
        filterPageObject.clickProductCompare();
        generateProductsPageObject();
        return this;
    }

    public CategoryPageObject choseSortBySelectorByParam(String param) {
        filterPageObject.choseSortBySelectorByParam(param);
        generateProductsPageObject();
        return this;
    }

    public CategoryPageObject choseSortBySelectorByID(int id) {
        filterPageObject.choseSortBySelectorByID(id);
        generateProductsPageObject();
        return this;
    }

    public CategoryPageObject choseShowSelectorByParam(String param) {
        filterPageObject.choseShowSelectorByParam(param);
        generateProductsPageObject();
        return this;
    }

    public CategoryPageObject choseShowSelectorByID(int id) {
        filterPageObject.choseShowSelectorByID(id);
        generateProductsPageObject();
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

    public String getTextFromAlertLabel() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CategoryLocators.ALERT_LABEL_LOC)));
        alertLabel = new Label(this.driver, CategoryLocators.ALERT_LABEL_LOC);
        return alertLabel.getText();
    }
    public String getCategoryName(){
        categoryNameLabel = new Label(driver, CategoryLocators.CATEGORY_NAME_LABEL_LOC);
        return categoryNameLabel.getText();
    }
}
