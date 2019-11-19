package greencity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Security {
    public String signIn(String name,String password){
        Map<String,String> map = new HashMap();
        map.put("Content-Type","application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest("https://greencitysoftserve.herokuapp.com/ownSecurity/signIn");

        baseHttpRequest.setHeader("POST",map);
        baseHttpRequest.sendRequest("{" +
                "  \"email\": \""+name+"\"," +
                "  \"password\": \""+password+"\""+
                "}");
        return baseHttpRequest.getResponse().get("accessToken").toString();
    }
}
