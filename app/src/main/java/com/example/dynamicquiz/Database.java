package com.example.dynamicquiz;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Database {
    //Constructor
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public Database(){
        FirebaseFirestore db = this.db;
    }

    public static Question[] questions = new Question[5];

    //
    public static List<String> questionList = new ArrayList<>();
    public static List<String[]> answerList = new ArrayList<>();
    public static List<String> correctAnswerList = new ArrayList<>();
    //

    public String question;
    public String answer[] = new String[5];
    public String correctAnswer;

    public void insertData(){
        // Create a new user with a first and last name
        Map<String, Object> question = new HashMap<>();
        question.put("Question5", "What does API stand for in the context of mobile app development?");
        question.put("Q5A1", "Application Programming Interface");
        question.put("Q5A2", "Advanced Programming Interface");
        question.put("Q5A3", "Automated Program Interaction");
        question.put("Q5A4", "App Processing Interface");
        question.put("Q5A5", "Android Programming Instruction");
        question.put("Q5CA", "Q5A1");

        // Add a new document with a generated ID
        db.collection("questions")
                .add(question)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("FIREBASE_TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("FIREBASE_TAG", "Error adding document", e);
                    }
                });
    }

    public void fetchData(){
        AtomicInteger i = new AtomicInteger(1);
        db.collection("questions")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            if(i.get() <= 5){
                                question = document.getString("Question" + i);
                                answer[0] = document.getString("Q" + i + "A1");
                                answer[1] = document.getString("Q" + i + "A2");
                                answer[2] = document.getString("Q" + i + "A3");
                                answer[3] = document.getString("Q" + i + "A4");
                                answer[4] = document.getString("Q" + i + "A5");
                                correctAnswer = document.getString("Q" + i + "CA");
                                //questions[i.get() - 1] = new Question(question, answer, correctAnswer);
                                questionList.add(i.get() - 1, question);
                                //Test
                                System.out.println("Question: " + question);
                                //
                                answerList.add(i.get() - 1, answer);
                                correctAnswerList.add(i.get() - 1, correctAnswer);
                                //
                                i.getAndIncrement();
                                Log.d("FIREBASE_TAG", document.getId() + document.getString("questions"));
                            }
                        }
                    } else {
                        Log.w("FIREBASE_TAG", "Error getting documents.", task.getException());
                    }
                });
    }
}
