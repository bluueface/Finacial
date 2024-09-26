package com.financial.banking.command;

public interface Command {
    void execute();
    void undo();
}
