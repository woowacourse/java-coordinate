package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Coordinates implements Iterable<Coordinate> {
    private static final String EX_DUPLICATED_COORDINATES_MESSAGE = "위치가 같은 점(point)이 존재합니다.";
    private static final String EX_MAX_COORDINATES_COUNT_MESSAGE = "4개 이하의 좌표를 입력해주세요.";
    private static final String EX_NOT_TRIANGLE_MESSAGE = "삼각형이 될 수 없는 조건입니다.";
    private static final String EX_NOT_RECTANGLE_MESSAGE = "x축, y축과 평행한 직사각형이 아닙니다.";
    private static final int MAX_COORDINATE = 4;
    private static final int TRIANGLE = 3;
    private static final int TRI_LONGEST_SIDE = 2;
    private static final int TRI_OTHER_SIDE = 1;
    private static final int TRI_ANOTHER_SIDE = 0;
    private static final int RECTANGLE = 4;
    private final List<Coordinate> coordinates;

    /**
     * 생성자
     */
    public Coordinates() {
        this.coordinates = new ArrayList<>();
    }

    /**
     * Coordinate 추가
     * <br> 중복된 Coordinate 추가 시 예외 발생
     *
     * @param coordinate 추가할 Coordinate
     * @throws IllegalArgumentException
     */
    public void add(Coordinate coordinate) {
        checkDuplication(coordinate);
        coordinates.add(coordinate);
        checkMaxCoordinates();

        if (coordinates.size() == TRIANGLE) {
            checkTriangle();
        }
        if (coordinates.size() == RECTANGLE) {
            checkRectangle();
        }
    }

    private void checkRectangle() {
        Set<Integer> xCoordinates = new HashSet<>();
        Set<Integer> yCoordinates = new HashSet<>();

        for (Coordinate coordinate : coordinates) {
            xCoordinates.add(coordinate.getX());
            yCoordinates.add(coordinate.getY());
        }

        checkNotRectangle(xCoordinates, yCoordinates);
    }

    private void checkNotRectangle(Set<Integer> xCoordinates, Set<Integer> yCoordinates) {
        if (!(xCoordinates.size() == 2 && yCoordinates.size() == 2)) {
            throw new IllegalArgumentException(EX_NOT_RECTANGLE_MESSAGE);
        }
    }

    private void checkTriangle() {
        double lengthA = FigureFactory.getInstance().create(this).straight(coordinates.get(0), coordinates.get(1));
        double lengthB = FigureFactory.getInstance().create(this).straight(coordinates.get(1), coordinates.get(2));
        double lengthC = FigureFactory.getInstance().create(this).straight(coordinates.get(0), coordinates.get(2));

        List<Double> lengths = Arrays.asList(lengthA, lengthB, lengthC);
        Collections.sort(lengths);
        checkNotTriangle(lengths);
    }

    private void checkNotTriangle(List<Double> lengths) {
        if (lengths.get(TRI_LONGEST_SIDE) >= lengths.get(TRI_OTHER_SIDE) + lengths.get(TRI_ANOTHER_SIDE)) {
            throw new IllegalArgumentException(EX_NOT_TRIANGLE_MESSAGE);
        }
    }

    private void checkDuplication(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            throw new IllegalArgumentException(EX_DUPLICATED_COORDINATES_MESSAGE);
        }
    }

    private void checkMaxCoordinates() {
        if (coordinates.size() > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_MAX_COORDINATES_COUNT_MESSAGE);
        }
    }

    /**
     * 크기 반환
     *
     * @return coordinates.size
     */
    public int size() {
        return coordinates.size();
    }

    public Coordinate get(int index) {
        return coordinates.get(index);
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return coordinates.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates points1 = (Coordinates) o;
        return Objects.equals(coordinates, points1.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
