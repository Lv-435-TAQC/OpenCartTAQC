package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminStatisticsItemPageObject extends BasePageObject {
    private String name;
    private String value;
    private WebElement refresh;

    public AdminStatisticsItemPageObject(WebDriver driver, String name, String value, WebElement refresh) {
        super(driver);
        this.name = name;
        this.value = value;
        this.refresh = refresh;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public WebElement getRefresh() {
        return refresh;
    }
}
