package Vol6Var11;

import java.util.Currency;

public class SavingsAccount implements BankDeposit {
    private String duration;
    private String depositType;
    private double principalAmount;
    private double interestRate;
    private Currency currency;

    public SavingsAccount(String duration, String depositType, double principalAmount, double interestRate, Currency currency) {
        this.duration = duration;
        this.depositType = depositType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.currency = currency;
    }

    @Override
    public void changeDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String getDepositType() {
        return this.depositType;
    }

    @Override
    public void closeAndReopen(String newCurrency) {

        System.out.println("Закрытие текущегог депозита в  " + this.currency.getCurrencyCode());
        this.currency = Currency.getInstance(newCurrency);
        System.out.println("Открытие нового депозита в " + this.currency.getCurrencyCode());

    }

    @Override
    public double calculateInterest() {
        return principalAmount * (interestRate / 100);
    }

    // Геттер для duration
    public String getDuration() {
        return duration;
    }

    public Currency getCurrency() {
        return currency;
    }

    // Дополнительный метод для отображения информации о вкладе
    public void displayInfo() {

        System.out.println("Продолжительность: " + duration);
        System.out.println("Тип депозита: " + depositType);
        System.out.println("Основная сумма: " + principalAmount);
        System.out.println("Процент прибыли: " + interestRate + "%");
        System.out.println("Валюта: " + currency.getCurrencyCode());
    }
}
