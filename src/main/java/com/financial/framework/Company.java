package com.financial.framework;

import com.financial.framework.builder.CompanyBuilder;

public class Company extends Customer {
    private int noOfEmployees;

    public Company(CompanyBuilder builder) {
        super(builder);
        noOfEmployees = builder.getNoOfEmployees();
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    @Override
    public String getType() {
        return "Company";
    }
}
