package coordinate.view;

import coordinate.InputValidator;
import coordinate.domain.Points;
import coordinate.domain.PointFactory;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {


    public static Points InputPoints() {
        try {
            System.out.println("좌표를 입력하세요");
            Scanner scanner = new Scanner(System.in);
           return PointFactory.generatePoints(convertPoint(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputPoints();
        }
    }

    private static List<String> convertPoint(Scanner scanner) {
        List<String> inputs = getSplit(scanner);
        if(InputValidator.isNotValidPointInput(inputs)){
            throw new IllegalArgumentException("형식에 맞는 입력을 해주시기 바랍니다.");
        };
        inputs = inputs.stream().map(s -> s.substring(1, s.length()-1)).collect(Collectors.toList());
        return inputs;
    }

    private static List<String> getSplit(Scanner scanner) {
        return Arrays.asList(scanner.nextLine().split("-"));
    }

}
