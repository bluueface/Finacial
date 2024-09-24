package com.financial.banking;

import com.financial.framework.AccountService;
import com.financial.framework.CompanyAccountFactory;
import com.financial.framework.PersonAccountFactory;

import java.util.Objects;

public class BankingService implements AccountService {
    @Override
    public Account createAccount(String accountNumber, Customer customer, String type) {
        if (Objects.equals(type, "Person")) {
            return new PersonAccountFactory().createAccount(accountNumber, customer);
        } else if (Objects.equals(type, "Company")) {
            new CompanyAccountFactory().createAccount(accountNumber, customer);
        }
        return null;
    }
}
