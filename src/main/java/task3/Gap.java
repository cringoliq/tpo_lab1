package task3;

public class Gap{
    private double width;
    private double height;

    public Gap(double width, double height){
        this.width = width;
        this.height = height;
    }


    public boolean canPass(Creature creature) {
        return this.width >= 1.5;
    }
}
