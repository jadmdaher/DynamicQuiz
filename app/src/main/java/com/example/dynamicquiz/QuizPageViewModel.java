package com.example.dynamicquiz;

import androidx.lifecycle.ViewModel;

public class QuizPageViewModel extends ViewModel {
    private Question[] questions = new Question[5];

    private boolean score[] = new boolean[5];

    public boolean[] getScore() {
        return score;
    }

    public void setScore(boolean[] score) {
        this.score = score;
    }

    public int totalScore(){
        int total = 0;
        for(int i = 0; i < score.length; i++){
            if(score[i]){
                total++;
            }
        }
        return total;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public Question getQuestion(int position){
        return questions[position];
    }
}
