package pageobjectstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.CategoryPageObject;
import pageobjects.HeaderPageObject;
import pageobjects.MenuPageObject;

import java.lang.reflect.Method;

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

    @Test(dataProvider = "sortBySelector")
    public void sortByParamTest(String sortType, String expected) {
        categoryPageObject = new CategoryPageObject(driver);
        String actual = categoryPageObject.choseSortBySelectorByParam(sortType).getNameOfProduct(1);
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

    @Test(dataProvider = "showSelector")
    public void showNumberOfElements(String numberOfItems, Integer expected) {
        categoryPageObject = new CategoryPageObject(driver);
        Integer actual = categoryPageObject.choseShowSelectorByParam(numberOfItems).generateProductsPageObject().getProducts().size();
        Assert.assertTrue(actual <= expected);
    }

    @Test
    public void validateGridButtonByImageTest() throws FindFailed {
        Screen s = new Screen();
        Pattern fileGridButton = new Pattern("src/main/resources/sikulipatterns/gridButton.png");
        s.find(fileGridButton);
    }

    @Test
    public void validateListButtonByImageTest() throws FindFailed {
        Screen s = new Screen();
        Pattern fileListButton = new Pattern("src/main/resources/sikulipatterns/listButton.png");
        s.find(fileListButton);
    }

    @Test
    public void sortByNameAZParamValidateByImageTest() throws FindFailed {
        categoryPageObject = new CategoryPageObject(driver);
        categoryPageObject.clickGridButton().choseSortBySelectorByParam("Name (A - Z)");
        Pattern scroll = new Pattern("src/main/resources/sikulipatterns/scroll.png");
        Screen s = new Screen();
        s.type(Key.PAGE_DOWN);
        Pattern fileAppleCinema30 = new Pattern("src/main/resources/sikulipatterns/AppleCinema30.png");
        s.find(fileAppleCinema30);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
