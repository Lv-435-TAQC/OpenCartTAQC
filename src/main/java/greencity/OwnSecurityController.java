package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.*;

public class OwnSecurityController {
    public int ownSecurityPassword(String token, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", " Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest(OWN_SECURITY_URL);
        baseHttpRequest.setHeader("PUT", map);
        baseHttpRequest.sendRequest("{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"currentPassword\": \"" + oldPassword + "\"," +
                "  \"password\": \"" + newPassword + "\"" +
                "}");
        System.out.println(token);
        return baseHttpRequest.getStatuusCode();
    }

    public int ownSecurityChangePassword(String token, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", " Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest(OWN_SECURITY_CHANGE_PASSWORD_URL);
        baseHttpRequest.setHeader("POST", map);
        baseHttpRequest.sendRequest("{" +
                "  \"confirmPassword\": \"" + newPassword + "\"," +
                "  \"password\": \"" + oldPassword + "\"," +
                "  \"token\": \"" + " Bearer " + token + "\"" +
                "}");
        return baseHttpRequest.getStatuusCode();
    }

    public int restorePasswrod(String token, String email) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", " Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest(OWN_SECURITY_CHANGE_PASSWORD_URL);
        baseHttpRequest.setHeader("POST", map);
        baseHttpRequest.sendRequest("{" +
//                "  \"confirmPassword\": \"" + newPassword + "\"," +
//                "  \"password\": \"" + oldPassword + "\"," +
                "  \"token\": \"" + " Bearer " + token + "\"" +
                "}");
        return baseHttpRequest.getStatuusCode();
    }

}
