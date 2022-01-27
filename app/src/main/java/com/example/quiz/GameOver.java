package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView gameOverText;
    Button playAgainBtn;
    Button mainMenuGameOver;
    int totalCorrect, totalQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_screen);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totalCorrect = extras.getInt("TotalCorrect");
            totalQuestions = extras.getInt("TotalQuestions");
            //The key argument here must match that used in the other activity
        }
        // View member variables of game_over_screen
        gameOverText = findViewById(R.id.tv_game_over_text);
        playAgainBtn = findViewById(R.id.btn_game_over_play_again);
        mainMenuGameOver = findViewById(R.id.btn_game_over_main_menu);

        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mainMenuGameOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOver.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        String message = getGameOverMessage(totalCorrect,totalQuestions);
        gameOverText.setText(message);



    }

    public String getGameOverMessage(int totalCorrect, int totalQuestions){
        if(totalCorrect==totalQuestions)
            return String.format("You got all %s right! You won!", totalQuestions);
        return String.format("You got %s right out of %s. Better luck next time!", totalCorrect, totalQuestions);
    }



}
