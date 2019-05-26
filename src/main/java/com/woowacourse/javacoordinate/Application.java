package com.woowacourse.javacoordinate;

import com.woowacourse.javacoordinate.domain.*;
import com.woowacourse.javacoordinate.domain.coordinate.CoordinateSystem;
import com.woowacourse.javacoordinate.domain.figure.Figure;
import com.woowacourse.javacoordinate.domain.figure.FigureFactory;
import com.woowacourse.javacoordinate.domain.point.Points;
import com.woowacourse.javacoordinate.view.InputView;
import com.woowacourse.javacoordinate.view.OutputView;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        while (true) {
            Points points = InputView.inputCoordinatePoints();

            Figure figure = FigureFactory.createFigure(points);
            Result result = new Result(figure);
            CoordinateSystem coordinateSystem = new CoordinateSystem(points);

            OutputView.printCoordinateSystem(coordinateSystem);
            OutputView.printResult(result);
        }
    }
}
