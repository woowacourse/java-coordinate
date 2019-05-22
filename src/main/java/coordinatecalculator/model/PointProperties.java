package coordinatecalculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PointProperties {

    private final static int MIN_POINT_NUMBER = 0;
    private final static int MAX_POINT_NUMBER = 24;
    private final static String NUMBER_REGEX = "[0-9]*";

    public abstract int getValue();

    public int validNumber(String point) {
        Matcher matcher = Pattern.compile(NUMBER_REGEX).matcher(point);
        if (!matcher.find()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (Integer.parseInt(point) < MIN_POINT_NUMBER || Integer.parseInt(point) > MAX_POINT_NUMBER) {
            throw new IllegalArgumentException("0부터 24까지 정수를 입력하세요");
        }
        return Integer.parseInt(point);
    }
}
