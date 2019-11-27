package utils;

public class PlaceControllerConstants {
    public static final String STATUSES_URL = "https://greencitysoftserve.herokuapp.com/place/statuses";
    public static final String PLACE_URL = "https://greencitysoftserve.herokuapp.com//place/about/";
    public static final String FAVORITE_PLACE_URL = "https://greencitysoftserve.herokuapp.com/place/save/favorite/";
    public static final String UPDATE_STATUS_URL = "https://greencitysoftserve.herokuapp.com/place/status";
    public static final String DELETE_PLACE_URL = "https://greencitysoftserve.herokuapp.com/place/";
    public static final String DATA_ABOUT_PLACE = "{\"openingHoursList\":[{\"breakTime\":null,\"weekDay\":\"SUNDAY\",\"closeTime\":\"23:00\",\"openTime\":\"10:00\"}],\"name\":\"Forum\",\"location\":{\"address\":\"вулиця Під Дубом, 7Б, Львів, Львівська область, Україна, 79000\",\"lng\":24.022395728633114,\"lat\":49.84988871692208},\"id\":2,\"category\":{\"name\":\"Food\"},\"discountValues\":[{\"specification\":{\"name\":\"Own Cup\"},\"value\":5}]}";
    public static final String NOT_EXIST_PLACE_MESSAGE = "{\"message\":\"The place does not exist by this id:";
    public static final String LIST_OF_STATUSES = "[\"PROPOSED\",\"DECLINED\",\"APPROVED\",\"DELETED\"]";
    public static final String ALREADY_EXIST_PLACE_MESSAGE = "\"message\":\"Favorite place already exist for this placeId: ";
    public static final String DATA_ABOUT_FAVORITE_PLACE =  "{\"name\":\"GoodPlace\",\"placeId\":5}";
    public static final String PLACE_UPDATING_MESSAGE = "{\"id\":2,\"status\":\"PROPOSED\"}";
    public static final String CURRENT_STATUS_MESSAGE = "\"Place with id: ";
}

