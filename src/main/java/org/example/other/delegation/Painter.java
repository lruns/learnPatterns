package org.example.other.delegation;

public class Painter {

    Graphics graphics;

    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    Figure draw() {
        return graphics.draw();
    }
}
