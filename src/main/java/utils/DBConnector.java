package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static utils.DBConstants.*;

public class DBConnector {
    private Connection connection;
    private Statement statement;

    public Statement getConnectionMariaDB(){
        try {
            Class.forName(MARIA_DB_DRIVER);
            connection = DriverManager.getConnection(MARIA_DB_URL, MARIA_DB_USER_NAME, MARIA_DB_PASSWORD);
            statement = connection.createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Boolean isConnected = true;
        try {
            isConnected = !connection.isClosed();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return statement;
    }
    public Boolean closeConnectionMariaDB(){
        Boolean isClosed = true;
        try {
            connection.close();
            isClosed = connection.isClosed();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isClosed;
    }
}
