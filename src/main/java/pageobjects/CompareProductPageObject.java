package pageobjects;

import entity.Product;
import locators.CompareProductLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Button;
import pageelements.Label;
import pageelements.LinkedLabel;

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
    private ArrayList<Button> addToCardButtonList;
    private ArrayList<Button> removeButtonList;

    public CompareProductPageObject(WebDriver driver) {
        super(driver);
        generateList();
    }

    private void generateList() {
        getRowsOfTable()
                .generateProductNamesLinkedLabelList()
                .generateButtonLists()
                .generateProductPriceLabelList()
                .generateProductModelLabelList()
                .generateProductBrandsLabelList()
                .generateProductAvailabilityLabelList()
                .generateProductRatingLabelList()
                .generateProductSummaryLabelList()
                .generateProductWeightLabelList()
                .generateProductDimensionsLabelList();
    }

    public ArrayList<Product> getProductList() {
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
        return products;
    }

    private CompareProductPageObject getRowsOfTable() {
        rowsOfTable = driver.findElements(By.xpath(CompareProductLocators.TBODY_WITH_PRODUCT_INFO_LOC));
        return this;
    }

    private CompareProductPageObject generateProductNamesLinkedLabelList() {
        int row = 0;
        productNameList = new ArrayList<>();
        for (int i = 1; i < getSubElements(row).size(); i++) {
            productNameList.add(new LinkedLabel(getSubElements(row).get(i), CompareProductLocators.NAME_LINKED_LABEL_SUB_LOC));
        }
        return this;
    }

    private CompareProductPageObject generateProductPriceLabelList() {
        int row = 2;
        priceList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductModelLabelList() {
        int row = 3;
        modelList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductBrandsLabelList() {
        int row = 4;
        brandsList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductAvailabilityLabelList() {
        int row = 5;
        availabilityList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductRatingLabelList() {
        int row = 6;
        ratingList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductSummaryLabelList() {
        int row = 7;
        summaryList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductWeightLabelList() {
        int row = 8;
        weightList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateProductDimensionsLabelList() {
        int row = 9;
        dimensionList = getLabelList(row);
        return this;
    }

    private CompareProductPageObject generateButtonLists() {
        List<WebElement> elements = driver.findElements(By.xpath(CompareProductLocators.TR_WITH_BUTTONS_LOC));
        removeButtonList = new ArrayList<>();
        addToCardButtonList = new ArrayList<>();
        for (int i = 1; i < elements.size(); i++) {
            addToCardButtonList.add(new Button(elements.get(i), CompareProductLocators.ADD_TO_CART_BUTTON_LOC));
            removeButtonList.add(new Button(elements.get(i), CompareProductLocators.REMOVE_BUTTON_LOC));
        }
        return this;
    }

    private ArrayList<Label> getLabelList(int row) {
        ArrayList<Label> labelList = new ArrayList<>();
        for (int i = 1; i < getSubElements(row).size(); i++) {
            labelList.add(new Label(getSubElements(row).get(i)));
        }
        return labelList;
    }

    private List<WebElement> getSubElements(int row) {
        return rowsOfTable.get(row).findElements(By.xpath(CompareProductLocators.ELEMENT_SUB_LOC));
    }

    public ItemInfoPageObject clickAddToCartButton(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                addToCardButtonList.get(i).click();
            }
        }
        return new ItemInfoPageObject(this.driver);
    }

    public CompareProductPageObject clickRemoveButton(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                removeButtonList.get(i).click();
            }
        }
        return this;
    }

    public ItemInfoPageObject clickProductNameLabel(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                addToCardButtonList.get(i).click();
            }
        }
        return new ItemInfoPageObject(this.driver);
    }
}
