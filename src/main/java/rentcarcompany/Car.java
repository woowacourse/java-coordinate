package rentcarcompany;

public abstract class Car implements CarInterface {
    protected String name;
    protected int distance;
    protected int mileage;

    private int makeOilAmount() {
        return distance / mileage;
    }

    public String makeInfo() {
        return name + " : " + makeOilAmount() + "리터";
    }

    @Override
    public String getInfo() {
        return name + " : " + makeOilAmount() + "리터";
    }
}
