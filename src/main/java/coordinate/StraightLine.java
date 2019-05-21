package coordinate;

public class StraightLine {
    private final Point p1;
    private final Point p2;

    public StraightLine(Point p1, Point p2) {
        if (p1.equals(p2)) {
            throw new IllegalArgumentException("직선의 두 점은 같을 수가 없습니다.");
        }
        this.p1 = p1;
        this.p2 = p2;
    }
}
