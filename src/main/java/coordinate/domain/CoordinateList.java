package coordinate.domain;

import java.util.*;

public class CoordinateList {
    private final List<Coordinate> coordinates;

    public CoordinateList(List<Coordinate> coordinates) {
        this.coordinates = checkDuplicate(coordinates);
    }

    public List<Line> findLine() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                lines.add(new Line(coordinates.get(i).findLength(coordinates.get(j))));
            }
        }
        return lines;
    }

    private List<Coordinate> checkDuplicate(List<Coordinate> coordinate) {
        if (isDuplicate(coordinate)) {
            throw new IllegalArgumentException("중복되지 않는 좌표를 입력해주세요.");
        }
        return coordinate;
    }

    private boolean isDuplicate(List<Coordinate> coordinate) {
        return Collections.indexOfSubList(coordinate, Arrays.asList(coordinate.get(0))) != -1;
    }

}
