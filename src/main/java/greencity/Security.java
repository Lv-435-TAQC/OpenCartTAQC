package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.LOGIN_URL;

public class Security {
    public String signIn(String name, String password) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.postRequest(LOGIN_URL, "{" +
                "  \"email\": \"" + name + "\"," +
                "  \"password\": \"" + password + "\"" +
                "}");
        return baseHttpRequest.parseJsonObject("accessToken");
    }
}