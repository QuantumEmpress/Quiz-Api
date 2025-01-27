package com.example.Quizz.controller;



import com.example.Quizz.entity.Question;
import com.example.Quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizzController {

    @Autowired
    private QuizzService quizzService;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return quizzService.getAllQuestions();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return quizzService.getQuestionById(id);
    }

    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question) {
        return quizzService.createQuestion(question);
    }

    @PostMapping("/validate-answer")
    public boolean validateAnswer(@RequestParam Integer questionId, @RequestParam Integer answerId) {
        return quizzService.isAnswerCorrect(questionId, answerId);
    }
}
