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
    private NavigationMenuPageObject navigationMenuPageObject;

    public CategoryPageObject(WebDriver driver, String productsXpath) {
        super(driver);
        this.productsXpath = productsXpath;
        filterPageObject = new FilterPageObject(this.driver, productsXpath);
        generateProductsPageObjects();
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

    public CategoryPageObject generateProductsList() {
        Product product;
        generateProductsPageObjects();
        products = new ArrayList<>();
        for (int i = 0; i < productsPO.size(); i++) {
            product = new Product();
            product.setId(productsPO.get(i).getIdOfProduct());
            product.setProductName(productsPO.get(i).getNameOfProduct());
            product.setSummary(productsPO.get(i).getDescriptionOfProduct());
            product.setPrise(productsPO.get(i).getPrice());
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


    public Double getNewPriceByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getPrice();
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

    public CategoryPageObject clickAddToWishListByID(Integer id) {
        for (int i = 0; i < productsPO.size(); i++) {
            if (productsPO.get(i).getIdOfProduct() == id) {
                productsPO.get(i).clickAddToWishList(productsXpath);
            }
        }
        return this;
    }

    public CategoryPageObject clickAddToWishListByNameOfProduct(String nameOfProduct) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(nameOfProduct)) {
                productsPO.get(i).clickAddToWishList(productsXpath);
            }
        }
        return this;
    }

    public CategoryPageObject clickAddToWishListByProduct(Product product) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(product.getProductName())) {
                productsPO.get(i).clickAddToWishList(productsXpath);
            }
        }
        return this;
    }

    public CategoryPageObject clickAddToCardByID(Integer id) {
        for (int i = 0; i < productsPO.size(); i++) {
            if (productsPO.get(i).getIdOfProduct() == id) {
                productsPO.get(i).clickAddToCardButton();
            }
        }
        return this;
    }

    public CategoryPageObject clickAddToCardByNameOfProduct(String nameOfProduct) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(nameOfProduct)) {
                productsPO.get(i).clickAddToCardButton();
            }
        }
        return this;
    }

    public CategoryPageObject clickAddToCardByProduct(Product product) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(product.getProductName())) {
                productsPO.get(i).clickAddToCardButton();
            }
        }
        return this;
    }

    public CategoryPageObject clickCompareThisProductByID(Integer id) {
        for (int i = 0; i < productsPO.size(); i++) {
            if (productsPO.get(i).getIdOfProduct() == id) {
                productsPO.get(i).clickCompareThisProduct(productsXpath);
            }
        }
        return this;
    }

    public CategoryPageObject clickCompareThisProductByNameOfProduct(String nameOfProduct) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(nameOfProduct)) {
                productsPO.get(i).clickCompareThisProduct(productsXpath);
            }
        }
        return this;
    }

    public CategoryPageObject clickCompareThisProductByProduct(Product product) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(product.getProductName())) {
                productsPO.get(i).clickCompareThisProduct(productsXpath);
            }
        }
        return this;
    }

    public Product getProductByID(Integer id) {
        generateProductsList();
        Product product = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                product = products.get(i);
            }
        }
        return product;
    }

    public Product getProductByPosition(Integer position) {
        return products.get(position);

    }

    public Product getProductByName(String name) {
        generateProductsList();
        Product product = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(name)) {
                product = products.get(i);
            }
        }
        return product;
    }

    public ArrayList<Product> getProducts() {
        generateProductsList();
        return products;
    }

    public NavigationMenuPageObject getNavigationMenuPageObject() {
        return navigationMenuPageObject;

    }

    public FilterPageObject getFilterPageObject() {
        filterPageObject = new FilterPageObject(this.driver, productsXpath);
        return filterPageObject;
    }
}
