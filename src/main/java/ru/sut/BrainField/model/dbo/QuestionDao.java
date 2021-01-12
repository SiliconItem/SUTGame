package ru.sut.BrainField.model.dbo;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class QuestionDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<QuestionVariantsDao> answers = new ArrayList<>();

    private String questGroup;

    @NonNull
    private String questText;




    public void addAnswer(QuestionVariantsDao ansverVariant){
        this.answers.add(ansverVariant);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<QuestionVariantsDao> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QuestionVariantsDao> answers) {
        this.answers = answers;
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }

    public String getQuestGroup() {
        return questGroup;
    }

    public void setQuestGroup(String questGroup) {
        this.questGroup = questGroup;
    }
}
