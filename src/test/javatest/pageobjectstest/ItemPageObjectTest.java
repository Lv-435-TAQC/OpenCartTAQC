

public class ItemPageObjectTest {
    WebDriver driver;
 ItemPageObject ;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();



    }

    @BeforeMethod
    public void getHome() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/opencart/index.php?route=product/product&path=57&product_id=49");
        item = new ItemPageObject(driver);
    }

    @After
    public void cleanUp(){
    driver.manage().deleteAllCookies(); }

    @AfterClass
    public void tearDown() {
        driver.close();
    }





@Test
        public void testItemDescriptionTab() {
        item.clickItemDescriptionTab();
        item.findTextField();
    softAssert.assertThat(DescriptionTextField).contains(ItemName);
    softAssert.assertThat(DescriptionTextField).hasSizeGreaterThan(0);
    }

@Test

    public void testItemReviewTab(){
    ItemPageObject itemPageObject = item.clickItemReviewTab();
    itemPageObject.enterName();
    softAssert.assertThat(NameField).hasSizeGreaterThan(3);
    softAssert.asserThat(NameField).hasSizeLessThan(25);



    itemPageObject.enterReview();
    softAssert.assertThat(ReviewField).hasSizeGreaterThan(25);
    softAssert.asserThat(ReviewField).hasSizeLessThan(1000);

 //   itemPageObject.findScoreField();
    itemPageObject.HighestRatingScoreButton.isDisplayed();
    itemPageObject.HighestRatingScoreButton.isEnabled();
    itemPageObject.selectHighestScoreButton();
    itemPageObject.HighestRatingScoreButton.isSelected();


    itemPageObject.clickSubmitReviewButton();





}


}