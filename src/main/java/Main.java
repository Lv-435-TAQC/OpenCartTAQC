import locators.ShoppingCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageelements.ShoppingProductsTable;
import pageobjects.ShoppingCartPageObject;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Code for run and testing my part of work!!!
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/OpenCart");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]")));
        WebElement add = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[1]"));
        WebElement add2 = driver.findElement(By.xpath("(//span[contains(.,'Add to Cart')])[1]"));
        add.click();
        add2.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div[3]/div/button")));
        WebElement add3 = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/button"));
//        add3.click();
//        PreviewShoppingCart previewShoppingCart = new PreviewShoppingCart(driver);
//        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/div/div[3]/div/ul/li[1]/table/tbody")));
//        previewShoppingCart.getMapProductInCart(ShoppingCartLocators.TABLE_PRODUCTS_FOR_PREVIEW_CART).get("MacBook").removeProduct();
        WebElement enter = driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md'][contains(.,'Shopping Cart')]"));
        enter.click();
        ShoppingCartPageObject shoppingCartPageObject = new ShoppingCartPageObject(driver);
       System.out.println(shoppingCartPageObject.getSubTotalCost());
        System.out.println(shoppingCartPageObject.getEcoTax());

        System.out.println(shoppingCartPageObject.getVAT());
//        System.out.println(shoppingCartPageObject.getCouponCode());
//        System.out.println(shoppingCartPageObject.getGiftCertificate());
        System.out.println(shoppingCartPageObject.getTotalCost());
        //shoppingCartPageObject.getShoppinProductsList().get("product 11").removeProductsFromCart();
//        shoppingCartPageObject.writeCouponCode("3333");
//        shoppingCartPageObject.writeEstimateShippingAndTaxes("Ukraine","L'vivs'ka Oblast'","790032");

//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"content\"]/form")));
//        ShoppingProductsTable table = new ShoppingProductsTable(driver, "//div[@id=\"content\"]/form/div/table/tbody");
//
//        System.out.println(table.productsListInCart().size());
//        System.out.println(table.productsListInCart().get(0).productName);
//        System.out.println(table.productsListInCart().get(1).productName);
//       table.productsListInCart().get(1).removeProductsFromCart();
//        driver.findElement(By.xpath(ShoppingCartLocators.OPEN_ESTIMATE_SHOPPING_TAXES_BUTTON)).click();
//
//        Select country = new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
//        country.selectByVisibleText("Bhutan");

    }

}
