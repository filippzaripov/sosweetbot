package cakes;

public enum CakeSize implements CakeProperty {
    SMALL(10, 10), MIDDLE(20, 20), BIG(30, 30);

    private final double cost;
    private final int size;

    CakeSize(int size, double cost) {
        this.cost = cost;
        this.size = size;
    }

    public double cost() {
        return 0;
    }
}
