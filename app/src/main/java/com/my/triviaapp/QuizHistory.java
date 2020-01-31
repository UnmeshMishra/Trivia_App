package com.my.triviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.my.triviaapp.adapters.QuizHistoryAdapter;
import com.my.triviaapp.database.AppDatabase;
import com.my.triviaapp.database.QuizGame;

import java.util.ArrayList;
import java.util.List;

public class QuizHistory extends AppCompatActivity {

    List<QuizGame> gameList = new ArrayList<>();
    RecyclerView recyclerView;
    QuizHistoryAdapter quizHistoryAdapter;
    AppDatabase database;

    TextView emptyTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_history);

        recyclerView = findViewById(R.id.quiz_history_recyclerview);
        database = AppDatabase.getInstance(getApplicationContext());

        gameList = database.quizDao().getQuizGameList();
        quizHistoryAdapter = new QuizHistoryAdapter(this,gameList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emptyTxt = findViewById(R.id.empty_txt);

        if (gameList.size()>0){
            recyclerView.setAdapter(quizHistoryAdapter);
        }
        else{
         emptyTxt.setText(getResources().getString(R.string.no_records));
        }


    }
}
