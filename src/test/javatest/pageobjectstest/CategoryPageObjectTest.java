package pageobjectstest;

import locators.CategoryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.CategoryPageObject;
import pageobjects.MenuPageObject;
import patterns.CategoryPatterns;
import utils.commonconstants.Constants;

import java.lang.reflect.Method;


public class CategoryPageObjectTest {
    WebDriver driver;
    MenuPageObject menuPageObject;
    CategoryPageObject categoryPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", Constants.PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.get("http://192.168.92.128/opencart");
        menuPageObject = new MenuPageObject(driver);
        menuPageObject.showAllDesktops();
    }

    /**
     * <b>TC-01: Test Text in label Sort By.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Get text from label;
     * <li>4. Verify text;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void labelSortByTextTest() {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        String actual = categoryPageObject
                .getFilterPageObject()
                .getSortByLabelText();
        String expected = "Sort By:";
        Assert.assertTrue(actual.contains(expected));
    }

    /**
     * <b>TC-02: Test Text in label Show.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Get text from label;
     * <li>4. Verify text;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void labelShowTextTest() {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        String actual = categoryPageObject
                .getFilterPageObject()
                .getShowLabelText();
        String expected = "Show:";
        Assert.assertTrue(actual.contains(expected));
    }

    @DataProvider(name = "sortBySelector")
    public Object[][] createDataForSortByParam(Method m) {
        return new Object[][]{new Object[]{"Default", "Apple Cinema 30"}
                , new Object[]{"Name (A - Z)", "Apple Cinema 30"}
                , new Object[]{"Name (Z - A)", "Sony VAIO"}
                , new Object[]{"Price (Low > High)", "Canon EOS 5D"}
                , new Object[]{"Price (High > Low)", "Sony VAIO"}
                , new Object[]{"Rating (Highest)", "Sony VAIO"}
                , new Object[]{"Rating (Lowest)", "Apple Cinema 30"}
                , new Object[]{"Model (A - Z)", "HTC Touch HD"}
                , new Object[]{"Model (Z - A)", "Product 8"}
        };
    }

    /**
     * <b>TC-03: Test selector Sort By.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Select option from selector sort by;
     * <li>4. Get name of first product ;
     * <li>5. Verify name with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test(dataProvider = "sortBySelector")
    public void sortByParamTest(String sortType, String expected) {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        String actual = categoryPageObject
                .getFilterPageObject()
                .choseSortBySelectorByParam(sortType)
                .getNameOfProductByNumberOfProduct(1);
        Assert.assertTrue(actual.contains(expected));
    }

    /**
     * <b>TC-04: Test list button.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Click for list button;
     * <li>4. Get attribute "class" of first product ;
     * <li>5. Verify attribute with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void ListButtonTest() {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        categoryPageObject
                .getFilterPageObject()
                .clickListButton();
        String actual = driver.findElement(By.xpath(CategoryLocators.FIRST_PRODUCT_LOC)).getAttribute("class");
        String expected = "product-layout product-list col-xs-12";
        Assert.assertTrue(actual.contains(expected));
    }

    /**
     * <b>TC-05: Test grid button.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Click for grid button;
     * <li>4. Get attribute "class" of first product ;
     * <li>5. Verify attribute with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void GridButtonTest() {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        categoryPageObject
                .getFilterPageObject()
                .clickGridButton();
        String actual = driver.findElement(By.xpath(CategoryLocators.FIRST_PRODUCT_LOC)).getAttribute("class");
        String expected = "product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12";
        Assert.assertTrue(actual.contains(expected));
    }

    @DataProvider(name = "showSelector")
    public Object[][] createDataForShowElements(Method m) {
        return new Object[][]{
                new Object[]{"15", 15}
                , new Object[]{"25", 25}
                , new Object[]{"50", 50}
                , new Object[]{"75", 75}
                , new Object[]{"100", 100}
        };
    }

    /**
     * <b>TC-06: Test show selector.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Select option from selector show;
     * <li>4. Get name of first product ;
     * <li>5. Verify name with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test(dataProvider = "showSelector")
    public void showNumberOfElements(String numberOfItems, Integer expected) {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        Integer actual = categoryPageObject
                .getFilterPageObject()
                .choseShowSelectorByParam(numberOfItems)
                .generateProductsPageObjects()
                .getProductsPO().size();
        Assert.assertTrue(actual <= expected);
    }

    /**
     * <b>TC-07: Test design in Grid Button.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3.  Verify design of button with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void validateGridButtonByImageTest() {
        Screen s = new Screen();
        Pattern fileGridButton = new Pattern(CategoryPatterns.GRID_BUTTON_PATTERN);
        Assert.assertTrue(menuPageObject.findPatternByScreen(s, fileGridButton));
    }

    /**
     * <b>TC-08: Test design in List Button.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3.  Verify design of button with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void validateListButtonByImageTest() {
        Screen s = new Screen();
        Pattern fileListButton = new Pattern(CategoryPatterns.LIST_BUTTON_PATTERN);
        Assert.assertTrue(menuPageObject.findPatternByScreen(s, fileListButton));
    }

    /**
     * <b>TC-09: Test selector Sort By.</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Open Firefox browser;
     * <li>2. Open All desktops Page on OpenCart.com;
     * <li>3. Select option from selector sort by;
     * <li>4. Verify product with expected;
     * </ul>
     * <p>
     * Expected Result: User can submit a review;
     */
    @Test
    public void sortByNameAZParamValidateByImageTest() {
        categoryPageObject = new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
        categoryPageObject
                .getFilterPageObject()
                .clickGridButton()
                .getFilterPageObject()
                .choseSortBySelectorByParam("Name (A - Z)");
        Screen s = new Screen();
        s.type(Key.PAGE_DOWN);
        Pattern fileAppleCinema30 = new Pattern(CategoryPatterns.APPLE_CINEMA_PRODUCT_PATTERN);
        Assert.assertTrue(categoryPageObject.findPatternByScreen(s, fileAppleCinema30));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
