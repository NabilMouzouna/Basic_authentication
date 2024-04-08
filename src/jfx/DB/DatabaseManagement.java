package jfx.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DatabaseManagement {

    // METHOD to find a user in the database by the email address
    static public User findUser(String email) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String findUserQuery = "SELECT * FROM users WHERE email = ?";
            PreparedStatement pstmt1 = conn.prepareStatement(findUserQuery);
            pstmt1.setString(1, email);
            ResultSet result = pstmt1.executeQuery();
    
            // Check if the ResultSet contains any rows
            if (result.next()) {
                // Extract user information from the ResultSet
                int id = result.getInt("id");
                String fullname = result.getString("fullname");
                String password = result.getString("password");
    
                return new User(id, fullname, email, password);
            } else {
                // No user found with the provided email
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    


    // METHOD to save user to the database
    static public boolean saveToDB(User user){
        
        try (Connection conn = DatabaseConnection.getConnection()){

                String createUserQuery = "INSERT INTO users (email, fullname, password) VALUES (?, ?, ?)";
                PreparedStatement pstmt2 = conn.prepareStatement(createUserQuery);
                pstmt2.setString(1, user.getEmail());
                pstmt2.setString(2, user.getFullname());
                pstmt2.setString(3, user.getPassword());
                int rowsInserted = pstmt2.executeUpdate(); // Execute the INSERT statement

                if (rowsInserted > 0) {
                    // User successfully created
                    System.out.println("User created successfully");
                    return true;
                } else {
                    // Failed to create user
                    System.out.println("Failed to create user");
                    return false;
                }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
   }
}
