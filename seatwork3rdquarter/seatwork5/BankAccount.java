abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001b[1m";
    public static final String GREEN = "\u001b[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String BG_GRAY = "\u001B[47m\u001B[30m";
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public abstract void calculateInterest();

    public double getBalance() {
        return balance;
    }


    protected void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

 
    protected void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public void displayAccountInfo() {
        System.out.println(BG_GRAY + " ACCOUNT ID: " + accountNumber + " " + RESET);
        System.out.println(BLUE + "Current Balance: $" + String.format("%.2f", balance) + RESET);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate = 0.05;
    
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println(GREEN + BOLD + "Savings Interest Added: $" + String.format("%.2f", interest) + RESET);
    }
}

class CheckingAccount extends BankAccount {
    private double fee = 2.50;
    
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    public void calculateInterest() {
        
        withdraw(fee); 
        System.out.println(RED + "Checking accounts do not earn interest.");
        System.out.println("Processing fee of $" + fee + " deducted." + RESET);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount mySavings = new SavingsAccount("SAV-9910", 1067.00);
        BankAccount myChecking = new CheckingAccount("CHK-4452", 500.00);
        
        System.out.println("\n" + BankAccount.BOLD + "--- BANKING SYSTEM DASHBOARD ---" + BankAccount.RESET);
      
        mySavings.displayAccountInfo();
        mySavings.calculateInterest();
        System.out.println("Updated Savings: $" + String.format("%.2f", mySavings.getBalance()));
        System.out.println(); 

        myChecking.displayAccountInfo();
        myChecking.calculateInterest();
        System.out.println("Updated Checking: $" + String.format("%.2f", myChecking.getBalance()));
        
        System.out.println("\n" + BankAccount.BOLD + "Transaction Complete." + BankAccount.RESET); 
    }
} 
