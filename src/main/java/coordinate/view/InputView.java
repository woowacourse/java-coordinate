package coordinate.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner SCANNER = new Scanner(System.in);

    public List<String> inputPoints() {
        System.out.println("좌표를 입력하세요.");
        String input =SCANNER.nextLine();
        Matcher matcher = Pattern.compile("\\(\\d,\\d\\)(-\\(\\d,\\d\\))*").matcher(input);

        if (matcher.find()) {
            List<String> points = Arrays.asList(input.split("-"));
            return points.stream().map(s -> s.substring(1, s.length()-1)).collect(Collectors.toList());
        }

        throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
    }
}
