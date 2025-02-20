package task3;

public class Voice {

    private int volume;
    private int pitch;
    private String description;

    public Voice(int volume, int pitch, String description) {
        this.volume = volume;
        this.pitch = pitch;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
