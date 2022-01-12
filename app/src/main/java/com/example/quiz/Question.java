package com.example.quiz;

public class Question {
    int correctAnswer, playersAnswer, imageId;
    String questionText, answer0, answer1, answer2, answer3;


    // Question question1 = new Question(1, "What's my name?", "dog", "dogitto", "small doggin", ":3", 3);

    public Question(int imageId, String questionText, String answer0, String answer1, String answer2, String answer3, int correctAnswer) {
        this.imageId = imageId;
        this.questionText = questionText;
        this.answer0 = answer0;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
        this.playersAnswer=-1;
    }

    boolean isCorrect(){
        return this.correctAnswer == this.playersAnswer;
    }
}
