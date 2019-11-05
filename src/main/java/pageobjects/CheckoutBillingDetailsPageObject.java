package pageobjects;

import locators.CheckoutBillingDetailsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Button;
import pageelements.DropDown;
import pageelements.Input;

public class CheckoutBillingDetailsPageObject extends BasePageObject {
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

    public CheckoutBillingDetailsPageObject(WebDriver driver) {
        super(driver);
        WebElement explicitWait = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckoutBillingDetailsLocators.EXISTING_ADDRESS)));
    }

    public CheckoutDeliveryDetailsPageObject inputRequiredInformation(String firstName, String lastName, String company, String address1, String city, String selectCountry, String selectCountryRegionOrState) {
        this
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCompany(company)
                .setAddress1(address1)
                .setCity(city)
                .selectCountry(selectCountry)
                .selectCountryRegionOrState(selectCountryRegionOrState)
                .clickNextButton();
        return new CheckoutDeliveryDetailsPageObject(driver);
    }

    public CheckoutDeliveryDetailsPageObject inputNotRequiredInformation(String firstName, String lastName, String company, String address1, String address2, String city, String postCode, String selectCountry, String selectCountryRegionOrState) {
        this
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
        return new CheckoutDeliveryDetailsPageObject(driver);
    }

    public CheckoutDeliveryDetailsPageObject wantUseAnExistingAddressButton() {
        return this.clickNextButton();
    }

    public CheckoutDeliveryDetailsPageObject WantUseNewExistingAddressButtonWithAllInformation(String firstName, String lastName, String company, String address1, String address2, String city, String postCode, String selectCountry, String selectCountryRegionOrState) {
        return this.clickIWantUseAnExistingAddressButton()
                .inputNotRequiredInformation(firstName, lastName, company, address1, address2, city, postCode, selectCountry, selectCountryRegionOrState);
    }

    public CheckoutBillingDetailsPageObject setFirstName(String firstName) {
        firstNameField = new Input(this.driver, CheckoutBillingDetailsLocators.FIRST_NAME);
        firstNameField.setText(firstName);
        return this;
    }

    public CheckoutBillingDetailsPageObject setLastName(String lastName) {
        lastNameField = new Input(this.driver, CheckoutBillingDetailsLocators.LAST_NAME);
        lastNameField.setText(lastName);
        return this;
    }

    public CheckoutBillingDetailsPageObject setCompany(String company) {
        companyField = new Input(this.driver, CheckoutBillingDetailsLocators.COMPANY);
        companyField.setText(company);
        return this;
    }

    public CheckoutBillingDetailsPageObject setAddress1(String address1) {
        address1Field = new Input(this.driver, CheckoutBillingDetailsLocators.ADDRESS_1);
        address1Field.setText(address1);
        return this;
    }

    public CheckoutBillingDetailsPageObject setAddress2(String address2) {
        address2Field = new Input(this.driver, CheckoutBillingDetailsLocators.ADDRESS_2);
        address2Field.setText(address2);
        return this;
    }

    public CheckoutBillingDetailsPageObject setCity(String city) {
        cityField = new Input(this.driver, CheckoutBillingDetailsLocators.CITY);
        cityField.setText(city);
        return this;
    }

    public CheckoutBillingDetailsPageObject setPostCode(String postCode) {
        postCodeField = new Input(this.driver, CheckoutBillingDetailsLocators.POST_CODE);
        postCodeField.setText(postCode);
        return this;
    }

    public CheckoutBillingDetailsPageObject selectCountry(String selectCountry) {
        selectCountryDrop = new DropDown(this.driver, CheckoutBillingDetailsLocators.COUNTRY);
        selectCountryDrop.writeOptionParameter(selectCountry);
        return this;
    }

    public CheckoutBillingDetailsPageObject selectCountryRegionOrState(String selectCountryRegionOrState) {
        selectCountryRegionOrStateDrop = new DropDown(this.driver, CheckoutBillingDetailsLocators.REGION_OR_STATE);
        selectCountryRegionOrStateDrop.writeOptionParameter(selectCountryRegionOrState);
        return this;
    }

    public CheckoutBillingDetailsPageObject clickIWantUseAnExistingAddressButton() {
        iWantUseAnExistingAddress = new Button(this.driver, CheckoutBillingDetailsLocators.EXISTING_ADDRESS);
        iWantUseAnExistingAddress.click();
        return this;
    }

    public CheckoutBillingDetailsPageObject clickIWantUseNewExistingAddressButton() {
        iWantUseNewExistingAddress = new Button(this.driver, CheckoutBillingDetailsLocators.NEW_ADDRESS);
        iWantUseNewExistingAddress.click();
        return this;
    }

    public CheckoutDeliveryDetailsPageObject clickNextButton() {
        continueButton = new Button(this.driver, CheckoutBillingDetailsLocators.CONTINUE_BUTTON);
        continueButton.click();
        return new CheckoutDeliveryDetailsPageObject(driver);

    }

}