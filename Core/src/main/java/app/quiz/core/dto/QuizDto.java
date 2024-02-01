package app.quiz.core.dto;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
    private String id;
    @NotBlank(message = "Quiz title cannot be blank")
    private String title;
}
