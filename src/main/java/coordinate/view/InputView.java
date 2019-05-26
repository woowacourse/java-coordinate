package coordinate.view;

import coordinate.domain.Points;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static Points inputPoints() { //TODO
        System.out.println("좌표를 입력하세요.");
        String inputPoints = scanner.nextLine();
        /**
         * (0,0)-(1,2)
         * 괄호 안에 있는 내용 가져오기 (String)
         * 쉼표 제거하고 List에 add
         * 동시에 짝수인지 확인
         * List 사이즈가 4개 미만인 경우 또는 8개를 초과한 경우 예외처리
         */

        Matcher matcher = Pattern.compile("\\((.*)\\)(.*)").matcher(inputPoints);
        if(matcher.find()) {

        }

        return null;
    }
}