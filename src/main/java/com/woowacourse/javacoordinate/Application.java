package com.woowacourse.javacoordinate;

import com.woowacourse.javacoordinate.domain.*;
import com.woowacourse.javacoordinate.domain.coordinate.CoordinateSystem;
import com.woowacourse.javacoordinate.domain.figure.Figure;
import com.woowacourse.javacoordinate.domain.figure.FigureFactory;
import com.woowacourse.javacoordinate.domain.point.Points;
import com.woowacourse.javacoordinate.view.InputView;
import com.woowacourse.javacoordinate.view.OutputView;

public class Application {
    public static void main(String[] args) {
        while (true) {
            Points points = InputView.inputCoordinatePoints();
            Result result = null;
            CoordinateSystem coordinateSystem = null;

            try {
                Figure figure = FigureFactory.createFigure(points);
                result = new Result(figure);
                coordinateSystem = new CoordinateSystem(points);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }

            OutputView.printCoordinateSystem(coordinateSystem);
            OutputView.printResult(result);
        }
    }
}
