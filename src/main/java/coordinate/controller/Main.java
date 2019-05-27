package coordinate.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("(((.),(.)))").matcher("(1,2)-(2,3)");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
