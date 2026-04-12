import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> history = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        System.out.println("=== Task 6: Array of Accounts ===");
        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount("B-01", "Aibek", 100000);
        arr[1] = new BankAccount("B-02", "Arsen", 120000);
        arr[2] = new BankAccount("B-03", "Nurzhan", 90000);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Account Number: " + arr[i].accountNumber +
                    ", Username: " + arr[i].username +
                    ", Balance: " + arr[i].balance);
        }
        System.out.println("================================");

        accounts.add(new BankAccount("A-01", "Ali", 150000));
        accounts.add(new BankAccount("A-02", "Aibek", 220000));

        int mainChoice = -1;

        while (mainChoice != 4) {
            System.out.println("\n===== MINI BANKING MENU =====");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");



            mainChoice = sc.nextInt();
            sc.nextLine();

            if (mainChoice == 1) {
                int bankChoice = -1;

                while (bankChoice != 0) {
                    System.out.println("\n--- BANK MENU ---");
                    System.out.println("1 - Add new account");
                    System.out.println("2 - Display all accounts");
                    System.out.println("3 - Search by username");
                    System.out.println("4 - Deposit money");
                    System.out.println("5 - Withdraw money");
                    System.out.println("6 - Add bill payment");
                    System.out.println("7 - Show last transaction");
                    System.out.println("8 - Undo last transaction");
                    System.out.println("9 - Submit account request");
                    System.out.println("0 - Back");
                    System.out.print("Choose: ");



                    bankChoice = sc.nextInt();
                    sc.nextLine();

                    if (bankChoice == 1) {
                        System.out.print("Enter account number: ");
                        String accountNumber = sc.nextLine();

                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter balance: ");
                        double balance = sc.nextDouble();
                        sc.nextLine();

                        BankAccount newAccount = new BankAccount(accountNumber, username, balance);
                        accounts.add(newAccount);

                        System.out.println("Account added successfully");

                    } else if (bankChoice == 2) {
                        if (accounts.size() == 0) {
                            System.out.println("No accounts found");
                        } else {
                            System.out.println("Accounts List:");
                            for (int i = 0; i < accounts.size(); i++) {
                                BankAccount acc = accounts.get(i);
                                System.out.println((i + 1) + ". " + acc.username + " - Balance: " + acc.balance);
                            }
                        }

                    } else if (bankChoice == 3) {
                        System.out.print("Enter username: ");
                        String searchName = sc.nextLine();

                        boolean found = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            BankAccount acc = accounts.get(i);

                            if (acc.username.equalsIgnoreCase(searchName)) {
                                System.out.println("Account found:");
                                System.out.println("Account Number: " + acc.accountNumber);
                                System.out.println("Username: " + acc.username);
                                System.out.println("Balance: " + acc.balance);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Account not found");
                        }

                    } else if (bankChoice == 4) {
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        boolean found = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            BankAccount acc = accounts.get(i);

                            if (acc.username.equalsIgnoreCase(username)) {
                                acc.deposit(amount);
                                history.push("Deposit " + amount + " to " + username);
                                System.out.println("New balance: " + acc.balance);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Account not found");
                        }

                    } else if (bankChoice == 5) {
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter withdraw amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        boolean found = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            BankAccount acc = accounts.get(i);

                            if (acc.username.equalsIgnoreCase(username)) {
                                boolean ok = acc.withdraw(amount);

                                if (ok) {
                                    history.push("Withdraw " + amount + " from " + username);
                                    System.out.println("New balance: " + acc.balance);
                                } else {
                                    System.out.println("Not enough balance");
                                }

                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account not found");
                        }

                    } else if (bankChoice == 6) {
                        System.out.print("Enter bill name: ");
                        String billName = sc.nextLine();

                        history.push("Bill payment: " + billName);
                        billQueue.add(billName);

                        System.out.println("Bill added to history and queue");

                    } else if (bankChoice == 7) {
                        if (history.isEmpty()) {
                            System.out.println("No transactions yet");
                        } else {
                            System.out.println("Last transaction: " + history.peek());
                        }

                    } else if (bankChoice == 8) {
                        if (history.isEmpty()) {
                            System.out.println("No transaction to undo");
                        } else {
                            System.out.println("Undo -> " + history.pop() + " removed");
                        }

                    } else if (bankChoice == 9) {
                        System.out.print("Enter account number: ");
                        String accountNumber = sc.nextLine();

                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter initial balance: ");
                        double balance = sc.nextDouble();
                        sc.nextLine();

                        BankAccount request = new BankAccount(accountNumber, username, balance);
                        accountRequests.add(request);

                        System.out.println("Account request submitted");

                    } else if (bankChoice == 0) {
                        System.out.println("Back to main menu");

                    } else {
                        System.out.println("Wrong choice");
                    }
                }

            } else if (mainChoice == 2) {
                int atmChoice = -1;

                while (atmChoice != 0) {
                    System.out.println("\n--- ATM MENU ---");
                    System.out.println("1 - Balance enquiry");
                    System.out.println("2 - Withdraw");
                    System.out.println("0 - Back");
                    System.out.print("Choose: ");


                    atmChoice = sc.nextInt();
                    sc.nextLine();

                    if (atmChoice == 1) {
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        boolean found = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            BankAccount acc = accounts.get(i);

                            if (acc.username.equalsIgnoreCase(username)) {
                                System.out.println("Balance: " + acc.balance);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Account not found");
                        }

                    } else if (atmChoice == 2) {
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter withdraw amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        boolean found = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            BankAccount acc = accounts.get(i);

                            if (acc.username.equalsIgnoreCase(username)) {
                                boolean ok = acc.withdraw(amount);

                                if (ok) {
                                    System.out.println("New balance: " + acc.balance);
                                } else {
                                    System.out.println("Not enough balance");
                                }

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Account not found");
                        }

                    } else if (atmChoice == 0) {
                        System.out.println("Back to main menu");

                    } else {
                        System.out.println("Wrong choice");
                    }
                }

            } else if (mainChoice == 3) {
                int adminChoice = -1;

                while (adminChoice != 0) {
                    System.out.println("\n--- ADMIN MENU ---");
                    System.out.println("1 - View account requests");
                    System.out.println("2 - Process account request");
                    System.out.println("3 - View bill queue");
                    System.out.println("4 - Process next bill");
                    System.out.println("0 - Back");
                    System.out.print("Choose: ");


                    adminChoice = sc.nextInt();
                    sc.nextLine();

                    if (adminChoice == 1) {
                        if (accountRequests.isEmpty()) {
                            System.out.println("No pending requests");
                        } else {
                            System.out.println("Pending account requests:");
                            for (BankAccount acc : accountRequests) {
                                System.out.println("Username: " + acc.username +
                                        ", Account Number: " + acc.accountNumber +
                                        ", Balance: " + acc.balance);
                            }
                        }

                    } else if (adminChoice == 2) {
                        if (accountRequests.isEmpty()) {
                            System.out.println("No pending requests");
                        } else {
                            BankAccount approved = accountRequests.poll();
                            accounts.add(approved);
                            System.out.println("Account request approved: " + approved.username);
                        }

                    } else if (adminChoice == 3) {
                        if (billQueue.isEmpty()) {
                            System.out.println("Queue is empty");
                        } else {
                            System.out.println("Bills in queue:");
                            for (String bill : billQueue) {
                                System.out.println(bill);
                            }
                        }

                    } else if (adminChoice == 4) {
                        if (billQueue.isEmpty()) {
                            System.out.println("No bills in queue");
                        } else {
                            String bill = billQueue.poll();
                            System.out.println("Processing: " + bill);
                        }

                    } else if (adminChoice == 0) {
                        System.out.println("Back to main menu");

                    } else {
                        System.out.println("Wrong choice");
                    }
                }

            } else if (mainChoice == 4) {
                System.out.println("Exiting program...");

            } else {
                System.out.println("Wrong choice");
            }
        }

        sc.close();
    }
}