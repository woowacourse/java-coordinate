package coordinate.view;

import coordinate.domain.PointList;
import coordinate.domain.PointFactory;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String DEFAULT_DELIMITERS = "\\([0-9]{1,2},[0-9]{1,2}\\)";

    public static PointList InputPoints() {
        System.out.println("좌표를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        return PointFactory.generatePointList(convertPoint(scanner));
    }

    private static List<String> convertPoint(Scanner scanner) {
        List<String> points = getSplit(scanner);
        points.stream().forEach(c -> isValidFormat(c));
        points = points.stream().map(s -> s.substring(1, s.length() - 1)).collect(Collectors.toList());
        return points;
    }

    private static List<String> getSplit(Scanner scanner) {
        return Arrays.asList(scanner.nextLine().split("-"));
    }

    private static void isValidFormat(String coordinate) {
        if (!coordinate.matches(DEFAULT_DELIMITERS)) {
            throw new IllegalArgumentException("올바른 형식을 입력하세요.");
        }
    }

}
