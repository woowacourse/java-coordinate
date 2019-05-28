package coordinate.model;

import java.util.Objects;

public class PointNumber {
        private static final int MIN_RANGE = 1;
        private static final int MAX_RANGE = 24;
        private int number;

        public PointNumber(int number) {
                checkValidRange(number);
                this.number = number;
        }

        private void checkValidRange(int number) {
                if (number < MIN_RANGE || number > MAX_RANGE) {
                        throw new IllegalArgumentException("좌표 숫자 입력 범위를 벗어났습니다.");
                }
        }

        public int getNumber() {
                return this.number;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof PointNumber)) return false;
                PointNumber that = (PointNumber) o;
                return getNumber() == that.getNumber();
        }

        @Override
        public int hashCode() {
                return Objects.hash(getNumber());
        }
}
