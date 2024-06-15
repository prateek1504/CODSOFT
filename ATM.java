import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
public class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void showMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void performWithdrawal(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Unable to process withdrawal.");
        }
    }
    public void performDeposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }
    public void displayBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Starting balance for the account
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        do {
            atm.showMenu();
            System.out.print("Please select an option: ");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double amountToWithdraw = scanner.nextDouble();
                    atm.performWithdrawal(amountToWithdraw);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double amountToDeposit = scanner.nextDouble();
                    atm.performDeposit(amountToDeposit);
                    break;
                case 3:
                    atm.displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (userChoice != 4);
        scanner.close();
    }
}
