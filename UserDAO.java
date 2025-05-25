/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.User;
import io.FileManager;

public class UserDAO {

    public static User findUser(String u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void updateUser(User currentUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Register a new user

    /**
     *
     * @param user
     * @return
     */
    public static boolean registerUser(User user) {
        if (FileManager.userExists(user.getUsername())) {
            return false; // User already exists
        }
        FileManager.saveUser(user.getUsername(), user.getPassword());
        return true;
    }

    // Validate login
    public boolean loginUser(User user) {
        return FileManager.validateLogin(user.getUsername(), user.getPassword());
    }
}

