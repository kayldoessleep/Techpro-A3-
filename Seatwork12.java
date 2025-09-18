import java.util.Scanner;

public class Seatwork12 {

    public static void checkBalance(int[] balances, int accountNumber) {
        System.out.println("Your current balance is: " + balances[accountNumber]);
    }

    public static void deposit(int[] balances, int accountNumber, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Try again.");
            return;
        }
        balances[accountNumber] += amount;
        System.out.println("Deposit successful! New balance: " + balances[accountNumber]);
    }

    public static void withdraw(int[] balances, int accountNumber, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount walamg pera. Try again.");
            return;
        }
        if (amount > balances[accountNumber]) {
            System.out.println("Insufficient funds hampas lupa! Transaction cancelled.");
            return;
        }
        balances[accountNumber] -= amount;
        System.out.println("Withdrawal successful! New balance: " + balances[accountNumber]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] balances = {10000, 20000, 30000};

        System.out.println("=== Welcome to Pepe Banking System ===");
        System.out.print("Enter account number (0, 1, or 2): ");
        int accountNumber = scanner.nextInt();

        if (accountNumber < 0 || accountNumber >= balances.length) {
            System.out.println("Invalid account number. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(balances, accountNumber);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    deposit(balances, accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(balances, accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            if (choice == 4) {
                break;
            }
        }
    }
}
