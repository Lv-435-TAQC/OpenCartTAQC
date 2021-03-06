package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBRequest {

    public Boolean insertDataToDB(String insert, Statement statement) {
        Boolean flag;
        try {
            statement.execute(insert);
            flag = true;
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public Boolean deleteDataFromDB(String request, Statement statement) {
        Boolean flag;
        try {
            statement.execute(request);
            flag = true;
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<String> getDataFromDBTwoParameters(String select, Statement statement, String firstColumnLabel, String secondColumnLabel) {
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

    public ArrayList<String> getDataFromDBOneParameters(String select, Statement statement, String firstColumnLabel) {
        ResultSet resultSet = null;
        int param;
        ArrayList<String> res = new ArrayList();
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                param = resultSet.getInt(firstColumnLabel);
                res.add(param + "");
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

    public ResultSet selectDataToDB(String select, Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(select);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
