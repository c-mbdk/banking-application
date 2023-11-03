import java.text.NumberFormat;
import java.util.Scanner;

public class BankAccount {
    private double rawBankBalance;
    private String bankBalance;

//    Constructor
    public BankAccount(double rawBankBalance) {
        this.rawBankBalance = rawBankBalance;
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

    public static String bankActions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select one action: " +
                "View my bank balance/Withdraw money/Deposit money/Exit: ");
        return scanner.nextLine();
    }
}
