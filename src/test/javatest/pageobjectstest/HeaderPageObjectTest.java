package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HeaderPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static utils.Constants.*;

public class HeaderPageObjectTest {
    WebDriver driver;
    HeaderPageObject header;


    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        header = new HeaderPageObject(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    /**
     * <b>TC-01: Euro Currency Test.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click currency selector;
     * <li>2. Choose euro currency;
     * <li>3. Find euro symbol in items title ;
     * <li>4. Compare expected and actual symbols;
     * </ul>
     * <p>
     * Expected Result:€.
     */

    @Test
    public void euroCurrencyTest() {
        String actual = header
                .chooseEuroCurrency()
                .getTextFromItems();
        assertTrue(actual.contains(EURO_CURRENCY));
    }

    /**
     * <b>TC-02: Dollar Currency Test.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click currency selector;
     * <li>2. Choose dollar currency;
     * <li>3. Find dollar symbol in items title ;
     * <li>4. Compare expected and actual symbols;
     * </ul>
     * <p>
     * Expected Result:$.
     */

    @Test
    public void dollarCurrencyTest() {
        String actual = header
                .chooseDollarCurrency()
                .getTextFromItems();
        assertTrue(actual.contains(DOLLAR_CURRENCY));
    }

    /**
     * <b>TC-03: Pound Currency Test.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click currency selector;
     * <li>2. Choose pound currency;
     * <li>3. Find pound symbol in items title ;
     * <li>4. Compare expected and actual symbols;
     * </ul>
     * <p>
     * Expected Result:£.
     */

    @Test
    public void poundCurrencyTest() {
        String actual = header
                .choosePoundCurrency()
                .getTextFromItems();
        assertTrue(actual.contains(POUND_CURRENCY));
    }

    /**
     * <b>TC-04: Login Page Test</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on login;
     * <li>2. Compare expected and actual title;
     * </ul>
     * <p>
     * Expected Result:Login.
     */

    @Test
    public void goToLoginPageTest() {
        header.clickLoginPage();
        String actual = header.getTextFromSecondTape();
        assertEquals(actual, LOGIN);
    }

    /**
     * <b>TC-05: Register Page Test</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on register;
     * <li>2. Compare expected and actual title;
     * </ul>
     * <p>
     * Expected Result:Register.
     */
    @Test
    public void goToRegistrationPageTest() {
        header.clickRegistrationPage();
        String actual = header.getTextFromSecondTape();
        assertEquals(actual, REGISTER);
    }

    /**
     * <b>TC-06: Wish List Page Test</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on wish list;
     * <li>2. Compare expected and actual title;
     * </ul>
     * <p>
     * Expected Result:Login.
     */

    @Test
    public void goToWishListTest(){
        header.clickWishList();
        String actual = header.getTextFromSecondTape();
        assertEquals(actual,LOGIN);
    }

    /**
     * <b>TC-07: Shopping cart Page Test</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on wish list;
     * <li>2. Compare expected and actual title;
     * </ul>
     * <p>
     * Expected Result:Login.
     */

    @Test
    public void goToShoppingCartPageTest(){
        header.clickShoppingCartPage();
         String actual = header.getTextFromFirstTape();
         assertEquals(actual,SHOPPING_CART);
    }

    /**
     * <b>TC-08: Checklist Page Test</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on wish list;
     * <li>2. Compare expected and actual title;
     * </ul>
     * <p>
     * Expected Result:Login.
     */

    @Test
    public void goToCheckoutPageTest(){
        header.goToCheckoutCartPage();
        String actual = header.getTextFromFirstTape();
        assertEquals(actual,SHOPPING_CART);
    }
}

