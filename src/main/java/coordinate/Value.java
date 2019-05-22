package coordinate;

public class Value {
    private final int value;
    
    public Value(String input) {
        int value = Integer.parseInt(input);
        if (value < 0 || value > 24) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        
    }
}
