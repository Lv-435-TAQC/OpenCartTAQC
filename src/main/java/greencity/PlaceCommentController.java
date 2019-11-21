package greencity;

import java.util.HashMap;
import java.util.Map;

public class PlaceCommentController {
    public String postComments(int estimateRate, String name, String text, String token ) {
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer "+ token );
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest("https://greencitysoftserve.herokuapp.com/place/4/comments");

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
        return baseHttpRequest.getResponseJsonObject().get("id").toString();
    }
}