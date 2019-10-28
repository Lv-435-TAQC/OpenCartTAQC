package utils;

public class Constants {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int EIGHT = 8;
    public static final String BASE_URL = "http://192.168.152.128/opencart/";
    public static final String PATH_TO_DRIVER = "src/main/resources/geckodriver.exe";
    public static final String KEY_TO_DRIVER = "webdriver.gecko.driver";
    public static final String REGISTRATION_PAGE_URL = BASE_URL + "index.php?route=account/register";
    public static final String SUCCESSFUL_REGISTRATION_URL = BASE_URL + "index.php?route=account/success";
    public static final String FIRST_NAME_INVALID_MESSAGE = "First Name does not appear to be valid!";
    public static final String LAST_NAME_INVALID_MESSAGE = "Last Name does not appear to be valid!";
    public static final String FIRST_NAME_INVALID_LENGTH_MESSAGE = "First Name must be between 1 and 32 characters!";
    public static final String LAST_NAME_INVALID_LENGTH_MESSAGE = "Last Name must be between 1 and 32 characters!";
    public static final String EMAIL_INVALID_ADDRESS_MESSAGE = "E-Mail Address does not appear to be valid!";
    public static final String TELEPHONE_INVALID_LENGTH_MESSAGE = "Telephone must be between 3 and 32 characters!";
    public static final String PASSWORD_INVALID_LENGTH_MESSAGE = "Password must be between 4 and 20 characters!";
    public static final String PASSWORD_CONFIRMATION_MATCH_ERROR_MESSAGE = "Password confirmation does not match password!";
    public static final String PRIVACY_POLICY_AGREE_WARNING_MESSAGE = "Warning: You must agree to the Privacy Policy!";
    public static final String SIKULI_IMAGE_WISH_LIST_IMAC = "E:\\Folder_for_sikuli/IMacWishList.png";
    public static final String SIKULI_IMAGE_WISH_LIST_APPLE = "E:\\Folder_for_sikuli/Apple.png";
    public static final String ALERT_WISH_LIST_SUCCESS = "Success:";
    public static final String WISH_LIST_ID_41 = "41";
    public static final String WISH_LIST_ID_42 = "42";
    public static final String LOGOUT_URL = "http://localhost/opencart/index.php?route=account/logout";
}
