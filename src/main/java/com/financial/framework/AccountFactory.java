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

    public Account createAccount(AccountType type, String accountNum, Builder builder) {
        Account account = null;
        switch (type) {
            case CHECKING:
                account = createCheckingAccount(accountNum, (CompanyBuilder) builder);
                break;
            case SAVINGS:
                account = createSavingsAccount(accountNum, (CompanyBuilder) builder);
                break;
            case PERSONAL:
                account = createPersonalAccount(accountNum, (PersonBuilder) builder);
                break;
        }
        return account;
    }
}
