

package model;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final String url = "jdbc:mysql://localhost:3306/lib"; // Your DB name
    private final String user = "root"; // Your DB user
    private final String password = "1234"; // Your DB password

    public void saveUser(User u) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL Driver not found.");
        }

        String sql = "INSERT INTO users (firstname, middlename, lastname, gender, birthday, contact, email, adress,password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, u.getFname());      // maps to firstname
            pst.setString(2, u.getMname());      // middlename
            pst.setString(3, u.getLname());      // lastname
            pst.setString(4, u.getGender());     // gender
            pst.setString(5, u.getBday());       // birthday
            pst.setString(6, u.getContact());    // contact
            pst.setString(7, u.getEmail());      // email
            pst.setString(8, u.getAdrs());     // adress (with typo)
            pst.setString(9, u.getpwd());
            
            pst.executeUpdate();
        } // resources closed automatically here
    }
    
    
   public User login(String email, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, this.password)) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("email"), rs.getString("password")); // You can add more fields
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
   
   
   public List<User> getAllUsers() throws SQLException {
    List<User> users = new ArrayList<>();
    String sql = "SELECT * FROM users";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            String id = rs.getString("id");
            String fname = rs.getString("firstname");
            String mname = rs.getString("middlename");
            String lname = rs.getString("lastname");
            String gender = rs.getString("gender");
            String bday = rs.getString("birthday");
            String contact = rs.getString("contact");
            String email = rs.getString("email");
            String adrs = rs.getString("adress");
            String pwd = rs.getString("password");

            User userObj = new User(id, fname, mname, lname, gender, bday, contact, email, adrs, pwd);
            users.add(userObj);
        }
    }
    return users;
    
   }
    
    
    
    public User getUserByEmail(String email) throws SQLException {
    String sql = "SELECT * FROM users WHERE email = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return new User(
                rs.getString("id"),
                rs.getString("firstname"),
                rs.getString("middlename"),
                rs.getString("lastname"),
                rs.getString("gender"),
                rs.getString("birthday"),
                rs.getString("contact"),
                rs.getString("email"),
                rs.getString("adress"),
                rs.getString("password")
            );
        }
    }
    return null;
}

}

    
    
    
    
    
    
    
    
    
    
    
   
   
   
   
   
   
   
   
   
   
   
   









