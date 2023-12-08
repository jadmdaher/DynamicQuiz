package com.example.dynamicquiz;

import static com.example.dynamicquiz.Database.answerList;
import static com.example.dynamicquiz.Database.correctAnswerList;
import static com.example.dynamicquiz.Database.questionList;
import static com.example.dynamicquiz.Database.questions;
import static com.example.dynamicquiz.MainActivity.db;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class QuestionFragmentStateAdapter extends FragmentStateAdapter {
    QuestionFragment fragment[];
    String fragmentHeader[];
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    public QuestionFragmentStateAdapter(FragmentActivity fragmentActivity, TabLayout tabLayout, ViewPager2 viewPager){
        super(fragmentActivity);
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
        fragmentHeader = new String[]{"1", "2", "3", "4", "5"};
        fragment = new QuestionFragment[]{QuestionFragment.newInstance(questionList.get(0), answerList.get(0), correctAnswerList.get(0)),
                QuestionFragment.newInstance(questionList.get(1), answerList.get(1), correctAnswerList.get(1)),
                QuestionFragment.newInstance(questionList.get(2), answerList.get(2), correctAnswerList.get(2)),
                QuestionFragment.newInstance(questionList.get(3), answerList.get(3), correctAnswerList.get(3)),
                QuestionFragment.newInstance(questionList.get(4), answerList.get(4), correctAnswerList.get(4))};
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
