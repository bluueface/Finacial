package com.financial.framework;

import com.financial.banking.*;

public class AccountFactory {
    public Account createPersonalAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new PersonalAccount(accountNumber, person);
    }

    public Account createSavingsAccount(String accountNum, CompanyBuilder builder) {
        Company company = new Company(builder);
        return new SavingsAccount(accountNum, company);
    }

    public Account createCheckingAccount(String accountNum, CompanyBuilder builder) {
        Company company = new Company(builder);
        return new CheckingAccount(accountNum, company);
    }
}
