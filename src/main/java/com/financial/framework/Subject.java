package com.financial.framework;

public interface Subject {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
