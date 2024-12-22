package Vol6Var11Test;

import Vol6Var11.SavingsAccount;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Currency;

public class SavingsAccountTest {

    @Test
    public void testChangeDuration() {

        SavingsAccount account = new SavingsAccount("Продолжительный", "Отзывной", 1000.0, 5.0, Currency.getInstance("USD"));
        account.changeDuration("Кратковременный");
        assertEquals("Кратковременный", account.getDuration());

    }

    @Test
    public void testGetDepositType() {


        SavingsAccount account = new SavingsAccount("Продолжительный", "Неотзывной", 1000.0, 5.0, Currency.getInstance("USD"));
        assertEquals("Неотзывной", account.getDepositType());

    }

    @Test
    public void testCloseAndReopen() {

        SavingsAccount account = new SavingsAccount("Продолжительный", "Отзывной", 1000.0, 5.0, Currency.getInstance("USD"));

        account.closeAndReopen("EUR");
        assertEquals("EUR", account.getCurrency().getCurrencyCode());
    }

    @Test
    public void testCalculateInterest() {

        SavingsAccount account = new SavingsAccount("Продолжительный", "Отзывной", 1000.0, 5.0, Currency.getInstance("USD"));
        assertEquals(50.0, account.calculateInterest());
    }
}
