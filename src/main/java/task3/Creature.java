package task3;

import java.util.ArrayList;
import java.util.List;

import static task3.Emotion.*;

abstract class Creature {
    protected String name;
    protected Size size;
    protected double weight;
    protected int strength;
    protected Voice voice;
    protected List<Action> actions = new ArrayList<>();
    protected Emotion emotion;

    public Creature(String name, Size size, double weight, int strength, Voice voice, Emotion emotion) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.strength = strength;
        this.voice = voice;
        this.emotion = emotion;
    }

    public void performAction(ActionType type, String description) {
        actions.add(new Action(type, description));
    }

    public abstract double makeSound();


    public double computeSoundVolume() {


        double baseVolume = voice.getVolume() + 1;


        double strengthFactor = Math.sqrt(this.strength + 5);


        double sizeAmplifier = Math.exp(this.size.getFactor() / 2.0);


        double emotionModifier = 1.0;
        if (this.emotion.equals(HAPPY)) {
            emotionModifier = 1.10;
        } else if (this.emotion.equals(ANGRY)) {
            emotionModifier = 1.30;
        } else if (this.emotion.equals(PANICKING)) {
            emotionModifier = 1.50;
        } else if (this.emotion.equals(SCARED)) {
            emotionModifier = 0.80;
        }


        return baseVolume * strengthFactor * sizeAmplifier * emotionModifier;
    }
}
