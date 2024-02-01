package app.quiz.service.question.services;


import app.quiz.core.dto.QuestionDto;
import app.quiz.core.dto.QuizDto;

import java.util.List;

public interface QuestionService {
    QuestionDto create(QuestionDto dto);
    QuestionDto update(QuestionDto dto);
    QuestionDto get(String id);
    QuestionDto delete(String id);
    List<QuestionDto> get();
    List<QuestionDto> getByQuiz(QuizDto quiz);
}
