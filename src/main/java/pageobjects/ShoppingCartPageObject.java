package pageobjects;

import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.*;

import java.util.HashMap;

public class ShoppingCartPageObject extends BasePageObject {
    ShoppingProductsTable productsTable;
    Button continueShoppingButton;
    Button checkoutButton;
    Button openCouponCodeButton;
    Input inputCouponCode;
    Button applyCouponButton;
    Button openEstimateShippingTaxesButton;
    DropDown selectCountry;
    DropDown selectRegion;
    Input postCode;
    Button flatRateInput;
    Button cancelFlatRate;
    Button applyFlatRate;
    Button getQuotesButton;
    Button openUseGiftCertificateButton;
    Input inputGiftCertificate;
    Button applyGiftCertificateButton;
    TextFromWebElement massageSuccessOperation;
    TextFromWebElement subTotalCost;
    TextFromWebElement couponCode;
    TextFromWebElement ecoTax;
    TextFromWebElement VAT;
    TextFromWebElement giftCertificate;
    TextFromWebElement totalCost;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }

    public HashMap<String, ShoppingCartPruduct> getShoppinProductsList() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.PRODUCTS_TABLE_XPATH)));
        this.productsTable = new ShoppingProductsTable(driver, ShoppingCartLocators.PRODUCTS_TABLE_XPATH);
        return productsTable.productsListInCart();
    }
    public ShoppingCartPageObject removeProductFromCart(String productID) {
        HashMap<String, ShoppingCartPruduct> mapProducts= this.getShoppinProductsList();
        mapProducts.get(productID).removeProductsFromCart();
        return this;
    }

    public ShoppingCartPageObject writeCouponCode(String couponCode) {
        openCouponCodeButton = new Button(driver, ShoppingCartLocators.OPEN_COUPON_CODE_BUTTON_XPATH);
        openCouponCodeButton.click();
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.INPUT_COUPON_CODE)));
        inputCouponCode = new Input(driver, ShoppingCartLocators.INPUT_COUPON_CODE);
        inputCouponCode.setTextForField(couponCode);
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.APPLY_CUPON_BUTTON)));
        applyCouponButton = new Button(driver, ShoppingCartLocators.APPLY_CUPON_BUTTON);
        applyCouponButton.click();
        massageNotise();
        return this;
    }

    public ShoppingCartPageObject writeEstimateShippingAndTaxes(String shippingCountry, Integer shippingRegion, String postCode) {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.OPEN_ESTIMATE_SHIPPING_TAXES_BUTTON)));
        this.openEstimateShippingTaxesButton = new Button(driver, ShoppingCartLocators.OPEN_ESTIMATE_SHIPPING_TAXES_BUTTON);
        this.openEstimateShippingTaxesButton.click();
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.SELECT_COUNTRY_XPATH)));
        this.selectCountry = new DropDown(driver, ShoppingCartLocators.SELECT_COUNTRY_XPATH);
        this.selectCountry.writOptionParameter(shippingCountry);
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.SELECT_REGION_XPATH)));
        this.selectRegion = new DropDown(driver, ShoppingCartLocators.SELECT_REGION_XPATH);
        this.selectRegion.writOrdinalIndex(shippingRegion);
        this.postCode = new Input(driver, ShoppingCartLocators.POST_CODE_XPATH);
        this.postCode.setTextForField(postCode);
        this.getQuotesButton = new Button(driver, ShoppingCartLocators.GET_QUOTES_BUTTON);
        this.getQuotesButton.click();
        this.chooseFletRate();
        return this;
    }
    public ShoppingCartPageObject chooseFletRate() {
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.FLAT_SHIPPING_RATE_XPATH)));
        this.flatRateInput = new Button(driver, ShoppingCartLocators.FLAT_SHIPPING_RATE_XPATH);
        this.flatRateInput.click();
        this.applyFlatRate = new Button(driver,ShoppingCartLocators.FLAT_SHIPPING_RATE_APPLY_XPATH);
        this.applyFlatRate.click();
        this.massageNotise();
        return this;
    }

    public ShoppingCartPageObject writeGiftCertificate(String certificateCode) {
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH)));
        openUseGiftCertificateButton = new Button(driver, ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH);
        openUseGiftCertificateButton.click();
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.INPUT_CERTIFICATE_CODE)));
        inputGiftCertificate = new Input(driver, ShoppingCartLocators.INPUT_CERTIFICATE_CODE);
        inputGiftCertificate.setTextForField(certificateCode);
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON)));
        applyGiftCertificateButton = new Button(driver, ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON);
        applyGiftCertificateButton.click();
        return this;
    }

    public HomePageObject continueShopping() {
        continueShoppingButton = new Button(driver, ShoppingCartLocators.CONTINUE_SHOPPING);
        continueShoppingButton.click();
        return new HomePageObject(driver);
    }

    public void checkout() {
        checkoutButton = new Button(driver, ShoppingCartLocators.CHECKOUT_BUTTON_XPATH);
        checkoutButton.click();
    }
    public  String getSubTotalCost(){
        subTotalCost = new TextFromWebElement(driver,ShoppingCartLocators.SUB_TOTAL_COST_XPATH);
        return subTotalCost.getText();
    }
    public String  getCouponCode(){
        couponCode= new TextFromWebElement(driver,ShoppingCartLocators.COUPON_XPATH);
        return  couponCode.getText();
    }
    public String  getEcoTax(){
        ecoTax = new TextFromWebElement(driver,ShoppingCartLocators.CECO_TAX_XPATH);
        return ecoTax.getText();
    }
    public String  getVAT(){
        VAT = new TextFromWebElement(driver,ShoppingCartLocators.VAT_XPATH);
        return VAT.getText();
    }
    public String  getGiftCertificate(){
        giftCertificate= new TextFromWebElement(driver,ShoppingCartLocators.GIFT_CERTIDICATE_XPATH);
        return totalCost.getText();
    }
    public String  getTotalCost(){
        totalCost= new TextFromWebElement(driver,ShoppingCartLocators.TOTAL_COST_XPATH);
        return totalCost.getText();
    }
    public String massageNotise(){
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.SUCCESS_MASSAGE)));
        massageSuccessOperation = new TextFromWebElement(driver,ShoppingCartLocators.SUCCESS_MASSAGE);
        return massageSuccessOperation.getText();
    }
}
