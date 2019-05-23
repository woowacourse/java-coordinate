package com.woowacourse.coordinate;

import com.woowacourse.coordinate.domain.Figure;
import com.woowacourse.coordinate.domain.FigureCreator;
import com.woowacourse.coordinate.domain.FigureFactory;
import com.woowacourse.coordinate.domain.Point;
import com.woowacourse.coordinate.view.InputView;
import com.woowacourse.coordinate.view.OutputView;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        boolean handledResult = tryHandlePoints();

        while (!handledResult) {
            handledResult = tryHandlePoints();
        }
    }

    private static boolean tryHandlePoints() {
        try {
            printPoints();
            return true;
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        return false;
    }

    private static void printPoints() {
        List<Point> points = Point.createWithPair(InputView.inputCoordinate());
        FigureCreator figureCreator = new FigureFactory();

        if (points.size() != 1) {
            Figure figure = figureCreator.create(points);
            OutputView.printCoordinate(points);
            OutputView.printShape(figure);
        }

        OutputView.printCoordinate(points);
    }
}
