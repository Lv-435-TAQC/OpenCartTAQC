package pageobjects;

import locators.CheckoutDeliveryDetailsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;

import static locators.CheckoutDeliveryDetailsLocators.REGION_OR_STATE;

public class CheckoutDeliveryDetailsPageObject extends BasePageObject {
    private Input firstNameField;
    private Input lastNameField;
    private Input companyField;
    private Input address1Field;
    private Input address2Field;
    private Input cityField;
    private Input postCodeField;
    private DropDown selectCountryDrop;
    private DropDown selectCountryRegionOrStateDrop;
    private Button continueButton;
    private Button iWantUseAnExistingAddress;
    private Button iWantUseNewExistingAddress;

    public CheckoutDeliveryDetailsPageObject(WebDriver driver) {
        super(driver);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CheckoutDeliveryDetailsLocators.EXISTING_ADDRESS)));
    }

    public CheckoutDeliveryMethodPageObject continueWantUseAnExistingAddressButton() {
        return this.clickIWantUseAnExistingAddressButton().clickNextButton();
    }

    public CheckoutDeliveryMethodPageObject continueWantUseNewAddressButtonWithAllInformation(
            String firstName, String lastName, String company, String address1, String address2,
            String city, String postCode, String selectCountry, int selectCountryRegionOrState) {
        return this.clickIWantUseNewExistingAddressButton()
                .continueInputNewNotRequiredInformation(
                        firstName, lastName, company, address1, address2, city, postCode, selectCountry, selectCountryRegionOrState);
    }

    public CheckoutDeliveryMethodPageObject continueWantUseNewAddressButtonWithAllInformation(String firstName, String lastName, String company, String address1, String city, String selectCountry, int selectCountryRegionOrState) {
        return this.clickIWantUseNewExistingAddressButton()
                .continueInputNewRequiredInformation(firstName, lastName, company, address1, city, selectCountry, selectCountryRegionOrState);
    }

    public CheckoutDeliveryMethodPageObject continueInputNewRequiredInformation(String firstName, String lastName, String company, String address1, String city, String selectCountry, int selectCountryRegionOrState) {
        this
                .clickIWantUseNewExistingAddressButton()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCompany(company)
                .setAddress1(address1)
                .setCity(city)
                .selectCountry(selectCountry)
                .selectCountryRegionOrState(selectCountryRegionOrState)
                .clickNextButton();
        return new CheckoutDeliveryMethodPageObject(driver);
    }

    public CheckoutDeliveryMethodPageObject continueInputNewNotRequiredInformation(
            String firstName, String lastName, String company, String address1, String address2,
            String city, String postCode, String selectCountry, int selectCountryRegionOrState) {
        this
                .clickIWantUseNewExistingAddressButton()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCompany(company)
                .setAddress1(address1)
                .setAddress2(address2)
                .setCity(city)
                .setPostCode(postCode)
                .selectCountry(selectCountry)
                .selectCountryRegionOrState(selectCountryRegionOrState)
                .clickNextButton();
        return new CheckoutDeliveryMethodPageObject(driver);
    }

    public CheckoutDeliveryDetailsPageObject setFirstName(String firstName) {
        firstNameField = new Input(this.driver, CheckoutDeliveryDetailsLocators.FIRST_NAME);
        firstNameField.setText(firstName);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject setLastName(String lastName) {
        lastNameField = new Input(this.driver, CheckoutDeliveryDetailsLocators.LAST_NAME);
        lastNameField.setText(lastName);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject setCompany(String company) {
        companyField = new Input(this.driver, CheckoutDeliveryDetailsLocators.COMPANY);
        companyField.setText(company);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject setAddress1(String address1) {
        address1Field = new Input(this.driver, CheckoutDeliveryDetailsLocators.ADDRESS_1);
        address1Field.setText(address1);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject setAddress2(String address2) {
        address2Field = new Input(this.driver, CheckoutDeliveryDetailsLocators.ADDRESS_2);
        address2Field.setText(address2);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject setCity(String city) {
        cityField = new Input(this.driver, CheckoutDeliveryDetailsLocators.CITY);
        cityField.setText(city);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject setPostCode(String postCode) {
        postCodeField = new Input(this.driver, CheckoutDeliveryDetailsLocators.POST_CODE);
        postCodeField.setText(postCode);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject selectCountry(String selectCountry) {
        selectCountryDrop = new DropDown(this.driver, CheckoutDeliveryDetailsLocators.COUNTRY);
        selectCountryDrop.writeOptionParameter(selectCountry);
        return this;
    }

    public CheckoutDeliveryDetailsPageObject selectCountryRegionOrState(int selectIndexCountryRegionOrState) {
        selectCountryRegionOrStateDrop = new DropDown(this.driver, REGION_OR_STATE);
        driver.findElement(By.xpath(REGION_OR_STATE)).click();
        selectCountryRegionOrStateDrop.getElement().selectByValue(String.valueOf(selectIndexCountryRegionOrState));
        return this;
    }

    public CheckoutDeliveryDetailsPageObject clickIWantUseAnExistingAddressButton() {
        iWantUseAnExistingAddress = new Button(this.driver, CheckoutDeliveryDetailsLocators.EXISTING_ADDRESS);
        iWantUseAnExistingAddress.click();
        return this;
    }

    public CheckoutDeliveryDetailsPageObject clickIWantUseNewExistingAddressButton() {
        iWantUseNewExistingAddress = new Button(this.driver, CheckoutDeliveryDetailsLocators.NEW_ADDRESS);
        iWantUseNewExistingAddress.click();
        return this;
    }

    public CheckoutDeliveryMethodPageObject clickNextButton() {
        continueButton = new Button(this.driver, CheckoutDeliveryDetailsLocators.CONTINUE_DETAILS);
        continueButton.click();
        return new CheckoutDeliveryMethodPageObject(driver);
    }

}