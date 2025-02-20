package task3;

import java.util.ArrayList;
import java.util.List;

public class Person extends Creature {

    private List<String> skills = new ArrayList<>();
    private List<String> clothing = new ArrayList<>();
    private Emotion emotion;

    public Person(String name, Size size, double weight, int strength, Voice voice, Emotion emotion) {
        super(name, size, weight, strength, voice);
        this.emotion = emotion;
    }

    @Override
    public void makeSound() {
        System.out.println(name + "издает звук: " + voice.getDescription());
    }

    public void closeDoor(Door door){
        door.lock();
    }
    public Emotion getEmotion() {
        return emotion;
    }
}
