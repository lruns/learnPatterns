package org.example.creational.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShapeTest {

    Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(1);
        rectangle.setY(2);
        rectangle.setColor("green");
        rectangle.setWidth(10);
        rectangle.setHeight(10);
        return rectangle;
    }

    Circle createCircle() {
        Circle circle = new Circle();
        circle.setX(1);
        circle.setY(2);
        circle.setColor("green");
        circle.setRadius(5);

        return circle;
    }

    @Test
    @DisplayName("Test, that cloning (prototyping) is work")
    public void testPrototyping() {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(createRectangle());
        shapes.add(createCircle());

        List<Shape> clonedShapes = shapes.stream().map(Shape::clone).toList();

        assertThat(shapes).usingDefaultComparator().isEqualTo(clonedShapes);

        clonedShapes.get(0).setColor("red");
        Shape shape = clonedShapes.get(1);
        if (shape instanceof Circle) {
            ((Circle) shape).setRadius(30);
        }

        assertThat(shapes).usingDefaultComparator().isNotEqualTo(clonedShapes);
    }
}
