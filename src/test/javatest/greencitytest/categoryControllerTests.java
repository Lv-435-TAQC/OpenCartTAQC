package javatest.greencitytest;

import greencity.PlaceCommentController;
import greencity.Security;
import greencity.categoryController;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;


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
        String actual=categoryController.postNewCategory("sdasdfadssa",ftoken);
        assertEquals(actual, "16");
    }
    @Test
    public void getCategoryList(){
        categoryController categoryController = new categoryController();
        String actual = categoryController.getCategoryList();
        Assert.assertEquals(actual, "[{\"name\":\"Food\"},{\"name\":\"Food&Wine\"},{\"name\":\"Green-grocery\"},{\"name\":\"2 the grocery\"},{\"name\":\"qweqwe\"},{\"name\":\"qweqweeqeeeqwewq\"},{\"name\":\"string\"},{\"name\":\"TTTTT\"},{\"name\":\"123123wadsadfsa\"},{\"name\":\"123123wadsadfqsa\"},{\"name\":\"dsfddsfsdfsdfhfhd\"},{\"name\":\"strsding\"},{\"name\":\"strssdding\"},{\"name\":\"sdafadsa\"},{\"name\":\"sdafadssa\"}]" );
    }
}

