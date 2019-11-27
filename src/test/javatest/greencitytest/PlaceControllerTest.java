package javatest.greencitytest;

import greencity.PlaceController;
import greencity.Security;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.GreenCityConstants.TWO_HUNDRED;
import static utils.PlaceControllerConstants.NOT_EXIST_PLACE_MESSAGE;
import static utils.PlaceControllerConstants.CURRENT_STATUS_MESSAGE;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PlaceControllerConstants;

public class PlaceControllerTest {
    String token;
    PlaceController placeController;

    @BeforeClass
    public void setUp() {
        Security sec = new Security();
        token = sec.signIn("andrijrubchuk@gmail.com", "Andr0306%");
        System.out.println(token);
        placeController = new PlaceController();
    }

    @Test
    public void getPlaceById(){
        String actualJSON = placeController.getPlaceById(2);
        assertEquals(actualJSON, PlaceControllerConstants.DATA_ABOUT_PLACE);
    }

    @Test
    public void getPlaceByIdNegative(){
        String actualJSON = placeController.getPlaceById(44);
        assertTrue(actualJSON.contains(NOT_EXIST_PLACE_MESSAGE));
    }

    @Test
    public void getStatuses(){
        String actualJSON = placeController.getStatuses();
        assertEquals(actualJSON,PlaceControllerConstants.LIST_OF_STATUSES);
    }

    @Test
    public void saveFavoritePlace(){
        String actualJSON = placeController.saveFavoritePlace(token,"Cafe",3);
        assertEquals(actualJSON,PlaceControllerConstants.DATA_ABOUT_FAVORITE_PLACE);
    }

    @Test
     public void saveExistingFavoritePlace(){
        placeController.saveFavoritePlace(token,"Cafe",3);
        String actualJSON = placeController.saveFavoritePlace(token,"Cafe",3);
        assertTrue(actualJSON.contains(PlaceControllerConstants.ALREADY_EXIST_PLACE_MESSAGE));
     }

    @Test
     public void updateStatus(){
        placeController.updatePlace(token,2,"APPROVED");
        String actual = placeController.updatePlace(token,2,"PROPOSED");
        assertTrue(actual.contains(PlaceControllerConstants.PLACE_UPDATING_MESSAGE));
     }

    @Test
    public void updateCurrentStatus(){
        placeController.updatePlace(token,2,"PROPOSED");
        String actual = placeController.updatePlace(token,2,"PROPOSED");
        assertTrue(actual.contains(CURRENT_STATUS_MESSAGE));
    }

    @Test
    public void deletePlace(){
        placeController.updatePlace(token,6,"PROPOSED");
        Integer actual = placeController.deletePlaceStatusCode(token,6);
        assertEquals(actual,TWO_HUNDRED);
    }

    @Test
    public void deleteDeletedPlace(){
        String actual = placeController.deletePlace(token,7);
        assertTrue(actual.contains(CURRENT_STATUS_MESSAGE));
    }

    @Test
    public void deleteNotExistingPlace(){
        String actual = placeController.deletePlace(token,30);
        assertTrue(actual.contains(NOT_EXIST_PLACE_MESSAGE));
    }
}
