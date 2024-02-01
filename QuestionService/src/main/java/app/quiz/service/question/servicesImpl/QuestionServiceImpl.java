package app.quiz.service.question.servicesImpl;

import app.quiz.common.helper.CustomException;
import app.quiz.core.dto.QuestionDto;
import app.quiz.core.dto.QuizDto;
import app.quiz.core.repository.QuestionRepository;
import app.quiz.core.repository.QuizRepository;
import app.quiz.core.transformer.QuestionTransformer;
import app.quiz.core.transformer.QuizTransformer;
import app.quiz.entites.QuestionEntity;
import app.quiz.entites.QuizEntity;
import app.quiz.service.question.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    @Override
    public QuestionDto create(QuestionDto dto) {
        if (ObjectUtils.isEmpty(dto))
            throw new CustomException("Question dto cannot be null");
        if (StringUtils.isEmpty(dto.getQuestion()))
            throw new CustomException("Question cannot be null");
        if (ObjectUtils.isEmpty(dto.getQuiz()) || StringUtils.isEmpty(dto.getQuiz().getId()))
            throw new CustomException("Quiz or Quiz id cannot be null");
        QuizEntity quizEntity = quizRepository.findById(Long.parseLong(dto.getQuiz().getId())).orElseThrow(() -> new CustomException("Quiz not found with id : " + dto.getQuiz().getId()));
        dto.setQuiz(QuizTransformer.toDto(quizEntity));
        QuestionEntity save = questionRepository.save(QuestionTransformer.toEntity(dto));
        return QuestionTransformer.toDto(save);
    }

    @Override
    public QuestionDto update(QuestionDto dto) {
        if (ObjectUtils.isEmpty(dto) || StringUtils.isEmpty(dto.getId()))
            throw new CustomException("Question dto aur id cannot be null");
        if (StringUtils.isEmpty(dto.getQuestion()))
            throw new CustomException("Question cannot be null");
        if (ObjectUtils.isEmpty(dto.getQuiz()) || StringUtils.isEmpty(dto.getQuiz().getId()))
            throw new CustomException("Quiz or Quiz id cannot be null");
        QuestionEntity entity = questionRepository.findById(Long.parseLong(dto.getId())).orElseThrow(() -> new CustomException("Question not found with id : " + dto.getId()));
        QuizEntity quizEntity = quizRepository.findById(Long.parseLong(dto.getQuiz().getId())).orElseThrow(() -> new CustomException("Quiz not found with id : " + dto.getQuiz().getId()));
        dto.setQuiz(QuizTransformer.toDto(quizEntity));
        QuestionEntity updated = questionRepository.save(QuestionTransformer.toUpdate(dto, entity));
        return QuestionTransformer.toDto(updated);
    }

    @Override
    public QuestionDto get(String id) {
        if (StringUtils.isEmpty(id))
            throw new CustomException(" id cannot be null");
        QuestionEntity entity = questionRepository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException("Question not found with id : " + id));
        return QuestionTransformer.toDto(entity);
    }

    @Override
    public QuestionDto delete(String id) {
        if (StringUtils.isEmpty(id))
            throw new CustomException(" id cannot be null");
        QuestionEntity entity = questionRepository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException("Question not found with id : " + id));
        QuestionDto questionDto = QuestionTransformer.toDto(entity);
        questionRepository.delete(entity);
        return questionDto;
    }

    @Override
    public List<QuestionDto> get() {
        return QuestionTransformer.toDto(questionRepository.findAll());
    }

    @Override
    public List<QuestionDto> getByQuiz(QuizDto quiz) {
        if (ObjectUtils.isEmpty(quiz)|| StringUtils.isEmpty(quiz.getId()))
            throw new CustomException("Quiz or Quiz Id cannot be null");
        QuizEntity quizEntity = quizRepository.findById(Long.parseLong(quiz.getId())).orElseThrow(() -> new CustomException("Quiz Not Found with Given Id"));
        List<QuestionEntity> list = questionRepository.findByQuiz(quizEntity);
        List<QuestionDto> dtoList=QuestionTransformer.toDto(list);
        if (ObjectUtils.isEmpty(dtoList))
            throw new CustomException("Question not found with Quiz : "+quizEntity.getTitle());
        return dtoList;
    }
}
