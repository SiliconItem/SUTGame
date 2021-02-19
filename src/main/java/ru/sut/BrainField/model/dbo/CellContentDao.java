package ru.sut.BrainField.model.dbo;

import ru.sut.BrainField.model.event.UIEditCell;

public class CellContentDao {

    private String cellId;
    private String cellName;
    private String cellImage;
    private String cellSound;
    private Integer cellScore;

    public CellContentDao(String cellId) {
        this.cellId = cellId;
    }

    public void updateStatus(UIEditCell event){
        this.cellImage = event.getImage();
        this.cellSound = event.getSound();
        this.cellScore = event.getScore();
    }
    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getCellImage() {
        return cellImage;
    }

    public void setCellImage(String cellImage) {
        this.cellImage = cellImage;
    }

    public String getCellSound() {
        return cellSound;
    }

    public Integer getCellScore() {
        return cellScore;
    }

    public void setCellScore(Integer cellScore) {
        this.cellScore = cellScore;
    }

    public void setCellSound(String cellSound) {
        this.cellSound = cellSound;
    }
}
