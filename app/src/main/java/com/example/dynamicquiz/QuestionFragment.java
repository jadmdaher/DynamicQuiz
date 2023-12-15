package com.example.dynamicquiz;

import static com.example.dynamicquiz.MainActivity.quizPageViewModel;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
    private int id;
    private String question;
    private String asnwer[] = new String[5];
    private String correctAnswer;
    private int answerTextView[] = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4, R.id.choice5};

    boolean score[] = quizPageViewModel.getScore();

    public static QuestionFragment newInstance(int id, String question, String answer[], String correctAnswer) {
        QuestionFragment fragment = new QuestionFragment();
        fragment.id = id;
        fragment.question = question;
        fragment.asnwer = answer;
        fragment.correctAnswer = correctAnswer;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frameLayout = inflater.inflate(R.layout.fragment_question, container, false);
        TextView questionTextView = frameLayout.findViewById(R.id.questionTextView);
        questionTextView.setText(question);
        for (int i = 0; i < asnwer.length; i++) {
            TextView answerTextView = frameLayout.findViewById(this.answerTextView[i]);
            answerTextView.setText(asnwer[i]);
        }
        return frameLayout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        for (int i = 0; i < asnwer.length; i++) {
//            TextView answerTextView = view.findViewById(this.answerTextView[i]);
//            answerTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    TextView answerTextView = (TextView) v;
//                    String answer = answerTextView.getText().toString();
//                    if (answer.equals(correctAnswer)) {
//                        score[id] = true;
//                        answerTextView.setBackgroundColor(getResources().getColor(R.color.green));
//                    } else {
//                        score[id] = false;
//                        answerTextView.setBackgroundColor(getResources().getColor(R.color.red));
//                    }
//                }
//            });
//        }

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView answerTextView = view.findViewById(checkedId);
                String answer = answerTextView.getText().toString();
                if (answer.equals(correctAnswer)) {
                    score[id] = true;
                    answerTextView.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    score[id] = false;
                    answerTextView.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });
    }
}