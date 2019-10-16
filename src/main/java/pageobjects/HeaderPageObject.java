package pageobjects;

import locators.HeaderLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.*;


import java.util.List;

import static utils.commonconstants.Constants.*;

public class HeaderPageObject extends BasePageObject {
    WebDriverWait wait = new WebDriverWait(driver,10);
    List<WebElement> listOfCurrency;
    List<WebElement> listOfMyAccountButtons;
    private Button wishPageButton;
    private Button itemsPageButton;
    private Label yourStore;
    private Button myAccountButton;
    private Button loginPageButton;
    private Button registrationPageButton;
    private Button shoppingCartButton;
    private Button currencyListButton;

    public HeaderPageObject(WebDriver driver) {
        super(driver);
    }

    private List<WebElement>createListOfCurrency(String xpath){
       listOfCurrency =  driver.findElements(By.xpath(xpath));
        return listOfCurrency;
    }
    private List<WebElement> createListOfMyAccountButtons(String xpath){
        listOfMyAccountButtons = driver.findElements(By.xpath(xpath));
        return listOfMyAccountButtons;

    }    public HomePageObject goToHomePage(){
        yourStore = new LinkedLabel(driver, HeaderLocators.YOUR_STORE_BUTTON_LOC).click();
        return new HomePageObject(driver);
    }
    public ItemPageObject goToItemsPage(){
        itemsPageButton = new ImageTextButton(driver,HeaderLocators.ITEMS_PAGE_BUTTON_LOC).click();
        return new ItemPageObject(driver);
    }
    public WishListPageObject goToWishList(){
        wishPageButton = new ImageTextButton(driver,HeaderLocators.WISH_LIST_PAGE_BUTTON_LOC).click();
        return new WishListPageObject(driver);
    }
    public LoginPageObject goToLoginPage(){
        myAccountButton = new ImageTextButton(driver,HeaderLocators.MY_ACCOUNT_BUTTON_LOC).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HeaderLocators.LOGIN_PAGE_BUTTON_LOC)));
        loginPageButton = new TextButton(driver,HeaderLocators.LOGIN_PAGE_BUTTON_LOC).click();
        return new LoginPageObject(driver);
    }
    public RegistrationPageObject goToRegistrationPage(){
        myAccountButton = new ImageTextButton(driver,HeaderLocators.MY_ACCOUNT_BUTTON_LOC).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HeaderLocators.REGISTRATION_PAGE_BUTTON_LOC)));
        registrationPageButton = new TextButton(driver,HeaderLocators.REGISTRATION_PAGE_BUTTON_LOC).click();
        return new RegistrationPageObject(driver);
    }
    public ShoppingCartPageObject goToShoppingCartPage(){
        shoppingCartButton = new ImageTextButton(driver,HeaderLocators.SHOPPING_CART_PAGE_BUTTON_LOC).click();
        return new ShoppingCartPageObject(driver);
    }
    public HeaderPageObject chooseDollarCurrency(){
        currencyListButton = new ImageTextButton(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
        this.createListOfCurrency(HeaderLocators.LIST_OF_CURRENCY_LOC).get(TWO).click();
        return new HeaderPageObject(driver);
    }
    public HeaderPageObject chooseEuroCurrency(){
        currencyListButton = new ImageTextButton(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
        this.createListOfCurrency(HeaderLocators.LIST_OF_CURRENCY_LOC).get(NULL).click();
        return new HeaderPageObject(driver);
    }
    public HeaderPageObject choosePoundCurrency(){
        currencyListButton = new ImageTextButton(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
        this.createListOfCurrency(HeaderLocators.LIST_OF_CURRENCY_LOC).get(ONE).click();
        return new HeaderPageObject(driver);
    }
}
