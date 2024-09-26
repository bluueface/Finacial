package com.financial.framework;

public class Logger implements Observer{
    public void update(String message) {
        System.out.println("Logger here:" + message);
    }
}
