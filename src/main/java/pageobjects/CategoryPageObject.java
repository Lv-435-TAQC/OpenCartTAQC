package pageobjects;

import entity.Product;
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
    private ArrayList<ProductUnitPageObject> productsPO;
    private ArrayList<Product> products;
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

    public CategoryPageObject generateProductsPageObjects() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productsXpath)));
        productsPO = new ArrayList<ProductUnitPageObject>();
        getAllProductsElementsFromPage();
        for (int i = 0; i < elements.size(); i++) {
            productsPO.add(new ProductUnitPageObject(this.driver, elements.get(i)));
        }
        return this;
    }

    public CategoryPageObject generateProductsList(){
        Product product;
        generateProductsPageObjects();
        for (int i = 0; i < productsPO.size(); i++) {
            product = new Product();
            product.setId(Integer.parseInt(productsPO.get(i).getIdOfProduct()));
            product.setProductName(productsPO.get(i).getNameOfProduct());
            product.setDimensions(productsPO.get(i).getDescriptionOfProduct());
            products.add(product);
        }
        return this;
    }

    public ItemInfoPageObject clickToImageByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickProductImage();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickToLinkedNameByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickLinkedProductName();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickToAddToCardByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickAddToCardButton();
        return new ItemInfoPageObject(this.driver);
    }

    public CategoryPageObject clickAddToWishListByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickAddToWishList(productsXpath);
        return this;
    }

    public CategoryPageObject clickCompareThisProductByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickCompareThisProduct(productsXpath);
        return this;
    }

    public String getNameOfProductByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getNameOfProduct();
    }

    public String getDescriptionOfProductByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getDescriptionOfProduct();
    }

    public String getOldPriceByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getOldPrice();
    }

    public String getNewPriceByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getNewPrice();
    }

    public String getExTaxByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getExTax();
    }

    public CategoryPageObject clickListButton() {
        filterPageObject.clickListButton();
        generateProductsPageObjects();
        return this;
    }

    public CategoryPageObject clickGridButton() {
        filterPageObject.clickGridButton();
        generateProductsPageObjects();
        return this;
    }

    public CategoryPageObject clickProductCompere() {
        filterPageObject.clickProductCompare();
        generateProductsPageObjects();
        return this;
    }

    public CategoryPageObject choseSortBySelectorByParam(String param) {
        filterPageObject.choseSortBySelectorByParam(param);
        generateProductsPageObjects();
        return this;
    }

    public CategoryPageObject choseSortBySelectorByID(int id) {
        filterPageObject.choseSortBySelectorByID(id);
        generateProductsPageObjects();
        return this;
    }

    public CategoryPageObject choseShowSelectorByParam(String param) {
        filterPageObject.choseShowSelectorByParam(param);
        generateProductsPageObjects();
        return this;
    }

    public CategoryPageObject choseShowSelectorByID(int id) {
        filterPageObject.choseShowSelectorByID(id);
        generateProductsPageObjects();
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

    public ArrayList<ProductUnitPageObject> getProductsPO() {
        return productsPO;
    }

    public String getTextFromAlertLabel() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CategoryLocators.ALERT_LABEL_LOC)));
        alertLabel = new Label(this.driver, CategoryLocators.ALERT_LABEL_LOC);
        return alertLabel.getText();
    }

    public String getCategoryName() {
        categoryNameLabel = new Label(driver, CategoryLocators.CATEGORY_NAME_LABEL_LOC);
        return categoryNameLabel.getText();
    }
}
