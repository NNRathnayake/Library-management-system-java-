/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private final String url = "jdbc:mysql://localhost:3306/lib"; // your DB
    private final String user = "root";
    private final String password = "1234";

    public void addBook(Book book) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found.");
        }

        String sql = "INSERT INTO books (title, description, quantity, image_path, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, book.getTitle());
            pst.setString(2, book.getDescription());
            pst.setInt(3, book.getQuantity());
            pst.setString(4, book.getImagePath());  // only filename or relative path
            pst.setDouble(5,book.getpric());
            pst.executeUpdate();
            
           
        }}
    
    
    
    
    public List<Book> getAllBooks() throws SQLException {
    List<Book> books = new ArrayList<>();
    String sql = "SELECT * FROM books";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            String title = rs.getString("title");
            String description = rs.getString("description");
            int quantity = rs.getInt("quantity");
            String imagePath = rs.getString("image_path");
            double price = rs.getDouble("price");
            int id = rs.getInt("id");
            Book book = new Book(id, title, description, quantity, imagePath, price);
            books.add(book);
        }
    }
    return books;
    
    }
    
    public void reduceQuantity(int bookId) throws Exception {
    Connection conn = DriverManager.getConnection(url, user, password);
    String sql = "UPDATE books SET quantity = quantity - 1 WHERE id = ? AND quantity > 0";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, bookId);
    stmt.executeUpdate();
    stmt.close();
    conn.close();

}
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
}
