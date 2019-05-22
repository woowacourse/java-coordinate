package coordinatecalculator.util;

public class OutputView {

    public static void printScore(String message, double score) {
        System.out.println(message + score);
    }

    public static void PrintErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }
}
