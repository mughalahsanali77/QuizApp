package app.quiz.service.quiz.services;



import app.quiz.core.dto.QuizDto;

import java.util.List;

public interface QuizService {
    QuizDto add(QuizDto quiz);

    QuizDto update(QuizDto quiz);

    QuizDto delete(String id);

    QuizDto get(String id);

    List<QuizDto> get();
}
