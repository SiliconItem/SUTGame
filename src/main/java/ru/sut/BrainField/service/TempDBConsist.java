package ru.sut.BrainField.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.dbo.QuestionVariantsDao;
import ru.sut.BrainField.repository.QuestionRepository;
import ru.sut.BrainField.repository.QuestionVariantsRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TempDBConsist {

    @Autowired
    private QuestionRepository repo;
    @Autowired
    private QuestionVariantsRepository repo2;
    @PostConstruct
    public void fillDB(){
        QuestionDao q1 = new QuestionDao();
        q1.setQuestText("Какие территории входят в первый район IARU (ITU)?");
        QuestionVariantsDao q1v1 = new QuestionVariantsDao();
        QuestionVariantsDao q1v2 = new QuestionVariantsDao();
        QuestionVariantsDao q1v3 = new QuestionVariantsDao();
        QuestionVariantsDao q1v4 = new QuestionVariantsDao();

        q1v1.setAnsText("Африка, Европа, страны бывшего СССР");
        q1v2.setAnsText("Южная Америка");
        q1v3.setAnsText("Австралия и Океания");
        q1v4.setAnsText("Северная Америка");
        q1v1.setValidResponse(Boolean.TRUE);

        q1.addAnswer(q1v1);
        q1.addAnswer(q1v2);
        q1.addAnswer(q1v3);
        q1.addAnswer(q1v4);

        q1v1.setQuestion(q1);
        q1v2.setQuestion(q1);
        q1v3.setQuestion(q1);
        q1v4.setQuestion(q1);

        repo2.save(q1v1);
        repo2.save(q1v2);
        repo2.save(q1v3);
        repo2.save(q1v4);
        repo.save(q1);

        ///
        QuestionDao q2 = new QuestionDao();
        q2.setQuestText("Как называется любительская радиостанция, производящая односторонние передачи в целях изучения условий распространения радиоволн?");
        QuestionVariantsDao q2v1 = new QuestionVariantsDao();
        QuestionVariantsDao q2v2 = new QuestionVariantsDao();
        QuestionVariantsDao q2v3 = new QuestionVariantsDao();
        QuestionVariantsDao q2v4 = new QuestionVariantsDao();

        q2v1.setAnsText("Радиомаяк");
        q2v2.setAnsText("Цифровая станция");
        q2v3.setAnsText("Станция радиоуправления");
        q2v4.setAnsText("Ретранслятор");
        q2v1.setValidResponse(Boolean.TRUE);

        q2.addAnswer(q2v1);
        q2.addAnswer(q2v2);
        q2.addAnswer(q2v3);
        q2.addAnswer(q2v4);

        q2v1.setQuestion(q2);
        q2v2.setQuestion(q2);
        q2v3.setQuestion(q2);
        q2v4.setQuestion(q2);

        repo2.save(q2v1);
        repo2.save(q2v2);
        repo2.save(q2v3);
        repo2.save(q2v4);
        repo.save (q2);

        ///
        QuestionDao q3 = new QuestionDao();
        q3.setQuestText("Допускается ли заземление радиостанции подключением к батарее отопления?");
        QuestionVariantsDao q3v1 = new QuestionVariantsDao();
        QuestionVariantsDao q3v2 = new QuestionVariantsDao();
        QuestionVariantsDao q3v3 = new QuestionVariantsDao();
        QuestionVariantsDao q3v4 = new QuestionVariantsDao();

        q3v1.setAnsText("Допускается");
        q3v2.setAnsText("Зависит от категории помещения");
        q3v3.setAnsText("Зависит от типа батарей отопления");
        q3v4.setAnsText("Категорически запрещено");
        q3v4.setValidResponse(Boolean.TRUE);

        q3.addAnswer(q3v1);
        q3.addAnswer(q3v2);
        q3.addAnswer(q3v3);
        q3.addAnswer(q3v4);

        q3v1.setQuestion(q3);
        q3v2.setQuestion(q3);
        q3v3.setQuestion(q3);
        q3v4.setQuestion(q3);

        repo2.save(q3v1);
        repo2.save(q3v2);
        repo2.save(q3v3);
        repo2.save(q3v4);
        repo.save (q3);

        ///
        QuestionDao q4 = new QuestionDao();
        q4.setQuestText("Для чего предназначен любительский ретранслятор?");
        QuestionVariantsDao q4v1 = new QuestionVariantsDao();
        QuestionVariantsDao q4v2 = new QuestionVariantsDao();
        QuestionVariantsDao q4v3 = new QuestionVariantsDao();
        QuestionVariantsDao q4v4 = new QuestionVariantsDao();

        q4v1.setAnsText("Для увеличения возможностей по проведению QSO переносных и мобильных радиостанций");
        q4v2.setAnsText("Для длительных бесед на интересные темы");
        q4v3.setAnsText("Для соревнований по радиоспорту");
        q4v4.setAnsText("Для передачи радиолюбительских новостей");
        q4v1.setValidResponse(Boolean.TRUE);

        q4.addAnswer(q4v1);
        q4.addAnswer(q4v2);
        q4.addAnswer(q4v3);
        q4.addAnswer(q4v4);

        q4v1.setQuestion(q4);
        q4v2.setQuestion(q4);
        q4v3.setQuestion(q4);
        q4v4.setQuestion(q4);

        repo2.save(q4v1);
        repo2.save(q4v2);
        repo2.save(q4v3);
        repo2.save(q4v4);
        repo.save (q4);

        ///
        QuestionDao q5 = new QuestionDao();
        q5.setQuestText("Укажите позывной сигнал любительской радиостанции, принадлежащей ветерану Великой Отечественной войны?");
        QuestionVariantsDao q5v1 = new QuestionVariantsDao();
        QuestionVariantsDao q5v2 = new QuestionVariantsDao();
        QuestionVariantsDao q5v3 = new QuestionVariantsDao();
        QuestionVariantsDao q5v4 = new QuestionVariantsDao();

        q5v1.setAnsText("R3DAAD/B");
        q5v2.setAnsText("RR3DH");
        q5v3.setAnsText("U3DI");
        q5v4.setAnsText("R73SRR");
        q5v3.setValidResponse(Boolean.TRUE);

        q5.addAnswer(q5v1);
        q5.addAnswer(q5v2);
        q5.addAnswer(q5v3);
        q5.addAnswer(q5v4);

        q5v1.setQuestion(q5);
        q5v2.setQuestion(q5);
        q5v3.setQuestion(q5);
        q5v4.setQuestion(q5);

        repo2.save(q5v1);
        repo2.save(q5v2);
        repo2.save(q5v3);
        repo2.save(q5v4);
        repo.save (q5);

    }
}
