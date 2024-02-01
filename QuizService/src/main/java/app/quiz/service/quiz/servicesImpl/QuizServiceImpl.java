package app.quiz.service.quiz.servicesImpl;

import app.quiz.common.helper.CustomException;
import app.quiz.core.dto.QuizDto;
import app.quiz.core.repository.QuizRepository;
import app.quiz.core.transformer.QuizTransformer;
import app.quiz.entities.QuizEntity;
import app.quiz.service.quiz.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    @Override
    public QuizDto add(QuizDto quiz) {
        System.out.println(quiz.getTitle());
        if (StringUtils.isEmpty(quiz.getTitle())) {
            throw new CustomException("Quiz name can not be null");
        }
        QuizEntity entity = quizRepository.save(QuizTransformer.toEntity(quiz));
        return QuizTransformer.toDto(entity);
    }

    @Override
    public QuizDto update(QuizDto quiz) {
        if (StringUtils.isEmpty(quiz.getId()) || ObjectUtils.isEmpty(quiz)) {
            throw new CustomException("Quiz or quiz id cannot be empty");
        }
        QuizEntity entity = quizRepository.findById(Long.parseLong(quiz.getId())).orElseThrow(() -> new CustomException("Quiz not found with id :" + quiz.getId()));
        QuizEntity update = quizRepository.save(QuizTransformer.toUpdate(quiz, entity));

        return QuizTransformer.toDto(update);
    }

    @Override
    public QuizDto delete(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new CustomException("Id cannot be null");
        }
        QuizEntity entity = quizRepository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException("Quiz not found with id :" + id));
        QuizDto dto = QuizTransformer.toDto(entity);
        quizRepository.delete(entity);
        return dto;
    }

    @Override
    public QuizDto get(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new CustomException("Id cannot be null");
        }
        QuizEntity entity = quizRepository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException("Quiz not found with id :" + id));
        return QuizTransformer.toDto(entity);
    }

    @Override
    public List<QuizDto> get() {
        List<QuizEntity> all = quizRepository.findAll();
        return QuizTransformer.toDto(all);
    }
}
