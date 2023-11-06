import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your 'Name' and 'CustomerID' to access your bank account.");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("CustomerID: ");
        String customerId = scanner.nextLine();
        BankAccount userBank = new BankAccount(0.00, name, customerId);
        System.out.print("\n");
        System.out.println(userBank.customerName + ", what would you like to do today?");
        char requestedAction = BankAccount.bankActions();

        do {
            switch (requestedAction) {
                case 'a' -> {
                    System.out.println(userBank.getBankBalance());
                    System.out.print("\n");
                    requestedAction = Character.toLowerCase(BankAccount.bankActions());
                }
                case 'b' -> {
                    System.out.print("How much would you like to deposit? ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(userBank.depositMoney(depositAmount));
                    System.out.print("\n");
                    requestedAction = Character.toLowerCase(BankAccount.bankActions());
                }
                case 'c' -> {
                    System.out.print("How much would you like to withdraw? ");
                    double withdrawalAmount = scanner.nextDouble();
                    String sufficientFunds = userBank.checkSufficientFunds(withdrawalAmount);
                    if (sufficientFunds.equals("insufficient funds")) {
                        System.out.println("You do not have sufficient funds to complete this action.");
                    } else {
                        System.out.println(userBank.withdrawMoney(withdrawalAmount));
                    }
                    System.out.print("\n");
                    requestedAction = Character.toLowerCase(BankAccount.bankActions());
                }

        }



    }
    while (!(requestedAction == 'd'));

    System.out.println("Bye " +userBank.customerName+ ". Have a nice day!");
    System.exit(0);
}
}