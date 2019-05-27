package coordinatecalculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PointFactory implements PointCreator {
    private static final String xPoint = "x";
    private static final String yPoint = "y";

    private static final Map<String, Function<String, PointValue>> pointFactory;

    static {
        pointFactory = new HashMap<>();
        pointFactory.put(xPoint, PointValue::new);
        pointFactory.put(yPoint, PointValue::new);
    }

    @Override
    public PointValue create(String point, String value) {
        return pointFactory.get(point).apply(value);
    }

}
