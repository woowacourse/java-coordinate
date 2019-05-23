package coordinate.view;

import coordinate.domain.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static List<Point> intputCoordinate() {
        List<Point> points = new ArrayList<>();
        String input = new Scanner(System.in).nextLine();
        List<String> inputs = Arrays.asList(input.split("-"));
        try {
            validateDuplication(inputs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return intputCoordinate();
        }
        Pattern p = Pattern.compile("[(]([\\d]*)[,]([\\d]*)[)]");
        for (String s : inputs) {
            Matcher m = p.matcher(s);
            m.matches();
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            points.add(new Point(x, y));
        }
        return points;
    }

    private static void validateDuplication(List<String> inputs) {
        Set<String> set = new HashSet<>(inputs);
        if (set.size() != inputs.size()) {
            throw new IllegalArgumentException("중복된 점이 입력되었습니다.");
        }
    }
}
