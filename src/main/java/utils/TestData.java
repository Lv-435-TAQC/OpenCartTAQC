package utils;

import static utils.Constants.BASE_URL;

public class TestData {
    public static final String USER_LOGIN_PAGE = BASE_URL + "index.php?route=account/login";
    public static final String ADMIN_PAGE = BASE_URL + "admin";
    public static final String USER_NAME = "user@gmail.com";
    public static final String USER_PASSWORD = "user";
    public static final String HOME_PAGE = BASE_URL;
    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String COST_OF_TWO_IPHONES = "$246.40";
    public static final String BLANK_SYMBOL = " ";
    public static final String EMPTY_SHOPPING_CART_MESSAGE = "Yourshopping cart is empty!";
    public static final String COUPON_CODE = "111";
    public static final String GIFT_CERTIFICATE = "333";
    public static final String COUPON_CODE_FIELD_ON_ORDER_PAGE = "Coupon (111)";
    public static final String GIFT_CERTIFICATE_FIELD_ON_ORDER_PAGE = "Gift Certificate (333)";
    public static final String QUANTITY_PRODUCTS = "2";
    public static final String CHECKOUT_PAGE = BASE_URL + "index.php?route=checkout/checkout";
    public static final String IPHONE_ID = "40";
    public static final String SHIPPING_COUNTRY = "Ukraine";
    public static final Integer SHIPPING_REGION = 13;
    public static final String POST_CODE = "790032";
    public static final String IPHONE_COST = "$101.00";
    public static final String DISCOUNT_COUPON_FOR_IPHONE = "$-10.10";
    public static final String DISCOUNT_GIFT_CERTIFICATE_FOR_IPHONE = "$-30.00";
    public static final String EMPTY_SHOPPING_CART_NOTICE = "Your shopping cart is empty!";
    public static final String NOTICE_ABOUT_SUCCESSFUL_SHIPPING_ESTIMATE = "Success: Your shipping estimate has been applied";
    public static final String COST_OF_IPHONE_USING_COUPON = "$111.08";
    public static final String COST_OF_IPHONE_USING_GIFT_CERTIFICATE = "$93.20";
    public static final String COST_OF_IPHONE_USING_GIFT_CERTIFICATE_AND_COUPON = "$81.08";
    public static final String COST_OF_IPHONE_USING_COUPON_WITH_SHIPPING = "$90.90";
    public static final String COST_OF_IPHONE_USING_GIFT_CERTIFICATE_WITH_SHIPPING = "$76.00";
    public static final Object[][] INVALID_DATA_FOR_TEST_GIFT_CERTIFICATE = {new Object[]{"a333"}, new Object[]{""}, new Object[]{"333a"}};
    public static final Object[][] INVALID_DATA_FOR_TEST_COUPON = {new Object[]{"a111"}, new Object[]{""}, new Object[]{"1111"}};
    public static final Object[][] INVALID_DATA_FOR_TEST_QUANTITY_PRODUCTS = {new Object[]{"aaa"}, new Object[]{""}, new Object[]{"12v"}};

    public static final String VOUCHER_CODE = "995";
    public static final String VOUCHER_FROM_NAME = "user";
    public static final String VOUCHER_FROM_E_MAIL = "user@usergmail.com";
    public static final String VOUCHER_TO_NAME = "user";
    public static final String VOUCHER_TO_E_MAIL = "user@usergmail.com";
    public static final String VOUCHER_THEME = "General";
    public static final String VOUCHER_MESSAGE = "";
    public static final String VOUCHER_AMOUNT = "30.00";
    public static final String VOUCHER_AMOUNT_IN_TABLE = "$30.00";
    public static final String VOUCHER_STATUS = "Enabled";

    public static final String COUPON_NAME = "for everybody";
    public static final String COUPON_CREATING_CODE = "777";
    public static final String COUPON_TYPE = "Percentage";
    public static final String COUPON_DISCOUNT = "30.0000";
    public static final String COUPON_TOTAL_AMOUNT = "100";
    public static final String COUPON_DATE_START = "2019-10-29";
    public static final String COUPON_DATE_END = "2019-11-29";
    public static final String COUPON_USES_PER_COUPON = "20";
    public static final String COUPON_USES_PER_CUSTOMER = "20";
    public static final String COUPON_STATUS = "Enabled";


}
