package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.DBConstants.*;

public class DBMethods {

    public String getLastOrderIDFromDB() {
        int lastOrder = -1;
        DBConnector connector = new DBConnector();
        DBRequest request = new DBRequest();
        ResultSet set = request.selectDataToDB(DBConstants.ORDERS,
                connector.getConnectionMariaDB(DBConstants.MARIA_DB_DRIVER, DBConstants.MARIA_DB_URL_XAMPP,
                        MARIA_DB_USER_NAME_XAMPP, DBConstants.MARIA_DB_PASSWORD_XAMPP));
        connector.closeConnectionMariaDB();
        try {
            while (set.next()) {
                int item = Integer.valueOf(set.getString(1));
                if (lastOrder < item)
                    lastOrder = item;
            }
        } catch (SQLException ex) {
            System.out.println("Connection to DB is fail !!!");
        }
        return String.valueOf(lastOrder);
    }

    public String getOrdersTotalCostFromDB(String orderId) {
        int id = Integer.parseInt(orderId);
        String totalCost = "0";
        DBConnector connector = new DBConnector();
        DBRequest request = new DBRequest();
        ResultSet set = request.selectDataToDB(DBConstants.ORDERS,
                connector.getConnectionMariaDB(DBConstants.MARIA_DB_DRIVER, DBConstants.MARIA_DB_URL_XAMPP,
                        MARIA_DB_USER_NAME_XAMPP, DBConstants.MARIA_DB_PASSWORD_XAMPP));
        connector.closeConnectionMariaDB();
        try {
            while (set.next()) {
                int item = Integer.valueOf(set.getString(1));
                if (id == item){
                    totalCost = set.getString(46);
                }

            }
        } catch (SQLException ex) {
            System.out.println("Connection to DB is fail !!!");
        }
        return totalCost;
    }

    public void deleteAllUsersFromDB() {
        DBConnector dbConnector = new DBConnector();
        DBRequest dbRequest = new DBRequest();
        dbConnector.getConnectionMariaDB(
                MARIA_DB_DRIVER, "jdbc:mysql://localhost:3307/opencartdb", MARIA_DB_USER_NAME_XAMPP, "");
        dbRequest.deleteDataFromDB(DELETE_ALL_USERS_FROM_DB, dbConnector.getStatement());
    }
}
