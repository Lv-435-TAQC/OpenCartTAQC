package greencity;

import java.util.HashMap;
import java.util.Map;

import static utils.PlaceControllerConstants.*;

public class PlaceController {
    Map<String, String> map = new HashMap();

    /**
     * getPlaceById
     * get info about place by id
     * @param id - id of place
     * @return JsonObject
     */

    public String getPlaceById(int id) {
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(PLACE_URL + id);
        return baseHttpRequest.getResponseJsonObject().toString();
    }

    /**
     * getStatuses
     * get list of available statuses
     * @return JsonArray
     */

    public String getStatuses() {
        map.put("Content-Type", "application/json;utf-8");
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.getRequest(STATUSES_URL);
        return baseHttpRequest.getResponseJsonArray().toString();
    }

    /**
     * saveFavoritePlace
     * add place to favorite places
     * @param token - token for authorisation
     * @param name - place name
     * @param id - place id
     * @return JsonObject
     */

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

    /**
     * updatePlaceStatus
     * change status of place
     * @param token - token for authorisation
     * @param id - place id
     * @param status - place status
     * @return JsonObject
     */

    public String updatePlaceStatus(String token,int id,String status){
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

    /**
     * deletePlace
     * delete place
     * @param token - token for authorisation
     * @param id - place id
     * @return place id
     */

    public String deletePlace(String token,int id){
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.deleteRequest(DELETE_PLACE_URL+id);
        return baseHttpRequest.getResponse();
    }

    /**
     * deletePlaceStatusCode
     * delete place and check status code
     * @param token - token for authorisation
     * @param id - place id
     * @return status code
     */

    public int deletePlaceStatusCode(String token,int id){
        map.put("Content-Type", "application/json;utf-8");
        map.put("Authorization", "Bearer " + token);
        BaseHttpRequest baseHttpRequest = new BaseHttpRequest();
        baseHttpRequest.setRequestHeaders(map);
        baseHttpRequest.deleteRequest(DELETE_PLACE_URL+id);
        return baseHttpRequest.getStatusCode();
    }
}




