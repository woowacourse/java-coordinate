package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.figure.Figure;

import java.util.Objects;

public class Result {
    private double result;
    private final int resultType;

    public Result(Figure figure) {
        this.result = figure.calculateArea();
        this.resultType = figure.getPointsSize();
    }

    public double getResult() {
        return result;
    }

    public int getResultType() {
        return resultType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Double.compare(result1.result, result) == 0 &&
                resultType == result1.resultType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, resultType);
    }
}
