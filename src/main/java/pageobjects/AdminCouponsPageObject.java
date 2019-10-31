package pageobjects;

import locators.AdminCouponsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Button;
import pageelements.CouponInTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminCouponsPageObject extends BasePageObject {
    HashMap<String, CouponInTable> coupons;
    private Button addNewCoupons;

    public AdminCouponsPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminCreationCouponPageObject goToCreationCoupon() {
        this.addNewCoupons = new Button(driver, AdminCouponsLocators.ADD_NEW_COUPONS).click();
        return new AdminCreationCouponPageObject(driver);
    }

    public Map getCouponsTable() {
        coupons = new HashMap<>();
        List<WebElement> tableRow = driver.findElements(By.tagName("tr"));
        for (int j = 1; j < tableRow.size(); j++) {
            String couponName = tableRow.get(j).findElement(By.xpath("td[2]")).getText();
            String couponCode = tableRow.get(j).findElement(By.xpath("td[3]")).getText();
            String discount = tableRow.get(j).findElement(By.xpath("td[4]")).getText();
            coupons.put(couponCode, new CouponInTable(couponName, couponCode, discount));
        }
        return coupons;
    }

}
