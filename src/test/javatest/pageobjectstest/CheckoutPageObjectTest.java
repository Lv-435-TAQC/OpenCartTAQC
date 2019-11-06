package javatest.pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageelements.Button;
import pageobjects.CheckoutBillingDetailsPageObject;
import pageobjects.HomePageObject;
import utils.Constants;

import static locators.CheckoutConfirmOrderLocators.CONFIRM_ORDER;
import static org.testng.Assert.assertEquals;
import static utils.Constants.*;

public class CheckoutPageObjectTest {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private CheckoutBillingDetailsPageObject checkoutBillingDetails;

    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open Home Page on OpenCart.com;
     * <li>3. Click on Login Tab;
     * <li>4. Enter username, password and Click Login Tab;
     * <li>5. Click on Home Tab;
     * <li>6. Click on Menu/Phones and PDAs Tab;
     * <li>7. Add Palm Treo Pro Item to Shopping Cart;
     * <li>8. Click on Shopping Cart Tab;
     * <li>9. Click on Checkout
     * </ul>
     * <p>
     */

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        homePageObject = new HomePageObject(driver);

        driver.get(HOME_PAGE);
        homePageObject.goToHomePage()
                .getHeaderPageObject()
                .clickLoginPage()
                .logIn("orysita.lviv+1@gmail.com", "orysia");
    }

    @BeforeMethod
    public void addProduct() {
        homePageObject
                .goToHomePage()
                .getMenuPageObject()
                .goToPhonesAndPDAs()
                .clickAddToCardByNameOfProduct("iPhone")
                .goToHomePage()
                .goToShoppingCartPage()
                .goCheckoutBillingDetails();
        checkoutBillingDetails = new CheckoutBillingDetailsPageObject(driver);

    }

//    @AfterMethod
//    public void logout() {
//        checkoutBillingDetails.goToUrl(LOGOUT_URL);
//        (new WebDriverWait(driver, 30))
//                .until(ExpectedConditions.textToBe(By.xpath("//div[@id = 'content']/h1"), "Account Logout"));
//    }

