package ru.sut.BrainField.model.event;

public class UIEditCell {

    private String cid;
    private String image;
    private String sound;
    private Integer score;

    public UIEditCell(String cid) {
        this.cid = cid;
    }



    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
