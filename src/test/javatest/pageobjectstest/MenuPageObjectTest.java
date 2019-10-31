package javatest.pageobjectstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.MenuPageObject;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import static utils.ConstantsForMenu.*;

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

    /**
     * <b>TC-01: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:PC.
     */

    @Test
    public void pcPageTest(){
       String actual =  menu.goToPcDesktops().getCategoryName();
        assertEquals(actual,PC_TITLE_LOC);
    }

    /**
     * <b>TC-02: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Mac.
     */

    @Test
    public void macPageTest(){
        String actual =  menu.clickMacDesktops().getCategoryName();
        assertEquals(actual,MAC_TITLE_LOC);
    }

    /**
     * <b>TC-03: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Desktops.
     */

    @Test
    public void showAllDesktopsPageTest(){
        String actual =  menu.showAllDesktops().getCategoryName();
        assertEquals(actual,DESKTOPS_TITLE_LOC);
    }

    /**
     * <b>TC-04: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Windows.
     */

    @Test
    public void windowsPageTest(){
        String actual =  menu.goToWindowsLaptops().getCategoryName();
        assertEquals(actual,WINDOWS_TITLE_LOC);
    }

    /**
     * <b>TC-05: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Macs.
     */

//    @Test
//    public void macsPageTest(){
//        String actual =  menu.goToMacsLaptops().getCategoryName();
//        assertEquals(actual,MACS_TITLE_LOC);
//    }

    /**
     * <b>TC-06: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Laptops & Notebooks.
     */

    @Test
    public void showAllLaptopsPageTest(){
        String actual =  menu.showAllLaptops().getCategoryName();
        assertEquals(actual,LAPTOPS_TITLE_LOC);
    }

    /**
     * <b>TC-07: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Mice and Trackballs.
     */

//    @Test
//    public void miceAndTrackballsPageTest(){
//        String actual =  menu.goToMiceAndTrackballsComponents().getCategoryName();
//        assertEquals(actual,MICE_TITLE_LOC);
//    }

    /**
     * <b>TC-08: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Monitors.
     */

    @Test
    public void monitorsPageTest(){
        String actual =  menu.goToMonitorsComponents().getCategoryName();
        assertEquals(actual,MONITORS_TITLE_LOC);
    }

    /**
     * <b>TC-09: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Scanners.
     */

    @Test
    public void scannersPageTest(){
        String actual =  menu.goToScannersComponents().getCategoryName();
        assertEquals(actual,SCANNERS_TITLE_LOC);
    }

    /**
     * <b>TC-10: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Printers.
     */

    @Test
    public void printersPageTest(){
        String actual =  menu.goToPrintersComponents().getCategoryName();
        assertEquals(actual,PRINTERS_TITLE_LOC);
    }

    /**
     * <b>TC-11: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Web Cameras.
     */

    @Test
    public void webCamerasPageTest(){
        String actual =  menu.goToWebCamerasComponents().getCategoryName();
        assertEquals(actual,WEB_CAMERAS_TITLE_LOC);
    }

    /**
     * <b>TC-12: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Components.
     */

    @Test
    public void showAllComponentsPageTest(){
        String actual =  menu.showAllComponents().getCategoryName();
        assertEquals(actual,COMPONENTS_TITLE_LOC);
    }

    /**
     * <b>TC-13: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Tablets.
     */

    @Test
    public void tabletsPageTest(){
        String actual =  menu.goToTablets().getCategoryName();
        assertEquals(actual,TABLETS_TITLE_LOC);
    }

    /**
     * <b>TC-14: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Software.
     */

    @Test
    public void softwarePageTest(){
        String actual =  menu.goToSoftware().getCategoryName();
        assertEquals(actual,SOFTWARE_TITLE_LOC);
    }

    /**
     * <b>TC-15: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Phones & PDAs.
     */

    @Test
    public void phonesPageTest(){
        String actual =  menu.goToPhonesAndPDAs().getCategoryName();
        assertEquals(actual,PHONES_PDAS_TITLE_LOC);
    }

    /**
     * <b>TC-16: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:Cameras.
     */

    @Test
    public void camerasPageTest(){
        String actual =  menu.goToWebCameras().getCategoryName();
        assertEquals(actual,CAMERAS_TITLE_LOC);
    }

    /**
     * <b>TC-17: Menu options tests.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click Option button;
     * <li>2. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:MP3 Players.
     */

    @Test
    public void mp3PageTest(){
        String actual =  menu.showAllMP3Players().getCategoryName();
        assertEquals(actual,MP3PLAYERS_TITLE_LOC);
    }
}