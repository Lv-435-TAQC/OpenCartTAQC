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
        request.insertDataToDB(INSERT_TO_VIEWED, connector.getStatement());
        request.deleteDataFromDB(DELETE_ALL_FROM_ORDER, connector.getStatement());
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
        connector.closeConnectionMariaDB();
        driver.close();
    }

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

    @Test
    public void validationOfDataInDatabaseAccordingToInformationOnStatisticsPage(){
        String actual = adminPageObject
                .getNavigation()
                .goToStatistics()
                .clickRefresh(ZERO)
                .getStatistics()
                .get(ZERO)
                .getValue();
        String expected = request
                .getDataFromDB(GET_FROM_ORDER, connector.getStatement(), "order_id", "total")
                .get(ZERO);
        Assert.assertEquals(Float.parseFloat(expected.split(" ")[1]),Float.parseFloat(actual));
    }

}
