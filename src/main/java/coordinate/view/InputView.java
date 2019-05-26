package coordinate.view;

import coordinate.domain.Coordinates;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
	private static final String DELIMITER = "-";
	private static final Pattern PATTERN = Pattern.compile("\\((.+),(.+)\\)");
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static Coordinates inputCoordinate() {
		System.out.println("좌표를 입력하세요.");
		return inputCoordinate(SCANNER.nextLine());
	}

	public static Coordinates inputCoordinate(final String input) {
		Optional<String> optInput = Optional.ofNullable(input);
		try {
			return assignCoordinate(optInput.orElse(""));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputCoordinate();
		}
	}

	private static Coordinates assignCoordinate(final String input) {
		List<Point> points = new ArrayList<>();
		for (String coordinate : input.split(DELIMITER)) {
			points.add(makePoint(coordinate));
		}
		return new Coordinates(points);
	}

	private static Point makePoint(final String coordinate) {
		Matcher matcher = PATTERN.matcher(coordinate);
		if (matcher.find()) {
			return Point.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
		}
		throw new IllegalArgumentException("다시 입력하세요");
	}
}
