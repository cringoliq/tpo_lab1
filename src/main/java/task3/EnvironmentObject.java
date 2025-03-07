package task3;

abstract class EnvironmentObject {
    protected String name;
    protected Material material;
    protected Size size;

    protected double mass;
    protected State state;

    public EnvironmentObject(String name, Material material, Size size, double mass) {
        this.name = name;
        this.material = material;
        this.size = size;
        this.mass = mass;
    }

}
