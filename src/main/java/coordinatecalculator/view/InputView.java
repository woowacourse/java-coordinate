package coordinatecalculator.view;

import java.util.*;

import coordinatecalculator.domain.parent.Figure;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Figure inputLocation() {
        // TODO: enum으로 Line, Tri, Rec 구분

        return new Figure();
    }
}
