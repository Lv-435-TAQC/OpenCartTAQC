package javatest.greencitytest;

import greencity.Security;
import greencity.categoryController;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static utils.testDataForCommentController.*;


public class categoryControllerTests {
    String token;
    /**
     * <b> Description of Precondition.</b>
     *
     * <ul>
     * <li>1. Sign in
     * </ul>
     * <p>
     */
    @BeforeClass
    public void setUp() {
        Security sec = new Security();
        token = sec.signIn(NAME_FOR_LOGIN,PASSWORD );
        /**
         * <b>: </b>
         * <p>
         * Scenario:
         * <ul>
         * <li> 1. Send request with data: name of category
         * </ul>
         * <p>
         * Expected Result: 53
         */
    }
    @Test
    public void postNewCategory() {
        categoryController categoryController = new categoryController();
        String actual=categoryController.postNewCategory("sdasddssfadssas",token);
        assertEquals(actual, GET_ID_OF_NEW_CATEGORY);
    }
    /**
     * <b>: </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. get category list
     * </ul>
     * <p>
     * Expected Result: list of existed category
     */
    @Test
    public void getCategoryList(){
        categoryController categoryController = new categoryController();
        String actual = categoryController.getCategoryList();
        Assert.assertEquals(actual, GET_CATEGORY_LIST);
    }
}

