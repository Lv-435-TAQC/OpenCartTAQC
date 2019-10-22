package pageobjects;

import locators.CategoryLocators;
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

    private List<WebElement> createListOfOptions(String xpath) {
        listOfOptions = driver.findElements(By.xpath(xpath));
        return listOfOptions;
    }

    public CategoryPageObject goToPcDesktops() {
        desktopsOptionsButton = new TextButton(driver, MenuLocators.DESKTOP_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.DESKTOP_OPTIONS_LOC).get(ZERO).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToMacDesktops() {
        desktopsOptionsButton = new TextButton(driver, MenuLocators.DESKTOP_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.DESKTOP_OPTIONS_LOC).get(ONE).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject showAllDesktops() {
        desktopsOptionsButton = new TextButton(driver, MenuLocators.DESKTOP_BUTTON_LOC).click();
        showAllDesktopsButton = new TextButton(driver, MenuLocators.SHOW_ALL_DESKTOPS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToMacsLaptops() {
        laptopsOptionsButton = new TextButton(driver, MenuLocators.LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.LAPTOPS_NOTEBOOKS_OPTIONS_LOC).get(ZERO).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToWindowsLaptops() {
        laptopsOptionsButton = new TextButton(driver, MenuLocators.LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.LAPTOPS_NOTEBOOKS_OPTIONS_LOC).get(ONE).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject showAllLaptops() {
        laptopsOptionsButton = new TextButton(driver, MenuLocators.LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        showAllLaptopsButton = new TextButton(driver, MenuLocators.SHOW_ALL_LAPTOPS_NOTEBOOKS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToMiceAndTrackballsComponents() {
        componentsOptionsButton = new TextButton(driver, MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(ZERO).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToMonitorsComponents() {
        componentsOptionsButton = new TextButton(driver, MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(ONE).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToPrintersComponents() {
        componentsOptionsButton = new TextButton(driver, MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(TWO).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToScannersComponents() {
        componentsOptionsButton = new TextButton(driver, MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(THREE).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToWebCamerasComponents() {
        componentsOptionsButton = new TextButton(driver, MenuLocators.COMPONENTS_BUTTON_LOC).click();
        this.createListOfOptions(MenuLocators.COMPONENTS_OPTIONS_LOC).get(FOUR).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject showAllComponents() {
        laptopsOptionsButton = new TextButton(driver, MenuLocators.COMPONENTS_BUTTON_LOC).click();
        showAllLaptopsButton = new TextButton(driver, MenuLocators.SHOW_ALL_COMPONENTS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToTablets() {
        tabletsButton = new TextButton(driver, MenuLocators.TABLETS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToSoftware() {
        tabletsButton = new TextButton(driver, MenuLocators.SOFTWARE_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToPhonesAndPDAs() {
        tabletsButton = new TextButton(driver, MenuLocators.PHONES_PDAS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject goToWebCameras() {
        tabletsButton = new TextButton(driver, MenuLocators.CAMERAS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.SUB_PRODUCTS_DIV_LOC);
    }

    public CategoryPageObject showAllMP3Players() {
        mp3PlayerButton = new Button(driver, MenuLocators.MP3_PLAYERS_BUTTON_LOC).click();
        showAllMP3PlayersButton = new Button(driver, MenuLocators.SHOW_ALL_MP3PLAYERS_BUTTON_LOC).click();
        return new CategoryPageObject(driver, CategoryLocators.ALL_PRODUCTS_DIV_LOC);
    }

}
