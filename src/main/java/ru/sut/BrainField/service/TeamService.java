package ru.sut.BrainField.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sut.BrainField.configuration.AppConst;
import ru.sut.BrainField.model.dbo.CellContentDao;
import ru.sut.BrainField.model.event.UIEditCell;
import ru.sut.BrainField.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.*;

@Service
public class TeamService {

    @Autowired
    private QuestionRepository repository;

    @Value("${app.data.path}")
    private String dataPath;

    private List<CellContentDao> field1 = new ArrayList<>();
    private List<CellContentDao> field2 = new ArrayList<>();
    private List<CellContentDao> joinField = new ArrayList<>();

    @PostConstruct
    public void configureField(){
        for (int i = 0; i < 100; i++){
            field1.add(new CellContentDao(cssIdGenerator()));
            field2.add(new CellContentDao(cssIdGenerator()));
        }
        joinField.addAll(field1);
        joinField.addAll(field2);

        System.out.println("Ячейки игрового поля инициированы. Количетво: "
                + (field1.size() + field2.size()));
    }

    public List<CellContentDao> getField1() {
        return field1;
    }

    public List<CellContentDao> getField2() {
        return field2;
    }

    public CellContentDao getCellByCssId(String cssId){
        return  joinField.stream()
                .filter(e -> e.getCellId().equals(cssId))
                .findFirst()
                .orElse(null);
    }


    public void setCellConfig(UIEditCell cellConfig) {
        joinField.stream()
                .filter(o -> o.getCellId().equals(cellConfig.getCid()))
                .findFirst().get() //CellContentDao
                .updateStatus(cellConfig);
    }


    public String[] getImageList(){
        File imgFolder = new File(dataPath + AppConst.IMG_PTH_PART);
        return imgFolder.list();
    }

    public String[] getSoundList(){
        File soundFolder = new File(dataPath + AppConst.SND_PTH_PART);
        return soundFolder.list();
    }


    ///// PRIVATE METHODS
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
