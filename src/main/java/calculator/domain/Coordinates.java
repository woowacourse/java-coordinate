package calculator.domain;

import java.util.*;

/**
 * Coordinate 들을 모아놓은 class
 * <br> 중복된 좌표가 있는지 확인
 *
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Coordinates implements Iterable<Coordinate> {
    private static final String EX_DUPLICATED_COORDINATES_MESSAGE = "위치가 같은 점(point)이 존재합니다.";
    private final List<Coordinate> coordinates;

    /**
     * 생성자
     */
    public Coordinates() {
        this.coordinates = new ArrayList<>();
    }

    public Coordinates(List<Coordinate> coordinates) {
        this.coordinates = new ArrayList<>(coordinates);
    }

    /**
     * Coordinate 추가
     * <br> 중복된 Coordinate 추가 시 예외 발생
     *
     * @param coordinate 추가할 Coordinate
     * @throws IllegalArgumentException
     */
    public Coordinates add(Coordinate coordinate) {
        checkDuplication(coordinate);
        coordinates.add(coordinate);
        return new Coordinates(coordinates);
    }

    private void checkDuplication(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            throw new IllegalArgumentException(EX_DUPLICATED_COORDINATES_MESSAGE);
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
