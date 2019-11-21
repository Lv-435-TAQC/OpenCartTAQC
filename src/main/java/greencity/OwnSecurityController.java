package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.*;

public class OwnSecurityController {
    public int ownSecurityPassword(String token, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", " Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest(OWN_SECURITY_URL, "PUT");
        baseHttpRequest.setHeader(map);
        baseHttpRequest.sendRequestWithBody("{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"currentPassword\": \"" + oldPassword + "\"," +
                "  \"password\": \"" + newPassword + "\"" +
                "}");
        System.out.println(token);
        return baseHttpRequest.statusCode;
    }

    public String ownSecurityChangePassword(String token, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap();
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest(OWN_SECURITY_CHANGE_PASSWORD_URL, "POST");
        baseHttpRequest.setHeader(map);
        baseHttpRequest.sendRequestWithBody("{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"password\": \"" + oldPassword + "\"," +
                "  \"token\": \"" + " Bearer " + token + "\"" +
                "}");
        return baseHttpRequest.getResponseString();
    }

    public String restorePassword(String email) {
        Map<String, String> map = new HashMap();
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest(RESTORE_PASSWORD, "GET");
        baseHttpRequest.setHeader(map);
        baseHttpRequest.sendRequest();
        return baseHttpRequest.parseJsonObject("message");
    }

}
