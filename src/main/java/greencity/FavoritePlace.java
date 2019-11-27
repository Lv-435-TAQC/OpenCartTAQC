package greencity;

import org.apache.http.client.methods.HttpRequestBase;

import java.util.HashMap;
import java.util.Map;

import static utils.GreenCityURL.FAVORITE_PLACE;

public class FavoritePlace {
	HashMap<String,String> map ;
	
	public FavoritePlace() {
		this.map = new HashMap();
		map.put("Content-Type", "application/json;utf-8");
	}
	
	public int getAllFavoritePlaces(String token){
		this.map.put("Authorization", "Bearer "+ token);
		BaseHttpRequest request = new BaseHttpRequest();
		request.setRequestHeaders(map);
		request.getRequest(FAVORITE_PLACE);
		
		return request.getStatusCode();
	}
	
	public int updateFavoritePlaceNameByID(String token, String place, int placeId){
		this.map.put("Authorization", "Bearer "+ token);
		BaseHttpRequest request = new BaseHttpRequest();
		request.setRequestHeaders(map);
		request.putRequest(FAVORITE_PLACE, "{" +
				"  \"name\": \"" + place + "\"," +
				"  \"placeId\": " + placeId + "" +
				"}");
		
		return request.getStatusCode();
	}
	
	public int deleteFavoritePlaceByID(String token, int placeId){
		this.map.put("Authorization", "Bearer "+ token);
		BaseHttpRequest request = new BaseHttpRequest();
		request.setRequestHeaders(map);
		request.deleteRequest(FAVORITE_PLACE + placeId);
		return request.getStatusCode();
	}
}