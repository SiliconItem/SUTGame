package ru.sut.BrainField.model.dto;

import ru.sut.BrainField.model.dbo.QuestionDao;

public class CellModelDto {

    private Integer cellNumber;
    private String  cellCssId;
    private Boolean cellPressed;
    private String  cellColor;
    private String  cellCssClass;
    private String  imageFile;
    private String  audioFile;
    private QuestionDao questionDao;

    public CellModelDto(String cellCssId, QuestionDao questionDao) {
        this.cellCssId = cellCssId;
        this.questionDao = questionDao;
    }


    public String getCellCssClass() {
        return cellCssClass;
    }

    public void setCellCssClass(String cellCssClass) {
        this.cellCssClass = cellCssClass;
    }


    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getCellCssId() {
        return cellCssId;
    }

    public void setCellCssId(String cellCssId) {
        this.cellCssId = cellCssId;
    }

    public void setCellNumber(Integer cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Boolean getCellPressed() {
        return cellPressed;
    }

    public void setCellPressed(Boolean cellPressed) {
        this.cellPressed = cellPressed;
    }

    public String getCellColor() {
        return cellColor;
    }

    public void setCellColor(String cellColor) {
        this.cellColor = cellColor;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
