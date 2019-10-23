package pageobjects;

import org.openqa.selenium.WebDriver;

public class MyAccountPageObject extends BasePageObject {
    private HeaderPageObject headerPageObject;
    private MenuPageObject menuPageObject;
    public MyAccountPageObject(WebDriver driver) {
        super(driver);
        this.headerPageObject = new HeaderPageObject(driver);
        this.menuPageObject = new MenuPageObject(driver);
    }

    public HeaderPageObject goToHeader(){
        return new HeaderPageObject(driver);
    }

    public MenuPageObject getMenuPageObject(){
        return new MenuPageObject(driver);
    }
}
