package pageobjects;

import org.openqa.selenium.WebDriver;
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


    public ItemInfoPageObject(WebDriver driver) {

        super(driver);
    }

    public ItemInfoPageObject findItemName() {
        itemName = new TextField(this.driver, ITEM_NAME);
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickItemDescriptionTab() {
        itemDescriptionTab = new Button(this.driver, ITEM_DESCRIPTION_TAB).click();
        return new ItemInfoPageObject(this.driver);
    }

    public  ItemInfoPageObject findTextField() {
        descriptionTextField = new TextField(this.driver, ITEM_DESCRIPTION_FIELD);
        return new ItemInfoPageObject(this.driver);
    }


    public ItemInfoPageObject clickItemReviewTab() {
        itemReviewTab = new Button(this.driver, ITEM_REVIEWS_TAB).click();
        return new ItemInfoPageObject(this.driver);
    }


    public ItemInfoPageObject enterName() {
        nameField = new Input(this.driver, NAME_INPUT_FIELD).setText("TEST NAME");
        return new ItemInfoPageObject(this.driver);
    }


    public ItemInfoPageObject enterReview() {
        reviewField = new Input(this.driver, REVIEW_INPUT_FIELD).setText("TEST REVIEW TEXT ");
        return new ItemInfoPageObject(this.driver);
    }


    public ItemInfoPageObject findScoreField() {
        scoreField = new TextField(this.driver, RATING_SCORE_FIELD);
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject selectLowRatingScoreButton() {
        lowRatingScoreButton = new Button(this.driver, LOW_RATING_SCORE_RADIO_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject selectHighestScoreButton() {
        highestRatingScoreButton = new Button(this.driver, HIGHEST_RATING_SCORE_RADIO_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject clickSubmitReviewButton() {
        submitReviewButton = new Button(this.driver, SUBMIT_REVIEW_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject addToWishList(){
        wishListButton = new Button(this.driver, ADD_TO_WISH_LIST_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject compareItems(){
        compareItemsButton = new Button(this.driver,COMPARE_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }


    public ItemInfoPageObject enterItemsQuantity(){
        quantityInputField = new Input(this.driver, QUANTITY_INPUT_FIELD).setText("2");
        return new ItemInfoPageObject(driver);
    }

    public ItemInfoPageObject addToCart(){
        addToCartButton = new Button(this.driver,ADD_TO_CART_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject findNavigationBar(){
        navigationBar = new Button(this.driver, NAVIGATION_BAR).isDisplayed();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject goToHomePage(){
        homePageButton = new Button(this.driver, HOME_BUTTON).click();
        return new ItemInfoPageObject(this.driver);
    }

    public ItemInfoPageObject verifySuccessNotification(){
        successNotificationMessage = new NotificationMeassage(this.driver,SUCCESS_NOTIFICATION_MESSAGE).isDisplayed();
        return new ItemInfoPageObject(this.driver);
    }
}
