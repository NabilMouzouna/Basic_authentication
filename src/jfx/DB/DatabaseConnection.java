package jfx.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/database-name";
    private static final String USERNAME = "your-database-username";
    private static final String PASSWORD = "your-database-password";

    // Méthode pour établir la connexion à la base de données
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Méthode pour fermer la connexion à la base de données
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}