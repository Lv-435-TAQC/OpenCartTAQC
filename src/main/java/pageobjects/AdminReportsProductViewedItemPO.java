package pageobjects;

import org.openqa.selenium.WebDriver;

public class AdminReportsProductViewedItemPO extends BasePageObject {
    private String name;
    private String model;
    private String viewed;
    private String percent;

    public AdminReportsProductViewedItemPO(WebDriver driver, String name, String model, String viewed, String percent) {
        super(driver);
        this.name = name;
        this.model = model;
        this.viewed = viewed;
        this.percent = percent;
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
