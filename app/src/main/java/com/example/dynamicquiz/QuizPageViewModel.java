package com.example.dynamicquiz;

import androidx.lifecycle.ViewModel;

public class QuizPageViewModel extends ViewModel {
    private String question;
    private String answer[];
    private String correctAnswer;

    public QuizPageViewModel(String question, String answer[], String correctAnswer){
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion(){ return question; }
    public void setQuestion(String question){ this.question = question; }
    public String[] getAnswer(){ return answer; }
    public void setAnswer(String answer[]){ this.answer = answer; }
    public String getCorrectAnswer(){ return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer){this.correctAnswer = correctAnswer;}

    private Database db = new Database();

    public Database getDatabase(){
        return db;
    }

    public void setDatabase(Database db){
        this.db = db;
    }

    public void insertData(){
        db.insertData();
    }

    public void fetchData(){
        db.fetchData();
        setQuestion(db.question);
        setAnswer(db.answer);
        setCorrectAnswer(db.correctAnswer);
    }
}
