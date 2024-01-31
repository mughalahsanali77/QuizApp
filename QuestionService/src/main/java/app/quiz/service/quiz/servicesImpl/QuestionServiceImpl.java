package app.quiz.service.quiz.servicesImpl;

import app.quiz.common.healper.CustomException;
import app.quiz.service.quiz.repositories.QuestionRepository;
import app.quiz.service.quiz.transformers.QuestionTransformer;
import app.quiz.service.quiz.dtos.QuestionDto;
import app.quiz.service.quiz.entities.QuestionEntity;
import app.quiz.service.quiz.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public QuestionDto create(QuestionDto dto) {
        if (ObjectUtils.isEmpty(dto))
            throw new CustomException("Question dto cannot be null");
        if (StringUtils.isEmpty(dto.getQuestion()))
            throw new CustomException("Question cannot be null");
        QuestionEntity save = questionRepository.save(QuestionTransformer.toEntity(dto));
        return QuestionTransformer.toDto(save);
    }

    @Override
    public QuestionDto update(QuestionDto dto) {
        if (ObjectUtils.isEmpty(dto) || StringUtils.isEmpty(dto.getId()))
            throw new CustomException("Question dto aur id cannot be null");
        if (StringUtils.isEmpty(dto.getQuestion()))
            throw new CustomException("Question cannot be null");
        QuestionEntity entity = questionRepository.findById(Long.parseLong(dto.getId())).orElseThrow(() -> new CustomException("Question not found with id : " + dto.getId()));
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
}
