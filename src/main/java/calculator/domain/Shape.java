package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public abstract class Shape {

    private String name;
    private String calculateTarget;

    public Shape(String name, String calculateTarget) {
        this.name = name;
        this.calculateTarget = calculateTarget;
    }

    public String getName() {
        return name;
    }

    public String getCalculateTarget() {
        return calculateTarget;
    }
}
