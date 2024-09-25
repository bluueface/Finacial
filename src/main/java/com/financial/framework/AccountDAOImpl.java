package com.financial.framework;


import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOImpl implements AccountDAO {
    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account isAccountExist = loadAccount(account.getAccountNumber());
        if (isAccountExist != null) {
            accountlist.remove(isAccountExist); // remove the old
            accountlist.add(account); // add the new
        }

    }

    public Account loadAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountlist;
    }

}
