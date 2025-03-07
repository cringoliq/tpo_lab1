package task3;

public enum Size {
    VERY_SMALL(0.2),
    SMALL(0.35),
    MEDIUM(0.5),
    BIG(0.75),
    VERY_BIG(0.95);


    private final double factor;

    Size(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
