package app.quiz.core.transformer;

import app.quiz.core.dto.QuizDto;
import app.quiz.entities.QuizEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizTransformer {

    public static QuizDto toDto(QuizEntity entity){
        QuizDto dto=new QuizDto();
        if (!ObjectUtils.isEmpty(entity.getId())){
            dto.setId(entity.getId().toString());
        }
        dto.setTitle(entity.getTitle());
        return dto;
    }
    public static QuizEntity toEntity(QuizDto dto){
        return mapDtoToEntity(dto,new QuizEntity());
    }
    public static QuizEntity toUpdate(QuizDto dto,QuizEntity entity){
        return mapDtoToEntity(dto,entity);
    }
    private static QuizEntity mapDtoToEntity(QuizDto dto, QuizEntity entity){
        if (!StringUtils.isEmpty(dto.getId())){
            entity.setId(Long.parseLong(dto.getId()));
        }
        entity.setTitle(dto.getTitle());
        return entity;
    }
    public static List<QuizDto> toDto(List<QuizEntity> entities){
        List <QuizDto> dtoList=new ArrayList<>();
        if (!ObjectUtils.isEmpty(entities)){
            for (QuizEntity entity:entities){
                dtoList.add(toDto(entity));
            }
        }
        return dtoList;
    }
}
