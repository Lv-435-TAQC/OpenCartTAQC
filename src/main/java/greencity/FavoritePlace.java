package greencity;

import java.util.HashMap;
import java.util.Map;

public class FavoritePlace {

    public String getAllFavoritePlaces(String token){
        Map<String,String> map = new HashMap();
        map.put("Content-Type","application/json;utf-8");
        BaseHttpRequest request = new BaseHttpRequest("https://greencitysoftserve.herokuapp.com/favorite_place/");
        map.put("Authorization", "Bearer "+ token);
        request.setHeader("GET", map);
        System.out.println(map.toString());
        return request.getResponseJsonArray().toString();
    }

}
