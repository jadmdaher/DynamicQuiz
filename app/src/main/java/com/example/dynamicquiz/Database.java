package com.example.dynamicquiz;

import android.util.Log;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Database {
    //Constructor
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public Database() {
        FirebaseFirestore db = this.db;
    }

//    public static Question[] questions = new Question[5];

    //
    public static List<String> questionList = new ArrayList<>();
    public static List<String[]> answerList = new ArrayList<>();
    public static List<String> correctAnswerList = new ArrayList<>();

    public void writeData() {
        // Create a new user with a first and last name
        CollectionReference questions = db.collection("questions");

        Map<String, Object> question1 = new HashMap<>();
        question1.put("Question1", "What is the name of the programming language used to develop Android apps?");
        question1.put("Q1A1", "Java");
        question1.put("Q1A2", "JavaScript");
        question1.put("Q1A3", "Python");
        question1.put("Q1A4", "C++");
        question1.put("Q1A5", "C#");
        question1.put("Q1CA", "Q1A1");
        questions.document("Question1").set(question1);
        Log.d("FIREBASE_TAG", "DocumentSnapshot added with ID: " + questions.document("Question1").getId());

        Map<String, Object> question2 = new HashMap<>();
        question2.put("Question2", "What is the name of the integrated development environment (IDE) used to develop Android apps?");
        question2.put("Q2A1", "Android Studio");
        question2.put("Q2A2", "Eclipse");
        question2.put("Q2A3", "IntelliJ IDEA");
        question2.put("Q2A4", "Visual Studio");
        question2.put("Q2A5", "NetBeans");
        question2.put("Q2CA", "Q2A1");
        questions.document("Question2").set(question2);
        Log.d("FIREBASE_TAG", "DocumentSnapshot added with ID: " + questions.document("Question2").getId());

        Map<String, Object> question3 = new HashMap<>();
        question3.put("Question3", "What is the name of the programming language used to develop iOS apps?");
        question3.put("Q3A1", "Swift");
        question3.put("Q3A2", "Objective-C");
        question3.put("Q3A3", "Python");
        question3.put("Q3A4", "C++");
        question3.put("Q3A5", "C#");
        question3.put("Q3CA", "Q3A1");
        questions.document("Question3").set(question3);
        Log.d("FIREBASE_TAG", "DocumentSnapshot added with ID: " + questions.document("Question3").getId());

        Map<String, Object> question4 = new HashMap<>();
        question4.put("Question4", "What is the name of the integrated development environment (IDE) used to develop iOS apps?");
        question4.put("Q4A1", "Xcode");
        question4.put("Q4A2", "Eclipse");
        question4.put("Q4A3", "IntelliJ IDEA");
        question4.put("Q4A4", "Visual Studio");
        question4.put("Q4A5", "NetBeans");
        question4.put("Q4CA", "Q4A1");
        questions.document("Question4").set(question4);
        Log.d("FIREBASE_TAG", "DocumentSnapshot added with ID: " + questions.document("Question4").getId());

        Map<String, Object> question5 = new HashMap<>();
        question5.put("Question5", "What does API stand for in the context of mobile app development?");
        question5.put("Q5A1", "Application Programming Interface");
        question5.put("Q5A2", "Advanced Programming Interface");
        question5.put("Q5A3", "Automated Program Interaction");
        question5.put("Q5A4", "App Processing Interface");
        question5.put("Q5A5", "Android Programming Instruction");
        question5.put("Q5CA", "Q5A1");
        questions.document("Question5").set(question5);
        Log.d("FIREBASE_TAG", "DocumentSnapshot added with ID: " + questions.document("Question5").getId());
    }

//    public void readData(){
//        AtomicInteger i = new AtomicInteger(1);
//        db.collection("questions")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            if(i.get() <= 5){
//
//
////                                question = document.getString("Question" + i);
////                                answer[0] = document.getString("Q" + i + "A1");
////                                answer[1] = document.getString("Q" + i + "A2");
////                                answer[2] = document.getString("Q" + i + "A3");
////                                answer[3] = document.getString("Q" + i + "A4");
////                                answer[4] = document.getString("Q" + i + "A5");
////                                correctAnswer = document.getString("Q" + i + "CA");
////                                //questions[i.get() - 1] = new Question(question, answer, correctAnswer);
////                                questionList.add(i.get() - 1, question);
////                                //Test
////                                System.out.println("Question: " + question);
////                                //
////                                answerList.add(i.get() - 1, answer);
////                                correctAnswerList.add(i.get() - 1, correctAnswer);
//                                //
//                                i.getAndIncrement();
//                                Log.d("FIREBASE_TAG", document.getId() + document.getString("questions"));
//                            }
//                        }
//                    } else {
//                        Log.w("FIREBASE_TAG", "Error getting documents.", task.getException());
//                    }
//                });
//    }

    public Question[] readData() {
        Question questionsArray[] = new Question[5];
        AtomicInteger i = new AtomicInteger(1);
        db.collection("questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if(i.get() <= 5){
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    questionsArray[i.get() - 1] = new Question(document.getString("Question" + i),
                                            new String[]{document.getString("Q" + i + "A1"),
                                                    document.getString("Q" + i + "A2"),
                                                    document.getString("Q" + i + "A3"),
                                                    document.getString("Q" + i + "A4"),
                                                    document.getString("Q" + i + "A5")},
                                            document.getString("Q" + i + "CA"));
                                    i.getAndIncrement();
                                    Log.d("FIREBASE_TAG", document.getId() + " => " + document.getData());
                                }
                            }
                        } else {
                            Log.w("FIREBASE_TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
        return questionsArray;
    }

//    public Question getDocumentAsQuestion(String documentID){
//        DocumentReference docRef = db.collection("cities").document(documentID);
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Question question = documentSnapshot.toObject(Question.class);
//            }
//        });
//        return
//    }
}
