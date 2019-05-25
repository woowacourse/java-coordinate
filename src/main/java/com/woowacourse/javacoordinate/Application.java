package com.woowacourse.javacoordinate;

import com.woowacourse.javacoordinate.domain.*;
import com.woowacourse.javacoordinate.view.InputView;
import com.woowacourse.javacoordinate.view.OutputView;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        while (true) {
            Points points = InputView.inputCoordinatePoints();

            Figure figure = FigureFactory.createFigure(points);
            CoordinateSystem coordinateSystem = new CoordinateSystem(points);
            Result result = new Result(figure);

            OutputView.printCoordinateSystem(coordinateSystem);
            OutputView.printResult(result);
        }
    }
}