//    @AfterClass
//    public void closeUp() {
//        driver.quit();
//    }

    /**
     * <b>TC-1: Test checkout     </b>
     *     IT IS LIST OF EVENT
     * Scenario:
     * <ul>
     * <li> Click I want to use an existing address on Billing Details
     * <li> Click I want to use a new address on Billing Details
     * <li> Input all information about user on Billing Details
     * <li> Click Continue Button on Billing Details
     * <li> Click I want to use an existing address on Delivery Details
     * <li> Click I want to use a new address on Delivery Details
     * <li> Click Continue Button on Delivery Details
     * <li> Click Flat Rate on Delivery Method
     * <li> Add comments about your order on Delivery Method
     * <li> Click Continue Button on Delivery Method
     * <li> Click "Cash on Delivery" on Payment Method
     * <li> Add comments about your order on Payment Method
     * <li> Click "I have read and agree to the Terms & Conditions" on Payment Method
     * <li> Click Continue Button on Payment Method
     * <li> Click Confirm Order on Confirm Order
     * <li> Click OK on alert
     * <li> Click Confirm Order on Confirm Order
     *
     * </ul>
     * <p>
     * Expected Result:
     */


    /**
     * <b>TC-1: Test checkout </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click I want to use an existing address on Billing Details
     * <li> 2. Click Continue Button on Billing Details
     * <li> 3. Click I want to use an existing address on Delivery Details
     * <li> 4. Click Continue Button on Delivery Details
     * <li> 5. Click Flat Rate on Delivery Method
     * <li> 6. Add comments about your order on Delivery Method
     * <li> 7. Click Continue Button on Delivery Method
     * <li> 8. Click "Cash on Delivery" on Payment Method
     * <li> 9. Add comments about your order on Payment Method
     * <li> 10. Click "I have read and agree to the Terms & Conditions" on Payment Method
     * <li> 11. Click Continue Button on Payment Method
     * <li> 12. Click Confirm Order on Confirm Order
     * <li> 13. Click OK on alert
     * <li> 14. Click Confirm Order on Confirm Order
     *
     * </ul>
     * <p>
     * Expected Result: Your order has been placed!
     */
    @Test(priority = 1)
    public void placeAnOrderWithYourCurrentAddressAndAllComments() {
        String actual = checkoutBillingDetails
                .continueWantUseAnExistingAddressBillingDetailsPageButton()
                .continueWantUseAnExistingAddressButton()
                .deliveryMethodWithCommentsAboutYourOrder("My buy")
                .paymentMethodWithCommentsAboutYourOrder("I paid")
                .clickContinueButtonX().successMessage();
        assertEquals(SUCCSSES_ORDER1.equalsIgnoreCase(actual) ? Constants.SUCCSSES_ORDER1 : Constants.SUCCSSES_ORDER2, actual);
    }

    /**
     * <b>TC-2: Test checkout </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Click I want to use an existing address on Billing Details
     * <li> 2. Click Continue Button on Billing Details
     * <li> 3. Click I want to use an existing address on Delivery Details
     * <li> 4. Click Continue Button on Delivery Details
     * <li> 5. Click Flat Rate on Delivery Method
     * <li> 6. Click Continue Button on Delivery Method
     * <li> 7. Click "Cash on Delivery" on Payment Method
     * <li> 8. Click "I have read and agree to the Terms & Conditions" on Payment Method
     * <li> 9. Click Continue Button on Payment Method
     * <li> 10. Click Confirm Order on Confirm Order
     * <li> 11. Click OK on alert
     * <li> 12. Click Confirm Order on Confirm Order
     *
     * </ul>
     * <p>
     * Expected Result: Your order has been placed!
     */

    @Test(priority = 2)
    public void placeAnOrderWithYourCurrentAddressAndNotAllComments() {
        String actual = checkoutBillingDetails
                .continueWantUseAnExistingAddressBillingDetailsPageButton()
                .continueWantUseAnExistingAddressButton()
                .deliveryMethodWithoutCommentsAboutYourOrder()
                .paymentMethodWithoutCommentsAboutYourOrder()
                .clickContinueButtonX().successMessage();
        assertEquals(SUCCSSES_ORDER1.equalsIgnoreCase(actual) ? Constants.SUCCSSES_ORDER1 : Constants.SUCCSSES_ORDER2, actual);
    }


    @Test(priority = 3)
    public void placeAnOrderWithYourNewAddressAndNotAllCommentsAndAllInformationTest() {
        String actual =
                checkoutBillingDetails
                        .continueWantUseNewAddressButtonWithAllInformation(
                                "Orysia", "Benko", "SoftServe",
                                "Chervonoy Kalyny 51", "Suxiv", "Lviv",
                                "125463", "Ukraine", 3493)
                        .continueWantUseNewAddressButtonWithAllInformation("Orysia", "Benko", "SoftServe",
                                "Chervonoy Kalyny 51", "Suxiv", "Lviv", "125463", "Ukraine", 3490)
                        .deliveryMethodWithoutCommentsAboutYourOrder()
                        .paymentMethodWithoutCommentsAboutYourOrder()
                        .clickContinueButtonX().successMessage();
        assertEquals(SUCCSSES_ORDER1.equalsIgnoreCase(actual) ? Constants.SUCCSSES_ORDER1 : Constants.SUCCSSES_ORDER2, actual);
    }

    @Test(priority = 4)
    public void placeAnOrderWithYourNewAddressAndAllCommentsAndInformationTest() {
//        String actual =
        checkoutBillingDetails
                .continueWantUseNewAddressButtonWithAllInformation("Orysia", "Benko", "SoftServe",
                        "Chervonoy Kalyny 51", "Suxiv", "Lviv",
                        "125463", "Thailand", 3192)
                .continueWantUseNewAddressButtonWithAllInformation("Orysia", "Benko", "SoftServe",
                        "Chervonoy Kalyny 51", "Suxiv", "Lviv",
                        "125463", "Thailand", 3192)
                .deliveryMethodWithCommentsAboutYourOrder("buy")
                .paymentMethodWithCommentsAboutYourOrder("paid");
//        driver.findElement(By.xpath("//a[@class = 'accordion-toggle collapsed' and @href = '#collapse-checkout-confirm']")).click();
        WebDriverWait wait = (new WebDriverWait(driver, 20));
        Boolean result = wait.until(ExpectedConditions.textToBe
                (By.xpath("/html/body/div[2]/div/div/div/div[6]/div[2]/div/div[1]/table/tfoot/tr[2]/td[1]/strong"), "Flat Shipping Rate:"));
        if (result) {
            driver.findElement(By.xpath("//input[@type = 'button' and @value = 'Confirm Order']")).click();
        }
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.alertIsPresent());
        if (driver.switchTo().alert() != null) {
            driver.switchTo().alert().accept();
        } else {
            new Button(this.driver, CONFIRM_ORDER).click();
        }
//        assertEquals(SUCCSSES_ORDER1.equalsIgnoreCase(actual) ? Constants.SUCCSSES_ORDER1 : Constants.SUCCSSES_ORDER2, actual);
    }

    @Test
    public void placeAnOrderWithYourNewAddressAndNotAllCommentsAndNotAllInformationTest() {
    }

}
