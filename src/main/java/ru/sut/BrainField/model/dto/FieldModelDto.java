package ru.sut.BrainField.model.dto;

import org.springframework.beans.factory.annotation.Value;
import ru.sut.BrainField.model.dbo.QuestionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FieldModelDto {

    private int fieldSize;
    private Integer fieldFullSize;
    private List<CellModelDto> cells;

    public FieldModelDto(int fieldSize) {
        this.fieldSize = fieldSize;
        this.fieldFullSize = fieldSize * fieldSize * 2;
        this.cells = new ArrayList<>(fieldFullSize);
    }

    public void addCell(CellModelDto cell){
        this.cells.add(cell);
    }

    public CellModelDto getCellByCssId(String cssId){
        return cells.stream()
                .filter(e -> e.getCellCssId().equals(cssId))
                .findFirst().get();
    }

    public List<CellModelDto> getCellsByCssClass (String cssClassName){
        return cells.stream()
                .filter(e -> e.getCellCssClass().equals(cssClassName))
                .collect(Collectors.toList());
    }

    public int getCellCapacity(){
       return cells.size();
    }

    //Generated code
    public List<CellModelDto> getCells() {
        return cells;
    }
    public void setCells(List<CellModelDto> cells) {
        this.cells = cells;
    }
    public void setFieldFullSize(Integer fieldFullSize) { this.fieldFullSize = fieldFullSize; }
    public int getFieldSize() { return fieldSize; }
    public void setFieldSize(int fieldSize) { this.fieldSize = fieldSize;}
    public Integer getFieldFullSize() { return fieldFullSize; }
}
