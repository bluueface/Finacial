package com.financial.framework.observer;

public interface Subject {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
