package ru.sut.BrainField.model.dto;

import ru.sut.BrainField.model.dbo.QuestionDao;
import java.util.Map;


public class FieldModel {

    private String commandName;
    private Integer fieldSize;
    private Map<String, QuestionDao> questions;

    public FieldModel(String commandName) {
        this.commandName = commandName;
    }

    public FieldModel(String commandName, Integer fieldSize) {
        this.commandName = commandName;
        this.fieldSize = fieldSize;
    }

    public void addQuestion (String cssId, QuestionDao questionDao){
        this.questions.put(cssId, questionDao);
    }
    public Map<String, QuestionDao> getQuestions() {
        return questions;
    }
    public void setQuestions(Map<String, QuestionDao> questions) {
        this.questions = questions;
    }
    public String getCommandName() {
        return commandName;
    }
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
    public Integer getFieldSize() { return fieldSize; }
    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

}
