package javatest.greencitytest;

import greencity.FavoritePlace;
import greencity.Security;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.GreenCityConstants.*;

public class FavoritePlaceTest {
	String token;
	FavoritePlace favoritePlace = new FavoritePlace();
	
	@DataProvider(name = "Change favorite place name")
	public Object[][] createDataForLoginPage(Method m) {
		return new Object[][]{
				new Object[]{"QWErty", 3}
				, new Object[]{"$%^", 3}
				, new Object[]{"123", 3}
				, new Object[]{"Абвг",3}
		};
	}
	
	@BeforeClass
	public void setUp() {
		Security sec = new Security();
		token = sec.signIn(USER_NAME, USER_PASSWORD);
	}
	
	@Test
	public void getFavoritePlaces(){
		Integer statusCode = favoritePlace.getAllFavoritePlaces(token);
		Assert.assertEquals(statusCode, TWO_HUNDRED);
	}
	
	@Test(dataProvider = "Change favorite place name")
	public void changeFavoritePlaceName(String place, int placeId){
		Integer statusCode = favoritePlace.updateFavoritePlaceNameByID(token, place, placeId);
		Assert.assertEquals(statusCode, TWO_HUNDRED);
	}
	
	@Test
	public void deleteFavoritePlace(){
		Integer statusCode = favoritePlace.deleteFavoritePlaceByID(token, FOUR);
		Assert.assertEquals(statusCode, TWO_HUNDRED);
	}
}
