package com.woowacourse.coordinate.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Point {
    private static final String PATTERN = "[,()]";

    private static final int MIN = 0;
    private static final int MAX = 24;

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        checkRange(x, y);
        this.x = x;
        this.y = y;
    }

    public Point(final String str) {
        String trimmed = str.trim();
        if (!isSurroundedWithParenthesis(trimmed)) {
            throw new IllegalArgumentException("유효하지 않은 좌표 입력입니다.");
        }

        String[] segments = trimmed.split(PATTERN);
        x = Integer.valueOf(segments[1].trim());
        y = Integer.valueOf(segments[2].trim());
        checkRange(x, y);
    }

    private void checkRange(final int x, final int y) {
        if (x <= MIN || x > MAX || y <= MIN || y > MAX) {
            throw new IllegalArgumentException(String.format("범위를 벗어난 좌표입니다 { x: %d, y: %d }", x, y));
        }
    }

    public static List<Point> createWithPair(final String s) {
        return Arrays.stream(s.split("-"))
            .map(Point::new)
            .collect(Collectors.toList());
    }

    private boolean isSurroundedWithParenthesis(final String s) {
        return s.startsWith("(") && s.endsWith(")");
    }

    public boolean matchX(final int x) {
        return this.x == x;
    }

    public boolean matchY(final int y) {
        return this.y == y;
    }

    public double calculateDistance(final Point point) {
        double dx = Math.abs(point.x - x);
        double dy = Math.abs(point.y - y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * 두 점 사이의 기울기를 구하여 반환한다.
     *
     * @param p
     * @return 기울기가 무한대인 경우(y축에 평행한 경우) null을 갖는 Optional 객체.
     */
    public Optional<Double> calculateSlope(final Point p) {
        if (p.x == this.x) {
            return Optional.ofNullable(null);
        }
        return Optional.of(Math.abs((p.y - this.y) / (double) (p.x - this.x)));
    }

    /**
     * this를 중심으로 하는 각 ∠p1-this-p2 의 각도를 반환한다.
     *
     * @param p1
     * @param p2
     * @return 계산된 각도, 양수
     */
    public double calculateAngle(Point p1, Point p2) {
        double cangleRad = Math.atan((double) (p2.y - this.y) / (p2.x - this.x)) - Math.atan((double) (p1.y - this.y) / (p1.x - this.x));
        return Math.abs(Math.toDegrees(cangleRad));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x &&
            y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("Point { x: %d, y: %d }", x, y);
    }
}
