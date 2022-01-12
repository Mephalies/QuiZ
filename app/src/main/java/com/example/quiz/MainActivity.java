package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int currentQuestionIndex, totalCorrect, totalQuestions;
    ArrayList<Question> questions;
    void startNewGame(){
        currentQuestionIndex=0;
        totalCorrect=0;
        Question question1 = new Question(1, "What's my name?1", "dog", "dogitto", "small doggin", ":3", 3);
        Question question2 = new Question(1, "What's my name?2", "dog", "dogitto", "small doggin", ":3", 2);
        Question question3 = new Question(1, "What's my name?3", "dog", "dogitto", "small doggin", ":3", 1);
        questions= new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        totalQuestions= questions.size();
        Question firstQuestion = chooseNewQuestion();
        Question secondQuestion = chooseNewQuestion();
        Question thirdQuestion = chooseNewQuestion();
        // displayQuestion(firstQuestion);
        // displayQuestionsRemaining(questions.size());
    }
    public  Question chooseNewQuestion(){
        currentQuestionIndex=generateRandomNumber(totalQuestions);
        return questions.get(currentQuestionIndex);
    }
    public Question getCurrentQuestion(){
        return questions.get(currentQuestionIndex);
    }
    public void onAnswersSubmission(){
        Question answer= getCurrentQuestion();
        if(answer.playersAnswer==answer.correctAnswer)
            totalCorrect++;
        questions.remove(answer);
        // displayQuestionsRemaining(questions.size());
        if(currentQuestionIndex==totalQuestions) {
            System.out.println("game over");
            startNewGame();
            // TODO: uncomment after implementing displayQuestion()
            // displayQuestion(getCurrentQuestion());

        }


    }

    public int generateRandomNumber(int max){
        double randomNum=Math.random()*max;
        return (int) randomNum;
    }

    public String getGameOverMessage(int totalCorrect, int totalQuestions){
        if(totalCorrect==totalQuestions)
            return String.format("You got all %s right! You won!", totalQuestions);
        return String.format("You got %s right out of %s. Better luck next time!", totalCorrect, totalQuestions);
    }


}


