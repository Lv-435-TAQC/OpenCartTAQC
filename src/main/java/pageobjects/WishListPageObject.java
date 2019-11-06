package pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.Label;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static locators.WishListLocators.*;
import static utils.Constants.WISH_LIST_URL;


public class WishListPageObject extends BasePageObject {

    private HeaderPageObject headerPageObject;
    private MenuPageObject menuPageObject;
    private Label label;
    private HashMap<String, WishListItem> items;

    public HeaderPageObject getHeaderPageObject() {
        return headerPageObject;
    }

    public MenuPageObject getMenuPageObject() {
        return menuPageObject;
    }

    public WishListPageObject(WebDriver driver) {
        super(driver);
        this.headerPageObject = new HeaderPageObject(driver);
        this.menuPageObject = new MenuPageObject(driver);
        this.label = new Label(driver, ALERT_LABEL_WISH_LIST);
    }

    public Label getLabel() {
        return this.label;
    }

    public HashMap<String, WishListItem> getItems() {
        return this.getMapOfItems();
    }

    public static void makeScreenShotSteps(WebDriver driver, String screenshotsName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src\\main\\resources\\screenshots\\" + screenshotsName + ".png"));
        } catch (IOException e) {
        }
    }

    public ItemInfoPageObject clickItemImage(String id){
        HashMap<String, WishListItem> items = getMapOfItems();
        items.get(id).getImage().click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickItemProductName(String id){
        HashMap<String, WishListItem> items = getMapOfItems();
        items.get(id).getProductName().click();
        return new ItemInfoPageObject(this.driver);
    }

    public WishListPageObject removeItemFromWishList(String id){
        HashMap<String, WishListItem> items = getMapOfItems();
        items.get(id).getRemove().click();
        items.remove(id);
        return this;
    }

    public BasePageObject addItemToCart(String id){
        HashMap<String, WishListItem> items = getMapOfItems();
        items.get(id).getAddToCart().click();
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals(WISH_LIST_URL)){
            return this;
        }else {
            return new ItemInfoPageObject(driver);
        }
    }

    public String getTextFromAlertLabel() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALERT_LABEL_WISH_LIST)));
        return this.getLabel().getText();
    }

    public HashMap<String, WishListItem> getMapOfItems(){
        this.items = new HashMap<>();
        List<WebElement> listTr = driver.findElement(By.xpath(WISH_LIST_TABLE)).findElements(By.xpath("tr"));

        for (WebElement element: listTr ) {
            String id = element.findElement(By.xpath("td[2]/a")).getAttribute("href").split("=")[2];
            WebElement image = element.findElement(By.xpath("td[1]/a"));
            WebElement productName = element.findElement(By.xpath("td[2]/a"));
            WebElement addToCart = element.findElement(By.xpath("td[6]/button"));
            WebElement remove = element.findElement(By.xpath("td[6]/a"));
            this.items.put(id,new WishListItem(driver, image, productName, addToCart, remove));
        }
        return items;
    }

    public Boolean findImageInScreen(String wayToImage){
        Pattern pattern = new Pattern(wayToImage);
        Screen screen = new Screen();
        try {
            screen.find(pattern);
            return true;
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            return false;
        }
    }


}


