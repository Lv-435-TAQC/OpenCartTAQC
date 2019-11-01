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
    public static final String INSERT_TO_VIEWED = "UPDATE oc_product SET viewed = 2 WHERE product_id < 35;";
    public static final String GET_FROM_VIEWED = "SELECT product_id, viewed FROM oc_product WHERE product_id < 35;";
    public static final ArrayList<String> EXPECTED = new ArrayList<String>(Arrays.asList("28 0", "29 0", "30 0", "31 0", "32 0", "33 0", "34 0"));
}
