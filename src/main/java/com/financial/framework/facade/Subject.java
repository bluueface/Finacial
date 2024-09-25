package com.financial.framework.facade;

import com.financial.framework.observer.Observer;

public interface Subject {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
