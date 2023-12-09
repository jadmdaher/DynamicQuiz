package com.example.dynamicquiz;

import androidx.lifecycle.ViewModel;

public class QuizPageViewModel extends ViewModel {
    private Question[] questions = new Question[5];

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
