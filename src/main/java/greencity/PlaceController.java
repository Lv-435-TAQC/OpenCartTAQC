package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.LOGIN_URL;

public class PlaceController {

    public String getPlaceById(int id) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest("https://greencitysoftserve.herokuapp.com//place/about/" + id);
        return baseHttpRequest.getResponseJsonObject().toString();
    }


    public String getStatuses() {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest("https://greencitysoftserve.herokuapp.com/place/statuses");
        return baseHttpRequest.getResponseJsonArray().toString();
    }

    public String saveFavoritePlace(String token) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.postRequest("https://greencitysoftserve.herokuapp.com/place/save/favorite/",  "{\n" +
                "  \"name\": \"HHhsdwea\",\n" +
                "  \"placeId\": 2\n" +
                "}");
        return baseHttpRequest.getResponseJsonObject().toString();
    }
}



