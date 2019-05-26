package com.woowacourse.javacoordinate.domain.coordinate;

import java.util.List;
import java.util.Objects;

public class CoordinateLine {
    private final List<Boolean> line;

    public CoordinateLine(List<Boolean> line) {
        if (Objects.isNull(line)) {
            throw new NullPointerException();
        }

        if (line.size() == 0) {
            throw new IllegalArgumentException("빈 데이터가 입력되었습니다");
        }

        this.line = line;
    }

    public boolean isMarked(int index) {
        return line.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordinateLine that = (CoordinateLine) o;

        return Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return line != null ? line.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Boolean point : line) {
            if (point) {
                sb.append("*");
                continue;
            }
            sb.append("  ");
        }
        return sb.toString();
    }
}
