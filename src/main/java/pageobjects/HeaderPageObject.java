package pageobjects;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import locators.HeaderLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.ListElements;


import java.util.List;

public class HeaderPageObject extends BasePageObject {
    WebDriverWait wait = new WebDriverWait(driver,10);
    List<String> listOfCurrency;
    private Button wishPageButton;
    private Button itemsPageButton;
    private Button homePageButton;
    private Button myAccountButton;
    private Button loginPageButton;
    private Button registrationPageButton;
    private Button shoppingCartButton;
    private Button currencyListButton;
    private Button dollar;
    private Button pound;
    private Button euro;

    public HeaderPageObject(WebDriver driver) {
        super(driver);
    }
    public HomePageObject goToHomePage(){
        homePageButton = new Button(driver, HeaderLocators.YOUR_STORE_BUTTON_LOC).click();
        return new HomePageObject(driver);
    }
    public ItemPageObject goToItemsPage(){
        itemsPageButton = new Button(driver,HeaderLocators.ITEMS_PAGE_BUTTON_LOC).click();
        return new ItemPageObject(driver);
    }
    public WishListPageObject goToWishList(){
        wishPageButton = new Button(driver,HeaderLocators.WISH_LIST_PAGE_BUTTON_LOC).click();
        return new WishListPageObject(driver);
    }
    public LoginPageObject goToLoginPage(){
        myAccountButton = new Button(driver,HeaderLocators.MY_ACCOUNT_BUTTON_LOC).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HeaderLocators.LOGIN_PAGE_BUTTON_LOC)));
        loginPageButton = new Button(driver,HeaderLocators.LOGIN_PAGE_BUTTON_LOC).click();
        return new LoginPageObject(driver);
    }
    public RegistrationPageObject goToRegistrationPage(){
        myAccountButton = new Button(driver,HeaderLocators.MY_ACCOUNT_BUTTON_LOC).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HeaderLocators.REGISTRATION_PAGE_BUTTON_LOC)));
        registrationPageButton = new Button(driver,HeaderLocators.REGISTRATION_PAGE_BUTTON_LOC).click();
        return new RegistrationPageObject(driver);
    }
    public ShoppingCartPageObject goToShoppingCartPage(){
        shoppingCartButton = new Button(driver,HeaderLocators.SHOPPING_CART_PAGE_BUTTON_LOC).click();
        return new ShoppingCartPageObject(driver);
    }
    public List<String> findListOfCurrency(){
         currencyListButton = new Button(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
         listOfCurrency = (List<String>) new ListElements(driver,HeaderLocators.LIST_OF_CURRENCY_LOC);
        return listOfCurrency;
    }
    public HeaderPageObject chooseDollarCurrency(){
        currencyListButton = new Button(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
        listOfCurrency = (List<String>) new ListElements(driver,HeaderLocators.LIST_OF_CURRENCY_LOC);
         dollar = new Button(driver,listOfCurrency.get(2)).click();
        return new HeaderPageObject(driver);
    }
    public HeaderPageObject chooseEuroCurrency(){
        currencyListButton = new Button(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
        listOfCurrency = (List<String>) new ListElements(driver,HeaderLocators.LIST_OF_CURRENCY_LOC);
        dollar = new Button(driver,listOfCurrency.get(0)).click();
        return new HeaderPageObject(driver);
    }
    public HeaderPageObject choosePoundCurrency(){
        currencyListButton = new Button(driver,HeaderLocators.CURRENCY_BUTTON_LOC).click();
        listOfCurrency = (List<String>) new ListElements(driver,HeaderLocators.LIST_OF_CURRENCY_LOC);
        dollar = new Button(driver,listOfCurrency.get(1)).click();
        return new HeaderPageObject(driver);
    }

}
