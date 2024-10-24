package org.example.other.delegation;

public interface Graphics {
    Figure draw();
}

class Triangle implements Graphics {

    @Override
    public Figure draw() {
        return Figure.TRIANGLE;
    }
}

class Square implements Graphics {
    @Override
    public Figure draw() {
        return Figure.SQUARE;
    }
}


class Circle implements Graphics {
    @Override
    public Figure draw() {
        return Figure.CIRCLE;
    }
}

