package com.my.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.my.triviaapp.R;
import com.my.triviaapp.database.AppDatabase;
import com.my.triviaapp.database.QuizGame;

public class CricketerQuestionActivity extends AppCompatActivity {

    LinearLayout cricketerAnswerLayout;
    Button sachinBtn,jacquesBtn,gillChristBtn,viratBtn;
    Button nextBtn;
    Integer SELECTED_PLAYER_POS = null;
    AppDatabase database;

    //cricketer's position as per their sequence in the lin layout
    int SACHIN=0,VIRAT=1,ADAMGILL=2,JACQUES=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketer_question);

        database = AppDatabase.getInstance(getApplicationContext());

        initViews();


    }


    public void initViews(){
        cricketerAnswerLayout = findViewById(R.id.cricketer_answer_layout);
        sachinBtn = findViewById(R.id.sachin_btn);
        jacquesBtn = findViewById(R.id.jacques_btn);
        gillChristBtn = findViewById(R.id.adam_btn);
        viratBtn = findViewById(R.id.virat_btn);

        nextBtn = findViewById(R.id.next_btn);

        sachinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // method call with cricketer's position in the layout
                cricketerClicked(SACHIN);
            }
        });

        viratBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // method call with cricketer's position in the layout
                cricketerClicked(VIRAT);
            }
        });

        jacquesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // method call with cricketer's position in the layout
                cricketerClicked(JACQUES);
            }
        });

        gillChristBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // method call with cricketer's position in the layout
                cricketerClicked(ADAMGILL);
            }
        });



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedCricketPlayer();
            }
        });



    }


    public synchronized void cricketerClicked(int pos){

        // obtains clicked button by it's position in the layout
        Button answerBtn = (Button)cricketerAnswerLayout.getChildAt(pos);

       for (int i=0;i<cricketerAnswerLayout.getChildCount();i++)
       {
           Button eachBtnInLayout = (Button) cricketerAnswerLayout.getChildAt(i);
           // set unselected buttons with different green color
           eachBtnInLayout.setBackground(getResources().getDrawable(R.drawable.btn_unselected));
       }

       // highlight selected answer
       answerBtn.setBackground(getResources().getDrawable(R.drawable.btn_selected));

       SELECTED_PLAYER_POS = pos;

    }


    public synchronized void selectedCricketPlayer(){

        if (SELECTED_PLAYER_POS != null){

            Button selectedPlayer = (Button) cricketerAnswerLayout.getChildAt(SELECTED_PLAYER_POS);
            String favCricketer = selectedPlayer.getText().toString();
            AnswerHolder.FAV_CRICKETER = favCricketer;

            startActivity(new Intent(CricketerQuestionActivity.this,FlagQuestionActivity.class));
        }

        else {

            AnswerHolder.FAV_CRICKETER = "";
            startActivity(new Intent(CricketerQuestionActivity.this,FlagQuestionActivity.class));
        }
    }


}
