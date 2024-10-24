package org.example.other.delegation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PainterTest {

    private final static Painter painter = new Painter();

    @ParameterizedTest
    @MethodSource("provideGraphicsAndFigure")
    public void checkDrawing(Graphics graphic, Figure figure) {
        painter.setGraphics(graphic);
        assertEquals(painter.draw(), figure);
    }

    private static Stream<Arguments> provideGraphicsAndFigure() {
        return Stream.of(
                Arguments.of(new Circle(), Figure.CIRCLE),
                Arguments.of(new Square(), Figure.SQUARE),
                Arguments.of(new Triangle(), Figure.TRIANGLE)
        );
    }

}
