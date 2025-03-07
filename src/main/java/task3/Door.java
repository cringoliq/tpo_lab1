package task3;

public class Door extends EnvironmentObject {

    public int fitting;

    public Door(String name, Material material, Size size, double mass, State state, int fitting) {
        super(name, material, size, mass);
        this.fitting = fitting;
    }



    public void lock() {
        double massEffect = mass * size.getFactor();

        double closingDifficulty = fitting * material.getDensity() * size.getFactor() - massEffect;

        if (closingDifficulty > 30) {
            this.state = State.CLOSED;
            System.out.println(name + " успешно закрыта.");
        } else {
            System.out.println(name + " не может быть закрыта, из-за плохого прилегания");
        }
    }


    public void unlock() {
        this.state = State.OPEN;
    }


    public State getState() {
        return state;
    }
    public void setFitting(int fitting) {
        this.fitting = fitting;
    }
}
