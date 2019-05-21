package coordinate.domain;

public class Point {
    private int point_x;
    private int point_y;

    public Point(String input_x,String input_y) {

        if(!isInteger(input_x,input_y) || isContains(input_x,input_y)){
            throw new IllegalArgumentException("공백없는 숫자를 입력해 주세요");
        }

        int point_x = Integer.parseInt(input_x);
        int point_y = Integer.parseInt(input_x);

        if(isAllowedNumber(point_x,point_y)){
            throw new IllegalArgumentException("24이하의 수를 입력해 주세요.");
        }

        this.point_x = point_x;
        this.point_y = point_y;
    }

    private boolean isAllowedNumber(int point_x,int point_y) {
        return (point_x > 24 || point_y < 0) && (point_x > 24 || point_y < 0);
    }

    private boolean isContains(String input_x,String input_y) {
        return input_x.contains(" ") || input_y.contains(" ");
    }

    private boolean isInteger(String point_x,String point_y) {
        try {
            Integer.parseInt(point_x);
            Integer.parseInt(point_y);

        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
