package greencity;

import static utils.GreenCityURL.LOGIN_URL;

public class Security {
    public String signIn(String name, String password) {
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.postRequest(LOGIN_URL, "{" +
                "  \"email\": \"" + name + "\"," +
                "  \"password\": \"" + password + "\"" +
                "}");
        return baseHttpRequest.parseJsonObject("accessToken");
    }
}