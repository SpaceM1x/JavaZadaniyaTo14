package Vol6Var11;

public interface BankDeposit {
    void changeDuration(String duration);
    String getDepositType();
    void closeAndReopen(String newCurrency);
    double calculateInterest();
}
