import greencity.FavoritePlace;
import greencity.OwnSecurityController;
import greencity.PlaceController;
import greencity.Security;

public class Main {

    public static void main(String[] args) {
        Security sec = new Security();
        String token = sec.signIn("oleh.zarichnyi@gmail.com", "QWErty123$%^");
    
        System.out.println(token);
        FavoritePlace favoritePlace = new FavoritePlace();
        System.out.println(favoritePlace.getAllFavoritePlaces(token));
        System.out.println(favoritePlace.updateFavoritePlaceName(token, "Бук", 3));
    }
}
