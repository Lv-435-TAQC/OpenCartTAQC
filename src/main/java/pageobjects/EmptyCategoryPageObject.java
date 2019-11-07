package pageobjects;

import entity.Product;
import locators.CategoryLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Label;
import pageelements.TextButton;

import java.util.ArrayList;

public class EmptyCategoryPageObject extends AbstractCategoryPageObject {
    private TextButton continueButton;
    private Label pageStatusLabel;

    public EmptyCategoryPageObject(WebDriver driver) {
        super(driver);
    }

    @Override
    public EmptyCategoryPageObject generateProductsPageObjects() {
        return this;
    }

    @Override
    public EmptyCategoryPageObject generateProductsList() {
        return this;
    }

    @Override
    public ItemInfoPageObject clickToImageByNumberOfProduct(int numberOfProduct) {
        return null;
    }

    @Override
    public ItemInfoPageObject clickToLinkedNameByNumberOfProduct(int numberOfProduct) {
        return null;
    }

    @Override
    public ItemInfoPageObject clickToAddToCardByNumberOfProduct(int numberOfProduct) {
        return null;
    }

    @Override
    public EmptyCategoryPageObject clickAddToWishListByNumberOfProduct(int numberOfProduct) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickCompareThisProductByNumberOfProduct(int numberOfProduct) {
        return this;
    }

    @Override
    public String getNameOfProductByNumberOfProduct(int numberOfProduct) {
        return null;
    }

    @Override
    public String getDescriptionOfProductByNumberOfProduct(int numberOfProduct) {
        return null;
    }

    @Override
    public Double getNewPriceByNumberOfProduct(int numberOfProduct) {
        return null;
    }

    @Override
    public ArrayList<ProductUnitPageObject> getProductsPO() {
        return null;
    }

    @Override
    public String getTextFromAlertLabel() {
        return null;
    }

    @Override
    public EmptyCategoryPageObject clickAddToWishListByID(Integer id) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickAddToWishListByNameOfProduct(String nameOfProduct) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickAddToWishListByProduct(Product product) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickAddToCardByID(Integer id) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickAddToCardByNameOfProduct(String nameOfProduct) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickAddToCardByProduct(Product product) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickCompareThisProductByID(Integer id) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickCompareThisProductByNameOfProduct(String nameOfProduct) {
        return this;
    }

    @Override
    public EmptyCategoryPageObject clickCompareThisProductByProduct(Product product) {
        return this;
    }

    @Override
    public Product getProductByID(Integer id) {
        return null;
    }

    @Override
    public Product getProductByPosition(Integer position) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }

    @Override
    public NavigationMenuPageObject getNavigationMenuPageObject() {
        return null;
    }

    @Override
    public FilterPageObject getFilterPageObject() {
        return null;
    }

    @Override
    public String getMessageAboutProducts() {
        return null;
    }

    @Override
    public String getMessageAboutEmptyPage() {
        pageStatusLabel = new Label(this.driver, CategoryLocators.PAGE_STATUS_LABEL);
        return pageStatusLabel.getText();
    }

    @Override
    public HomePageObject clickOnContinueButton() {
        continueButton = new TextButton(this.driver, CategoryLocators.CONTINUE_BUTTON_LOC);
        continueButton.click();
        return new HomePageObject(this.driver);
    }

}
