package com.exam.services.implemantations;

import com.exam.dao.QuizDao;
import com.exam.entities.exam.Category;
import com.exam.entities.exam.Quiz;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDao quizDao;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizDao.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizDao.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizDao.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizDao.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {

        this.quizDao.deleteById(quizId);

    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizDao.findBycategory(category);
    }

    //get active quizzes

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizDao.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizDao.findByCategoryAndActive(c,true);
    }

}
