package org.example.behavioral.command;

import lombok.AllArgsConstructor;

import java.util.Stack;

// Receiver
public class Editor {
    String text;
    String clipboard;

    public Editor(String text) {
        this.text = text;
    }
}


@AllArgsConstructor
class CommandHistoryFacade {
    private CommandHistory history;

    void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}

// Invoker
class CommandHistory {
    Stack<Command> history = new Stack<>();

    public void push(Command command) {
        history.push(command);
    }
    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}

abstract class Command {

    public Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.text;
    }

    void undo() {
        editor.text = backup;
    }

    abstract boolean execute();
}

class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    boolean execute() {
        editor.clipboard = editor.text;
        return false;
    }
}

class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    boolean execute() {
        backup();
        editor.text += editor.clipboard;
        return true;
    }
}