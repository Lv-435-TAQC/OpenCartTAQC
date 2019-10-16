package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.MenuPageObject;
import org.testng.Assert;
import pageobjects.ProductsPageObject;

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
        driver.close();
    }
    @Test
    public void PcPageTest(){
       String actual =  menu.goToPcDesktops().getLabelText();
        String expected = "PC";
        assertEquals(actual,expected);
    }
    @Test
    public void MacPageTest(){
        String actual =  menu.goToMacDesktops().getLabelText();
        String expected = "Mac";
        assertEquals(actual,expected);
    }
    @Test
    public void showAllDesktopsPageTest(){
        String actual =  menu.showAllDesktops().getLabelText();
        String expected = "Desktops";
        assertEquals(actual,expected);
    }
    @Test
    public void WindowsPageTest(){
        String actual =  menu.goToWindowsLaptops().getLabelText();
        String expected = "Windows";
        assertEquals(actual,expected);
    }
    @Test
    public void MacsPageTest(){
        String actual =  menu.goToMacsLaptops().getLabelText();
        String expected = "Macs";
        assertEquals(actual,expected);
    }
    @Test
    public void showAllLaptopsPageTest(){
        String actual =  menu.showAllLaptops().getLabelText();
        String expected = "Laptops & Notebooks";
        assertEquals(actual,expected);
    }
    @Test
    public void MiceAndTrackballsPageTest(){
        String actual =  menu.goToMiceAndTrackballsComponents().getLabelText();
        String expected = "Mice and Trackballs";
        assertEquals(actual,expected);
    }
    @Test
    public void MonitorsPageTest(){
        String actual =  menu.goToMonitorsComponents().getLabelText();
        String expected = "Monitors";
        assertEquals(actual,expected);
    }
    @Test
    public void ScannersPageTest(){
        String actual =  menu.goToScannersComponents().getLabelText();
        String expected = "Scanners";
        assertEquals(actual,expected);
    }
    @Test
    public void PrintersPageTest(){
        String actual =  menu.goToPrintersComponents().getLabelText();
        String expected = "Printers";
        assertEquals(actual,expected);
    }
    @Test
    public void WebCamerasPageTest(){
        String actual =  menu.goToWebCamerasComponents().getLabelText();
        String expected = "Web Cameras";
        assertEquals(actual,expected);
    }
    @Test
    public void showAllComponentsPageTest(){
        String actual =  menu.showAllComponents().getLabelText();
        String expected = "Components";
        assertEquals(actual,expected);
    }
    @Test
    public void TabletsPageTest(){
        String actual =  menu.goToTablets().getLabelText();
        String expected = "Tablets";
        assertEquals(actual,expected);
    }
    @Test
    public void SoftwarePageTest(){
        String actual =  menu.goToSoftware().getLabelText();
        String expected = "Software";
        assertEquals(actual,expected);
    }
    @Test
    public void PhonesPageTest(){
        String actual =  menu.goToPhonesAndPDAs().getLabelText();
        String expected = "Phones & PDAs";
        assertEquals(actual,expected);
    }
    @Test
    public void CamerasPageTest(){
        String actual =  menu.goToWebCameras().getLabelText();
        String expected = "Cameras";
        assertEquals(actual,expected);
    }
    @Test
    public void MP3PageTest(){
        String actual =  menu.showAllMP3Players().getLabelText();
        String expected = "MP3 Players";
        assertEquals(actual,expected);
    }
}