package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.LOGIN_URL;
import static utils.PlaceControllerConstants.*;

public class PlaceController {
    Map<String, String> map = new HashMap();

    public String getPlaceById(int id) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(PLACE_URL + id);
        return baseHttpRequest.getResponseJsonObject().toString();
    }


    public String getStatuses() {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(STATUSES_URL);
        return baseHttpRequest.getResponseJsonArray().toString();
    }
    
    public String saveFavoritePlace(String token,String name,int id) {
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.postRequest(FAVORITE_PLACE_URL,  "{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"placeId\": "+id+"\n" +
                "}");
        return baseHttpRequest.getResponseJsonObject().toString();

    }
    public String updatePlace(String token,int id,String status){
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.patchRequest(UPDATE_STATUS_URL,  "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"status\": \""+status+"\"\n" +
                "}");
        return baseHttpRequest.getResponseJsonObject().toString();
    }

    public String deletePlace(String token,int id){
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.deleteRequest(DELETE_PLACE_URL+id);
        return baseHttpRequest.getResponse();
    }

    public int deletePlaceStatusCode(String token,int id){
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.deleteRequest(DELETE_PLACE_URL+id);
        return baseHttpRequest.getStatusCode();
    }
}




