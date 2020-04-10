package compulsory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class that adds or finds albums
 */
public class AlbumController {

    private Database database;

    public AlbumController(Database database) {
        this.database = database;
    }

    public void create(String name, int artistId, int releaseYear) {
        Statement statement = null;
        try {
            statement = database.getConnection().createStatement();
            statement.executeQuery("insert into albums (name,artist_id,release_year) VALUES  ('" + name + "','" + artistId + "','" + releaseYear + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> findByArtist(int artistId) {
        try {
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select id from albums where artist_id = " + artistId + ";");
            resultSet.next();

            List<Integer> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getInt(1));
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
