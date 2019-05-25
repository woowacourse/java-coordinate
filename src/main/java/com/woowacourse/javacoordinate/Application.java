package com.woowacourse.javacoordinate;

import com.woowacourse.javacoordinate.domain.*;
import com.woowacourse.javacoordinate.view.InputView;
import com.woowacourse.javacoordinate.view.OutputView;

public class Application {
    public static void main(String[] args) {
        while (true) {
            Points points = InputView.inputCoordinatePoints();
            Figure figure = FigureFactory.createFigure(points);
            CoordinateSystem coordinateSystem = new CoordinateSystem(points);

            OutputView.printCoordinateSystem(coordinateSystem);
            OutputView.printResult(calculate(figure));
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

        return new Result(result, OutputView.TYPE_OF_LINE);
    }

    private static Result calculateTriangle(Figure figure) {
        double result = figure.calculateArea();

        return new Result(result, OutputView.TYPE_OF_TRIANGLE);
    }

    private static Result calculateRectangle(Figure figure) {
        double result = figure.calculateArea();

        return new Result(result, OutputView.TYPE_OF_RECTANGLE);
    }
}
