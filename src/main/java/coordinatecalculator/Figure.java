package coordinatecalculator;

interface Figure {
    int MINIMUM_POINTS_COUNT = 3;
    String ERROR_POINTS_INSUFFICIENT
            = "점의 개수가 도형을 만들기에 모자랍니다.";
    String ERROR_POINTS_DUPLICATE
            = "입력된 점의 좌표가 중복됩니다.";

    double area();

    boolean equals(Object another);

    int hashCode();
}
