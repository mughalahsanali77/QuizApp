package app.quiz.service.quiz.controllers;

import app.quiz.service.quiz.services.QuestionService;
import app.quiz.service.quiz.dtos.QuestionDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping
    List<QuestionDto> get(){
        return questionService.get();
    }
    @GetMapping("/findById/{id}")
    QuestionDto get(@PathVariable String id){
        return questionService.get(id);
    }
    @PostMapping("/create")
    QuestionDto create(@RequestBody QuestionDto dto){
        return questionService.create(dto);
    }
    @PutMapping("/update")
    QuestionDto update(@RequestBody QuestionDto dto){
        return questionService.update(dto);
    }
    @DeleteMapping("/{id}")
    QuestionDto delete(@PathVariable String id){
        return questionService.delete(id);
    }
}
