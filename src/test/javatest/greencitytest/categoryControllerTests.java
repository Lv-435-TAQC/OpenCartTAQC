package javatest.greencitytest;

import greencity.PlaceCommentController;
import greencity.Security;
import greencity.categoryController;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static utils.testDataForCommentController.ASSERT_FOR_GET_CATEGORY_LIST;
import static utils.testDataForCommentController.ASSERT_FOR_POST_NEW_CATEGORY;


public class categoryControllerTests {
    String ftoken;
    @BeforeClass
    public void setUp() {
        Security sec = new Security();
        ftoken = sec.signIn("oleh.zarichnyi@gmail.com", "QWErty123$%^");

    }
    @Test
    public void postNewCategory() {
        categoryController categoryController = new categoryController();
        String actual=categoryController.postNewCategory("sdasddfadssa",ftoken);
        assertEquals(actual, ASSERT_FOR_POST_NEW_CATEGORY);
    }
    @Test
    public void getCategoryList(){
        categoryController categoryController = new categoryController();
        String actual = categoryController.getCategoryList();
        Assert.assertEquals(actual, ASSERT_FOR_GET_CATEGORY_LIST );
    }
}

