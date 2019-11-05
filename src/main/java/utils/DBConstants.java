package utils;

public class DBConstants {
    public static final String MARIA_DB_URL = "jdbc:mariadb://192.168.152.128:3306/opencart";
    public static final String MARIA_DB_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String MARIA_DB_USER_NAME = "opencartuser";
    public static final String MARIA_DB_PASSWORD = "user_password_here";
    private static final String INSERT_TO_WISH_LIST = "INSERT INTO oc_customer_wishlist(customer_id, product_id, date_added) VALUES ('1','41','2019-10-28 06:04:10');";

    public static final String MARIA_DB_URL_XAMPP = "jdbc:mysql://localhost/opencart";
    public static final String MARIA_DB_USER_NAME_XAMPP = "root";
    public static final String MARIA_DB_PASSWORD_XAMPP = "root";
    public static final String ORDERS = "SELECT * FROM opencart.oc_order;";


}
