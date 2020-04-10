package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class that manages the connection to the database
 */
public class Database {

    private static Database database = null;
    public static Connection connection = null;

    private Database() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String serverName = "localhost";
            String serverPort = "1521";
            String sid = "XE";

            String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;

            String username = "dba";
            String password = "sql";

            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Successfully connected to the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to the database " + e.getMessage());
        }
    }

    public static Database getInstance() {
        if (database == null)
            database = new Database();
        return database;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
