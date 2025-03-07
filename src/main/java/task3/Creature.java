package task3;

import java.util.ArrayList;
import java.util.List;

abstract class Creature {
    protected String name;
    protected Size size;
    protected double weight;
    protected int strength;
    protected Voice voice;
    protected List<Action> actions = new ArrayList<>();

    public Creature(String name, Size size, double weight, int strength, Voice voice) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.strength = strength;
        this.voice = voice;
    }

    public void performAction(ActionType type, String description) {
        actions.add(new Action(type, description));
    }

    public abstract void makeSound();


}
