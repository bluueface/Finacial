package com.financial.framework.factory;

import com.financial.framework.*;
import com.financial.framework.builder.CompanyBuilder;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.strategy.AccountStrategy;
import com.financial.framework.strategy.CheckingAccountStrategy;
import com.financial.framework.strategy.PersonalAccountStrategy;
import com.financial.framework.strategy.SavingsAccountStrategy;

public class AccountFactory {
    public Account createPersonalAccount(String accountNo, PersonBuilder builder) {
        Person person = new Person(builder);
        AccountStrategy strategy = new PersonalAccountStrategy();
        return new Account(accountNo, person, strategy);
    }

    public Account createSavingsAccount(String accountNo, CompanyBuilder builder) {
        Company company = new Company(builder);
        AccountStrategy strategy = new SavingsAccountStrategy();
        return new Account(accountNo, company, strategy);
    }

    public Account createCheckingAccount(String accountNo, CompanyBuilder builder) {
        Company company = new Company(builder);
        AccountStrategy strategy = new CheckingAccountStrategy();
        return new Account(accountNo, company, strategy);
    }
}
