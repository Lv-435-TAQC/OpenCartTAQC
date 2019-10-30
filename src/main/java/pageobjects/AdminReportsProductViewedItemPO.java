package pageobjects;

import org.openqa.selenium.WebDriver;

public class AdminReportsProductViewedItemPO extends BasePageObject {
    private String name;
    private String model;
    private String viewed;
    private String percent;

    public AdminReportsProductViewedItemPO(WebDriver driver, String n, String m, String v, String p) {
        super(driver);
        this.name = n;
        this.model = m;
        this.viewed = v;
        this.percent = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getViewed() {
        return viewed;
    }

    public void setViewed(String viewed) {
        this.viewed = viewed;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
