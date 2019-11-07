package pageobjects;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageelements.Button;
import pageelements.Input;
import pageelements.NotificationMeassage;
import pageelements.TextField;

import static locators.ItemLocators.*;


public class ItemInfoPageObject extends BasePageObject {

    private Button itemDescriptionTab;
    private Button itemReviewTab;
    public Input nameField;
    public Input reviewField;
    private Button submitReviewButton;
    private Button lowRatingScoreButton;
    public Button highestRatingScoreButton;
    public TextField descriptionTextField;
    public TextField itemName;
    private TextField scoreField;
    public Button wishListButton;
    public Button compareItemsButton;
    public Button addToCartButton;
    public Input quantityInputField;
    public Button navigationBar;
    public Button homePageButton;
    public NotificationMeassage successNotificationMessage;
    public Button tabletsMenuButton;
    public Button tabletSelectionButton;


    public ItemInfoPageObject(WebDriver driver) {

        super(driver);
    }

    /**
     * Find name of selected Item;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject findItemName() {
        itemName = new TextField(this.driver, ITEM_NAME);
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Item Description Tab;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject clickItemDescriptionTab() {
        itemDescriptionTab = new Button(this.driver, ITEM_DESCRIPTION_TAB).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Text field of Description tab;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject findTextField() {
        descriptionTextField = new TextField(this.driver, ITEM_DESCRIPTION_FIELD);
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Review tab;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject clickItemReviewTab() {
        itemReviewTab = new Button(this.driver, ITEM_REVIEWS_TAB).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Name text field on the Review tab and enter any text;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject enterName() {
        nameField = new Input(this.driver, NAME_INPUT_FIELD).setText("TEST NAME");
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Name text field on the Review tab and enter text;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject enterReview() {
        reviewField = new Input(this.driver, REVIEW_INPUT_FIELD).setText("TEST REVIEW TEXT ");
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Score field;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject findScoreField() {
        scoreField = new TextField(this.driver, RATING_SCORE_FIELD);
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Select Lowest Rating on the Score field;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject selectLowRatingScoreButton() {
        lowRatingScoreButton = new Button(this.driver, LOW_RATING_SCORE_RADIO_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Select Highest Rating on the Score field;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject selectHighestScoreButton() {
        highestRatingScoreButton = new Button(this.driver, HIGHEST_RATING_SCORE_RADIO_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Click on Submit button to submit the Review;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject clickSubmitReviewButton() {
        submitReviewButton = new Button(this.driver, SUBMIT_REVIEW_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Add Item to the Wish List;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject addToWishList() {
        wishListButton = new Button(this.driver, ADD_TO_WISH_LIST_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Add Item to the Compare List;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject compareItems() {
        compareItemsButton = new Button(this.driver, COMPARE_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Enter Items quantity in to the Quantity text field;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject enterItemsQuantity() {
        quantityInputField = new Input(this.driver, QUANTITY_INPUT_FIELD).setText("2");
        return new ItemInfoPageObject(driver);
    }

    /**
     * Add Item to the Cart;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject addToCart() {
        addToCartButton = new Button(this.driver, ADD_TO_CART_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Verify that Navigation bar is displayed on the Item Description Page;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject findNavigationBar() {
        navigationBar = new Button(this.driver, NAVIGATION_BAR).isDisplayed();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Navigate to Home page;
     * @return HomePageObject;
     */

    public HomePageObject goToHomePage() {
        homePageButton = new Button(this.driver, HOME_BUTTON).click();
        return new HomePageObject(this.driver);
    }

    /**
     * Verification of Successful Notification message;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject verifySuccessNotification() {
        successNotificationMessage = new NotificationMeassage(this.driver, SUCCESS_NOTIFICATION_MESSAGE).isDisplayed();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Verification of text content of Successful Notification message;
     * @return NotificationMeassage;
     */

    public String getTextSuccessNotification() {
        return new NotificationMeassage(this.driver, SUCCESS_NOTIFICATION_MESSAGE).getText();
    }

    /**
     * Open Tablets list by selected category;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject openTabletsMenu() {
        tabletsMenuButton = new Button(this.driver, TABLETS_MENU).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Select Tablet for preview;
     * @return ItemInfoPageObject;
     */

    public ItemInfoPageObject selectTablet() {
        tabletSelectionButton = new Button(this.driver, SELECT_TABLET).click();
        return new ItemInfoPageObject(this.driver);
    }

    /**
     * Verify that Description page corresponds the selected Item;
     * @return true;
     */

    public Boolean findSelectedItemByImage(String itemPath) {
        Pattern pattern = new Pattern(itemPath);
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
