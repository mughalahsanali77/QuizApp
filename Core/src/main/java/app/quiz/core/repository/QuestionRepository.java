package app.quiz.core.repository;


import app.quiz.entities.QuestionEntity;
import app.quiz.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    List<QuestionEntity> findByQuiz(QuizEntity quiz);
}
