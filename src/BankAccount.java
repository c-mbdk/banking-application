import java.text.NumberFormat;
import java.util.Scanner;

public class BankAccount {
    private double rawBankBalance;
    private String bankBalance;
    public String customerName;
    private String customerId;

//    Constructor
    public BankAccount(double rawBankBalance, String customerName, String customerId) {
        this.rawBankBalance = rawBankBalance;
        this.customerName = customerName;
        this.customerId = customerId;
        transformRawBankBalance();
    }

    //    produces the formatted version of bank balance (includes currency)
    private void transformRawBankBalance() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        this.bankBalance = currency.format(this.rawBankBalance);
    }

//    formatted version of bank balance for viewing (includes currency)
    public String getBankBalance() {
        return "Current bank balance: " + bankBalance;
    }

    public String depositMoney(double amount) {
        this.rawBankBalance += amount;
        transformRawBankBalance();
        return getBankBalance();
    }

    public String withdrawMoney(double amount) {
        this.rawBankBalance -= amount;
        transformRawBankBalance();
        return getBankBalance();
    }

    public String checkSufficientFunds(double amount) {
        if (amount > this.rawBankBalance)
            return "insufficient funds";
        else
            return "sufficient funds";
    }

    public static char bankActions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("Menu");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit money");
        System.out.println("c) Withdraw money");
        System.out.println("d) Exit");
        System.out.print("Please select one option (a/b/c/d): ");
        return scanner.next().charAt(0);
    }
}
