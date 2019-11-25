import greencity.OwnSecurityController;
import greencity.PlaceController;
import greencity.Security;

public class Main {

    public static void main(String[] args) {
        Security sec = new Security();
        String token = sec.signIn("orysita.lviv+10002@gmail.com", "QWErty123$%^");
        OwnSecurityController ownSecurityController = new OwnSecurityController();
        System.out.println(ownSecurityController.ownSecurityPassword(token, "QWErty123$%^", "QWErty0123$%^"));
        System.out.println(ownSecurityController.ownSecurityPassword(token, "QWErty0123$%^", "QWErty123$%^"));
       // OwnSecurityController ownSecurityController = new OwnSecurityController();
      //  System.out.println(token);
//        System.out.println(ownSecurityController.signUp("orysita.lviv+10002@gmail.com","Orysia","Benko","QWErty123$%^"));
//        Security sec = new Security();
//        String token = sec.signIn("orysita.lviv+10002@gmail.com", "QWErty123$%^");
//        ownSecurityController.varifyEmail(token);
//        FavoritePlace favoritePlace = new FavoritePlace();
//        System.out.println(favoritePlace.getAllFavoritePlaces(token));

//        Security sec = new Security();
//        String token = sec.signIn("andrijrubchuk@gmail.com", "Andr0306%");
//        System.out.println(token);
//        PlaceController placeController = new PlaceController();
//        System.out.println(placeController.saveFavoritePlace(token));
//
//    }
}