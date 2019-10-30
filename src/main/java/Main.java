import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.AdminPageObject;
import pageobjects.AdminReportsProductViewedItemPO;

import java.util.List;

public class Main {

    public static final String ADMIN_NAME = "nataliia";
    public static final String ADMIN_PASSWORD = "vmnataliia";

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        AdminPageObject adminPageObject = new AdminPageObject(driver);
        List<AdminReportsProductViewedItemPO> itemPOList = adminPageObject
                .goToAdminPage()
                .logIn(ADMIN_NAME, ADMIN_PASSWORD)
                .closeModalWindow()
                .getNavigation()
                .goToReports()
                .clickProductsViewedReport()
                .getViewedItemPOS();

       System.out.println(itemPOList.get(0).getName());
    }
}