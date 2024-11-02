package org.example.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;


@AllArgsConstructor
@Getter
@Setter
class State implements Cloneable {
    private int level;
    private int positionX;

    @Override
    public State clone() {
        try {
            return (State) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

// originator
@Getter
public class MementoGame {
    private State state;

    public MementoGame() {
        state = new State(1, 0);
    }

    public void levelUp() {
        state.setLevel(state.getLevel() + 1);
    }

    public void move(int distance) {
        state.setPositionX(state.getPositionX() + distance);
    }

    public Save save() {
        return new Save(state.clone());
    }

    public void restore(Save save) {
        this.state = save.state.clone();
    }

    // memento
    record Save(State state) {
    }
}


// caretaker
class GameSaver {
    private final MementoGame game;
    private final Stack<MementoGame.Save> saves = new Stack<>();

    public GameSaver(MementoGame game) {
        this.game = game;
    }

    public void save() {
        MementoGame.Save save = game.save();
        saves.push(save);
    }

    public void restore() {
        MementoGame.Save lastSave = saves.pop();
        game.restore(lastSave);
    }
}