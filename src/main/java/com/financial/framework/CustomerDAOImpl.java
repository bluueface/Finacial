package com.financial.framework;

import com.financial.framework.facade.CustomerDAO;

import java.util.*;

public class CustomerDAOImpl implements CustomerDAO {
    private final Map<Customer, Set<Account>> customers = new HashMap<>();
    Collection<Customer> customerList = new ArrayList<>();

    @Override
    public void saveCustomer(Account account) {
        Customer customer = account.getCustomer();
        customer.addAccount(account);
        customerList.add(customer); // add the new
    }

    @Override
    public void updateCustomer(Customer customer) {
//        Account accountExists = loadAccount(account.getAccountNumber());
//        if (accountExists != null) {
//            customerList.remove(accountExists); // remove the old
//            customerList.add(account); // add the new
//        }
    }

    public Customer loadAccount(String accountNumber) {
        Optional<Customer> customer = customers.keySet().stream()
                .filter(Customer::match)
                .limit(1
                ).findFirst();
        return customer.orElse(null);
    }

    public Collection<Customer> getCustomers() {
        return customerList;
    }

}
