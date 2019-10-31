package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private Connection connection;
    private Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public Statement getConnectionMariaDB(String DBdriver, String DBurl, String DBname, String DBpassword){
        try {
            Class.forName(DBdriver);
            connection = DriverManager.getConnection(DBurl, DBname, DBpassword);
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
