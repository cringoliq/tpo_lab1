package task3;

public class Gap {
    private final double width;
    private final double height;

    public Gap(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public boolean canPass(Creature creature) {
        return this.width >= 1.5; // Если ширина щели не меньше 1.5, то через неё можно пройти.
    }
}
