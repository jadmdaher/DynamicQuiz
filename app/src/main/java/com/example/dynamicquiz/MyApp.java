package com.example.dynamicquiz;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

public class MyApp extends Application {
    public static QuizPageViewModel quizPageViewModel;
    public static Database database;
    private static Context context;

    public QuizPageViewModel getQuizPageViewModel() {
        if(quizPageViewModel == null){
            quizPageViewModel = new ViewModelProvider.AndroidViewModelFactory(this).create(QuizPageViewModel.class);
        }
        return quizPageViewModel;
    }

    public void setDataBase(Database db) {
        this.database = db;
    }
}
