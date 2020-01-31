package com.my.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.my.triviaapp.database.AppDatabase;
import com.my.triviaapp.database.QuizGame;

import java.util.Date;

public class FinalActivity extends AppCompatActivity {

    Button finishBtn,historyBtn;
    AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        finishBtn = findViewById(R.id.finish_btn);
        historyBtn = findViewById(R.id.history_btn);

        database = AppDatabase.getInstance(getApplicationContext());

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.quizDao().insertQuizgame(new QuizGame(
                        AnswerHolder.PLAYER_NAME,
                        AnswerHolder.FAV_CRICKETER,
                        AnswerHolder.FLAG_COLORS,
                        new Date()
                        ));

                finishAffinity();

                startActivity(new Intent(getApplicationContext(),PlayerRegisterActivity.class));

            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalActivity.this,QuizHistory.class));
            }
        });

    }
}
