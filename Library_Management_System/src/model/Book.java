/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Book {
    private int id;
    private String title;
    private String description;
    private int quantity;
    private String imagePath;
    private double price;

   // Constructor for existing book with ID (e.g., from database)
    public Book(int id, String title, String description, int quantity, String imagePath, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.price = price;
    }

    // Constructor for new book without ID (e.g., when inserting)
    public Book(String title, String description, int quantity, String imagePath, double price) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.price = price;
    }

    
    // Constructor for new book without ID (e.g., when inserting)
    public Book(String title, int id) {
        this.title = title;
        
        this.id = id;
    }

    
    
    
    
    
    
    
    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public String getImagePath() { return imagePath; }
    public double getpric() { return price; }

    void setId(int generatedId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
