package org.example.behavioral.command;


// Тоже Invokerы
abstract class Interactive {
    Runnable someCommand;

    public void addListener(Runnable someCommand) {
        this.someCommand = someCommand;
    }
}

public class Button extends Interactive {
    public void click() {
        someCommand.run();
    }
}

class Shortcut extends Interactive {
    public void press() {
        someCommand.run();
    }
}
