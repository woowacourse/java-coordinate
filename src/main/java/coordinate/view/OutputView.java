package coordinate.view;

import coordinate.Figure;
import coordinate.domain.Point;

public class OutputView {
	private static final int MAX_POINT = Point.MAX_POINT;
	private static final int MIN_POINT = Point.MIN_POINT;

	public static void showGraph(final Figure figure) {
		showHorizontalLines(figure);

		showLInes();
		showBottomNumbers();
	}

	private static void showHorizontalLines(Figure figure) {
		for (int row = MAX_POINT; row >= MIN_POINT; row--) {
			System.out.print(String.format("%3s", row));
			System.out.print("|");
			showHorizontalOneLine(figure, row);
			System.out.println();
		}
	}

	private static void showHorizontalOneLine(Figure figure, int row) {
		for (int col = MIN_POINT; col <= MAX_POINT; col++) {
			showPoint(figure, row, col);
		}
	}

	private static void showPoint(Figure figure, int row, int col) {
		if (figure.hasPoint(Point.of(col, row))) {
			System.out.print(String.format("%-3s", "* "));
			return;
		}
		System.out.print(String.format("%3s", "   "));
	}

	private static void showLInes() {
		for (int col = MIN_POINT; col <= MAX_POINT; col++) {
			System.out.print("----");
		}
		System.out.println();
	}

	private static void showBottomNumbers() {
		System.out.print("  ");
		for (int col = MIN_POINT; col <= MAX_POINT; col++) {
			System.out.print(String.format("%3s", col));
		}
		System.out.println();
	}

	public static void showArea(final Figure figure) {
		System.out.println();
		System.out.println(figure.getName() + "는 " + String.format("%.3f", figure.getArea()) + "입니다");
	}
}
