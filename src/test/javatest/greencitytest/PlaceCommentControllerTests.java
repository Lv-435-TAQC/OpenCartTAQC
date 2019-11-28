package javatest.greencitytest;
import greencity.PlaceCommentController;
import greencity.Security;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static utils.testDataForCommentController.*;

public class PlaceCommentControllerTests {
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
        token = sec.signIn(NAME_FOR_LOGIN, PASSWORD);

    }
    /**
     * <b>: </b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Send request with data: name ant text
     * </ul>
     * <p>
     * Expected Result: 53
     */
    @Test
    public void postComment() {
        PlaceCommentController commentController = new PlaceCommentController();
        String actual=commentController.postComments(2, "CommentForTest52", "QWErs12f3d$%^",token);
        assertEquals(actual, ID_POST_COMMENT);
    }
    /**
     * <b>: specificationGet</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. get information about list category
     * </ul>
     * <p>
     * Expected Result: list of existed specification
     */
    @Test
    public void specificationGet(){
        PlaceCommentController commentController = new PlaceCommentController();
        String actual = commentController.getSpecification();
        assertEquals(actual, LIST_OF_SPECIFICATION);
    }
}
