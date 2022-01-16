package com.example.quiz;

public class Question {
    int correctAnswer, playersAnswer, imageId;
    String questionText, answer1, answer2, answer3, answer4;



    public Question(int imageId, String questionText, String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
        this.imageId = imageId;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.playersAnswer=-1;
    }

    boolean isCorrect(){
        return this.correctAnswer == this.playersAnswer;
    }
}
