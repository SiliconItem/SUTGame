package ru.sut.BrainField.model.event;

public class UIPushGamer {

    private String commandName;
    private String target;
    private String color = "#ff0000";


    public UIPushGamer(String commandName, String target) {
        this.commandName = commandName;
        this.target = target;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
