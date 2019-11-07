package pageobjects;


import locators.ShoppingCartLocators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.*;
import patterns.ShoppingCartPatterns;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static locators.ShoppingCartLocators.PRODUCTS_TABLE_XPATH;

/**
 *  The class is created to describe the basic functionality on the shopping cart page
 */
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
    private Button applyFlatRate;
    private Button getQuotesButton;
    private Button openUseGiftCertificateButton;
    private Input inputGiftCertificate;
    private Button applyGiftCertificateButton;
    private Label massageSuccessOperation;
    private Label couponCode;
    private Label giftCertificate;
    private Label totalCost;
    private Label shoppingCartEmptyMassage;
    private Screen screen;
    private Pattern quantityUpdate;
    private Pattern quantityForm;
    private Pattern message;
    private Pattern totalCostProduct;
    private Pattern messageEmptyCart;
    private Button checkoutBillingButton;


    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        screen = new Screen();
    }
    /**
     * This method is used to create screenshots when displaying a web page by the driver.
     * @param driver .
     * @param screenshotsName .
     */
    public static void makeScreenShotSteps(WebDriver driver, String screenshotsName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src\\main\\resources\\screenshots\\" + screenshotsName + ".png"));
        } catch (IOException e) {

        }
    }
    /**
     * This method is used to extract the table of products, that have been added to the cart.
     * @return Map of products in the cart.
     */
    public HashMap<String, ShoppingCartProduct> getShoppingProductsList() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRODUCTS_TABLE_XPATH)));
        this.productsTable = new ShoppingProductsTable(driver, PRODUCTS_TABLE_XPATH);
        return productsTable.productsListInCart();
    }
    /**
     * This method is used to remove products from the cart.
     * @param productID .
     * @return this.
     */
    public ShoppingCartPageObject removeProductFromCart(String productID) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        mapProducts.get(productID).removeProductsFromCart();
        return this;
    }
    /**
     * This method is used to update quantity products in the cart.
     * @param productID .
     * @return this.
     */
    public ShoppingCartPageObject updateProductQuantityInCart(String productID) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        mapProducts.get(productID).updateProductsFromCart();
        return this;
    }
    /**
     * This method is used to write some new quantity of products in the cart.
     * @param productID .
     * @param quantity .
     * @return this.
     */
    public ShoppingCartPageObject writeProductQuantityInCart(String productID, String quantity) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        mapProducts.get(productID).clearInputQuantity();
        mapProducts.get(productID).writeQuantity(quantity);
        return this;
    }
    /**
     * This method gets the total cost of some product from the products table in cart .
     * @param productID .
     * @return total prise .
     */
    public String getTotalCostProductInCart(String productID) {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        return mapProducts.get(productID).getTotalPrice();
    }
    /**
     * This method write code in Use Coupon Code input  .
     * @param couponCode .
     * @return this .
     */
    public ShoppingCartPageObject writeCouponCode(String couponCode) {
        openCouponCodeButton = new Button(driver, ShoppingCartLocators.OPEN_COUPON_CODE_BUTTON_XPATH);
        openCouponCodeButton.click();
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.INPUT_COUPON_CODE)));
        inputCouponCode = new Input(driver, ShoppingCartLocators.INPUT_COUPON_CODE);
        inputCouponCode.element.clear();
        inputCouponCode.setText(couponCode);
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.APPLY_COUPON_BUTTON)));
        applyCouponButton = new Button(driver, ShoppingCartLocators.APPLY_COUPON_BUTTON);
        applyCouponButton.click();
        messageAboutOption();
        return this;
    }
    /**
     * This method write data in Estimate Shipping And Taxes inputs  .
     * @param shippingCountry .
     * @param shippingRegion .
     * @param postCode .
     * @return this .
     */
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
        this.postCode.setText(postCode);
        this.getQuotesButton = new Button(driver, ShoppingCartLocators.GET_QUOTES_BUTTON);
        this.getQuotesButton.click();
        this.chooseFlatRate();
        this.messageAboutOption();
        return this;
    }
    /**
     * This method write data in Estimate Shipping And Taxes inputs  .
     * @return this .
     */
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
    /**
     * This method write code in Use Gift Certificate input  .
     * @param certificateCode .
     * @return this .
     */
    public ShoppingCartPageObject writeGiftCertificate(String certificateCode) {
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH)));
        openUseGiftCertificateButton = new Button(driver, ShoppingCartLocators.OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH);
        openUseGiftCertificateButton.click();
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.INPUT_CERTIFICATE_CODE)));
        inputGiftCertificate = new Input(driver, ShoppingCartLocators.INPUT_CERTIFICATE_CODE);
        inputGiftCertificate.setText(certificateCode);
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON)));
        applyGiftCertificateButton = new Button(driver, ShoppingCartLocators.APPLY_CERTIFICATE_CODE_BUTTON);
        applyGiftCertificateButton.click();
        messageAboutOption();
        return this;
    }
    /**
     * This method redirects driver to the homepage  .
     * @return Home Page Object .
     */
    public HomePageObject continueShopping() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ShoppingCartLocators.CONTINUE_SHOPPING)));
        continueShoppingButton = new Button(driver, ShoppingCartLocators.CONTINUE_SHOPPING);
        continueShoppingButton.click();
        return new HomePageObject(driver);
    }
    /**
     * This method redirects driver to the Checkout page  .
     * @return driver current url after redirects .
     */
    public String goToCheckout() {
        checkoutButton = new Button(driver, ShoppingCartLocators.CHECKOUT_BUTTON_XPATH);
        checkoutButton.click();
        return driver.getCurrentUrl();
    }
    /**
     * This method extracts coupon code from cart page  .
     * @return couponCode .
     */
    public String getCouponCode() {
        couponCode = new Label(driver, ShoppingCartLocators.COUPON_XPATH);
        return couponCode.getText();
    }
    /**
     * This method extracts gift certificate code from cart page  .
     * @return giftCertificate .
     */
    public String getGiftCertificate() {
        giftCertificate = new Label(driver, ShoppingCartLocators.GIFT_CERTIFICATE_XPATH);
        return giftCertificate.getText();
    }
    /**
     * This method extracts gift certificate code from cart page with explicitly wait  .
     * @return giftCertificate .
     */
    public String getGiftCertificateWithWait() {
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.GIFT_CERTIFICATE_XPATH)));
        giftCertificate = new Label(driver, ShoppingCartLocators.GIFT_CERTIFICATE_XPATH);
        return giftCertificate.getText();
    }
    /**
     * This method extracts massage from empty shopping cart .
     * @return massage .
     */
    public String getCartEmptyMassage() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(ShoppingCartLocators.CART_EMPTY_MASSAGE), "our shopping cart is empty!"));
        shoppingCartEmptyMassage = new Label(driver, ShoppingCartLocators.CART_EMPTY_MASSAGE);
        return shoppingCartEmptyMassage.getText();
    }
    /**
     * This method gets the total cost of all products from the products table in cart .
     * @return total prise .
     */
    public String getTotalCost() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.TOTAL_COST_XPATH)));
        totalCost = new Label(driver, ShoppingCartLocators.TOTAL_COST_XPATH);
        return totalCost.getText();
    }
    /**
     * This method extracts a message from shopping cart when coupon code or gift certificates used successfully .
     * @return massage .
     */
    public String messageAboutOption() {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ShoppingCartLocators.SUCCESS_MASSAGE)));
        massageSuccessOperation = new Label(driver, ShoppingCartLocators.SUCCESS_MASSAGE);
        return massageSuccessOperation.getText();
    }

    /**
     * This method finds the item on the current page.
     * @return match .
     */

    public Match finedElementInShoppingCartSikuly(Pattern pattern) {
        Match match = null;
        try {
            match = screen.wait(pattern, 20);
        } catch (org.sikuli.script.FindFailed ex) {
            System.out.println("Exception in finedElementInShoppingCartSikuly");
        }
        return match;
    }
    /**
     * This method is used to change quantity products in the cart.
     * @return this.
     */
    public ShoppingCartPageObject changeQuantityProductsSikuly() {
        quantityUpdate = new Pattern(ShoppingCartPatterns.QUANTITY_UPDATE);
        quantityForm = new Pattern(ShoppingCartPatterns.QUANTITY_FORM);
        message = new Pattern(ShoppingCartPatterns.MESSAGE);
        totalCostProduct = new Pattern(ShoppingCartPatterns.TOTAL_COST_PRODUCT);
        try {
            screen.wait(quantityForm.targetOffset(-100, 0), 20).click();
            Keyboard keyboard = new DesktopKeyboard();
            keyboard.type(Key.BACKSPACE);
            keyboard.type("2");
            screen.find(quantityUpdate).click();
            screen.wait(message, 20);
        } catch (org.sikuli.script.FindFailed ex) {
            System.out.println("Exception in changeQuantityProductsSikuly()");
        }
        return this;
    }
    /**
     * This method is used to remove products from the cart use sikuly.
     * @return location messageEmpty cart.
     */
    public String removeProductSikuly() {
        String messageCart = null;
        quantityForm = new Pattern(ShoppingCartPatterns.QUANTITY_FORM);
        messageEmptyCart = new Pattern(ShoppingCartPatterns.EMPTY_CART_MESSAGE);
        try {
            screen.wait(quantityForm.targetOffset(50, 0), 20).click();
            messageCart = screen.wait(messageEmptyCart, 20).text();
        } catch (org.sikuli.script.FindFailed ex) {
            System.out.println("Exception in removeProductSikuly() ");
        }
        return messageCart;
    }
    /**
     * This method gets the total cost of some product from the products table in cart use sikuly.
     * @return total prise .
     */
    public String getTotalCostSikuly() {
        String text = null;
        try {
            screen.wait(totalCostProduct, 20);
            text = screen.find(ShoppingCartPatterns.TEXT).text();
        } catch (org.sikuli.script.FindFailed ex) {
            System.out.println("Exception in getTotalCostSikuly()");
        }

        String finalCost = text.trim();
        return finalCost;
    }

    public CheckoutBillingDetailsPageObject goCheckoutBillingDetails() {
        checkoutBillingButton = new Button(driver, ShoppingCartLocators.CHECKOUT_BUTTON_XPATH);
        checkoutBillingButton.click();
        return new CheckoutBillingDetailsPageObject(driver);
    }

    public BasePageObject determineIfTableExistsAndRemoveAll(){
        String shopCart = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText();
        if(shopCart.contains("Use Gift Certificate")){
            return this.removeAllProductsFromCart();
        }else {
            return this;
        }
    }

    public ShoppingCartPageObject removeAllProductsFromCart() {
        HashMap<String, ShoppingCartProduct> mapProducts = this.getShoppingProductsList();
        ArrayList<String> listIDs = new ArrayList<>();
        if(mapProducts.isEmpty()){
            return this;
        }else {
            for (HashMap.Entry<String, ShoppingCartProduct> entry : mapProducts.entrySet()) {
                listIDs.add(entry.getKey());
            }
            for (String s : listIDs) {
                this.removeProductFromCart(s);
            }
            return new ShoppingCartPageObject(driver);
        }

    }
}
