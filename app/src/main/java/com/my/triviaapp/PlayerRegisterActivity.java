package com.my.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.my.triviaapp.database.AppDatabase;
import com.my.triviaapp.database.QuizGame;

public class PlayerRegisterActivity extends AppCompatActivity {
Button playerBtn;
EditText playerNameEdt;
AppDatabase database;
AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_register);

        playerNameEdt = findViewById(R.id.player_name_edt);
        playerBtn = findViewById(R.id.player_name_btn);
        database = AppDatabase.getInstance(getApplicationContext());

        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    AnswerHolder.PLAYER_NAME = playerNameEdt.getText().toString();
                    startActivity(new Intent(PlayerRegisterActivity.this,CricketerQuestionActivity.class));
                }
            }
        });


        // add validation to input field
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.player_name_edt, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);


    }
}
