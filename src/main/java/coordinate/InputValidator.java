package coordinate;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String DEFAULT_DELIMITERS = "\\([0-9]{1,2},[0-9]{1,2}\\)";

    public static boolean isNotValidPointInput(List<String> inputs) {
        return inputs.stream()
                .filter(c -> InputValidator.isValidFormat(c))
                .filter(c -> InputValidator.isNotEmpty(c))
                .collect(Collectors.toList())
                .size() != inputs.size();
    }

    private static boolean isValidFormat(String input) {
        if (!input.matches(DEFAULT_DELIMITERS)) {
            return false;
        }
        return true;
    }

    private static boolean isNotEmpty(String input){
        if(input.contains(" ")){
            return false;
        }
        return true;
    }

    public static boolean isNotInteger(String inputX,String inputY){
            try {
                Integer.parseInt(inputX);
                Integer.parseInt(inputY);
                return false;
            } catch (IllegalArgumentException e) {
                return true;
            }
    }
}
