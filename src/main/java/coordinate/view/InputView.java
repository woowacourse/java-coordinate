package coordinate.view;

import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
	private static final String DELIMITER = "-";
	private static final String BLANK = "";
	private static final Pattern PATTERN = Pattern.compile("\\((.+),(.+)\\)");
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static List<Point> inputPoints() {
		System.out.println("좌표를 입력하세요.");
		return inputPoints(SCANNER.nextLine());
	}

	public static List<Point> inputPoints(final String input) {
		Optional<String> optInput = Optional.ofNullable(input);
		try {
			return assignPoints(optInput.orElse(BLANK));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPoints();
		}
	}

	private static List<Point> assignPoints(final String input) {
		List<Point> points = new ArrayList<>();
		for (String coordinate : input.split(DELIMITER)) {
			points.add(makePoint(coordinate));
		}
		return points;
	}

	private static Point makePoint(final String coordinate) {
		Matcher matcher = PATTERN.matcher(coordinate);
		if (matcher.find()) {
			return Point.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
		}
		throw new IllegalArgumentException("다시 입력하세요");
	}
}
