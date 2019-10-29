package utils;

import java.sql.SQLException;
import java.sql.Statement;

public class DBRequester {
    private Statement statement;

    public Boolean insertDataToDB(String insert){
            try{
                statement.execute(insert);
            }catch (SQLException e){
                e.printStackTrace();
            }
        return true;
    }
}
