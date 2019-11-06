package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBRequest {

    public Boolean insertDataToDB(String insert, Statement statement) {
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

    public Boolean deleteDataFromDB(String insert, Statement statement) {
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

    public ArrayList<String> getDataFromDB(String select, Statement statement, String firstColumnLabel, String secondColumnLabel) {
        ResultSet resultSet = null;
        int id;
        int secondParam;
        ArrayList<String> res = new ArrayList();
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                id = resultSet.getInt(firstColumnLabel);
                secondParam = resultSet.getInt(secondColumnLabel);
                res.add(id + " " + secondParam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Boolean closeTransaction(Statement statement) {
        Boolean flag;
        try {
            statement.close();
            flag = true;
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
