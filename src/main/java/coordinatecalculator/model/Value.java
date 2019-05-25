package coordinatecalculator.model;

import java.util.HashMap;
import java.util.Map;

public class Value {
    private static Map<Integer, Value> values = new HashMap<>();

    private double value;

    static {
        for (int i = 0; i < 25; i++) {
            values.put(i, new Value(i));
        }
    }

    private Value(double value) {
        this.value = value;
    }

    public static Value retrieveValue(int key) {
        return values.get(key);
    }
}
