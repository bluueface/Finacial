package com.financial.framework.facade;

public interface Subject {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
