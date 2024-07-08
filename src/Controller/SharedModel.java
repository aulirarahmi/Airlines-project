package Controller;

public class SharedModel {
    private static SharedModel instance;
    private double initialPrice;

    private SharedModel() {}

    public static SharedModel getInstance() {
        if (instance == null) {
            instance = new SharedModel();
        }
        return instance;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }
}
