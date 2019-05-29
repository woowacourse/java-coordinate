package coordinatecalculator.model.figure.impl;

public class LineCalculator {
    private static final int SQUARE = 2;

    public static double multipleLength(Line a, Line b) {
        return a.calculateArea() * b.calculateArea();
    }

    public static double triangleArea(Line a, Line b, Line c) {
        double lengthA = a.calculateArea();
        double lengthB = b.calculateArea();
        double lengthC = c.calculateArea();

        return heronFormula(lengthA, lengthB, lengthC);
    }

    private static double heronFormula(double a, double b, double c) {
        double squaredA = Math.pow(a, SQUARE);
        double squaredB = Math.pow(b, SQUARE);
        double squaredC = Math.pow(c, SQUARE);

        return (double) 1 / 4 * Math.sqrt(4 * squaredA * squaredB
                - Math.pow(squaredA + squaredB - squaredC, SQUARE));
    }
}
