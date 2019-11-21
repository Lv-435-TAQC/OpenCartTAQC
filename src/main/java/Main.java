import greencity.FavoritePlace;
import greencity.PlaceCommentController;
import greencity.Security;
import utils.DBMethods;

public class Main {

    public static void main(String[] args) {
        Security sec = new Security();
        String token = sec.signIn("oleh.zarichnyi@gmail.com","QWErty123$%^");
    

    }

}