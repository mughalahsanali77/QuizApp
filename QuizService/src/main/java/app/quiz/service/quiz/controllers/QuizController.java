package app.quiz.service.quiz.controllers;

import app.quiz.common.util.ResponseUtil;
import app.quiz.core.dto.QuizDto;
import app.quiz.service.quiz.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/all")
    public ResponseEntity<Object> get(){
        List<QuizDto> list = quizService.get();
        return ResponseUtil.returnResponse(list);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Object> get(@PathVariable String id){
        QuizDto quizDto = quizService.get(id);
        return ResponseUtil.returnResponse(quizDto);
    }
    @PostMapping("/create")
    public ResponseEntity<Object>create(@RequestBody QuizDto quizDto){
        QuizDto dto = quizService.add(quizDto);
        return ResponseUtil.returnResponse(dto);
    }
    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody QuizDto quizDto){
        QuizDto dto = quizService.update(quizDto);
        return ResponseUtil.returnResponse(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        QuizDto dto = quizService.delete(id);
        return ResponseUtil.returnResponse(dto);
    }
}
