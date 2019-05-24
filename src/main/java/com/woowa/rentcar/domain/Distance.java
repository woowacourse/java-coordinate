package com.woowa.rentcar.domain;

public class Distance {
    private int distance;

    public Distance(String distance) {
        try {
            this.distance = Integer.valueOf(distance);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("거리는 숫자 형식으로 입력해주세요.");
        }
    }
}
