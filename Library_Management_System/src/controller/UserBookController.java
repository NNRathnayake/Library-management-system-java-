/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import model.UserBook;
import model.UserBookDAO;
import model.UserDAO;
import model.Book;
import model.BookDAO;
import javax.swing.*;
import model.session;



public class UserBookController {

    private final UserDAO userDAO = new UserDAO();
    private final UserBookDAO userBookDAO = new UserBookDAO();
    private final BookDAO bookDAO = new BookDAO();

    public void borrowBook(Book book, String userEmail) {
        try {
            User user = userDAO.getUserByEmail(userEmail);

            if (user == null) {
                JOptionPane.showMessageDialog(null, "User not found.");
                return;
            }

            if (book.getQuantity() <= 0) {
                JOptionPane.showMessageDialog(null, "Book is out of stock.");
                return;
            }

            UserBook userBook = new UserBook(user.getId(), book.getId(), book.getTitle(), book.getpric(), user.getEmail());
            userBookDAO.insertUserBook(userBook);

            bookDAO.reduceQuantity(book.getId());

            JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Borrow failed: " + e.getMessage());
        }
    }
}
