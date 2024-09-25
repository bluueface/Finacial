package com.financial.banking;

public interface Command {
    void execute();
    void undo();
}
