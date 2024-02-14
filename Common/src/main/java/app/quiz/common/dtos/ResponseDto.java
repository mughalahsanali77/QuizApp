package app.quiz.common.dtos;

import app.quiz.common.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    private ResponseEnum code;
    private String message;
    private Object data;

    public String getCode(){
        return code.getValue()+"";
    }
}
