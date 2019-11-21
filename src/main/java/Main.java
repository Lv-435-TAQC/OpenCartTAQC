import greencity.OwnSecurityController;
import greencity.Security;

public class Main {

    public static void main(String[] args) {
        Security sec = new Security();
     //   String token = sec.signIn("orysita.lviv@gmail.com","QWErty123$%^");
       OwnSecurityController ownSecurityController=new OwnSecurityController();
       System.out.println(ownSecurityController.restorePassword("orysita.lviv@gmail.com"));
//        FavoritePlace favoritePlace = new FavoritePlace();
//        System.out.println(favoritePlace.getAllFavoritePlaces(token));
    }
}