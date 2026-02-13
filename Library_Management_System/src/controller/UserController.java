/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.session;

import model.User;
import model.UserDAO;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import view.Home;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    public void handleUserSubmission(String fname, String mname, String lname, String gender, String bday, String contact, String email, String address,String password) {
        // 1. Validate inputs (simple example)
        if (fname == null || fname.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "First name cannot be empty!");
            return;
        }
        // You can add more validations here...

        // 2. Create User object
        User user = new User(fname, mname, lname, gender, bday, contact, email, address,password);

        // 3. Save user to database
        try {
            userDAO.saveUser(user);
            JOptionPane.showMessageDialog(null, "User saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving user: " + e.getMessage());
        }
    }
     
    
    
  public void validate(String email, String password, javax.swing.JFrame loginFrame) {
    User user = userDAO.login(email, password);

    if (user != null) {
        model.session.setCurrentEmail(email);  // store session
        JOptionPane.showMessageDialog(null, "Login successful!");

        Home home = new Home();
        home.setVisible(true);

        loginFrame.dispose(); // ✅ Close login window
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email or password!");
    }
}

}
