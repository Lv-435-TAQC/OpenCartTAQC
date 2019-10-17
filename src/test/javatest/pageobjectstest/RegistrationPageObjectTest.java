package pageobjectstest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegistrationPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class RegistrationPageObjectTest {

    private WebDriver driver;
    private RegistrationPageObject registrationPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        registrationPageObject = new RegistrationPageObject(driver);
    }

    @BeforeMethod
    public void getToRegistrationPage() {
        registrationPageObject.goToUrl("http://192.168.65.128/opencart/index.php?route=account/register");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void firstNameFieldNumbersAndSymbolsNegativeTest() {
        registrationPageObject.setDataToFirstNameField("q873458273#%").pushOnContinueButton();
        String expectedMessage = "First Name does not appear to be valid!";
        assertFalse(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void firstNameFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToFirstNameField("").pushOnContinueButton();
        String expectedMessage = "First Name must be between 1 and 32 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void firstNameFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToFirstNameField("alsoiruejthgnsmcbnbksjsnbksdjfsjdnfjsndfjnsdjfnsdjfn")
                .pushOnContinueButton();
        String expectedMessage = "First Name must be between 1 and 32 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void lastNameFieldNumbersAndSymbolsNegativeTest() {
        registrationPageObject.setDataToLastNameField("q873458273#%").pushOnContinueButton();
        String expectedMessage = "Last Name does not appear to be valid!";
        assertFalse(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void lastNameFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToLastNameField("").pushOnContinueButton();
        String expectedMessage = "Last Name must be between 1 and 32 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void lastNameFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToLastNameField("alsoiruejthgnsmcbnbksjsnbksdjfsjdnfjsndfjnsdjfnsdjfn")
                .pushOnContinueButton();
        String expectedMessage = "Last Name must be between 1 and 32 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void emailFieldInvalidEmailAddressNegativeTest() {
        registrationPageObject.setDataToEmailField("akjdgfjdfkg").pushOnContinueButton();
        assertFalse((Boolean)((JavascriptExecutor)driver)
                .executeScript("return arguments[0].validity.valid;", registrationPageObject.getFieldEmail().element));
    }

    @Test
    public void emailFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToEmailField("").pushOnContinueButton();
        String expectedMessage = "E-Mail Address does not appear to be valid!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void telephoneFieldEmptySpaceNegativeTest() {
        registrationPageObject.setDataToTelephoneField("").pushOnContinueButton();
        String expectedMessage = "Telephone must be between 3 and 32 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void passwordFieldFewerAmountCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToPasswordField("075").pushOnContinueButton();
        String expectedMessage = "Password must be between 4 and 20 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void passwordFieldGreaterAmountOfCharactersThanAllowedNegativeTest() {
        registrationPageObject.setDataToPasswordField("12345678901234567890123456789012345678901")
                .pushOnContinueButton();
        String expectedMessage = "Password must be between 4 and 20 characters!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void passwordConfirmFieldInvalidConfirmationNegativeTest() {
        registrationPageObject
                .setDataToPasswordField("12345").setDataToPasswordConfirmField("085741").pushOnContinueButton();
        String expectedMessage = "Password confirmation does not match password!";
        assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @Test
    public void checkboxPrivacyPolicyClickTest() {
        registrationPageObject.checkOnPrivacyPolicyCheckbox().pushOnContinueButton();
        String unexpectedMessage = "Warning: You must agree to the Privacy Policy!";
        assertFalse(driver.getPageSource().contains(unexpectedMessage));
    }

    @Test(priority = 1)
    public void successfulRegisterTest() {
        registrationPageObject.setDataToFirstNameField("Paprika").setDataToLastNameField("Pepper")
                .setDataToEmailField(new Random().nextInt(1000) + "paprika@paprika.com")
                .setDataToTelephoneField("0794852421").setDataToPasswordField("12345").setDataToPasswordConfirmField("12345")
                .checkOnPrivacyPolicyCheckbox().pushOnContinueButton();
        String expectedURL = "http://192.168.65.128/opencart/index.php?route=account/success";
        assertEquals(driver.getCurrentUrl(), expectedURL);
    }
}
