import utils.DBMethods;

public class Main {

    public static void main(String[] args) {
        DBMethods dbMethods = new DBMethods();
        dbMethods.deleteAllUsersFromDB();
    }
}