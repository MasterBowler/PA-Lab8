package compulsory;

public class Main {

    public static void main(String[] args) {
        Database database = Database.getInstance();

        ArtistController artistController = new ArtistController(database);
        AlbumController albumController = new AlbumController(database);

        artistController.create("Oliver Tree","California");
        artistController.create("Lemaitre","Norway");

        albumController.create("Alien Boy",artistController.findByName("Oliver Tree"),2018);
        System.out.println(albumController.findByArtist(artistController.findByName("Oliver Tree")));

        Database.closeConnection();
    }
}
