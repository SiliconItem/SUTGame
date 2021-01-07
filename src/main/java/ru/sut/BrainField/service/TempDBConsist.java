package ru.sut.BrainField.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.dbo.QuestionVariantsDao;
import ru.sut.BrainField.repository.QuestionRepository;

import javax.annotation.PostConstruct;

@Service
public class TempDBConsist {

    @Autowired
    private QuestionRepository repo;
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

        /////


        repo.save(q2);
        repo.save(q3);
        repo.save(q4);
        repo.save(q5);

    }
}
