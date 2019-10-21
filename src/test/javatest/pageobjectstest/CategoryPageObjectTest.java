package pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CategoryPageObject;
import pageobjects.HeaderPageObject;
import pageobjects.MenuPageObject;

public class CategoryPageObjectTest {
    WebDriver driver;
    HeaderPageObject headerPageObject;
    MenuPageObject menuPageObject;
    CategoryPageObject categoryPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://192.168.92.128/opencart");
        headerPageObject = new HeaderPageObject(driver);
        headerPageObject.goToLoginPage().logIn("oleh.zarichnyi@gmail.com", "lhgfeilhgfei");
    }

    @BeforeMethod
    public void goToTestPage() {
        menuPageObject = new MenuPageObject(driver);
        menuPageObject.showAllDesktops();
    }

    @Test
    public void labelSortByTextTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.getSortByLabelText();
        String expected = "Sort By:";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void labelShowTextTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.getShowLabelText();
        String expected = "Show:";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByDefaultParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Default").getNameOfProduct(1);
        String expected = "Apple Cinema 30";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByNameAZParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Name (A - Z)").getNameOfProduct(1);
        String expected = "Apple Cinema 30";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByNameZAParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Name (Z - A)").getNameOfProduct(1);
        String expected = "Sony VAIO";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByPriceLowHighParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Price (Low > High)").getNameOfProduct(1);
        System.out.println(actual);
        String expected = "Canon EOS 5D";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByPriceHighLowParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Price (High > Low)").getNameOfProduct(1);
        String expected = "Sony VAIO";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByRatingHighestParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Rating (Highest)").getNameOfProduct(1);
        String expected = "Sony VAIO";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByRatingLowestParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Rating (Lowest)").getNameOfProduct(1);
        String expected = "Apple Cinema 30";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByModelAZParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Model (A - Z)").getNameOfProduct(1);
        String expected = "HTC Touch HD";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void sortByModelZAParamTest() {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam("Model (Z - A)").getNameOfProduct(1);
        String expected = "Product 8";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void ListButtonTest() {
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.clickListButton();
        String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[1]")).getAttribute("class");
        String expected = "product-layout product-list col-xs-12";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void GridButtonTest() {
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.clickGridButton();
        String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[1]")).getAttribute("class");
        String expected = "product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void showFifteenElements() {
        categoryPageObject = new CategoryPageObject(driver);
        Integer actual = categoryPageObject.choseShowSelectorByParam("15").generateProductsPageObject().getProducts().size();
        Integer expected = 15;
        Assert.assertTrue(actual <= expected);
    }

    @Test
    public void showTwentyFiveElements() {
        categoryPageObject = new CategoryPageObject(driver);
        Integer actual = categoryPageObject.choseShowSelectorByParam("25").generateProductsPageObject().getProducts().size();
        Integer expected = 25;
        Assert.assertTrue(actual <= expected);
    }

    @Test
    public void showFiftyElements() {
        categoryPageObject = new CategoryPageObject(driver);
        Integer actual = categoryPageObject.choseShowSelectorByParam("50").generateProductsPageObject().getProducts().size();
        Integer expected = 50;
        Assert.assertTrue(actual <= expected);
    }

    @Test
    public void showSeventyFiveElements() {
        categoryPageObject = new CategoryPageObject(driver);
        Integer actual = categoryPageObject.choseShowSelectorByParam("75").generateProductsPageObject().getProducts().size();
        Integer expected = 75;
        Assert.assertTrue(actual <= expected);
    }

    @Test
    public void showHundredElements() {
        categoryPageObject = new CategoryPageObject(driver);
        Integer actual = categoryPageObject.choseShowSelectorByParam("100").generateProductsPageObject().getProducts().size();
        Integer expected = 100;
        Assert.assertTrue(actual <= expected);
    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
