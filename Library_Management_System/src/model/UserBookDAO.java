/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserBookDAO {
    private final String url = "jdbc:mysql://localhost:3306/lib";
    private final String user = "root";
    private final String password = "1234";

  
    
    public void insertUserBook(UserBook userBook) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

      String sql = "INSERT INTO user_book (user_id, book_id, book_title, price, email) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);

    stmt.setString(1, userBook.getUserId());
    stmt.setInt(2, userBook.getBookId());
    stmt.setString(3, userBook.getBookTitle());
    stmt.setDouble(4, userBook.getPrice());
    stmt.setString(5, userBook.getemail()); // 
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
