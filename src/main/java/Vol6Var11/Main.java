package Vol6Var11;

import java.util.Currency;

public class Main {
    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount(
                "Продолжительный",
                "Отзывной",
                1000.0,
                5.0,
                Currency.getInstance("USD")
        );

        account.displayInfo();

        account.changeDuration("Кратковременный");
        System.out.println("\nПосле изменения продолжительности:");
        account.displayInfo();

        System.out.println("\nТип депозита: " + account.getDepositType());


        double interest = account.calculateInterest();
        System.out.println("\nРассчитанный процент: " + interest);


        account.closeAndReopen("EUR");
        account.displayInfo();
    }
}
