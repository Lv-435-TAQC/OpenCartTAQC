package javatest.greencitytest;

import greencity.OwnSecurityController;
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
        token = sec.signIn(USER_EMAIL, PASSWORD);
    }


    /**
     * <b>TC-1: Change password</b>
     * <p>
     * Scenario:
     * <ul>
     * <li> 1. Send request with data: old password and new password
     * </ul>
     * <p>
     * Expected Result: status code 200
     */

    @Test
    public void changePassword() {
        Integer actual = ownSecurityController.ownSecurityPassword(token, "QWErty123$%^", "QWErty0123$%^");
        assertEquals(actual, TWO_HUNDRED);
    }

    @Test(priority = 1)
    public void changePasswordReverse() {
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

    /**
     * <b>TC-1: Change password</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Send request with data from "Change password": old password and new password
     * </ul>
     * <p>
     * Expected Result: 400
     */

    @Test(dataProvider = "Change password")
    public void testNegative(String oldPassword, String newPassword) {
        Integer actual = ownSecurityController.ownSecurityPassword(token, oldPassword, newPassword);
        assertEquals(actual, FOUR_HUNDRED);
    }

    /**
     * <b>TC-1: Sign up</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Send request with data email, first name, last name, password
     * </ul>
     * <p>
     * Expected Result: 200
     */


    @Test()
    public void testRegistration() {
        Integer actual = ownSecurityController.signUp("orysita.lviv+17@gmail.com", "Orysia", "Benko", "QWErty123$%^");
        assertEquals(actual, TWO_HUNDRED_ONE);
    }

    /**
     * <b>TC-1: Sign up negative</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Send request with data from "Registration": email, first name, last name, password
     * </ul>
     * <p>
     * Expected Result: 400
     */


    @DataProvider(name = "Registration")
    public Object[][] testRegistrationNegative(Method m) {
        return new Object[][]{
                new Object[]{"orysita.lviv+6@gmail.com", "Orysia", "Benko", "QWErty123$%^"}
                , new Object[]{"", "", "", ""}
                , new Object[]{"orysita.lviv+1008@gmail.com", "Orysia", "Benko", ""}
                , new Object[]{"orysita.lviv+102@gmail.com", "Orysia", "Benko", "fjs2"}
        };
    }

    @Test(dataProvider = "Registration")
    public void testRegistrationNegative(String email, String firstName, String lastName, String password) {
        Integer actual = ownSecurityController.signUp(email, firstName, lastName, password);
        assertEquals(actual, FOUR_HUNDRED);
    }

    /**
     * <b>TC-1: Change password with token</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Send request with data from "Change password without old": old password, new password and token
     * </ul>
     * <p>
     * Expected Result: status code 400
     */

    @DataProvider(name = "Change password without old")
    public Object[][] createDataChangePassword(Method m) {
        return new Object[][]{
                new Object[]{"QWErty123$%^", "QWErty0123$%^"}
                , new Object[]{"QWErty123$%^", " "}
                , new Object[]{"Uhyyyyyyy", "Aaaaaaa"}
                , new Object[]{"", ""}
        };
    }

    @Test(dataProvider = "Change password without old")
    public void testNegativeChange(String oldPassword, String newPassword) {
        Integer actual = ownSecurityController.ownSecurityChangePassword(token, oldPassword, newPassword);
        assertEquals(actual, FOUR_HUNDRED);
    }

    /**
     * <b>TC-1: Restore password</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Send request with data from " RestorePassword " : email
     * </ul>
     * <p>
     * Expected Result: "The user does not exist by this email: " + email
     */

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