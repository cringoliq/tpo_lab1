package task3;

public class Furry extends Creature {
    private int fingerAmount;


    public Furry(String name, Size size, double weight, int strength, Voice voice, Emotion emotion ,int fingerAmount) {
        super(name, size, weight, strength, voice, emotion);
        this.fingerAmount = fingerAmount;
    }

    @Override
    public double makeSound() {
        double computedVolume = computeSoundVolume();
        System.out.printf("%s издает верещание: %s с громкостью %.2f дБ%n", name, voice.getDescription(), computedVolume);
        return computedVolume;
    }

    public void stickHand(Gap gap){
        if(gap.canPass(this)){
            System.out.println(name + " просовывает руку через щель.");
            actions.add(new Action(ActionType.MOVEMENT, name + " просунул руку через щель."));
        } else {
            System.out.println(name + " не может просунуть руку через щель");
            actions.add(new Action(ActionType.MOVEMENT, name + " попытался просунуть руку, но не смог."));
        }
    }

}
