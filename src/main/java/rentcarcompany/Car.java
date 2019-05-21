package rentcarcompany;

public abstract class Car {
    protected String name;
    protected int distance;
    protected int mileage;

    private int makeOilAmount() {
        return distance / mileage;
    }

    String makeInfo() {
        return name + " : " + makeOilAmount() + "리터";
    }
}
