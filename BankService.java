/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UserDAO;
import io.FileManager;
import model.User;

import java.util.*;
import java.text.SimpleDateFormat;

public class BankService {
    private final Scanner sc = new Scanner(System.in);
    private User currentUser;

    public void start() throws Exception {
        OUTER:
        while (true) {
            System.out.println("===== Online Banking System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Goodbye!");
                    break OUTER;
                }
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private void register() throws Exception {
        System.out.print("Enter username: ");
        String u = sc.nextLine().trim();
        System.out.print("Enter password: ");
        String p = sc.nextLine().trim();

        // Create User with initial balance 0.0
        User newUser = new User(u, p, 0.0);

        
        if (!UserDAO.registerUser(newUser)) {
            System.out.println("Username already exists.\n");
        } else {
            System.out.println("Registration successful!\n");
        }
    }

    private void login() throws Exception {
        System.out.print("Username: ");
        String u = sc.nextLine().trim();
        System.out.print("Password: ");
        String p = sc.nextLine().trim();

        User user = UserDAO.findUser(u);
        if (user != null && user.getPassword().equals(p)) {
            currentUser = user;
            System.out.println("Login successful.\n");
            dashboard();
        } else {
            System.out.println("Invalid credentials.\n");
        }
    }

    private void dashboard() throws Exception {
        while (true) {
            System.out.println("\n--- Welcome, " + currentUser.getUsername() + " ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine(); 

            switch (ch) {
                case 1 -> System.out.println("Balance: $" + currentUser.getBalance());
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> showTransactions();
                case 5 -> {
                    System.out.println("Logging out...\n");
                    currentUser = null;
                    return; // exit dashboard
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void deposit() throws Exception {
        System.out.print("Amount to deposit: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        if (amt <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        currentUser.setBalance(currentUser.getBalance() + amt);
        UserDAO.updateUser(currentUser);
        recordTransaction("Deposit", amt);
        System.out.println("Deposit successful.");
    }

    private void withdraw() throws Exception {
        System.out.print("Amount to withdraw: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        if (amt <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (amt > currentUser.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            currentUser.setBalance(currentUser.getBalance() - amt);
            UserDAO.updateUser(currentUser);
            recordTransaction("Withdraw", amt);
            System.out.println("Withdrawal successful.");
        }
    }

    private void recordTransaction(String type, double amt) throws Exception {
        String file;
        file = "transactions_" + currentUser.getUsername() + ".txt";
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        FileManager.appendLine(file, type + "," + amt + "," + time);
    }

    private void showTransactions() throws Exception {
        String file = "transactions_" + currentUser.getUsername() + ".txt";
        List<String> txs = FileManager.readLines(file);
        System.out.println("--- Transaction History ---");
        if (txs.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String tx : txs) System.out.println(tx);
        }
    }
}
