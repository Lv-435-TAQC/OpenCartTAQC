package pageobjects;

import entity.Product;
import locators.CompareProductLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Label;
import pageelements.LinkedLabel;
import pageelements.TextButton;

import java.util.ArrayList;
import java.util.List;

public class CompareProductPageObject extends BasePageObject {
    private ArrayList<Product> products;
    private List<WebElement> rowsOfTable;
    private ArrayList<LinkedLabel> productNameList;
    private ArrayList<Label> priceList;
    private ArrayList<Label> modelList;
    private ArrayList<Label> brandsList;
    private ArrayList<Label> availabilityList;
    private ArrayList<Label> ratingList;
    private ArrayList<Label> summaryList;
    private ArrayList<Label> weightList;
    private ArrayList<Label> dimensionList;
    private ArrayList<TextButton> addToCardButtonList;
    private ArrayList<TextButton> removeButtonList;
    private Label emptyPageLabel;

    public CompareProductPageObject(WebDriver driver) {
        super(driver);
        generateListsWithInfo();
    }

    /**
     * This methods is colling methods with generating rows with info form table on Compare Product page.
     *
     * @return instance of this page object;
     */
    public CompareProductPageObject generateListsWithInfo() {
        getRowsOfTable()
                .generateProductNamesLinkedLabelList()
                .generateProductPriceLabelList()
                .generateProductModelLabelList()
                .generateProductBrandsLabelList()
                .generateProductAvailabilityLabelList()
                .generateProductRatingLabelList()
                .generateProductSummaryLabelList()
                .generateProductWeightLabelList()
                .generateProductDimensionsLabelList()
                .generateButtonLists();
        return this;
    }

    /**
     * It`s getter of object in class, which previously call method with generating this list.
     *
     * @return array list with Products entities from Compare Product page;
     */
    public ArrayList<Product> getProductList() {
        generateProductList();
        return products;
    }

    /**
     * This method sets info into Product entity from table on Compare Product page
     * and add it one by one to list with products.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductList() {

        generateListsWithInfo();
        products = new ArrayList<>();
        Product product;
        for (int i = 0; i < productNameList.size(); i++) {
            product = new Product();
            product.setId(Integer.parseInt(productNameList.get(i).getAttribute("href").split("=")[2]));
            product.setProductName(productNameList.get(i).getText());
            if (priceList.get(i).getText().contains(" ")) {
                product.setPrise(Double.parseDouble(priceList.get(i).getText()
                        .split(" ")[1]
                        .replace("$", "")
                        .replace(",", "")));
            } else {
                product.setPrise(Double.parseDouble(priceList.get(i).getText()
                        .replace("$", "")
                        .replace(",", "")));
            }
            product.setSummary(summaryList.get(i).getText());
            product.setModel(modelList.get(i).getText());
            product.setBrands(brandsList.get(i).getText());
            product.setAvailability(availabilityList.get(i).getText());
            product.setRating(ratingList.get(i).getText());
            product.setWeight(Double.parseDouble(weightList
                    .get(i)
                    .getText()
                    .replace("k", "")
                    .replace("g", "")));
            product.setDimensions(dimensionList.get(i).getText());
            products.add(product);
        }
        return this;
    }

    /**
     * This method get all rows from table on Compare Product page and set it to list of web elements.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject getRowsOfTable() {
        rowsOfTable = driver.findElements(By.xpath(CompareProductLocators.TBODY_WITH_PRODUCT_INFO_LOC));
        return this;
    }

    /**
     * This method generate list of LinkedLabel objects with names of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */

    private CompareProductPageObject generateProductNamesLinkedLabelList() {
        int row = 0;
        productNameList = new ArrayList<>();
        for (int i = 1; i < getSubElements(row).size(); i++) {
            productNameList.add(new LinkedLabel(getSubElements(row).get(i), CompareProductLocators.NAME_LINKED_LABEL_SUB_LOC));
        }
        return this;
    }

