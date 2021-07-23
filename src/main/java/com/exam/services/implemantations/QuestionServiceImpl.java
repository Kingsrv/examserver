package com.exam.services.implemantations;

import com.exam.dao.QuestionDao;
import com.exam.entities.exam.Question;
import com.exam.entities.exam.Quiz;
import com.exam.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public Question addQuestion(Question question) {
        return this.questionDao.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionDao.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionDao.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionDao.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionDao.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();
        question.setQuesId(quesId);
        this.questionDao.delete(question);
    }

    @Override
    public Question getQues(Long questionsId) {
        return this.questionDao.getOne(questionsId);
    }
}
