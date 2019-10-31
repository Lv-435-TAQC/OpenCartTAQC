import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.AdminPageObject;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        AdminPageObject adminPageObject = new AdminPageObject(driver);

        adminPageObject
                .goToAdminPage()
                .logIn("nataliia", "vmnataliia")
                .closeModalWindow()
                .getNavigation()
                .goToReports().clickProductsViewedReport()
                .getAdminReportsProductViewedPO()
                .clickResetAndDeleteItemsFromList();
    }
}