package greencity;

import org.apache.http.client.methods.HttpRequestBase;

import java.util.HashMap;
import java.util.Map;

public class FavoritePlace {
	
	
	public String getAllFavoritePlaces(String token){
		HashMap<String,String> map = new HashMap();
        map.put("Content-Type","application/json;utf-8");
		map.put("Authorization", "Bearer "+ token);
		BaseHttpRequest request = new BaseHttpRequest();
		request.setRequestHeaders(map);
		request.getRequest("https://greencitysoftserve.herokuapp.com/favorite_place/");
		
		return request.getResponse();
	}
	
	public int updateFavoritePlaceName(String token, String place, int placeId){
		HashMap<String,String> map = new HashMap();
		map.put("Content-Type","application/json;utf-8");
		map.put("Authorization", "Bearer "+ token);
		BaseHttpRequest request = new BaseHttpRequest();
		request.setRequestHeaders(map);
		request.putRequest("https://greencitysoftserve.herokuapp.com/favorite_place/", "{" +
				"  \"name\": \"" + place + "\"," +
				"  \"placeId\": " + placeId + "" +
				"}");
		
		return request.getStatusCode();
	}
}