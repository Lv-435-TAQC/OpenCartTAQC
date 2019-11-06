package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class DBConstants {
    public static final String MARIA_DB_URL = "jdbc:mariadb://192.168.152.128:3306/opencart";
    public static final String MARIA_DB_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String MARIA_DB_USER_NAME = "opencartuser";
    public static final String MARIA_DB_PASSWORD = "user_password_here";
    public static final String ADMIN_NAME = "nataliia";
    public static final String ADMIN_PASSWORD = "vmnataliia";
    public static final String UPDATE_VIEWED_PRODUCTS = "UPDATE oc_product SET viewed = 2 WHERE product_id < 35;";
    public static final String GET_FROM_VIEWED = "SELECT product_id, viewed FROM oc_product WHERE product_id < 35;";
    public static final ArrayList<String> EXPECTED_FOR_REPORTS = new ArrayList<String>(Arrays.asList("28 0", "29 0", "30 0", "31 0", "32 0", "33 0", "34 0"));
    public static final String GET_FROM_ORDER = "SELECT order_id, total FROM oc_order;";
    public static final String INSERT_TO_ORDER = "INSERT INTO `opencart`.`oc_order` (`order_id`, `invoice_no`, `invoice_prefix`, `store_id`, `store_name`, `store_url`, `customer_id`, `customer_group_id`, `firstname`, `lastname`, `email`, `telephone`, `fax`, `custom_field`, `payment_firstname`, `payment_lastname`, `payment_company`, `payment_address_1`, `payment_address_2`, `payment_city`, `payment_postcode`, `payment_country`, `payment_country_id`, `payment_zone`, `payment_zone_id`, `payment_address_format`, `payment_custom_field`, `payment_method`, `payment_code`, `shipping_firstname`, `shipping_lastname`, `shipping_company`, `shipping_address_1`, `shipping_address_2`, `shipping_city`, `shipping_postcode`, `shipping_country`, `shipping_country_id`, `shipping_zone`, `shipping_zone_id`, `shipping_address_format`, `shipping_custom_field`, `shipping_method`, `shipping_code`, `comment`, `total`, `order_status_id`, `affiliate_id`, `commission`, `marketing_id`, `tracking`, `language_id`, `currency_id`, `currency_code`, `currency_value`, `ip`, `forwarded_ip`, `user_agent`, `accept_language`, `date_added`, `date_modified`) VALUES ('7', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '205', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '2019-11-05 05:15:24', '2019-11-05 05:15:24');";
    public static final String DELETE_ALL_FROM_ORDER = "DELETE FROM `opencart`.`oc_order`;";
    public static final String DELETE_ALL_FROM_WISH_LIST = "DELETE FROM `opencart`.`oc_customer_wishlist`;";
    public static final String INSERT_TO_WISH_LIST = "INSERT INTO `opencart`.`oc_customer_wishlist` (`customer_id`, `product_id`, `date_added`) \n" +
            "VALUES ('1', '47', '2019-11-05 00:07:17'),\n" +
            "('1', '42', '2019-11-05 00:07:17'),\n" +
            "('1', '41', '2019-11-05 00:07:17'),\n" +
            "('1', '40', '2019-11-05 00:07:17'),\n" +
            "('1', '30', '2019-11-05 00:07:17');";
    public static final String MARIA_DB_URL_XAMPP = "jdbc:mysql://localhost/opencart";
    public static final String MARIA_DB_USER_NAME_XAMPP = "root";
    public static final String MARIA_DB_PASSWORD_XAMPP = "root";
    public static final String ORDERS = "SELECT * FROM opencart.oc_order;";
}
