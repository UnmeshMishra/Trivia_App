package com.my.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.my.triviaapp.database.AppDatabase;

public class FlagQuestionActivity extends AppCompatActivity {
    LinearLayout flagAnswerLayout;
    Button whiteBtn,yellowBtn,orangeBtn,greenBtn;
    Button submitBtn, nextBtn;
    Integer SELECTED_PLAYER_POS = null;
    AppDatabase database;

    //cricketer's position as per their sequence in the lin layout
    int WHITE=0,YELLOW=1,ORANGE=2,GREEN=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_question);

        flagAnswerLayout = findViewById(R.id.flag_answer_layout);
        whiteBtn = findViewById(R.id.white_btn);
        yellowBtn = findViewById(R.id.yellow_btn);
        orangeBtn = findViewById(R.id.orange_btn);
        greenBtn = findViewById(R.id.green_btn);
        nextBtn = findViewById(R.id.next_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitColor();
            }
        });

        whiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorClicked(WHITE);
            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorClicked(YELLOW);
            }
        });

        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorClicked(ORANGE);
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorClicked(GREEN);
            }
        });
    }



    public void colorClicked(int pos){

        Button colorClickedBtn = (Button) flagAnswerLayout.getChildAt(pos);

        Drawable selectedDrawable,unselectedDrawable;

        selectedDrawable = getResources().getDrawable(R.drawable.btn_selected);
        unselectedDrawable = getResources().getDrawable(R.drawable.btn_unselected);


        Drawable colorClickedDrawable = colorClickedBtn.getBackground();


       if (colorClickedDrawable.getConstantState() == selectedDrawable.getConstantState()){
           colorClickedBtn.setBackground(getResources().getDrawable(R.drawable.btn_unselected));
           Log.e("COLOR_CLICKED","set to green");
       }

       if (colorClickedDrawable.getConstantState() == unselectedDrawable.getConstantState()){
           colorClickedBtn.setBackground(getResources().getDrawable(R.drawable.btn_selected));
           Log.e("COLOR_CLICKED","set to orange");
       }

    }


    public void submitColor(){

        String chosenColors ="";

        for (int i=0;i<flagAnswerLayout.getChildCount();i++){

            Button eachColorBtn = (Button) flagAnswerLayout.getChildAt(i);

            if (eachColorBtn.getBackground().getConstantState() == getResources()
                    .getDrawable(R.drawable.btn_selected).getConstantState())
            chosenColors += eachColorBtn.getText().toString()+" ";
            Log.e("CHOSEN_COLORS",chosenColors);
        }

        chosenColors = chosenColors.trim();
        chosenColors = chosenColors.replace(" ",", ");

        Log.e("CHOSEN_COLORS",chosenColors);

        AnswerHolder.FLAG_COLORS = chosenColors;
        startActivity(new Intent(this,FinalActivity.class));

    }


}
