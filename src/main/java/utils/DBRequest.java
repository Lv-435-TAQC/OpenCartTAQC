package utils;

import java.sql.SQLException;
import java.sql.Statement;

public class DBRequest {

    public Boolean insertDataToDB(String insert, Statement statement){
        Boolean flag;
            try{
                statement.execute(insert);
                flag = true;
            }catch (SQLException e){
                flag = false;
                e.printStackTrace();
            }
        return flag;
    }
}
