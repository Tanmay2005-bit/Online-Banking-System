/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io;

import java.io.*;
import java.util.*;

public class FileManager {

    private static final String USER_FILE = "users.txt";

    public static Map<String, String> loadUsers() {
        Map<String, String> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    users.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            // File may not exist yet — no problem
        }
        return users;
    }

    public static void saveUser(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(username + "," + password);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean userExists(String username) {
        return loadUsers().containsKey(username);
    }

    public static boolean validateLogin(String username, String password) {
        Map<String, String> users = loadUsers();
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // This method appends a line (like a transaction record) to a file.
    public static void appendLine(String file, String line) {
        System.out.println("🟩 appendLine() reached: " + line);  
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method reads all lines from a file and returns as a list of strings.
    public static List<String> readLines(String file) {
         System.out.println("🟦 readLines() reading file: " + file);  
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            // If file not found, just return empty list
        }
        return lines;
    }
}
