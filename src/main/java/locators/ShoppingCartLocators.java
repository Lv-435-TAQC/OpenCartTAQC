package locators;

public class ShoppingCartLocators {
    public static final String PRODUCTS_TABLE_XPATH = "//div[@id=\"content\"]/form/div/table/tbody";
    public static final String CONTINUE_SHOPPING_BUTTON_XPATH = "//a[contains(.,'Continue Shopping')]";
    public static final String CHECKOUT_BUTTON_XPATH = "//a[@class='btn btn-primary']";
    public static final String OPEN_COUPON_CODE_BUTTON_XPATH = "//a[contains(.,'Use Coupon Code')]";
    public static final String INPUT_COUPON_CODE = "//input[@name='coupon']";
    public static final String APPLY_COUPON_BUTTON = "//*[@id=\"button-coupon\"]";
    public static final String OPEN_ESTIMATE_SHIPPING_TAXES_BUTTON = "//a[contains(.,'Estimate Shipping & Taxes')]";
    public static final String SELECT_COUNTRY_XPATH = "//select[@name='country_id']";
    public static final String SELECT_REGION_XPATH = "//*[@id=\"input-zone\"]";
    public static final String POST_CODE_XPATH = "//input[@name='postcode']";
    public static final String GET_QUOTES_BUTTON = "//button[@type='button'][contains(.,'Get Quotes')]";
    public static final String OPEN_USE_GIFT_CERTIFICATE_BUTTON_XPATH = "/html/body/div[2]/div/div/div[1]/div[3]/div[1]/h4/a";
    public static final String INPUT_CERTIFICATE_CODE = "//*[@id=\"input-voucher\"]";
    public static final String APPLY_CERTIFICATE_CODE_BUTTON = "//*[@id=\"button-voucher\"]";
    public static final String CONTINUE_SHOPPING = "//a[contains(@class,'btn btn-default')]";

    public static final String SUB_TOTAL_COST_XPATH = "//strong[contains(.,'Sub-Total:')]/../../td[2]";
    public static final String COUPON_XPATH = "//strong[contains(.,'Coupon (111):')]/../../td[2]";
    public static final String ECO_TAX_XPATH = "//strong[contains(.,'Eco Tax (-2.00):')]/../../td[2]";
    public static final String VAT_XPATH = "//strong[contains(.,'VAT (20%):')]/../../td[2]";
    public static final String GIFT_CERTIFICATE_XPATH = "//strong[contains(.,'Gift Certificate (333):')]/../../td[2]";
    public static final String TOTAL_COST_XPATH = "//strong[text()='Total:']/../../td[2]";
    public static final String FLAT_SHIPPING_RATE_XPATH = "//input[contains(@type,'radio')]";
    public static final String FLAT_SHIPPING_RATE_CANCEL_XPATH = "//button[@type='button'][contains(.,'Cancel')]";
    public static final String FLAT_SHIPPING_RATE_APPLY_XPATH = "//input[contains(@value,'Apply Shipping')]";
    public static final String TABLE_PRODUCTS_FOR_PREVIEW_CART = "/html/body/header/div/div/div[3]/div/ul/li[1]/table/tbody";
    public static final String SUCCESS_MASSAGE = "/html/body/div[2]/div[1]";
    public static final String CART_EMPTY_MASSAGE = "/html/body/div[2]/div/div/p";
}
