package coordinate.view;

import coordinate.domain.*;

public class OutputView {
    public void printResult(Figure figure) {
        if (figure instanceof AreaCalculable) {
            System.out.println(figure.getClassName() + "의 넓이는 " + ((AreaCalculable) figure).area());
        }

        System.out.println(figure.getClassName() + "의 길이는 " + figure.length());
    }
}
