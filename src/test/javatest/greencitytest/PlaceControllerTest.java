package javatest.greencitytest;

import greencity.PlaceController;
import greencity.Security;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.GreenCityConstants.TWO_HUNDRED;
import static utils.PlaceControllerConstants.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PlaceControllerConstants;

public class PlaceControllerTest {
    String token;
    PlaceController placeController;

    @BeforeClass
    public void setUp() {
        Security sec = new Security();
        token = sec.signIn(LOGIN, PASSWORD);
        placeController = new PlaceController();
    }

    /**
     * <b>TC-1: Get place by id</b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Get information about place
     * </ul>
     * <p>
     * Expected Result: json with information about place;
     */

    @Test
    public void getPlaceById(){
        String actualJSON = placeController.getPlaceById(2);
        assertEquals(actualJSON, PlaceControllerConstants.DATA_ABOUT_PLACE);
    }

    /**
     * <b>TC-2: Get Place By Id Negative </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Get information about place
     * </ul>
     * <p>
     * Expected Result: {\"message\":\"The place does not exist by this id:;
     */

    @Test
    public void getPlaceByIdNegative(){
        String actualJSON = placeController.getPlaceById(44);
        assertTrue(actualJSON.contains(NOT_EXIST_PLACE_MESSAGE));
    }

    /**
     * <b>TC-3: Get statuses </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Get array of status
     * </ul>
     * <p>
     * Expected Result: ["PROPOSED","DECLINED","APPROVED","DELETED"];
     */

    @Test
    public void getStatuses(){
        String actualJSON = placeController.getStatuses();
        assertEquals(actualJSON,PlaceControllerConstants.LIST_OF_STATUSES);
    }

    /**
     * <b>TC-4: Save favorite place </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Add place to favorite
     * </ul>
     * <p>
     * Expected Result: json with data about favorite place;
     */

    @Test
    public void saveFavoritePlace(){
        String actualJSON = placeController.saveFavoritePlace(token,"GoodPlace",5);
        assertEquals(actualJSON,PlaceControllerConstants.DATA_ABOUT_FAVORITE_PLACE);
    }

    /**
     * <b>TC-5: Save existing favorite place </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Save existing favorite place which already saved;
     * </ul>
     * <p>
     * Expected Result: Favorite place already exist for this placeId:;
     */

    @Test
     public void saveExistingFavoritePlace(){
        placeController.saveFavoritePlace(token,"Cafe",3);
        String actualJSON = placeController.saveFavoritePlace(token,"Cafe",3);
        assertTrue(actualJSON.contains(PlaceControllerConstants.ALREADY_EXIST_PLACE_MESSAGE));
     }

    /**
     * <b>TC-6: Update status </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Update status of place;
     * </ul>
     * <p>
     * Expected Result: {"id":2,"status":"PROPOSED"};
     */

    @Test
     public void updateStatus(){
        placeController.updatePlaceStatus(token,2,"APPROVED");
        String actual = placeController.updatePlaceStatus(token,2,"PROPOSED");
        assertTrue(actual.contains(PlaceControllerConstants.PLACE_UPDATING_MESSAGE));
     }

    /**
     * <b>TC-7: Update current status </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Set status ;
     * </ul>
     * <p>
     * Expected Result: {"id":2,"status":"PROPOSED"};
     */

    @Test
    public void updateCurrentStatus(){
        placeController.updatePlaceStatus(token,2,"PROPOSED");
        String actual = placeController.updatePlaceStatus(token,2,"PROPOSED");
        assertTrue(actual.contains(CURRENT_STATUS_MESSAGE));
    }

    /**
     * <b>TC-8: Delete place </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. delete place from list;
     * </ul>
     * <p>
     * Expected Result: 200;
     */

    @Test(priority = 1)
    public void deletePlace(){
        placeController.updatePlaceStatus(token,6,"PROPOSED");
        Integer actual = placeController.deletePlaceStatusCode(token,6);
        assertEquals(actual,TWO_HUNDRED);
    }

    /**
     * <b>TC-9: Delete deleted place </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Delete place that was already deleted;
     * </ul>
     * <p>
     * Expected Result: Place with id;
     */

    @Test(priority = 1)
    public void deleteDeletedPlace(){
        String actual = placeController.deletePlace(token,7);
        assertTrue(actual.contains(CURRENT_STATUS_MESSAGE));
    }

    /**
     * <b>TC-10: Delete not existing place </b>
     * <p>
     * Scenario:
     * <ul>
     * <li>1. Delete not existing place;
     * </ul>
     * <p>
     * Expected Result: The place does not exist by this id:;
     */

    @Test(priority = 1)
    public void deleteNotExistingPlace(){
        String actual = placeController.deletePlace(token,30);
        assertTrue(actual.contains(NOT_EXIST_PLACE_MESSAGE));
    }
}
