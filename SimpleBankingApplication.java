import java.util.Scanner;

public class SimpleBankingApplication {

    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    makeDeposit(scanner);
                    break;
                case 3:
                    makeWithdrawal(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nSimple Banking Application");
        System.out.println("1. Check Balance");
        System.out.println("2. Make a Deposit");
        System.out.println("3. Make a Withdrawal");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    private static void makeDeposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("You have successfully deposited $%.2f. Your new balance is $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void makeWithdrawal(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have successfully withdrawn $%.2f. Your new balance is $%.2f\n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please enter an amount less than or equal to your current balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}
