package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.COMMENT_URL;
import static utils.GreenCityURL.GET_SPECIFICATION;

public class PlaceCommentController {
    /**
     * post comments
     * @param estimateRate
     * @param name
     * @param text
     * @param token
     * @return if from JsonObject
     */
    public String postComments(int estimateRate, String name, String text, String token ) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer "+ token );
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();


        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.postRequest(COMMENT_URL,"{" +
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
        System.out.println(token);
      baseHttpRequest.getStatusCode();

        return baseHttpRequest.getResponseJsonObject().get("id").toString();
    }

    /**
     *get list of specification
     * @return list from JsonArray
     */
    public String getSpecification(){
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(GET_SPECIFICATION);
        return baseHttpRequest.getResponseJsonArray().toString();
    }
}
