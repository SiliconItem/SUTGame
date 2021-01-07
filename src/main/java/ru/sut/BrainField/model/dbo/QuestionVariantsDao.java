package ru.sut.BrainField.model.dbo;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class QuestionVariantsDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quest_id")
    private QuestionDao question;

    private Boolean validResponse = Boolean.FALSE;
    private String ansText;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionDao getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDao question) {
        this.question = question;
    }

    public Boolean getValidResponse() {
        return validResponse;
    }

    public void setValidResponse(Boolean validResponse) {
        this.validResponse = validResponse;
    }

    public String getAnsText() {
        return ansText;
    }

    public void setAnsText(String ansText) {
        this.ansText = ansText;
    }
}
