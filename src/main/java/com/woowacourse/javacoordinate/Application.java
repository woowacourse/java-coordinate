package com.woowacourse.javacoordinate;

import com.woowacourse.javacoordinate.domain.*;
import com.woowacourse.javacoordinate.view.InputView;
import com.woowacourse.javacoordinate.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String TYPE_OF_LINE = "Line";
    private static final String TYPE_OF_TRIANGLE = "Triangle";
    private static final String TYPE_OF_RECTANGLE = "Rectangle";

    public static void main(String[] args) {
        while (true) {
            Points points = InputView.inputCoordinatePoints();
            Figure figure = makeShape(points);
            CoordinateSystem coordinateSystem = drawCoordinate(points);

            OutputView.printCoordinateSystem(coordinateSystem);
            OutputView.printResult(calculate(figure));
        }
    }

    private static Figure makeShape(Points points) {
        int size = points.getSize();

        if (size == Line.LINE_POINT_NUMBER) {
            return new Line(points);
        }
        if (size == Triangle.TRIANGLE_POINT_NUMBER) {
            return new Triangle(points);
        }
        if (size == Rectangle.RECTANGLE_POINT_NUMBER) {
            return new Rectangle(points);
        }
        throw new IllegalArgumentException("Points 형식이 잘못 되었습니다");
    }

    private static CoordinateSystem drawCoordinate(Points points) {
        List<CoordinateLine> coordinateLines = new ArrayList<>();

        for (int yAxis = Point.MIN_BOUNDARY; yAxis <= Point.MAX_BOUNDARY; yAxis++) {
            coordinateLines.add(createLine(points, yAxis));
        }

        return new CoordinateSystem(coordinateLines);
    }

    private static CoordinateLine createLine(Points points, int yAxis) {
        Boolean[] line = initLine();

        for (int i = 0; i < points.getSize(); i++) {
            Point point = points.getPoints().get(i);
            int x = point.getX();
            int y = point.getY();
            checkMark(yAxis, line, x, y);
        }

        return new CoordinateLine(Arrays.asList(line));
    }

    private static Boolean[] initLine() {
        Boolean[] line = new Boolean[25];
        for (int i = 0; i < line.length; i++) {
            line[i] = false;
        }
        return line;
    }

    private static void checkMark(int yAxis, Boolean[] line, int x, int y) {
        if (yAxis == y) {
            line[x] = true;
        }
    }

    private static Result calculate(Figure figure) {
        if (figure instanceof Line) {
            return calculateLine(figure);
        }
        if (figure instanceof Triangle) {
            return calculateTriangle(figure);
        }
        if (figure instanceof Rectangle) {
            return calculateRectangle(figure);
        }
        throw new IllegalArgumentException("Points 형식이 잘못 되었습니다");
    }

    private static Result calculateLine(Figure figure) {
        double result = figure.calculateLength();

        return new Result(result, TYPE_OF_LINE);
    }

    private static Result calculateTriangle(Figure figure) {
        double result = figure.calculateArea();

        return new Result(result, TYPE_OF_TRIANGLE);
    }

    private static Result calculateRectangle(Figure figure) {
        double result = figure.calculateArea();

        return new Result(result, TYPE_OF_RECTANGLE);
    }
}
