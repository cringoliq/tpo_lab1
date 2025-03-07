package task3;

public enum Material {
    WOOD(1.1),
    STONE(1.6),
    IRON(2.0),
    GOLD(3.0),
    DIAMOND(9.0);

    private final double density;

    Material(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

}
