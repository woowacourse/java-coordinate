package coordinate.model;

public class PointNumber {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 24;
    private int number;
    public PointNumber(int number) {
        checkValidRange(number);
        this.number=number;
    }

    private void checkValidRange(int number) {
        if(number<MIN_RANGE || number >MAX_RANGE){
            throw new IllegalArgumentException("좌표 숫자 입력 범위 오류");
        }
    }

    public int getNumber() {
        return this.number;
    }
}
