package javatest.greencitytest;
import greencity.PlaceCommentController;
import greencity.Security;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static utils.testDataForCommentController.JSON_ARRAY_GET_SPECIFICATION;
import static utils.testDataForCommentController.ID_FROM_JSON_POST_COMMENT;

public class PlaceCommentControllerTests {
    String ftoken;

    @BeforeClass
    public void setUp() {
        Security sec = new Security();
        ftoken = sec.signIn("oleh.zarichnyi@gmail.com", "QWErty123$%^");

    }
    @Test
    public void postComment() {
        PlaceCommentController commentController = new PlaceCommentController();
        String actual=commentController.postComments(2, "CommentForTest52", "QWErs12f3d$%^",ftoken);
        assertEquals(actual, ID_FROM_JSON_POST_COMMENT);
    }
    @Test
    public void specificationGet(){
        PlaceCommentController commentController = new PlaceCommentController();
        String actual = commentController.getSpecification();
        assertEquals(actual, JSON_ARRAY_GET_SPECIFICATION);
    }
}
