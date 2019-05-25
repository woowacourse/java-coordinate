package coordinatecalculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<Points,Figure>> figureFactory;

    static {
        figureFactory=new HashMap<>();
        figureFactory.put(2,Line::new);
        figureFactory.put(3,Triangle::new);
        figureFactory.put(4,Rectangle::new);
    }

    public static Figure create(Points points){
        if(!figureFactory.containsKey(points.getSize())){
            throw  new IllegalArgumentException("잘못된 점의 개수 입니다.");
        }
        return figureFactory.get(points.getSize()).apply(points);
    }
}
