package com.crio.codingame.repositories;

import java.util.*;
import java.util.stream.Collectors;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;

public class QuestionRepository implements IQuestionRepository {

    private final Map<String,Question> questionMap;
    private Integer autoIncrement = 0;

    public QuestionRepository(){
        questionMap = new HashMap<String,Question>();
    }

    public QuestionRepository(Map<String, Question> questionMap) {
        this.questionMap = questionMap;
        this.autoIncrement = questionMap.size();
    }

    @Override
    public Question save(Question entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Question q = new Question(Integer.toString(autoIncrement),entity.getTitle(),entity.getLevel(),entity.getScore());
            questionMap.put(q.getId(),q);
            return q;
        }
        questionMap.put(entity.getId(),entity);
        return entity;
    }


    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>(questionMap.values());
        return questions;
    }

    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questionMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Question entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public List<Question> findAllQuestionLevelWise(Level level) {
        List<Question> questions = questionMap.values().stream().filter(question->question.getLevel()==level).collect(Collectors.toList());
        return questions;
    }
    
}
