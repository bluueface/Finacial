package com.financial.framework;

public class EmailSender implements Observer{
    public void update(String message) {
        System.out.println("Email sender:" + message);
    }
}
