package coordinate.domain.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.PointList;


public class OutputView {
    public static void printPoints(PointList pointList) {
        for (int y = 24; y >= 1; y--) {
            System.out.printf("%2s", isEvenNumber(y));
            for (int x = 0; x <= 24; x++) {
                if(pointList.isContain(new Point(""+x,""+y))){
                    System.out.print("*");
                }
                else if(x == 0){
                    System.out.print("|");
                }
                else{
                    System.out.printf("%2s"," ");
                }
            }
            System.out.println();
        }

        if(pointList.isContain(new Point("0","0"))){
            System.out.print("  *");
        }
        else{
            System.out.print("  +");
        }
        for(int i=1;i<=24;i++){
             if(pointList.isContain(new Point(""+i,"0"))){
                 System.out.print(" * ");
             }
             else {
                 System.out.print("ㅡ");
             }
        }
        System.out.println();
        System.out.printf("%2s",0);
        for(int i =2; i<=24; i+=2){
            System.out.printf("%4s",i);
        }
        System.out.println();
    }

    private static String isEvenNumber(int index) {
        if (index % 2 == 0) {
            return "" + index;
        }
        return "";
    }

    public static void printResult(Figure figure) {
        System.out.printf(figure.findResult(),figure.findArea());
    }
}
