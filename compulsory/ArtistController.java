package compulsory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAO class that adds or finds artists
 */
public class ArtistController {

    private Database database;

    public ArtistController(Database database) {
        this.database = database;
    }

    public void create(String name, String country) {
        Statement statement = null;
        try {
            statement = database.getConnection().createStatement();
            statement.executeQuery("insert into artists (name,country) VALUES  ('" + name + "','" + country + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findByName(String name) {
        try {
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select id from artists where name = '" + name + "';");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
