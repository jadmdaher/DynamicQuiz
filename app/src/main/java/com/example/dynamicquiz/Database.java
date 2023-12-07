package com.example.dynamicquiz;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.HashMap;
import java.util.Map;

public class Database {
    //Constructor
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public Database(){
        FirebaseFirestore db = this.db;
    }

    public String question;
    public String answer[] = new String[5];
    public String correctAnswer;


    public void insertData(){
        // Create a new user with a first and last name
        Map<String, Object> question = new HashMap<>();
        question.put("Question2", "Which programming language is commonly used for native Android app development?");
        question.put("Answer1", "Swift");
        question.put("Answer2", "Java");
        question.put("Answer3", "Python");
        question.put("Answer4", " C#");
        question.put("Answer5", "Ruby");
        question.put("CorrectAnswer", "Answer2");

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
        db.collection("questions")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            question = document.getString("Question1");
                            answer[0] = document.getString("Answer1");
                            answer[1] = document.getString("Answer2");
                            answer[2] = document.getString("Answer3");
                            answer[3] = document.getString("Answer4");
                            answer[4] = document.getString("Answer5");
                            correctAnswer = document.getString("CorrectAnswer");
                            Log.d("FIREBASE_TAG", document.getId() + document.getString("questions"));
                        }
                    } else {
                        Log.w("FIREBASE_TAG", "Error getting documents.", task.getException());
                    }
                });
    }
}
