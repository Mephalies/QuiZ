package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    int currentQuestionIndex, totalCorrect, totalQuestions;
    ArrayList<Question> questions;

    ImageView questionImageView;
    TextView questionTextView;
    TextView questionRemainingTextView;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button answer4Button;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        
        //logo in action bar if activated
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);*/
        Log.d(TAG,"nenter");

        setContentView(R.layout.activity_main);

        // View member variables
        questionImageView = findViewById(R.id.iv_main_quiz_image);
        questionTextView = findViewById(R.id.tv_main_quiz_questions);
        questionRemainingTextView= findViewById(R.id.tv_main_number_questions_remaining);
        answer1Button = findViewById(R.id.btn_main_question_1);
        answer2Button = findViewById(R.id.btn_main_question_2);
        answer3Button = findViewById(R.id.btn_main_question_3);
        answer4Button = findViewById(R.id.btn_main_question_4);
        submitButton = findViewById(R.id.btn_main_submit_button);

        // onClickListener for each answer Button
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(1);
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(2);
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(3);
            }
        });
        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(4);
            }
        });

        // onClickListener for the submit answer Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onAnswersSubmission();
            }
        });

        startNewGame();
    }

    // Displays image, question and answers
        void displayQuestion(Question question){
        questionTextView.setText(question.questionText);
        questionImageView.setImageResource(question.imageId);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);
        answer4Button.setText(question.answer4);
        }

    // Sets text of remaining questions
    void displayQuestionsRemaining(int questionRemaining){
       Log.d(TAG, String.valueOf(questionRemaining));
        questionRemainingTextView.setText(String.valueOf(questionRemaining));
    }

    // Checks if answer is correct
    @SuppressLint("SetTextI18n")
    void onAnswerSelected(int answerSelected){
        Question current =getCurrentQuestion();
        current.playersAnswer=answerSelected;
        answer1Button.setText(current.answer1);
        answer2Button.setText(current.answer2);
        answer3Button.setText(current.answer3);
        answer4Button.setText(current.answer4);
        if(answerSelected==1)
            answer1Button.setText("✔ " + current.answer1);
        else if(answerSelected==2)
            answer2Button.setText("✔ " + current.answer2);
        else if(answerSelected==3)
            answer3Button.setText("✔ " + current.answer3);
        else
            answer4Button.setText("✔ " + current.answer4);

    }

    void startNewGame(){
        questions= new ArrayList<>();
        currentQuestionIndex=0;

        // Amount of questions in game
        totalQuestions= 3;


        // Creates each question
        Question question1 = new Question(R.drawable.anime1, "What's the name of the Anime1", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 3);
        Question question2 = new Question(R.drawable.anime1, "What's the name of the Anime2", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 2);
        Question question3 = new Question(R.drawable.anime1, "What's the name of the Anime3", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 1);
        Question question4 = new Question(R.drawable.anime1, "What's the name of the Anime4", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 3);
        Question question5 = new Question(R.drawable.anime1, "What's the name of the Anime5", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 2);
        Question question6 = new Question(R.drawable.anime1, "What's the name of the Anime6", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 1);


        //add all questions to list
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);

        // TODO check size of all answers to change the size of box of all if needed
        //checkSizeOfAnswers(questions);


        //initializing
        totalCorrect=0;
        Question firstQuestion = chooseNewQuestion();


        // gets number of question an updates it on screen
        displayQuestionsRemaining(totalQuestions);

        // displays Question
        displayQuestion(firstQuestion);
    }



    // uses the random class to choose a random question
    public  Question chooseNewQuestion(){
        currentQuestionIndex=generateRandomNumber(questions.size());
        return questions.get(currentQuestionIndex);
    }

    //gets current question
    public Question getCurrentQuestion(){
        return questions.get(currentQuestionIndex);
    }

    //After user submits answer everything gets upadated
    public void onAnswersSubmission(){
        Question answer= getCurrentQuestion();
        if(answer.playersAnswer==answer.correctAnswer)
            totalCorrect++;
        else if(answer.playersAnswer==-1)
            return;
        questions.remove(answer);
        totalQuestions--;

        // updates number of questions remaining
        displayQuestionsRemaining(totalQuestions);
        if(totalQuestions == 0) {
            // TODO 5-D: Show a new window
            Log.d(TAG, "Game Over");
            startNewGame();


        }
        else{
            // randomly chooses new question
            chooseNewQuestion();
            // updates question
            displayQuestion(getCurrentQuestion());
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


