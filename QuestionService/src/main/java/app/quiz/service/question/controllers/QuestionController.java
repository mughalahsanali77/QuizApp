package app.quiz.service.question.controllers;

import app.quiz.common.util.ResponseUtil;
import app.quiz.core.dto.QuestionDto;
import app.quiz.service.question.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping
    ResponseEntity<Object> get(){
        List<QuestionDto> dtos = questionService.get();
        return ResponseUtil.returnResponse(dtos);
    }
    @GetMapping("/findById/{id}")
    ResponseEntity<Object> get(@PathVariable String id){
        QuestionDto questionDto = questionService.get(id);
        return ResponseUtil.returnResponse(questionDto);
    }
    @PostMapping("/create")
    ResponseEntity<Object> create(@RequestBody QuestionDto dto){
        QuestionDto questionDto = questionService.create(dto);
        return ResponseUtil.returnResponse(dto);
    }
    @PutMapping("/update")
    ResponseEntity<Object> update(@RequestBody QuestionDto dto){
        QuestionDto update = questionService.update(dto);
        return ResponseUtil.returnResponse(update);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Object> delete(@PathVariable String id){
        QuestionDto delete = questionService.delete(id);
        return ResponseUtil.returnResponse(delete);
    }
}
