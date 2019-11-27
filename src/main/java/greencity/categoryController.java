package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.GET_CATEGORY_LIST;
import static utils.GreenCityURL.POST_NEW_CATEGORY;

public class categoryController {
        public String postNewCategory( String name ,String token) {
            Map<String, String> map = new HashMap();
            map.put("Content-Type", "application/json;utf-8");
            map.put("Authorization", "Bearer "+ token );
            BaseHttpRequest baseHttpRequest = new BaseHttpRequest();


            baseHttpRequest.setRequestHeaders(map);
            baseHttpRequest.postRequest(POST_NEW_CATEGORY,"{\n" +
                    "  \"name\": \""+name+"\"\n" +
                    "}");
            System.out.println(token);
            baseHttpRequest.getStatusCode();

            return baseHttpRequest.getResponseJsonObject().get("id").toString();
        }
    public String getCategoryList(){
        Map<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(GET_CATEGORY_LIST);
        return baseHttpRequest.getResponseJsonArray().toString();
    }

}
