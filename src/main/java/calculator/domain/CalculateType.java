package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-28
 */
public enum CalculateType {
    PERIMETER("거리"),
    AREA("넓이");

    private final String type;

    CalculateType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
