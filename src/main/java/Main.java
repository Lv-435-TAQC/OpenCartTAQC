import greencity.Security;
import utils.DBMethods;

public class Main {

    public static void main(String[] args) {
        Security sec = new Security();
        System.out.println(sec.signIn("oleh.zarichnyi@gmail.com","QWErty123$%^"));
    }
}