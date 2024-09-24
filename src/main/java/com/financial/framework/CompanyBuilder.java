package com.financial.framework;

public class CompanyBuilder extends Builder {
    private int noOfEmployees;

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public CompanyBuilder setNoOfEmployees(int name) {
        this.noOfEmployees = name;
        return this;
    }
}
