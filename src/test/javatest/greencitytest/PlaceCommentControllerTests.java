package javatest.greencitytest;
import greencity.PlaceCommentController;
import greencity.Security;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
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
        String actual=commentController.postComments(2, "QWxxxrcxzdsdscx1f23$", "QWErs12f3d$%^",ftoken);
        assertEquals(actual, "49");
    }
    @Test
    public void specificationGet(){
        PlaceCommentController commentController = new PlaceCommentController();
        String actual = commentController.getSpecification();
        assertEquals(actual, "[{\"name\":\"Own Cup\"}]" );
    }
}
