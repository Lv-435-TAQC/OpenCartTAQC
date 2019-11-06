package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CheckoutBillingDetailsPageObject;
import pageobjects.HomePageObject;
import utils.Constants;

import static org.testng.Assert.assertEquals;
import static utils.Constants.KEY_TO_DRIVER;
import static utils.Constants.PATH_TO_DRIVER;

public class CheckoutPageObjectTest {
    WebDriver driver;
    HomePageObject homePageObject;
    CheckoutBillingDetailsPageObject checkoutBillingDetails;

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
        driver.get(Constants.HOME_PAGE);
        homePageObject.goToHomeUrlPage()
                .getHeaderPageObject()
                .clickLoginPage()
                .logIn("orysita.lviv+1@gmail.com", "orysia")
                .getMenuPageObject()
                .goToPhonesAndPDAs()
                .clickAddToCardByNameOfProduct("Palm Treo Pro")
                .goToHomeUrlPage()
                .goToShoppingCartPage()
                .goCheckoutBillingDetails();
        checkoutBillingDetails = new CheckoutBillingDetailsPageObject(driver);
    }
  /*  @BeforeMethod
    public void getHome() {
        homePageObject.getMenuPageObject()
                .goToPhonesAndPDAs()
                .clickAddToCardByNameOfProduct("Palm Treo Pro")
                .goToHomeUrlPage()
                .goToShoppingCartPage()
                .goCheckoutBillingDetails();
    }*/

 //   @AfterClass
  //    public void closeUp() {
 //        driver.quit();
 //   }

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
     *
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
    @Test
    public void placeAnOrderWithYourCurrentAddressAndAllComments() {
        String actual = checkoutBillingDetails
                .continueWantUseAnExistingAddressBillingDetailsPageButton()
                .continueWantUseAnExistingAddressButton()
                .deliveryMethodWithCommentsAboutYourOrder("My buy")
                .paymentMethodWithCommentsAboutYourOrder("I paid")
                .clickContinueButton().successMessage();
        String expected = "Your order has been placed!";
        assertEquals(actual, expected);
    }

    /**
     * <b>TC-2: Test checkout </b>
     *
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

    @Test
    public void placeAnOrderWithYourCurrentAddressAndNotAllComments() {
        String actual = checkoutBillingDetails
                .continueWantUseAnExistingAddressBillingDetailsPageButton()
                .continueWantUseAnExistingAddressButton()
                .deliveryMethodWithoutCommentsAboutYourOrder()
                .paymentMethodWithoutCommentsAboutYourOrder()
                .clickContinueButton().successMessage()
        String expected = "Your order has been placed!";
        assertEquals(actual, expected);
    }



    @Test
    public void placeAnOrderWithYourNewAddressAndNotAllCommentsAndAllInformationTest() {
        String actual = checkoutBillingDetails
                .continueWantUseNewAddressButtonWithAllInformation("Orysia","Benko","SoftServe", "Chervonoy Kalyny 51", "Suxiv", "Lviv", "125463", "Ukraine", 3493)
        .continueWantUseNewAddressButtonWithAllInformation("Orysia","Benko","SoftServe", "Chervonoy Kalyny 51", "Suxiv", "Lviv", "125463", "Ukraine", 3493)
               .deliveryMethodWithoutCommentsAboutYourOrder()
                .paymentMethodWithoutCommentsAboutYourOrder()
                .clickContinueButton().successMessage();
        String expected = "Your order has been placed!";
        assertEquals(actual, expected);
    }

    @Test
    public void placeAnOrderWithYourNewAddressAndAllCommentsAndInformationTest() {
        String actual = checkoutBillingDetails
                .continueWantUseNewAddressButtonWithAllInformation("Orysia","Benko","SoftServe", "Chervonoy Kalyny 51", "Suxiv", "Lviv", "125463", "Ukraine", 3493)
                .continueWantUseNewAddressButtonWithAllInformation("Orysia","Benko","SoftServe", "Chervonoy Kalyny 51", "Suxiv", "Lviv", "125463", "Ukraine", 3493)
                .deliveryMethodWithCommentsAboutYourOrder("My buy")
                .paymentMethodWithCommentsAboutYourOrder("I paid")
                .clickContinueButton().successMessage();
        String expected = "Your order has been placed!";
        assertEquals(actual, expected);
    }

    @Test
    public void placeAnOrderWithYourNewAddressAndNotAllCommentsAndNotAllInformationTest() {
    }

}
