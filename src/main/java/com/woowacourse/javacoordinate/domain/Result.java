package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.figure.Figure;
import com.woowacourse.javacoordinate.domain.figure.Line;
import com.woowacourse.javacoordinate.domain.figure.Rectangle;
import com.woowacourse.javacoordinate.domain.figure.Triangle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class Result {
    private double result;
    private final String resultType;
    private Map<String, Supplier<Double>> map = new HashMap<>();

    public Result(Figure figure) {
        map.put(Line.TYPE_OF_LINE, figure::calculateLength);
        map.put(Triangle.TYPE_OF_TRIANGLE, figure::calculateArea);
        map.put(Rectangle.TYPE_OF_RECTANGLE, figure::calculateArea);

        try {
            this.result = calculate(figure);
        } catch (IllegalArgumentException e) {
            System.err.println("도형 타입이 올바르지 않습니다");
        }
        this.resultType = figure.getType();
    }

    private double calculate(Figure figure) {
        Supplier<Double> calculator = map.get(figure.getType());
        double result = 0;
        try {
            result = calculator.get();
        } catch (NullPointerException e) {
            System.err.println("도형 타입이 올바르지 않습니다");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public double getResult() {
        return result;
    }

    public String getResultType() {
        return resultType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Double.compare(result1.result, result) == 0 &&
                Objects.equals(resultType, result1.resultType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, resultType);
    }
}
