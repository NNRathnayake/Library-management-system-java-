/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author USER
 */

public class session {
    private static String currentEmail;
    private static final String SESSION_FILE = "session.txt";

    // Set and save session
    public static void setCurrentEmail(String email) {
        currentEmail = email;
        try (FileWriter writer = new FileWriter(SESSION_FILE)) {
            writer.write(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get from memory (if loaded)
    public static String getCurrentEmail() {
        return currentEmail;
    }

    // Load session from file (use this when program starts)
    public static void loadSession() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SESSION_FILE))) {
            currentEmail = reader.readLine();
        } catch (IOException e) {
            currentEmail = null; // file not found or error
        }
    }

    public static void clear() {
        currentEmail = null;
        try {
            new FileWriter(SESSION_FILE).close(); // clear file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isLoggedIn() {
        return currentEmail != null;
    }

   
}
