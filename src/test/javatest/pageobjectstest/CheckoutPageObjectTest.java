package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

    @AfterClass
       public void closeUp() {
         driver.quit();
    }


    @Test
    public void placeAnOrderWithYourCurrentAddressAndAllCommentsAndAllInformationTest() {
        String actual = checkoutBillingDetails
                .clickIWantUseAnExistingAddressButton()
                .wantUseAnExistingAddressButton()
                .wantUseAnExistingAddressButton()
                .deliveryMethodWithCommentsAboutYourOrder("My buy")
                .paymentMethodWithCommentsAboutYourOrder("I paid")
                .clickContinueButton().successMessage();
        String expected = "Your order has been placed!";
        System.out.println(expected);
        System.out.println(actual);
        assertEquals(actual, expected);
    }


    @Test
    public void placeAnOrderWithYourCurrentAddressAndAllCommentsAndNotAllInformationTest() {
    }

    @Test
    public void placeAnOrderWithYourCurrentAddressAndNotAllCommentsAndAllInformationTest() {
    }


    @Test
    public void placeAnOrderWithYourNewAddressAndNotAllCommentsAndAllInformationTest() {
    }

    @Test
    public void placeAnOrderWithYourNewAddressAndNotAllCommentsAndNotAllInformationTest() {
    }

}
