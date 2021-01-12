package ru.sut.BrainField.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.dbo.QuestionVariantsDao;

import java.util.List;

@Repository
public interface QuestionVariantsRepository extends CrudRepository<QuestionVariantsDao, Long> {

    List<QuestionVariantsDao> findAllByIdIsNotNull();

}
