package com.financial.framework.observer;

public interface Subject {
    void notifyObservers(String msg);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
