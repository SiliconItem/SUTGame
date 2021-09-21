package ru.sut.BrainField.model.event;

import ru.sut.BrainField.model.dbo.CellContentDao;

public class UIPushGamer {

    private String commandName;
    private String target;
    private String color = "yellow";
    private String image;
    private String sound;
    private boolean configured;

    public UIPushGamer(String target) {
        this.target = target;
    }

    public UIPushGamer(CellContentDao cellDao){
        this.commandName = cellDao.getCellName();
        this.target = cellDao.getCellId();
        this.image  = cellDao.getCellImage();
        this.sound  = cellDao.getCellSound();
        this.configured = cellDao.isConfigured();
    }

    public Boolean isConfigured() {
        return configured;
    }

    public Boolean getConfigured() {
        return configured;
    }

    public void setConfigured(Boolean configured) {
        this.configured = configured;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
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
