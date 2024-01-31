package app.quiz.service.quiz.services;

import app.quiz.service.quiz.dtos.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto create(QuestionDto dto);
    QuestionDto update(QuestionDto dto);
    QuestionDto get(String id);
    QuestionDto delete(String id);
    List<QuestionDto> get();
}
