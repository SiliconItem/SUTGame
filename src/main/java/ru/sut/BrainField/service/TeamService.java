package ru.sut.BrainField.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.dto.FieldModel;
import ru.sut.BrainField.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class TeamService {

    @Autowired
    private QuestionRepository repository;

    private static int PROB = 30;

    public FieldModel configureField(String commName, int fieldSize){

        List<QuestionDao> questonsDao = repository.findAllByIdIsNotNull();
        FieldModel fieldModel = new FieldModel(commName, fieldSize);

        HashMap<String, QuestionDao> fieldPosition = new HashMap(fieldSize * fieldSize);
        for (int i = 1 ; i <= fieldSize*fieldSize; i++){
            if (new Random().nextInt(100) > PROB) {
                fieldPosition.put(cssIdGenerator(), questonsDao.get( new Random().nextInt(questonsDao.size())));
            } else {
                fieldPosition.put(cssIdGenerator(), null);
            }
        }

        fieldModel.setQuestions(fieldPosition);

        //Debug
        System.out.println("Info for command: " + commName);
        for (Map.Entry<String, QuestionDao> entry : fieldPosition.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }

        return fieldModel;
    }


    private String cssIdGenerator(){
        int leftLimit = 48;
        int rightLimit = 95;
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;

    }

}
