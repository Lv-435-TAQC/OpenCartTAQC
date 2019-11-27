package greencity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.*;

public class OwnSecurityController {

    /**
     * change password
     * @param token - token user
     * @param oldPassword - old password user
     * @param newPassword - new password user
     * @return status code
     */

    public int ownSecurityPassword(String token, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.putRequest(OWN_SECURITY_URL, "{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"currentPassword\": \"" + oldPassword + "\"," +
                "  \"password\": \"" + newPassword + "\"" +
                "}");
        System.out.println(token);
        return baseHttpRequest.getStatusCode();
    }

    /**
     * change password by token
     * @param token - token user
     * @param oldPassword - old password user
     * @param newPassword- new password user
     * @return response
     */

    public int ownSecurityChangePassword(String token, String oldPassword, String newPassword) {
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.postRequest(OWN_SECURITY_CHANGE_PASSWORD_URL, "{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"password\": \"" + oldPassword + "\"," +
                "  \"token\": \"" + " Bearer " + token + "\"" +
                "}");
        return baseHttpRequest.getStatusCode();
    }

    /**
     * restore password
     * @param email - your email
     * @return restore password
     */

    public String restorePassword(String email) {
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        String url = null;
        try {
            url = RESTORE_PASSWORD + URLEncoder.encode(email, "UTF-8");
            System.out.println(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        baseHttpRequest.getRequest(url);
        if (baseHttpRequest.getStatusCode() == 200) {
            baseHttpRequest.getStatusCode();
        }
        return baseHttpRequest.parseJsonObject("message");
    }

    /**
     * create account
     * @param email - your email
     * @param firstName - your first name
     * @param lastName - your last name
     * @param password - your password
     * @return new account
     */

    public Integer signUp(String email, String firstName, String lastName, String password) {
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.postRequest(REISTATION_URL, "{" +
                "  \"email\": \"" + email + "\"," +
                "  \"firstName\": \"" + firstName + "\"," +
                "  \"lastName\": \"" + lastName + "\"," +
                "  \"password\": \"" + password + "\"" +
                "}");
        return baseHttpRequest.getStatusCode();
    }

}