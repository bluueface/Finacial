package com.financial.framework.observer;

public interface Subject {
    void notifyObservers(String message);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
