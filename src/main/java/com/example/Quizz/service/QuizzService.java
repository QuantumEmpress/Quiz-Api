package com.example.Quizz.service;



import com.example.Quizz.entity.Question;
import com.example.Quizz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public boolean isAnswerCorrect(Integer questionId, Integer answerId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question == null) return false;

        return question.getAnswers().stream()
                .anyMatch(answer -> answer.getId().equals(answerId) && answer.isCorrect());
    }
}
