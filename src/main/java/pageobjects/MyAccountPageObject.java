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

    public HeaderPageObject getHeaderPageObject(){
        return this.headerPageObject;
    }

    public MenuPageObject getMenuPageObject(){
        return this.menuPageObject;
    }
}
