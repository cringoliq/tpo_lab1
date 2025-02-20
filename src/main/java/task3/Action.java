package task3;

public class Action {

    private ActionType type;
    private String description;

    public Action(ActionType type, String description) {
        this.type = type;
        this.description = description;
    }

    public ActionType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
