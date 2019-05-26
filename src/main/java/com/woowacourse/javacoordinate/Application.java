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
            Result result;
            CoordinateSystem coordinateSystem;

            try {
                Figure figure = FigureFactory.createFigure(points);
                result = new Result(figure);
                coordinateSystem = new CoordinateSystem(points);

                OutputView.printCoordinateSystem(coordinateSystem);
                OutputView.printResult(result);
            } catch (NullPointerException e) {
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.err.println("알 수 없는 예외 발생");
                System.exit(0);
            }
        }
    }
}
