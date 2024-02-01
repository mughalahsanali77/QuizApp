package app.quiz.service.quiz.controllers;

import app.quiz.core.dto.QuizDto;
import app.quiz.service.quiz.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/all")
    public List<QuizDto> get(){
        return quizService.get();
    }
    @GetMapping("findById/{id}")
    public QuizDto get(@PathVariable String id){
        return quizService.get(id);
    }
    @PostMapping("/create")
    public QuizDto create(@RequestBody QuizDto quizDto){
        return quizService.add(quizDto);
    }
    @PutMapping()
    public QuizDto update(@RequestBody QuizDto quizDto){
        return quizService.update(quizDto);
    }
    @DeleteMapping("/{id}")
    public QuizDto delete(@PathVariable String id){
        return quizService.delete(id);
    }
}
