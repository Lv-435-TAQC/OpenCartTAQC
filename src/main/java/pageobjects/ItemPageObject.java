package pageobjects;

import locators.ItemLocators;
import org.openqa.selenium.WebDriver;
import pageelements.Button;
import pageelements.Input;
import pageelements.TextField;
import pageelements.TextFromWebElement;

import static locators.ItemLocators.*;


public class ItemPageObject extends BasePageObject {

    private Button ItemDescriptionTab;
    private Button ItemReviewTab;
    private Input NameField;
    private Input ReviewField;
    private Button SubmitReviewButton;
    private Button LowRatingScoreButton;
    private Button HighestRatingScoreButton;
    private TextField DescriptionTextField;
    private TextField ItemName;
    private TextField ScoreField;


    public ItemPageObject(WebDriver driver) {

        super(driver);
    }

    public ItemPageObject findItemName() {
        ItemName = new TextField(this.driver, ITEM_NAME);
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject clickItemDescriptionTab() {
        ItemDescriptionTab = new Button(this.driver, ITEM_DESCRIPTION_TAB).click();
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject findTextField() {
        DescriptionTextField = new TextField(this.driver, ITEM_DESCRIPTION_FIELD);
        return new ItemPageObject(this.driver);
    }


    public ItemPageObject clickItemReviewTab() {
        ItemReviewTab = new Button(this.driver, ITEM_REVIEWS_TAB).click();
        return new ItemPageObject(this.driver);
    }


    public ItemPageObject enterName() {
        NameField = new Input(this.driver, NAME_INPUT_FIELD).setTextForField("TEST NAME");
        return new ItemPageObject(this.driver);
    }


    public ItemPageObject enterReview() {
        ReviewField = new Input(this.driver, REVIEW_INPUT_FIELD).setTextForField("TEST REVIEW TEXT ");
        return new ItemPageObject(this.driver);
    }


    public ItemPageObject findScoreField() {
        ScoreField = new TextField(this.driver, RATING_SCORE_FIELD);
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject selectLowRatingScoreButton() {
        LowRatingScoreButton = new Button(this.driver, LOW_RATING_SCORE_RADIO_BUTTON).click();
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject selectHighestScoreButton() {
        HighestRatingScoreButton = new Button(this.driver, HIGHEST_RATING_SCORE_RADIO_BUTTON).click();
        return new ItemPageObject(this.driver);
    }

    public ItemPageObject clickSubmitReviewButton() {
        SubmitReviewButton = new Button(this.driver, SUBMIT_REVIEW_BUTTON).click();
        return new ItemPageObject(this.driver);
    }


}
