package com.example.dynamicquiz;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
    private String question;
    private String asnwer[] = new String[5];
    private String correctAnswer;
    private int questionTextView = R.id.questionTextView;
    private int answerTextView[] = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4, R.id.choice5};

    public static QuestionFragment newInstance(String question, String answer[], String correctAnswer) {
        QuestionFragment fragment = new QuestionFragment();
        fragment.question = question;
        fragment.asnwer = answer;
        fragment.correctAnswer = correctAnswer;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frameLayout = inflater.inflate(R.layout.fragment_question, container, false);
        TextView questionTextView = frameLayout.findViewById(this.questionTextView);
        questionTextView.setText(question);
        for (int i = 0; i < asnwer.length; i++) {
            TextView answerTextView = frameLayout.findViewById(this.answerTextView[i]);
            answerTextView.setText(asnwer[i]);
        }
        return frameLayout;
    }
}