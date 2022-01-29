package com.example.quiz;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Question {
    private final int correctAnswer;
    private int playersAnswer;
    private int imageId;
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    public static int numberQuestion=2;
    public static int totalQuestions=3;
    public static int totalCorrect;

    public Question(int imageId, String questionText, String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
        this.imageId = imageId;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.playersAnswer = -1;
    }


    public boolean isCorrect(){
        numberQuestion++;
        if (this.correctAnswer == this.playersAnswer){
            totalCorrect++;
            return true;
        }
        return false;
    }

    public boolean gameIsFinished(){
        return numberQuestion == totalQuestions + 1;
    }

    public boolean playerAnswered() {
        return playersAnswer != -1;
    }

    public void selectingButton(Button btn1, Button btn2, Button btn3, Button btn4, int i){
        playersAnswer=i;
        resetButtonText(btn1, btn2, btn3, btn4);
        changeButtonText(btn1, btn2, btn3, btn4,i);
    }

    private void resetButtonText(Button btn1, Button btn2, Button btn3, Button btn4){
        btn1.setText(this.answer1);
        btn2.setText(this.answer2);
        btn3.setText(this.answer3);
        btn4.setText(this.answer4);
    }
    private void changeButtonText(Button btn1, Button btn2, Button btn3, Button btn4, int i){
        if(i==1)
            btn1.setText("✔ " + this.answer1);
        if(i==2)
            btn2.setText("✔ " + this.answer2);
        if(i==3)
            btn3.setText("✔ " + this.answer3);
        if(i==4)
            btn4.setText("✔ " + this.answer4);

    }

    public void displayQuestion(TextView text, ImageView image, Button btn1, Button btn2, Button btn3, Button btn4){
        text.setText(questionText);
        image.setImageResource(imageId);
        //TODO do a random answer selector
        resetButtonText(btn1, btn2, btn3, btn4);
    }

}
