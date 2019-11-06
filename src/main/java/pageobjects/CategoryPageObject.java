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
    }

    /**
     * List generator of web elements with every product on page
     *
     * @return list of web elements
     */
    private List<WebElement> getAllProductsElementsFromPage() {
        elements = driver.findElements(By.xpath(productsXpath));
        return elements;
    }

    /**
     * ArrayList generator with instances of product unit page objects for every product on page
     *
     * @return instance of this page object
     */
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

    /**
     * ArrayList generator with instances of product entities for every product on page
     *
     * @return instance of this page object
     */
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

    /**
     * Wrapper for click on image of product based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return instance of item page object
     */
    public ItemInfoPageObject clickToImageByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickProductImage();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Wrapper for click on name of product based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return instance of item page object
     */
    public ItemInfoPageObject clickToLinkedNameByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickLinkedProductName();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Wrapper for click on "Add to Card" button of product based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return instance of item page object
     */
    public ItemInfoPageObject clickToAddToCardByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickAddToCardButton();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Wrapper for click on "Add to Wish List" button of product based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToWishListByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickAddToWishList(productsXpath);
        return this;
    }

    /**
     * Wrapper for click on "Compare this Product" button of product based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return instance of item page object
     */
    public CategoryPageObject clickCompareThisProductByNumberOfProduct(int numberOfProduct) {
        productsPO.get(numberOfProduct - 1).clickCompareThisProduct(productsXpath);
        return this;
    }

    /**
     * Text getter of product name based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return name of product
     */
    public String getNameOfProductByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getNameOfProduct();
    }

    /**
     * Text getter of product description based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return description og product
     */
    public String getDescriptionOfProductByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getDescriptionOfProduct();
    }

    /**
     * Text getter of product price based on position on page
     *
     * @param numberOfProduct - position of product on page
     * @return price
     */
    public Double getNewPriceByNumberOfProduct(int numberOfProduct) {
        return productsPO.get(numberOfProduct - 1).getPrice();
    }

    /**
     * Getter of array list with product unit page objects
     *
     * @return array list with product unit page objects
     */
    public ArrayList<ProductUnitPageObject> getProductsPO() {
        return productsPO;
    }

    /**
     * Text getter from alert label on page
     *
     * @return text of label
     */
    public String getTextFromAlertLabel() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CategoryLocators.ALERT_LABEL_LOC)));
        alertLabel = new Label(this.driver, CategoryLocators.ALERT_LABEL_LOC);
        return alertLabel.getText();
    }

    /**
     * Text getter from category name label
     *
     * @return name of category
     */
    public String getCategoryName() {
        categoryNameLabel = new Label(driver, CategoryLocators.CATEGORY_NAME_LABEL_LOC);
        return categoryNameLabel.getText();
    }

    /**
     * Wrapper for click on "Add to Wish List" button of product based on id of product
     *
     * @param id - id of product
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToWishListByID(Integer id) {
        for (int i = 0; i < productsPO.size(); i++) {
            if (productsPO.get(i).getIdOfProduct() == id) {
                productsPO.get(i).clickAddToWishList(productsXpath);
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Add to Wish List" button of product based on name of product
     *
     * @param nameOfProduct - name of product
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToWishListByNameOfProduct(String nameOfProduct) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(nameOfProduct)) {
                productsPO.get(i).clickAddToWishList(productsXpath);
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Add to Wish List" button of product based on product entity
     *
     * @param product - entity of product
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToWishListByProduct(Product product) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(product.getProductName())) {
                productsPO.get(i).clickAddToWishList(productsXpath);
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Add to Card" button of product based on id of product
     *
     * @param id - id of product
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToCardByID(Integer id) {
        for (int i = 0; i < productsPO.size(); i++) {
            if (productsPO.get(i).getIdOfProduct() == id) {
                productsPO.get(i).clickAddToCardButton();
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Add to Card" button of product based on name of product
     *
     * @param nameOfProduct - name of product
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToCardByNameOfProduct(String nameOfProduct) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(nameOfProduct)) {
                productsPO.get(i).clickAddToCardButton();
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Add to Card" button of product based on product entity
     *
     * @param product - entity of product
     * @return instance of this page object
     */
    public CategoryPageObject clickAddToCardByProduct(Product product) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(product.getProductName())) {
                productsPO.get(i).clickAddToCardButton();
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Compare this Product" button of product based on id of product
     *
     * @param id - id of product
     * @return instance of this page object
     */
    public CategoryPageObject clickCompareThisProductByID(Integer id) {
        for (int i = 0; i < productsPO.size(); i++) {
            if (productsPO.get(i).getIdOfProduct() == id) {
                productsPO.get(i).clickCompareThisProduct(productsXpath);
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Compare this Product" button of product based on name of product
     *
     * @param nameOfProduct - name of product
     * @return instance of this page object
     */
    public CategoryPageObject clickCompareThisProductByNameOfProduct(String nameOfProduct) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().contains(nameOfProduct)) {
                productsPO.get(i).clickCompareThisProduct(productsXpath);
            }
        }
        return this;
    }

    /**
     * Wrapper for click on "Compare this Product" button of product based on product entity
     *
     * @param product - entity of product
     * @return instance of this page object
     */
    public CategoryPageObject clickCompareThisProductByProduct(Product product) {
        generateProductsList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (product.getId())) {
                productsPO.get(i).clickCompareThisProduct(productsXpath);
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CategoryLocators.ALERT_LABEL_LOC)));
        return this;
    }

    /**
     * Getter of product entity based on id of product
     *
     * @param id - id of product
     * @return product entity
     */
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

    /**
     * Getter of product entity based on position of product
     *
     * @param position - position of product
     * @return product entity
     */
    public Product getProductByPosition(Integer position) {
        generateProductsList();
        return products.get(position - 1);

    }

    /**
     * Getter of product entity based on name of product
     *
     * @param name - name of product
     * @return product entity
     */
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

    /**
     * ArrayList getter with entities of all products on page
     *
     * @return array list with product entities
     */
    public ArrayList<Product> getProducts() {
        generateProductsList();
        return products;
    }

    /**
     * Getter of navigation menu page object
     *
     * @return instance of navigation menu page object
     */

    public NavigationMenuPageObject getNavigationMenuPageObject() {
        return navigationMenuPageObject;

    }

    /**
     * Getter of filter page object
     *
     * @return instance of filter page object
     */
    public FilterPageObject getFilterPageObject() {
        filterPageObject = new FilterPageObject(this.driver, productsXpath);
        return filterPageObject;
    }
}
