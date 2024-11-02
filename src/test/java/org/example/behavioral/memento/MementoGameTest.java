package org.example.behavioral.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MementoGameTest {

    @Test
    public void testMementoGame() {
        MementoGame game = new MementoGame();
        game.move(5);
        game.levelUp();

        GameSaver gameSaver = new GameSaver(game);
        gameSaver.save();

        assertEquals(5, game.getState().getPositionX());

        game.move(10);
        gameSaver.restore();
        assertEquals(5, game.getState().getPositionX());
    }
}
