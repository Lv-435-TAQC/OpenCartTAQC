package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.AdminPageObject;
import pageobjects.WishListPageObject;
import utils.DBConnector;
import utils.DBRequest;

import java.util.ArrayList;

import static utils.Constants.*;
import static utils.DBConstants.*;
import static utils.DBConstants.ADMIN_PASSWORD;

public class AdminReportsUserStories {
    WebDriver driver;
    DBConnector connector;
    DBRequest request;
    AdminPageObject adminPageObject;

    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_TO_DRIVER, PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        connector = new DBConnector();
        connector.getConnectionMariaDB(MARIA_DB_DRIVER, MARIA_DB_URL, MARIA_DB_USER_NAME, MARIA_DB_PASSWORD);
        request = new DBRequest();
        request.deleteDataFromDB(DELETE_ALL_FROM_ORDER, connector.getStatement());
        request.insertDataToDB(UPDATE_VIEWED_PRODUCTS, connector.getStatement());
        request.insertDataToDB(INSERT_TO_ORDER, connector.getStatement());
        adminPageObject = new AdminPageObject(driver);

    }

    @BeforeMethod
    public void getHome() {
        adminPageObject
                .goToAdminPage()
                .logIn(ADMIN_NAME, ADMIN_PASSWORD)
                .closeModalWindow();
    }

    @AfterMethod
    public void makeScreenshots(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            WishListPageObject.makeScreenShotSteps(driver, result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        connector.closeConnectionMariaDB();
        driver.close();
    }

    /**
     * <b>TC-01: Validation Data On Reports According To Database.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Reports/reports in Navigation Tab;
     * <li>2. Choose Products Viewed Report in Filter;
     * <li>3. Click Reset;
     * <li>4. Get Data from Database about about views;
     * </ul>
     * <p>
     * Expected Result: In Database noted that products with id <35 weren't viewed.
     */

    @Test
    public void validationOfDataOnReportsProductViewedPageAccordingToInformationInDatabase() {
          adminPageObject
                .getNavigation()
                .goToReports()
                .clickProductsViewedReport()
                .getAdminReportsProductViewedPO()
                .clickResetAndDeleteItemsFromList();
        ArrayList actual = request
                .getDataFromDB(GET_FROM_VIEWED, connector.getStatement(), "product_id", "viewed");
        System.out.println(actual);
        Assert.assertEquals( actual, EXPECTED_FOR_REPORTS);
    }

    /**
     * <b>TC-02: Validation Data On Statistics According To Database.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Reports/statistics in Navigation Tab;
     * <li>2. Click Refresh on Order Sales in Statistics;
     * <li>3. Get Value from Order Sales in Statistics;
     * <li>4. Get Data from Database about Order Sales;
     * </ul>
     * <p>
     * Expected Result: In Statistics and in the database the same orders' information by Value.
     */

    @Test
    public void validationOfDataInDatabaseAccordingToInformationOnStatisticsPage(){
        String actual = adminPageObject
                .getNavigation()
                .goToStatistics()
                .clickRefresh(ZERO)
                .getStatistics()
                .get(ZERO)
                .getValue();
        System.out.println(actual);
        String expected = request
                .getDataFromDB(GET_FROM_ORDER, connector.getStatement(), "order_id", "total")
                .get(ZERO);
        System.out.println(expected);
        Assert.assertEquals(Float.parseFloat(expected.split(" ")[1]),Float.parseFloat(actual));
    }

}
