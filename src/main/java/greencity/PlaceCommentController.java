package greencity;

import java.util.HashMap;
import java.util.Map;

public class PlaceCommentController {
    public String postComments(String name, String text, int estimateRate) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest("https://greencitysoftserve.herokuapp.com/ownSecurity/signIn");

        baseHttpRequest.setHeader("POST",map);
        baseHttpRequest.sendRequest("{" +
                "  \"estimate\": {\n" +
                "    \"rate\": "+estimateRate+"\n" +
                "  },\n" +
                "  \"photos\": [\n" +
                "    {\n" +
                "      \"name\": \""+name+"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"text\": \""+text+"\"\n" +
                "}");
        return baseHttpRequest.getResponse().get("commentToken").toString();
    }
}