package ru.sut.BrainField.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.dto.CellModelDto;
import ru.sut.BrainField.model.dto.FieldModelDto;
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

    @Value("${app.field.quesrand}")
    private int PROB;
    @Value("${app.field.size}")
    private int fieldSize;

    public static FieldModelDto field;

    public void configureField(){
        FieldModelDto fieldModelDto = new FieldModelDto(fieldSize);
        List<QuestionDao> questonsDao = repository.findAllByIdIsNotNull();

        for (int i = 1 ; i <= fieldModelDto.getFieldFullSize(); i++){
            CellModelDto cell =  new CellModelDto(cssIdGenerator(), null);
            if (new Random().nextInt(100) > PROB) {
                cell.setQuestionDao(questonsDao.get( new Random().nextInt(questonsDao.size())));
            }
            if (i%2 != 0){
                cell.setCellCssClass("comClass1");
            } else {
                cell.setCellCssClass("comClass2");
            }
            fieldModelDto.addCell(cell);
        }

        //debug
        for (CellModelDto cell : fieldModelDto.getCells()){
            System.out.println(cell.getCellCssId() + "\t" + cell.getQuestionDao());
        }

        field = fieldModelDto;

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
