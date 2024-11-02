package org.example.behavioral.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorTest {

    private CommandHistoryFacade history;
    private Editor editor;

    @Test
    void test() {
        history = new CommandHistoryFacade(new CommandHistory());
        editor = new Editor("Some text; ");

        Runnable copy = () -> history.executeCommand(new CopyCommand(editor));
        Runnable paste = () -> history.executeCommand(new PasteCommand(editor));

        Button copyButton = new Button();
        Button pasteButton = new Button();

        Shortcut copyShortcut = new Shortcut();
        Shortcut pasteShortcut = new Shortcut();

        copyButton.addListener(copy);
        copyShortcut.addListener(copy);
        pasteButton.addListener(paste);
        pasteShortcut.addListener(paste);

        copyButton.click();
        pasteShortcut.press();
        pasteButton.click();
        pasteShortcut.press();
        copyShortcut.press();
        copyShortcut.press();
        copyShortcut.press();
        history.undo();
        history.undo();

        assertEquals("Some text; Some text; Some text; Some text; ", editor.clipboard);
        assertEquals("Some text; Some text; ", editor.text);
    }
}
