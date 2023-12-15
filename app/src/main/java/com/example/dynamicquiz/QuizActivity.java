package com.example.dynamicquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dynamicquiz.databinding.ActivityQuizBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class QuizActivity extends AppCompatActivity {
    private ActivityQuizBinding quizBinding;
    QuizPageViewModel quizPageViewModel;
    public Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizBinding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(quizBinding.getRoot());

//        quizPageViewModel = ((MyApp)getApplication()).getQuizPageViewModel();
//        db = ((MyApp)getApplication()).database;

//        quizPageViewModel.getQuestion();
//        quizPageViewModel.getAnswer();
//        quizPageViewModel.getCorrectAnswer();

        QuestionFragmentStateAdapter stateAdapter1 = new QuestionFragmentStateAdapter(this, quizBinding.tabLayout, quizBinding.viewPager);
        quizBinding.viewPager.setAdapter(stateAdapter1);
        stateAdapter1.setUpTabLayoutMediator();
    }
}