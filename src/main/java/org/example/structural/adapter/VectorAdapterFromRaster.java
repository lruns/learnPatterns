package org.example.structural.adapter;

record Point(int x, int y) {}

interface VectorGraphics {
    void drawLine(Point start, Point end);
    void drawSquare(Point origin, int size);
}

class RasterGraphics {
    private final int SIZE = 10;
    int[][] space = new int[SIZE][SIZE];

    public RasterGraphics() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                space[i][j] = 0;
            }
        }
    }

    public void drawPoint(Point p) {
        space[p.x()][p.y()] = 1;
    }
}

public class VectorAdapterFromRaster implements VectorGraphics {

    final RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawLine(Point start, Point end) {
        int startX = start.x(), endX = end.x();
        int startY = start.y(), endY = end.y();
        boolean xDirection = startX < endX;
        boolean yDirection = startY < endY;
        int distanceX = Math.abs(startX - endX);
        int distanceY = Math.abs(startY - endY);

        for (int i = 0; i <= distanceX; i++) {
            for (int j = 0; j <= distanceY; j++) {
                raster.drawPoint(new Point(
                        xDirection ? startX + i : startX - i,
                        yDirection ? startY + j : startY - j));
            }
        }
    }

    @Override
    public void drawSquare(Point origin, int size) {
        Point point1 = new Point(origin.x() + size, origin.y());
        Point point2 = new Point(origin.x() + size, origin.y() + size);
        Point point3 = new Point(origin.x(), origin.y() + size);

        drawLine(origin, point1);
        drawLine(point1, point2);
        drawLine(point2, point3);
        drawLine(point3, origin);
    }
}