package coordinatecalculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointFactory {
    private static final Map<Integer, PointValue> pointFactory = new HashMap<>();

    public PointValue create(String pointValue) {
        int value = Integer.parseInt(pointValue);
        if(pointFactory.get(value) == null){
            pointFactory.put(value,new PointValue(value));
        }
        return pointFactory.get(value);
    }
}
