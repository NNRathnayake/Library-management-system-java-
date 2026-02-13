/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class UserBook {
    private String Id;
    private int id;
    private String bookTitle;
    private double price;
    private String email;

    public UserBook(String Id, int id, String bookTitle, double price ,String email) {
        this.id = id;
        this.Id =Id;
        this.bookTitle = bookTitle;
        this.price = price;
        this.email=email;
    }

    public String getUserId() { return Id; }
    public int getBookId() { return id; }
    public String getBookTitle() { return bookTitle; }
    public double getPrice() { return price;}
 public String getemail() { return email;}
    /**
     *
     * @return
     */
   

}
