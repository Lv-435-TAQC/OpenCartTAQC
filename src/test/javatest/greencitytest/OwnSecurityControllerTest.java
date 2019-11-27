package javatest.greencitytest;

import
        greencity.OwnSecurityController;
import greencity.Security;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static utils.GreenCityConstants.*;

public class OwnSecurityControllerTest {
    String token;
    OwnSecurityController ownSecurityController = new OwnSecurityController();
    Security sec = new Security();

    @BeforeClass
    public void setUp() {
        token = sec.signIn("orysita.lviv+10001@gmail.com", "QWErty123$%^");
    }

    @Test
    public void test1() {
        Integer actual = ownSecurityController.ownSecurityPassword(token, "QWErty123$%^", "QWErty0123$%^");
        assertEquals(actual, TWO_HUNDRED);
    }

    @Test(priority = 1)
    public void test2() {
        Integer actual = ownSecurityController.ownSecurityPassword(token, "QWErty0123$%^", "QWErty123$%^");
        assertEquals(actual, TWO_HUNDRED);

    }

    @DataProvider(name = "Change password")
    public Object[][] createDataForLoginPage(Method m) {
        return new Object[][]{
                new Object[]{"", "QWErty0123$%^"}
                , new Object[]{"QWErty123$%^", " "}
                , new Object[]{"Uhyyyyyyy", "Aaaaaaa"}
                , new Object[]{"", ""}
        };
    }

    @Test(dataProvider = "Change password")
    public void testNegative(String oldPassword, String newPassword) {
        Integer actual = ownSecurityController.ownSecurityPassword(token, oldPassword, newPassword);
        assertEquals(actual, FOUR_HUNDRED);
    }

    @Test()
    public void testRegistration() {
        Integer actual = ownSecurityController.signUp("orysita.lviv+12@gmail.com", "Orysia", "Benko", "QWErty123$%^");
        assertEquals(actual, TWO_HUNDRED_ONE);
    }

    @DataProvider(name = "Registration")
    public Object[][] testRegistrationNegative(Method m) {
        return new Object[][]{
                new Object[]{"orysita.lviv+6@gmail.com", "Orysia", "Benko", "QWErty123$%^"}
                , new Object[]{"", "", "", ""}
                , new Object[]{"orysita.lviv+1008@gmail.com", "Orysia", "Benko", ""}
                , new Object[]{"orysita.lviv+1008@gmail.com", "Orysia", "Benko", "fjs2"}
        };
    }

    @Test(dataProvider = "Registration")
    public void testRegistrationNegative(String email, String firstName, String lastName, String password) {
        Integer actual = ownSecurityController.signUp(email, firstName, lastName, password);
        assertEquals(actual, FOUR_HUNDRED);
    }


    @DataProvider(name = "Change password without old")
    public Object[][] createDataChangePasswrod(Method m) {
        return new Object[][]{
                new Object[]{"QWErty123$%^", "QWErty0123$%^"}
                , new Object[]{"QWErty123$%^", " "}
                , new Object[]{"Uhyyyyyyy", "Aaaaaaa"}
                , new Object[]{"", ""}
        };
    }

    @Test(dataProvider = "Change password without old")
    public void testNegativeChange(String oldPassword, String newPassword) {
        String actual = ownSecurityController.ownSecurityChangePassword(token, oldPassword, newPassword);
        assertEquals(actual, FOUR_HUNDRED);
    }

    @DataProvider(name = "RestorePassword")
    public Object[][] restorePassword(Method m) {
        return new Object[][]{
                new Object[]{"orysita.lviv+100@gmail.com"}
                , new Object[]{""}
        };
    }

    @Test(priority = 1, dataProvider = "RestorePassword")
    public void restorePassword(String email) {
        String actual = ownSecurityController.restorePassword(email);
        assertEquals(actual, WRONG_MESSAGE + email);
    }
}