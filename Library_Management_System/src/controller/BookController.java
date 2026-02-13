/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;



import model.Book;
import model.BookDAO;
  import model.UserBook;
import model.UserBookDAO;
import javax.swing.*;
import model.User;

public class BookController {
    
    
    
  

    
    
    
    
    
    
    
    
    
 
    private final BookDAO dao = new BookDAO();

    public void addNewBook(String title, String description, int quantity, String imagepath ,double price) {
        try {
            
            Book book = new Book(title, description, quantity, imagepath, price);
            dao.addBook(book);
            JOptionPane.showMessageDialog(null, "Book added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid year. Please enter a number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    
    public java.util.List<Book> getAllBooks() throws Exception {
    return dao.getAllBooks();
}

    
    
 

}