package app.quiz.core.dto;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private String id;
    @NotBlank(message = "Question cannot be blank")
    private String question;
    @NotNull(message = "Quiz cannot be null")
    private QuizDto quiz;
}
