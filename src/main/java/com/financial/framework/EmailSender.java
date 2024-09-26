package com.financial.framework;

import com.financial.framework.observer.Observer;

public class EmailSender implements Observer {
    public void update(String message) {
        System.out.println("Email sender:" + message);
    }
}
