package pageobjects;

import locators.AdminGiftVouchersLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Button;
import pageelements.VoucherInTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminGiftVouchersPageObject extends BasePageObject {
    private Button addNewVoucher;
    private Button removeVoucher;
    private HashMap<String, VoucherInTable> vouchers;

    public AdminGiftVouchersPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminCreationGiftVoucherPageObject goToCreationGiftVoucher() {
        this.addNewVoucher = new Button(driver, AdminGiftVouchersLocators.ADD_NEW_VOUCHER).click();
        return new AdminCreationGiftVoucherPageObject(driver);
    }

    public Map getGiftVouchersTable() {
        vouchers = new HashMap<>();
        List<WebElement> tableRow = driver.findElements(By.tagName("tr"));
        for (int j = 1; j < tableRow.size(); j++) {
            Button mark = new Button(tableRow.get(j), "td[1]");
            String code = tableRow.get(j).findElement(By.xpath("td[2]")).getText();
            String from = tableRow.get(j).findElement(By.xpath("td[3]")).getText();
            String to = tableRow.get(j).findElement(By.xpath("td[4]")).getText();
            String amount = tableRow.get(j).findElement(By.xpath("td[5]")).getText();
            vouchers.put(code, new VoucherInTable(mark, code, from, to, amount));
        }
        return vouchers;
    }


}
