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
    Button getQuotesButton;
    Button openUseGiftCertificateButton;
    Input inputGiftCertificate;
    Button applyGiftCertificateButton;
    GetTextFromWebElement subTotalCost;
    GetTextFromWebElement couponCode;
    GetTextFromWebElement ecoTax;
    GetTextFromWebElement VAT;
    GetTextFromWebElement giftCertificate;
    GetTextFromWebElement totalCost;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }

    public HashMap<String, ShoppingCartPruduct> getShoppinProductsList() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.PRODUCTS_TABLE_XPATH)));
        this.productsTable = new ShoppingProductsTable(driver, ShoppingCartLocators.PRODUCTS_TABLE_XPATH);
        return productsTable.productsListInCart();
    }

    public ShoppingCartPageObject writeCouponCode(String couponCode) {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.OPEN_COUPON_CODE_BUTTON_XPATH)));
        openCouponCodeButton = new Button(driver, ShoppingCartLocators.OPEN_COUPON_CODE_BUTTON_XPATH);
        openCouponCodeButton.click();
        inputCouponCode = new Input(driver, ShoppingCartLocators.INPUT_COUPON_CODE);
        inputCouponCode.setTextForField(couponCode);
        applyCouponButton = new Button(driver, ShoppingCartLocators.APPLY_CUPON_BUTTON);
        return this;
    }

    public ShoppingCartPageObject writeEstimateShippingAndTaxes(String shippingCountry, String shippingRegion, String postCode) {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.OPEN_ESTIMATE_SHIPPING_TAXES_BUTTON)));
        this.openEstimateShippingTaxesButton = new Button(driver, ShoppingCartLocators.OPEN_ESTIMATE_SHIPPING_TAXES_BUTTON);
        this.openEstimateShippingTaxesButton.click();
        this.selectCountry = new DropDown(driver, ShoppingCartLocators.SELECT_COUNTRY_XPATH);
        this.selectCountry.writOptionParameter(shippingCountry);
        this.selectRegion = new DropDown(driver, ShoppingCartLocators.SELECT_REGION_XPATH);
        this.selectRegion.writOptionParameter(shippingRegion);
        this.postCode = new Input(driver, ShoppingCartLocators.POST_CODE_XPATH);
        this.postCode.setTextForField(postCode);
        this.getQuotesButton = new Button(driver, ShoppingCartLocators.GET_QUOTES_BUTTON);
        this.getQuotesButton.click();
        return this;
    }

    public ShoppingCartPageObject writeGiftCertificate(String certificateCode) {
        openUseGiftCertificateButton = new Button(driver, ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH);
        openUseGiftCertificateButton.click();
        inputGiftCertificate = new Input(driver, ShoppingCartLocators.INPUT_CERTIFICATE_CODE);
        inputGiftCertificate.setTextForField(certificateCode);
        applyGiftCertificateButton = new Button(driver, ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON);
        applyCouponButton.click();
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
        subTotalCost = new GetTextFromWebElement(driver,ShoppingCartLocators.SUB_TOTAL_COST_XPATH);
        return subTotalCost.getText();
    }
    public String  getCouponCode(){
        couponCode= new GetTextFromWebElement(driver,ShoppingCartLocators.COUPON_XPATH);
        return  couponCode.getText();
    }
    public String  getEcoTax(){
        ecoTax = new GetTextFromWebElement(driver,ShoppingCartLocators.CECO_TAX_XPATH);
        return ecoTax.getText();
    }
    public String  getVAT(){
        VAT = new GetTextFromWebElement(driver,ShoppingCartLocators.VAT_XPATH);
        return VAT.getText();
    }
    public String  getGiftCertificate(){
        giftCertificate= new GetTextFromWebElement(driver,ShoppingCartLocators.GIFT_CERTIDICATE_XPATH);
        return totalCost.getText();
    }
    public String  getTotalCost(){
        totalCost= new GetTextFromWebElement(driver,ShoppingCartLocators.TOTAL_COST_XPATH);
        return totalCost.getText();
    }
}
