package task3;

public class Door extends EnvironmentObject{

    public int fitting;


    public Door(String name, Material material, Size size, double mass, State state, int fitting) {
        super(name, material, size, mass, state);
        this.fitting = fitting;
    }

    public void lock(){
        if(fitting > 5) {
            this.state = State.CLOSED;
            System.out.println(name + "успешно закрыта.");
        } else {
            this.state = State.OPEN;
            System.out.println(name + " не может быть закрыта, из-за плохого прилегания");
        }
    }
    public void unlock(){
        this.state = State.OPEN;
    }

    @Override
    public void changeState(State newState) {
        this.state = newState;
    }
}
