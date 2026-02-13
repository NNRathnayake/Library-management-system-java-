/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

/*public class User {
    private String fname;

    public User(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return fname;
    }
String UGender = gender.getText();
        String birthDay= bday.getText();
        String PNumber = contact.getText();
        String uEmail=email.getText();
        String Uaddress= adress.getText();
}
*/

public class User {
    private String fname;
    private String mname;
    private String lname;
    private String gender;
    private String bday;
    private String contact;
    private String email;
    private String adress;
 private String password;
 private String Id;
    public User(String fname, String mname, String lname, String gender, String bday, String contact, String email, String adress, String password) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.gender = gender;
        this.bday = bday;
        this.contact = contact;
        this.email = email;
        this.adress = adress;
        this.password=password;
    }
    
    public User( String Id,String fname, String mname, String lname, String gender, String bday, String contact, String email, String adress,String password) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.gender = gender;
        this.bday = bday;
        this.contact = contact;
        this.email = email;
        this.adress = adress;
        this.password=password;
        this.Id=Id;
    } 

    
    public User(String email, String Id) {
        this.email = email;
        this.Id=Id;
    }

    // Getters
    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    public String getGender() {
        return gender;
    }

    public String getBday() {
        return bday;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getAdrs() {
        return adress;
    }

    public String getpwd() {
        return password;
    }
    public String getId() {
        return Id;
    }
}