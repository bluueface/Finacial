package com.financial.banking;

import com.financial.framework.Account;

public class AddInterestCommand implements Command {
    private Account account;
    private double interestRate;
    public AddInterestCommand(Account account, double interestRate) {
        this.account = account;
        this.interestRate = interestRate;
    }
    @Override
    public void execute() {
        double interest = account.getBalance() * interestRate;
        account.deposit(interest);
        System.out.println("Added interest: " + interest);
    }

    @Override
    public void undo() {
        double interest = account.getBalance() * interestRate;
        account.withdraw(interest);  // Undo interest addition by withdrawing the same amount
        System.out.println("Undid interest addition of: " + interest);
    }
}
