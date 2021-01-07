package ru.sut.BrainField.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sut.BrainField.model.dbo.QuestionDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionDao, Long> {

    List<QuestionDao> findAllByIdIsNotNull();

}
