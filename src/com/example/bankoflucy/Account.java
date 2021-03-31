package com.example.bankoflucy;
import java.util.*;
public class Account {
    int balance;
    int previousTransaction;
    String accountName;
    String accountId;

    //constructor of Account;
    Account (String clientName, String clientId) {
        this.accountName = clientName;
        this.accountId = clientId;
    }

    //Make a deposit;
    public void Deposit(int amount) {
        if(amount != 0) {
            this.balance += amount;
            this.previousTransaction = amount;
        }
    }

    //Make a withdrawal;
    public void Withdraw(int amount) {
        if(amount != 0) {
            this.balance -= amount;
            this.previousTransaction = -amount;
        }
    }

    //View the previous transaction;
    public void previousTransaction() {
        if(this.previousTransaction > 0) {
          System.out.println("Deposit：" + previousTransaction);
        }
        else if(this.previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No previous transaction.");
        }
    }

    //Calculate Interest;
    public void calculateInterest(int years) {
        double currentInterest = 0.0225;
        double newBalance = balance * currentInterest * years + balance;
        System.out.println("The current interest rate is " + (currentInterest * 100) + "%");
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    }

    //display option menu;
    public void displayMenu() {
        System.out.println("Welcome, " + accountName);
        System.out.println("Your account ID is: " + accountId);
        System.out.println("1) Check your balance");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) View the previous transaction");
        System.out.println("5) Calculate Interest");
        System.out.println("6) Exit");
    }

    //option action
    public void chooseOption() {
        int option = 0;
        Scanner in = new Scanner(System.in);
        Scanner inputAmount = new Scanner(System.in);
        displayMenu();
        do {
            System.out.println("Selection: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Your account balance is: $" + balance);
                    System.out.println("=====================================");
                    break;
                case 2:
                    System.out.println("Enter an amount to deposit: $");
                    int amount1 = inputAmount.nextInt();
                    Deposit(amount1);
                    System.out.println("=====================================");
                    break;
                case 3:
                    System.out.println("Enter an amount to withdraw: $");
                    int amount2 = inputAmount.nextInt();
                    Withdraw(amount2);
                    System.out.println("=====================================");
                    break;
                case 4:
                    System.out.println();
                    previousTransaction();
                    System.out.println("=====================================");
                    break;
                case 5:
                    System.out.println("Enter how many years of accrued years: ");
                    int yrs = inputAmount.nextInt();
                    calculateInterest(yrs);
                    System.out.println("=====================================");
                    break;
                case 6:
                    System.out.println("=====================================");
                    break;
                default:
                    System.out.println("Error: invalid option. please enter 1, 2, 3, 4, 5, 6 .");
                    break;
            }
        }while (option != 6);
                System.out.println("Thank you for banking with us!");
                System.out.println("=====================================");
            }
        }


