package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.AdminPageObject;
import pageobjects.WishListPageObject;
import utils.DBConnector;
import utils.DBRequest;

import static utils.Constants.KEY_TO_DRIVER;
import static utils.Constants.PATH_TO_DRIVER;
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
        adminPageObject = new AdminPageObject(driver);
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
        Assert.assertEquals(request.getDataFromDB(GET_FROM_VIEWED, connector.getStatement()), EXPECTED);
    }

    @Test
    public void validationOfDataInDatabaseAccordingToInformationOnStatisticsPage(){
        adminPageObject
                .getNavigation()
                .goToStatistics()
                .getStatistics();
    }
    @Test
    public void buyingProductsFromWishListAndCheckingPurchaseInDatabase (){

    }
}
