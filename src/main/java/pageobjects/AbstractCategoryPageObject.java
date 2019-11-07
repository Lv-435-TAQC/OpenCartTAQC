package pageobjects;

import entity.Product;
import locators.CategoryLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Label;

import java.util.ArrayList;

public abstract class AbstractCategoryPageObject extends BasePageObject {
    private Label categoryNameLabel;
    private NavigationMenuPageObject navigationMenuPageObject;
    private HeaderPageObject headerPageObject;
    private MenuPageObject menuPageObject;


    public AbstractCategoryPageObject(WebDriver driver) {
        super(driver);
        navigationMenuPageObject = new NavigationMenuPageObject(driver);
        headerPageObject = new HeaderPageObject(driver);
        menuPageObject = new MenuPageObject(driver);
    }

    public abstract AbstractCategoryPageObject generateProductsPageObjects();

    public abstract AbstractCategoryPageObject generateProductsList();

    public abstract ItemInfoPageObject clickToImageByNumberOfProduct(int numberOfProduct);

    public abstract ItemInfoPageObject clickToLinkedNameByNumberOfProduct(int numberOfProduct);

    public abstract ItemInfoPageObject clickToAddToCardByNumberOfProduct(int numberOfProduct);

    public abstract AbstractCategoryPageObject clickAddToWishListByNumberOfProduct(int numberOfProduct);

    public abstract AbstractCategoryPageObject clickCompareThisProductByNumberOfProduct(int numberOfProduct);

    public abstract String getNameOfProductByNumberOfProduct(int numberOfProduct);

    public abstract String getDescriptionOfProductByNumberOfProduct(int numberOfProduct);

    public abstract Double getNewPriceByNumberOfProduct(int numberOfProduct);

    public abstract ArrayList<ProductUnitPageObject> getProductsPO();

    public abstract String getTextFromAlertLabel();

    public abstract AbstractCategoryPageObject clickAddToWishListByID(Integer id);

    public abstract AbstractCategoryPageObject clickAddToWishListByNameOfProduct(String nameOfProduct);

    public abstract AbstractCategoryPageObject clickAddToWishListByProduct(Product product);

    public abstract AbstractCategoryPageObject clickAddToCardByID(Integer id);

    public abstract AbstractCategoryPageObject clickAddToCardByNameOfProduct(String nameOfProduct);

    public abstract AbstractCategoryPageObject clickAddToCardByProduct(Product product);

    public abstract AbstractCategoryPageObject clickCompareThisProductByID(Integer id);

    public abstract AbstractCategoryPageObject clickCompareThisProductByNameOfProduct(String nameOfProduct);

    public abstract AbstractCategoryPageObject clickCompareThisProductByProduct(Product product);

    public abstract Product getProductByID(Integer id);

    public abstract Product getProductByPosition(Integer position);

    public abstract Product getProductByName(String name);

    public abstract ArrayList<Product> getProducts();

    public abstract FilterPageObject getFilterPageObject();

    public abstract String getMessageAboutProducts();

    public abstract String getMessageAboutEmptyPage();

    public abstract HomePageObject clickOnContinueButton();

    public String getCategoryName() {
        categoryNameLabel = new Label(driver, CategoryLocators.CATEGORY_NAME_LABEL_LOC);
        return categoryNameLabel.getText();
    }

    public NavigationMenuPageObject getNavigationMenuPageObject() {
        return navigationMenuPageObject;
    }

    public HeaderPageObject getHeaderPageObject() {
        return headerPageObject;
    }

    public MenuPageObject getMenuPageObject() {
        return menuPageObject;
    }
}
