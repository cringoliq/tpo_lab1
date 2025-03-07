package task3;

import java.util.ArrayList;
import java.util.List;

public class Person extends Creature {


    private final Emotion emotion;

    public Person(String name, Size size, double weight, int strength, Voice voice, Emotion emotion) {
        super(name, size, weight, strength, voice, emotion);
        this.emotion = emotion;
    }

    @Override
    public double makeSound() {
        double computedVolume = computeSoundVolume();
        System.out.printf("%s издает звук: %s с громкостью %.2f дБ%n", name, voice.getDescription(), computedVolume);
        return computedVolume;
    }



}
