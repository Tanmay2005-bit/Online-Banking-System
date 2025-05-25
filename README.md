# Online-Banking-System

## Overview

This is a **Console-based Online Banking System** implemented in Java.  
The system allows users to register, login, check their balance, deposit money, withdraw money, and view transaction history.  
It uses file-based storage to persist user data and transactions.

## Project Structure

ConsoleBankingSystem

-> Main.java # Main class to run the application

 -> model
  User.java # User model class representing a bank user

 -> -dao
   UserDAO.java # Data Access Object for reading/writing User data

 -> service/
   BankService.java # Business logic for banking operations

 -> io
    FileManager.java # File handling utility class for persistence

## Requirements

- **Java Development Kit (JDK)** 8 or higher installed  
- Any Java IDE (e.g., NetBeans, IntelliJ IDEA, Eclipse) or command line setup  
- Basic command line or terminal for running the program

- Here in our project we have installed JDK 23 and have used NetBeans as our IDE

- ## Setup Instructions

1. **Clone or download** the project source code to your local machine.

2. **Open the project in NetBeans:**

   - Launch **NetBeans IDE**.
   - Go to **File > Open Project**.
   - Navigate to the `ConsoleBankingSystem` folder and select it.
   - NetBeans will automatically recognize the project and load it.

3. **Build and run the project:**

   - Right-click on the project in the **Projects** panel.
   - Select **Clean and Build** to compile the project.
   - Select **Run** to execute the application.

>  No command-line compilation is needed. All development and execution were handled directly within NetBeans.

# Once the application is running, you can interact with it through the console menu:

Register a new user account

Login with existing credentials

Check Balance of your account

Deposit money into your account

Withdraw money from your account

View Transaction History

Exit the application

# IMPORTANT POINT TO BE TAKEN REGARDING VIEWING OF THE PROJECT 

-> Project is submitted as .zip file in the repository.

-> Codes  .txt file is also seperately included in the repository for efficient and easy viewing of the files.

# Project is performed step by step covering every part of rubrics for review 1:

Creating the new project with JDK & IDE setup:
Install JDK (Java Development Kit) (version 8+).
Use NetBeans IDE.
Create new project:
Go to File → New Project → Java Application.
Name: ConsoleBankingSystem.
Uncheck “Create Main Class”.

Define the project structure : Already Defined above 

Design the database schema for the project:
We'll store users and transactions in .txt files:
users.txt:
username,password,balance
john,1234,5000.0
transactions_username.txt:
type,amount,date
Deposit,1000,2024-05-24

Create a Files to work on the Project ( to store, Retrive , update , delete ):
Use java.io:
FileReader, FileWriter, BufferedReader, PrintWriter
Store all users in users.txt
One file per user for transactions

Implement IO connectivity using Io package. :
This is done under FileManager.java

Create Model, DAO classes for the IO CRUD operations:
This is done under User.java and UserDAO.java

Aesthetics and Visual Appeal of the UI (Console based , using scanner class ) :
This is done under BankService.java

Component Placement and Alignment in the UI:
Menus are cleanly separated.
Each screen shows only relevant info.
Options are numbered clearly.
Prompts guide the user.

Responsiveness and Accessibility of the UI:
Works well on any terminal.
Clear text-based prompts.
Gracefully handles errors like wrong input.


# Explanation of Completed Tasks

Project Setup:
Initialized the Java project environment with the necessary JDK and IDE configurations, ensuring smooth compilation and execution.

Project Structure Definition:
Organized the codebase into clear packages: model, dao, service, and io for modular development and maintainability.

Database Schema Design:
Designed the logical data schema to support user accounts, transactions, and balances. (File-based storage used instead of a formal database.)

File Management for Persistence:
Created files and structured the system for performing Create, Read, Update, and Delete (CRUD) operations on user and transaction data.

IO Package Implementation:
Developed the FileManager class to handle all file input/output operations robustly.

Model & DAO Classes:
Built the core model (User) and data access object (UserDAO) classes to encapsulate data and persistence logic respectively.

User Interface (Console-based):
Designed an easy-to-use console UI using Java’s Scanner class, focusing on clarity, input validation, and a pleasant user experience.

UI Component Alignment:
Thoughtfully placed UI prompts and menu components for logical flow and user readability.

UI Responsiveness & Accessibility:
Ensured the console application responds promptly to user input and is accessible through keyboard-only navigation.


By -
Tanmay Sharma






- 



