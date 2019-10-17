package pageobjects;

import locators.MenuLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageelements.Button;
import pageelements.TextButton;

import java.util.List;

import static utils.commonconstants.Constants.*;

public class MenuPageObject extends BasePageObject {
    private List<WebElement> listOfOptions;
    private Button desktopsOptionsButton;
    private Button showAllDesktopsButton;
    private Button laptopsOptionsButton;
    private Button showAllLaptopsButton;
    private Button componentsOptionsButton;
    private Button showAllComponentsButton;
    private Button tabletsButton;
    private Button softwareButton;
    private Button phonesAndPDAsButton;
    private Button webCamerasButton;
    private Button mp3PlayerButton;
    private Button showAllMP3PlayersButton;


    public MenuPageObject(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> createListOfOptions(String xpath){
        listOfOptions = driver.findElements(By.xpath(xpath));
        return listOfOptions;
    }

    public ProductsPageObject goToPcDesktops(){
    desktopsOptionsButton = new TextButton(driver, MenuLocators.DESKTOP_BUTTON_LOC).click();
    this.createListOfOptions(MenuLocators.DESKTOP_OPTIONS_LOC).get(NULL).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToMacDesktops(){
        desktopsOptionsButton = new TextButton(driver, MenuLocators.DESKTOP_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.DESKTOP_OPTIONS_LOC).get(ONE).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject showAllDesktops(){
        desktopsOptionsButton = new TextButton(driver, MenuLocators.DESKTOP_BUTTON_LOC).click();
        showAllDesktopsButton = new TextButton(driver,MenuLocators.SHOW_ALL_DESKTOPS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToMacsLaptops(){
        laptopsOptionsButton = new TextButton(driver,MenuLocators.LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.LAPTOPS_NOTEBOOKS_OPTIONS_LOC).get(NULL).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToWindowsLaptops(){
        laptopsOptionsButton = new TextButton(driver,MenuLocators.LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.LAPTOPS_NOTEBOOKS_OPTIONS_LOC).get(ONE).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject showAllLaptops(){
        laptopsOptionsButton = new TextButton(driver,MenuLocators.LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        showAllLaptopsButton = new TextButton(driver,MenuLocators.SHOW_ALL_LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToMiceAndTrackballsComponents(){
        componentsOptionsButton = new TextButton(driver,MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(NULL).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToMonitorsComponents(){
        componentsOptionsButton = new TextButton(driver,MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(ONE).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToPrintersComponents(){
        componentsOptionsButton = new TextButton(driver,MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(TWO).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToScannersComponents(){
        componentsOptionsButton = new TextButton(driver,MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(THREE).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToWebCamerasComponents(){
        componentsOptionsButton = new TextButton(driver,MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(FOUR).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject showAllComponents(){
        laptopsOptionsButton = new TextButton(driver,MenuLocators.COMPONENTS_BUTTON_LOC).click();
        showAllLaptopsButton = new TextButton(driver,MenuLocators.SHOW_ALL_COMPONENTS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToTablets(){
        tabletsButton = new TextButton(driver,MenuLocators.TABLETS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToSoftware(){
        tabletsButton = new TextButton(driver,MenuLocators.SOFTWARE_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToPhonesAndPDAs(){
        tabletsButton = new TextButton(driver,MenuLocators.PHONES_PDAS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject goToWebCameras(){
        tabletsButton = new TextButton(driver,MenuLocators.CAMERAS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

    public ProductsPageObject showAllMP3Players(){
        mp3PlayerButton = new Button(driver,MenuLocators.MP3_PLAYERS_BUTTON_LOC).click();
        showAllMP3PlayersButton = new Button(driver,MenuLocators.SHOW_ALL_MP3PLAYERS_BUTTON_LOC).click();
        return new ProductsPageObject(driver);
    }

}
