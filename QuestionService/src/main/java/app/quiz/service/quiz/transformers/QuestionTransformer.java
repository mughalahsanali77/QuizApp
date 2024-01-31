package app.quiz.service.quiz.transformers;

import app.quiz.service.quiz.dtos.QuestionDto;
import app.quiz.service.quiz.entities.QuestionEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionTransformer {
    public static QuestionDto toDto(QuestionEntity entity){
        QuestionDto dto=new QuestionDto();
        if (!ObjectUtils.isEmpty(entity.getId())){
            dto.setId(entity.getId().toString());
        }
        dto.setQuestion(entity.getQuestion());
        return dto;
    }
    public static QuestionEntity toEntity(QuestionDto dto){
        return mapDtoToEntity(dto,new QuestionEntity());
    }
    public static QuestionEntity toUpdate(QuestionDto dto, QuestionEntity entity){
        return mapDtoToEntity(dto,entity);
    }
    private static QuestionEntity mapDtoToEntity(QuestionDto dto,QuestionEntity entity){
        if (!StringUtils.isEmpty(dto.getId())){
            entity.setId(Long.parseLong(dto.getId()));
        }
        entity.setQuestion(dto.getQuestion());
        return entity;
    }
    public static List<QuestionDto> toDto(List<QuestionEntity> entities){
        List<QuestionDto> dtoList=new ArrayList<>();
        if (!ObjectUtils.isEmpty(entities)){
            for (QuestionEntity entity:entities){
                dtoList.add(toDto(entity));
            }
        }
        return dtoList;
    }
}
