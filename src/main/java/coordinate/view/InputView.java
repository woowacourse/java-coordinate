package coordinate.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public List<Integer> inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        return extractCoordinates(SCAN.nextLine());
    }

    private List<Integer> extractCoordinates(String input) {
        String result = input.replace("-", ",").replace(")", "").replace("(", "");
        List<Integer> numbers = Arrays.stream(result.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return numbers;
    }
}
