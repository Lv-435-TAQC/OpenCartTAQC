package pageobjects;


import locators.ShoppingCartLocators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import org.sikuli.script.*;
import pageelements.*;
import pageelements.Button;
import pageelements.Label;
import patterns.ShoppingCartPatterns;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;




public class ShoppingCartPageObject extends BasePageObject {
    private ShoppingProductsTable productsTable;
    private Button continueShoppingButton;
    private Button checkoutButton;
    private Button openCouponCodeButton;
    private Input inputCouponCode;
    private Button applyCouponButton;
    private Button openEstimateShippingTaxesButton;
    private DropDown selectCountry;
    private DropDown selectRegion;
    private Input postCode;
    private Button flatRateInput;
    private Button cancelFlatRate;
    private Button applyFlatRate;
    private Button getQuotesButton;
    private Button openUseGiftCertificateButton;
    private Input inputGiftCertificate;
    private Button applyGiftCertificateButton;
    private Label massageSuccessOperation;
    private Label subTotalCost;
    private Label couponCode;
    private Label ecoTax;
    private Label VAT;
    private Label giftCertificate;
    private Label totalCost;
    private Label shoppingCartEmptyMassage;
    Screen screen;
    Pattern iphoneAddToCartButton;
    Pattern scroll;
    Pattern openShoppingCartButton;
    Pattern quantityUpdate;
    Pattern quantityForm;
    Pattern message;
    Pattern totalCostProduct;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        screen = new Screen();
    }

    public static void makeScreenShotSteps(WebDriver driver, String screenshotsName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src\\main\\resources\\screenshots\\" + screenshotsName + ".png"));
        } catch (IOException e) {

        }
    }

    public HashMap<String, ShoppingCartProduct> getShoppingProductsList() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.PRODUCTS_TABLE_XPATH)));
        this.productsTable = new ShoppingProductsTable(driver, ShoppingCartLocators.PRODUCTS_TABLE_XPATH);
        return productsTable.productsListInCart();
    }

    public ShoppingCartPageObject removeProductFromCart(String productID) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        mapProducts.get(productID).removeProductsFromCart();
        return this;
    }

    public ShoppingCartPageObject updateProductQuantityInCart(String productID) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        mapProducts.get(productID).updateProductsFromCart();
        return this;
    }

    public ShoppingCartPageObject writeProductQuantityInCart(String productID, String quantity) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        mapProducts.get(productID).clearInputQuantity();
        mapProducts.get(productID).writeQuantity(quantity);
        return this;
    }

    public String getTotalCostProductInCart(String productID) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        return mapProducts.get(productID).getTotalPrice();
    }

    public ShoppingCartPageObject writeCouponCode(String couponCode) {
        openCouponCodeButton = new Button(driver, ShoppingCartLocators.OPEN_COUPON_CODE_BUTTON_XPATH);
        openCouponCodeButton.click();
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.INPUT_COUPON_CODE)));
        inputCouponCode = new Input(driver, ShoppingCartLocators.INPUT_COUPON_CODE);
        inputCouponCode.element.clear();
        inputCouponCode.setTextForField(couponCode);
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.APPLY_COUPON_BUTTON)));
        applyCouponButton = new Button(driver, ShoppingCartLocators.APPLY_COUPON_BUTTON);
        applyCouponButton.click();
        messageAboutOption();
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
        this.selectCountry.writeOptionParameter(shippingCountry);

        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath(ShoppingCartLocators.SELECT_REGION_XPATH), By.tagName("option")));
        this.selectRegion = new DropDown(driver, ShoppingCartLocators.SELECT_REGION_XPATH);
        this.selectRegion.writeOrdinalIndex(shippingRegion);

        this.postCode = new Input(driver, ShoppingCartLocators.POST_CODE_XPATH);
        this.postCode.setTextForField(postCode);
        this.getQuotesButton = new Button(driver, ShoppingCartLocators.GET_QUOTES_BUTTON);
        this.getQuotesButton.click();
        this.chooseFlatRate();
        this.messageAboutOption();
        return this;
    }

    public ShoppingCartPageObject chooseFlatRate() {
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.FLAT_SHIPPING_RATE_XPATH)));
        this.flatRateInput = new Button(driver, ShoppingCartLocators.FLAT_SHIPPING_RATE_XPATH);
        this.flatRateInput.click();
        this.applyFlatRate = new Button(driver, ShoppingCartLocators.FLAT_SHIPPING_RATE_APPLY_XPATH);
        this.applyFlatRate.click();
        this.messageAboutOption();
        return this;
    }

    public ShoppingCartPageObject writeGiftCertificate(String certificateCode) {
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH)));
        openUseGiftCertificateButton = new Button(driver, ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH);
        openUseGiftCertificateButton.click();
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.INPUT_CERTIFICATE_CODE)));
        inputGiftCertificate = new Input(driver, ShoppingCartLocators.INPUT_CERTIFICATE_CODE);
        inputGiftCertificate.setTextForField(certificateCode);
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON)));
        applyGiftCertificateButton = new Button(driver, ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON);
        applyGiftCertificateButton.click();
        messageAboutOption();
        return this;
    }

    public HomePageObject continueShopping() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.CONTINUE_SHOPPING)));
        continueShoppingButton = new Button(driver, ShoppingCartLocators.CONTINUE_SHOPPING);
        continueShoppingButton.click();
        return new HomePageObject(driver);
    }

    public String checkout() {
        checkoutButton = new Button(driver, ShoppingCartLocators.CHECKOUT_BUTTON_XPATH);
        checkoutButton.click();
        return driver.getCurrentUrl();
    }

    public String getSubTotalCost() {
        subTotalCost = new Label(driver, ShoppingCartLocators.SUB_TOTAL_COST_XPATH);
        return subTotalCost.getText();
    }

    public String getCouponCode() {
        couponCode = new Label(driver, ShoppingCartLocators.COUPON_XPATH);
        return couponCode.getText();
    }

    public String getEcoTax() {
        ecoTax = new Label(driver, ShoppingCartLocators.ECO_TAX_XPATH);
        return ecoTax.getText();
    }

    public String getVAT() {
        VAT = new Label(driver, ShoppingCartLocators.VAT_XPATH);
        return VAT.getText();
    }

    public String getGiftCertificate() {
        giftCertificate = new Label(driver, ShoppingCartLocators.GIFT_CERTIFICATE_XPATH);
        return giftCertificate.getText();
    }

    public String getGiftCertificateWithWait() {
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.GIFT_CERTIFICATE_XPATH)));
        giftCertificate = new Label(driver, ShoppingCartLocators.GIFT_CERTIFICATE_XPATH);
        return giftCertificate.getText();
    }

    public String getCartEmptyMassage() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(ShoppingCartLocators.CART_EMPTY_MASSAGE), "our shopping cart is empty!"));
        shoppingCartEmptyMassage = new Label(driver, ShoppingCartLocators.CART_EMPTY_MASSAGE);
        return shoppingCartEmptyMassage.getText();
    }

    public String getTotalCost() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.TOTAL_COST_XPATH)));
        totalCost = new Label(driver, ShoppingCartLocators.TOTAL_COST_XPATH);
        return totalCost.getText();
    }

    public String messageAboutOption() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.SUCCESS_MASSAGE)));
        massageSuccessOperation = new Label(driver, ShoppingCartLocators.SUCCESS_MASSAGE);
        return massageSuccessOperation.getText();
    }

    public ShoppingCartPageObject addIphoneToShoppingCartSikuly() throws Exception {
        iphoneAddToCartButton = new Pattern(ShoppingCartPatterns.IPHONE_ADD_TO_CART_BUTTON).targetOffset(10, 180);
        scroll = new Pattern(ShoppingCartPatterns.SCROLL);
        openShoppingCartButton = new Pattern(ShoppingCartPatterns.OPEN_SHOPPIN_CART_BUTTON);
        screen.wait(scroll, 20);
        screen.type(Key.PAGE_DOWN);
        screen.find(iphoneAddToCartButton).click();
        screen.wait(openShoppingCartButton, 20).click();
        return this;
    }

    public Match finedElementInShoppingCart (Pattern pattern) throws  Exception{
        return screen.wait(pattern,20);
    }

    public ShoppingCartPageObject changeQuantityProductsSikuly() throws Exception{
        quantityUpdate = new Pattern(ShoppingCartPatterns.QUANTITY_UPDATE);
        quantityForm = new Pattern(ShoppingCartPatterns.QUANTITY_FORM);
        message = new Pattern(ShoppingCartPatterns.MESSAGE);
        totalCostProduct = new Pattern(ShoppingCartPatterns.TOTAL_COST_PRODUCT);
        screen.wait(quantityForm.targetOffset(-100,0),20).click();
        Keyboard keyboard = new DesktopKeyboard();
        keyboard.type(Key.BACKSPACE);
        keyboard.type("2");
        screen.find(quantityUpdate).click();
        screen.wait(message,20);
        return this;
    }

    public String getTotalCostSikuly()throws Exception{
        screen.wait(totalCostProduct,20);
        String text = screen.find( ShoppingCartPatterns.TEXT).text();
        String finalCost = text.trim();
        return finalCost;
    }


    public String getURL() {
        return this.getURL();
    }
}
