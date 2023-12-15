package com.example.dynamicquiz;

import static com.example.dynamicquiz.MainActivity.quizPageViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dynamicquiz.databinding.ActivityStatisticsBinding;

public class StatisticsActivity extends AppCompatActivity {
    private ActivityStatisticsBinding statisticsBinding;
    int score = quizPageViewModel.totalScore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statisticsBinding = ActivityStatisticsBinding.inflate(getLayoutInflater());
        setContentView(statisticsBinding.getRoot());

        statisticsBinding.score.setText(score + "/5");
        if (score < 3) {
            statisticsBinding.displayMessage.setText("Better luck next time!");
        } else if (score == 3) {
            statisticsBinding.displayMessage.setText("Good work!");
        }else if(score == 4){
            statisticsBinding.displayMessage.setText("Very good work!");
        }else if(score == 5){
            statisticsBinding.displayMessage.setText("Excellent work!");
        }

        statisticsBinding.homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}