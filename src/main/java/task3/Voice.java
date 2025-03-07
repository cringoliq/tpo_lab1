package task3;

public class Voice {

    private final int volume;
    private final String description;

    public Voice(int volume, String description) {
        this.volume = volume;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public int getVolume() {
        return volume;
    }
}
