package com.example.dynamicquiz;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModelProvider;

public class MyApp extends Application {
    //Constructor
    public MyApp() {
        super();
    }
    public static QuizPageViewModel quizPageViewModel;

    public QuizPageViewModel getQuizPageViewModel() {
        if(quizPageViewModel == null){
            quizPageViewModel = new ViewModelProvider.AndroidViewModelFactory(this).create(QuizPageViewModel.class);
        }
        return quizPageViewModel;
    }

    public void setQuizPageViewModel(QuizPageViewModel quizPageViewModel) {
        this.quizPageViewModel = quizPageViewModel;
    }
}
