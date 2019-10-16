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
import pageobjects.HomePageObject;
import pageobjects.PreviewShoppingCart;
import pageobjects.ShoppingCartPageObject;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Code for run and testing my part of work!!!
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/OpenCart");


        HomePageObject home = new HomePageObject(driver);
        home.addToCart();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div[3]/div/button")));
        WebElement add3 = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/button"));
        add3.click();



        PreviewShoppingCart previewShoppingCart = new PreviewShoppingCart(driver);
        previewShoppingCart.removeProductFromShoppingCart("40");


//        WebElement enter = driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md'][contains(.,'Shopping Cart')]"));
//        enter.click();
//        ShoppingCartPageObject shoppingCartPageObject = new ShoppingCartPageObject(driver);
//        shoppingCartPageObject.
//               writeCouponCode("111");
//          shoppingCartPageObject.writeEstimateShippingAndTaxes("Ukraine",13,"790032");
//                shoppingCartPageObject.writeGiftCertificate("333");


//        System.out.println(shoppingCartPageObject.getCouponCode());
//        System.out.println(shoppingCartPageObject.getGiftCertificate());

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
