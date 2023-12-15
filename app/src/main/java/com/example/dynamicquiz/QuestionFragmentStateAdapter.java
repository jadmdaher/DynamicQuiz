package com.example.dynamicquiz;

import static com.example.dynamicquiz.Database.answerList;
import static com.example.dynamicquiz.Database.correctAnswerList;
import static com.example.dynamicquiz.Database.questionList;
//import static com.example.dynamicquiz.Database.questions;
import static com.example.dynamicquiz.MainActivity.db;
import static com.example.dynamicquiz.MainActivity.quizPageViewModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class QuestionFragmentStateAdapter extends FragmentStateAdapter {
    Question[] questionsArray = quizPageViewModel.getQuestions();
    Fragment fragment[];
    String fragmentHeader[];
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    public QuestionFragmentStateAdapter(FragmentActivity fragmentActivity, TabLayout tabLayout, ViewPager2 viewPager){
        super(fragmentActivity);
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
        fragmentHeader = new String[]{"1", "2", "3", "4", "5", "Submit"};
        fragment = new Fragment[]{QuestionFragment.newInstance(0, questionsArray[0].getQuestion(), questionsArray[0].getAnswer(), questionsArray[0].getCorrectAnswer()),
                QuestionFragment.newInstance(1, questionsArray[1].getQuestion(), questionsArray[1].getAnswer(), questionsArray[1].getCorrectAnswer()),
                QuestionFragment.newInstance(2, questionsArray[2].getQuestion(), questionsArray[2].getAnswer(), questionsArray[2].getCorrectAnswer()),
                QuestionFragment.newInstance(3, questionsArray[3].getQuestion(), questionsArray[3].getAnswer(), questionsArray[3].getCorrectAnswer()),
                QuestionFragment.newInstance(4, questionsArray[4].getQuestion(), questionsArray[4].getAnswer(), questionsArray[4].getCorrectAnswer()),
                SubmitFragment.newInstance()};
    }

    public void setUpTabLayoutMediator() {
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(fragmentHeader[position])
        ).attach();
    }
    @Override
    public Fragment createFragment(int position) {
        return fragment[position];
    }

    @Override
    public int getItemCount() {
        return fragment.length;
    }
}
