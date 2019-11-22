package greencity;


import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.*;

public class OwnSecurityController {
    public int ownSecurityPassword(String token, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", " Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.putRequest(OWN_SECURITY_URL,"{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"currentPassword\": \"" + oldPassword + "\"," +
                "  \"password\": \"" + newPassword + "\"" +
                "}");
        System.out.println(token);
        return baseHttpRequest.getStatusCode();
    }

    public String ownSecurityChangePassword(String token, String oldPassword, String newPassword) {
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.postRequest(OWN_SECURITY_CHANGE_PASSWORD_URL,"{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"password\": \"" + oldPassword + "\"," +
                "  \"token\": \"" + " Bearer " + token + "\"" +
                "}");
        return baseHttpRequest.getResponse();
    }

    public String restorePassword(String email) {
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(RESTORE_PASSWORD);
        return baseHttpRequest.parseJsonObject("message");
    }

}
