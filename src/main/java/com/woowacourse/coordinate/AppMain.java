package com.woowacourse.coordinate;

import java.util.List;

import com.woowacourse.coordinate.domain.*;
import com.woowacourse.coordinate.view.InputView;
import com.woowacourse.coordinate.view.OutputView;

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
