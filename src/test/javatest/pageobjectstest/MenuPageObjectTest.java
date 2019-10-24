package pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.MenuPageObject;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class MenuPageObjectTest {
    WebDriver driver;
    MenuPageObject menu;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/shop");
        menu = new MenuPageObject(driver);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void pcPageTest(){
       String actual =  menu.goToPcDesktops().getCategoryName();
        String expected = "PC";
        assertEquals(actual,expected);
    }
    @Test
    public void macPageTest(){
        String actual =  menu.clickMacDesktops().getCategoryName();
        String expected = "Mac";
        assertEquals(actual,expected);
    }
    @Test
    public void showAllDesktopsPageTest(){
        String actual =  menu.showAllDesktops().getCategoryName();
        String expected = "Desktops";
        assertEquals(actual,expected);
    }
    @Test
    public void windowsPageTest(){
        String actual =  menu.goToWindowsLaptops().getCategoryName();
        String expected = "Windows";
        assertEquals(actual,expected);
    }
    @Test
    public void macsPageTest(){
        String actual =  menu.goToMacsLaptops().getCategoryName();
        String expected = "Macs";
        assertEquals(actual,expected);
    }
    @Test
    public void showAllLaptopsPageTest(){
        String actual =  menu.showAllLaptops().getCategoryName();
        String expected = "Laptops & Notebooks";
        assertEquals(actual,expected);
    }
    @Test
    public void miceAndTrackballsPageTest(){
        String actual =  menu.goToMiceAndTrackballsComponents().getCategoryName();
        String expected = "Mice and Trackballs";
        assertEquals(actual,expected);
    }
    @Test
    public void monitorsPageTest(){
        String actual =  menu.goToMonitorsComponents().getCategoryName();
        String expected = "Monitors";
        assertEquals(actual,expected);
    }
    @Test
    public void scannersPageTest(){
        String actual =  menu.goToScannersComponents().getCategoryName();
        String expected = "Scanners";
        assertEquals(actual,expected);
    }
    @Test
    public void printersPageTest(){
        String actual =  menu.goToPrintersComponents().getCategoryName();
        String expected = "Printers";
        assertEquals(actual,expected);
    }
    @Test
    public void webCamerasPageTest(){
        String actual =  menu.goToWebCamerasComponents().getCategoryName();
        String expected = "Web Cameras";
        assertEquals(actual,expected);
    }
    @Test
    public void showAllComponentsPageTest(){
        String actual =  menu.showAllComponents().getCategoryName();
        String expected = "Components";
        assertEquals(actual,expected);
    }
    @Test
    public void tabletsPageTest(){
        String actual =  menu.goToTablets().getCategoryName();
        String expected = "Tablets";
        assertEquals(actual,expected);
    }
    @Test
    public void softwarePageTest(){
        String actual =  menu.goToSoftware().getCategoryName();
        String expected = "Software";
        assertEquals(actual,expected);
    }
    @Test
    public void phonesPageTest(){
        String actual =  menu.goToPhonesAndPDAs().getCategoryName();
        String expected = "Phones & PDAs";
        assertEquals(actual,expected);
    }
    @Test
    public void camerasPageTest(){
        String actual =  menu.goToWebCameras().getCategoryName();
        String expected = "Cameras";
        assertEquals(actual,expected);
    }
    @Test
    public void mp3PageTest(){
        String actual =  menu.showAllMP3Players().getCategoryName();
        String expected = "MP3 Players";
        assertEquals(actual,expected);
    }
}