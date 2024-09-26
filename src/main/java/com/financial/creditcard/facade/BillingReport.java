package com.financial.creditcard.facade;

public interface BillingReport {
    double getBalance();
    double getChargeDue();
    double getTotalCharges();
    double getTotalCredits();
    double getPreviousBalance();
}
