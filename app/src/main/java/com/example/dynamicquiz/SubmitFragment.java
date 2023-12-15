package com.example.dynamicquiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SubmitFragment extends Fragment {
    public SubmitFragment() {
        // Required empty public constructor
    }

    public static SubmitFragment newInstance() {
        SubmitFragment fragment = new SubmitFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frameLayout = inflater.inflate(R.layout.fragment_submit, container, false);
        Button submitButton = frameLayout.findViewById(R.id.submitQuiz);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStatistics();
            }
        });
        return frameLayout;
    }

    private void showStatistics() {
        Intent intent = new Intent(getActivity(), StatisticsActivity.class);
        startActivity(intent);
    }
}