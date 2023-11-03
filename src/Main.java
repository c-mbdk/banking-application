import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userBank = new BankAccount(0.00);

        System.out.print("Welcome! What's your name? ");
        String userName = scanner.nextLine();
        System.out.println(userName + ", how may I help you today?");
        String requestedAction = BankAccount.bankActions().toLowerCase(Locale.ROOT);

        while (!requestedAction.equals("exit")) {
            switch (requestedAction) {
                case "view my bank balance" -> {
                    System.out.println(userBank.getBankBalance());
                    requestedAction = BankAccount.bankActions().toLowerCase(Locale.ROOT);
                }
                case "deposit money" -> {
                    System.out.print("How much would you like to deposit? ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(userBank.depositMoney(depositAmount));
                    requestedAction = BankAccount.bankActions().toLowerCase(Locale.ROOT);
                }
                case "withdraw money" -> {
                    System.out.print("How much would you like to withdraw? ");
                    double withdrawalAmount = scanner.nextDouble();
                    String sufficientFunds = userBank.checkSufficientFunds(withdrawalAmount);
                    if (sufficientFunds.equals("insufficient funds")) {
                        System.out.println("You do not have sufficient funds to complete this action.");
                    } else {
                        System.out.println(userBank.withdrawMoney(withdrawalAmount));
                    }
                    requestedAction = BankAccount.bankActions().toLowerCase(Locale.ROOT);
                }

        } System.out.println("Bye " +userName+ ". Have a nice day!");
        System.exit(0);
    }
}
}