package com.financial.banking.command;

import com.financial.framework.Account;

public class DepositCommand implements Command {
    private Account account;
    private double amount;
    public DepositCommand(Account account, double amount) {
        this.account = account;
    }
    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void undo() {
        account.withdraw(amount);
        System.out.println("Withdrawn: " + amount);
    }
}
