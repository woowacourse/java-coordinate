package coordinatecalculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Point implements IPoint {

    int validNumber(final String yPoint){
        Matcher matcher = Pattern.compile("[0-9]*").matcher(yPoint);
        if(!matcher.find()){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if(Integer.parseInt(yPoint) < 0 || Integer.parseInt(yPoint) > 24){
            throw new IllegalArgumentException("0부터 24까지 정수를 입력하세요");
        }
        return Integer.parseInt(yPoint);
    }

}