    /**
     * This method generate list of Label objects with price of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductPriceLabelList() {
        int row = 2;
        priceList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with model of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductModelLabelList() {
        int row = 3;
        modelList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with brand of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductBrandsLabelList() {
        int row = 4;
        brandsList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with availability of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductAvailabilityLabelList() {
        int row = 5;
        availabilityList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with rating of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductRatingLabelList() {
        int row = 6;
        ratingList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with summary of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductSummaryLabelList() {
        int row = 7;
        summaryList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with weight of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductWeightLabelList() {
        int row = 8;
        weightList = getLabelList(row);
        return this;
    }

    /**
     * This method generate list of Label objects with dimension of product
     * from Compare Product page, based on parsing row.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateProductDimensionsLabelList() {
        int row = 9;
        dimensionList = getLabelList(row);
        return this;
    }

    /**
     * This method generate two list of Buttons objects
     * with add to card and remove buttons
     * from Compare Product page, based on parsing td tag int tbody/tr.
     *
     * @return instance of this page object;
     */
    private CompareProductPageObject generateButtonLists() {
        List<WebElement> elements = driver.findElements(By.xpath(CompareProductLocators.TR_WITH_BUTTONS_LOC));
        removeButtonList = new ArrayList<>();
        addToCardButtonList = new ArrayList<>();
        for (int i = 1; i < elements.size(); i++) {
            addToCardButtonList.add(new TextButton(elements.get(i), CompareProductLocators.ADD_TO_CART_BUTTON_LOC));
            removeButtonList.add(new TextButton(elements.get(i), CompareProductLocators.REMOVE_BUTTON_LOC));
        }
        return this;
    }

    /**
     * This method is universal to parse one row of table, to find all Labels in row.
     * It was done to remove duplicated code from methods.
     *
     * @param row - it`s row which we will parse for labels;
     * @return array list with Labels from this row;
     */
    private ArrayList<Label> getLabelList(int row) {
        ArrayList<Label> labelList = new ArrayList<>();
        for (int i = 1; i < getSubElements(row).size(); i++) {
            labelList.add(new Label(getSubElements(row).get(i)));
        }
        return labelList;
    }

    /**
     * This method is universal to parse one row of table, to find all WebElements in row.
     * It was done to remove duplicated code from methods.
     *
     * @param row - it`s row which we will parse for WebElements;
     * @return list with WebElements in row
     */
    private List<WebElement> getSubElements(int row) {
        return rowsOfTable.get(row).findElements(By.xpath(CompareProductLocators.ELEMENT_SUB_LOC));
    }

    /**
     * It`s wrapper of click method to "Add to Cart" button on Compare Product page
     *
     * @param product - it`s product entity, which we want to add to card with button
     * @return ItemInfoPageObject with detail info about product
     */
    public ItemInfoPageObject clickAddToCartButton(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                addToCardButtonList.get(i).click();
            }
        }
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * It`s wrapper of click method to "Remove" button on Compare Product page
     *
     * @param product - it`s product entity, which we want to remove from Compare Product page
     * @return instance of this page object
     */
    public CompareProductPageObject clickRemoveButton(Product product) {
        generateProductList();
        for (int i = 0; i < removeButtonList.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                removeButtonList.get(i).click();
            }
        }
        return this;
    }

    /**
     * It`s wrapper of click method to product name LinkedLabel
     *
     * @param product - it`s product entity, for name of which we want to click
     * @return ItemInfoPageObject with detail info about product
     */

    public ItemInfoPageObject clickProductNameLabel(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                addToCardButtonList.get(i).click();
            }
        }
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Simple getter of text from label, when page is without products
     *
     * @return text from label
     */
    public String getTextAboutEmptyPage() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CompareProductLocators.EMPTY_PAGE_LABEL_LOC)));
        emptyPageLabel = new Label(driver, CompareProductLocators.EMPTY_PAGE_LABEL_LOC);
        return emptyPageLabel.getText();
    }
}
