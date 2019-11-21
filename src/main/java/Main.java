import greencity.OwnSecurityController;
import greencity.FavoritePlace;
import greencity.PlaceCommentController;
import greencity.Security;

public class Main {

    public static void main(String[] args) {
        Security sec = new Security();
        String token = sec.signIn("orysita.lviv@gmail.com","QWErty123$%^");
       // OwnSecurityController ownSecurityController=new OwnSecurityController();
      //  System.out.println(ownSecurityController.ownSecurityChangePassword(token,"QWErty123$%^", "QWErty0123$%^"));
        FavoritePlace favoritePlace = new FavoritePlace();
        System.out.println(favoritePlace.getAllFavoritePlaces(token));
    }

}