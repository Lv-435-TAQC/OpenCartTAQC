package pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageelements.Label;
import org.sikuli.script.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static locators.WishListLocators.*;


public class WishListPageObject extends BasePageObject {
    private HeaderPageObject header;
    private MenuPageObject menu;
    private Label label;
    private HashMap<String, WishListItemPageObject> items;
    org.sikuli.script.Screen screen = new org.sikuli.script.Screen();

    public WishListPageObject(WebDriver driver) {
        super(driver);
        this.header = new HeaderPageObject(driver);
        this.menu = new MenuPageObject(driver);

    }

    public static void makeScreenShotSteps(WebDriver driver, String screenshotsName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src\\main\\resources\\screenshots\\" + screenshotsName + ".png"));
        } catch (IOException e) {
        }
    }

    public ItemInfoPageObject itemImageClick(String id){
        HashMap<String, WishListItemPageObject> items = getMapOfItems();
        items.get(id).image.click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject itemProductNameClick(String id){
        HashMap<String, WishListItemPageObject> items = getMapOfItems();
        items.get(id).productName.click();
        return new ItemInfoPageObject(this.driver);
    }

    public WishListPageObject removeItemFromWishList(String id){
        HashMap<String, WishListItemPageObject> items = getMapOfItems();
        items.get(id).remove.click();
        items.remove(id);
        return this;
    }

    public BasePageObject addItemToCart(String id){
        HashMap<String, WishListItemPageObject> items = getMapOfItems();
        items.get(id).addToCart.click();
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
        label = new Label(this.driver, ALERT_LABEL_WISH_LIST);
        return label.getText();
    }

    public HashMap<String, WishListItemPageObject> getMapOfItems(){
        HashMap<String, WishListItemPageObject> items = new HashMap<String, WishListItemPageObject>();
        List<WebElement> listTr = driver.findElement(By.xpath(WISH_LIST_TABLE)).findElements(By.xpath("tr"));

        for (WebElement element: listTr ) {
            String id = element.findElement(By.xpath("td[2]/a")).getAttribute("href").split("=")[2];
            WebElement image = element.findElement(By.xpath("td[1]/a"));
            WebElement productName = element.findElement(By.xpath("td[2]/a"));
            WebElement addToCart = element.findElement(By.xpath("td[6]/button"));
            WebElement remove = element.findElement(By.xpath("td[6]/a"));
            items.put(id,new WishListItemPageObject(driver, image, productName, addToCart, remove));
        }
        return items;
    }

    public static Boolean findImageInScreen(Screen screen, Pattern pattern){
        try {
            screen.find(pattern);
            return true;
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            return false;
        }
    }
}


