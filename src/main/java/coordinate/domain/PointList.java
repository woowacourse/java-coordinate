package coordinate.domain;

import java.util.*;

public class PointList {
    private final List<Point> points;

    public PointList(List<Point> points) {
        isCorrectSize(points);
        this.points = checkDuplicate(points);
    }

//    List<Line> findLine() {
//        List<Line> lines = new ArrayList<>();
//        for (int i = 0; i < points.size(); i++) {
//            for (int j = i + 1; j < points.size(); j++) {
//                lines.add(new Line(new PointList(Arrays.asList(points.get(i),points.get(j)))));
//            }
//        }
//        lines.sort(null);
//        return lines;
//    }

    private void isCorrectSize(List<Point> points) {
        if(!(points.size()>=2 && points.size()<=4)){
            throw new IllegalArgumentException("좌표는 2~4개 입력하세요");
        }
    }

    private List<Point> checkDuplicate(List<Point> points) {
        if (isDuplicate(points)) {
            throw new IllegalArgumentException("중복되지 않는 좌표를 입력해주세요.");
        }
        return points;
    }

    private boolean isDuplicate(List<Point> points) {
        HashSet<Point> set = new HashSet<>(points);
        return set.size() != points.size();
    }

    public boolean isContain(Point point) {
        return points.contains(point);
    }

    int getSize() {
        return this.points.size();
    }

    Point getPoint(int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        List<Point> points =new ArrayList<>();
        points.addAll(this.points);
        return points;
    }
}
