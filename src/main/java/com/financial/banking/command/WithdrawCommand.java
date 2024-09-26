package com.financial.banking.command;

import com.financial.framework.Account;

public class WithdrawCommand implements Command {
    private Account account;
    private double amount;
    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void execute() {
        account.withdraw(amount);
        System.out.println("Withdrew: " + amount);
    }

    @Override
    public void undo() {
        account.deposit(amount);
        System.out.println("Undid withdrawal of: " + amount);
    }
}
