package coordinate.view;

import coordinate.domain.*;

public class OutputView {
    public static void printResult(Figure figure) {
        if (figure instanceof AreaCalculable) {
            System.out.format("%s의 넓이는 %.5f%n", figure.getClassName(), ((AreaCalculable) figure).area());
            return;
        }
        System.out.format("%s의 길이는 %.5f%n", figure.getClassName(), figure.length());
    }
}
