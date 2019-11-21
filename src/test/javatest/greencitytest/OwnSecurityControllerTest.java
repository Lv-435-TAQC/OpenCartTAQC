//package javatest.greencitytest;
//
//import greencity.OwnSecurityController;
//import greencity.Security;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//
//import static org.testng.Assert.assertEquals;
//import static utils.GreenCityConstants.*;
//
//public class OwnSecurityControllerTest {
//    String token;
//
//    @BeforeClass
//    public void setUp() {
//        Security sec = new Security();
//        token = sec.signIn("orysita.lviv@gmail.com", "QWErty123$%^");
//    }
//
//    @Test
//    public void test1() {
//        OwnSecurityController ownSecurityController = new OwnSecurityController();
//        Integer actual=ownSecurityController.ownSecurityPassword(token, "QWErty123$%^", "QWErty0123$%^");
//        assertEquals(actual, TWO_HUNDRED);
//    }
//
//    @Test(priority = 1)
//    public void test2() {
//        OwnSecurityController ownSecurityController = new OwnSecurityController();
//        Integer actual=ownSecurityController.ownSecurityPassword(token, "QWErty0123$%^", "QWErty123$%^");
//        assertEquals(actual, TWO_HUNDRED);
//
//    }
//    @DataProvider(name = "Change password")
//    public Object[][] createDataForLoginPage(Method m) {
//        return new Object[][]{
//                new Object[]{"", "QWErty0123$%^"}
//                , new Object[]{"QWErty123$%^", " "}
//                , new Object[]{"Uhyyyyyyy", "Aaaaaaa"}
//                , new Object[]{"", ""}
//        };
//    }
//
//    @Test(dataProvider ="Change password" )
//    public void testNegative(String oldPassword, String newPassword) {
//        OwnSecurityController ownSecurityController = new OwnSecurityController();
//        Integer actual=ownSecurityController.ownSecurityPassword(token, oldPassword, newPassword);
//        assertEquals(actual, FOUR_HUNDRED);
//    }
//
//
//
//}