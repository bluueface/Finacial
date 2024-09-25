package com.financial.banking;

import com.financial.framework.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {
    private Command command;
    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private List<Observer> observers = new ArrayList<>();

    public CommandManager(Command command) {
        this.command = command;
    }
    public void executeCommand(){
        command.execute();
    }
    public void undoCommand(){
        commandHistory.pop();
        redoStack.pop();
    }
    public void redoCommand(){
        redoStack.push(command);
    }
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
