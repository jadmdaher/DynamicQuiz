package com.example.dynamicquiz;

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
        fragmentHeader = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        fragment = new QuestionFragment[]{QuestionFragment.newInstance(db.question, db.answer, db.correctAnswer),
                QuestionFragment.newInstance(db.question, db.answer, db.correctAnswer),
                QuestionFragment.newInstance(db.question, db.answer, db.correctAnswer),
                QuestionFragment.newInstance(db.question, db.answer, db.correctAnswer),
                QuestionFragment.newInstance(db.question, db.answer, db.correctAnswer)};
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
