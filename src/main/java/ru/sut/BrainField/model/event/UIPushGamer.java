package ru.sut.BrainField.model.event;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class UIPushGamer {

    private String commandName;
    private String target;
    private String color;
    private Boolean action;
    private String actionData;
    private String actionReq1;
    private String actionReq2;
    private String actionReq3;
    private String actionReq4;

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

    public Boolean getAction() {
        return action;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }

    public String getActionData() {
        return actionData;
    }

    public void setActionData(String actionData) {
        this.actionData = actionData;
    }

    public String getActionReq1() {
        return actionReq1;
    }

    public void setActionReq1(String actionReq1) {
        this.actionReq1 = actionReq1;
    }

    public String getActionReq2() {
        return actionReq2;
    }

    public void setActionReq2(String actionReq2) {
        this.actionReq2 = actionReq2;
    }

    public String getActionReq3() {
        return actionReq3;
    }

    public void setActionReq3(String actionReq3) {
        this.actionReq3 = actionReq3;
    }

    public String getActionReq4() {
        return actionReq4;
    }

    public void setActionReq4(String actionReq4) {
        this.actionReq4 = actionReq4;
    }
}
