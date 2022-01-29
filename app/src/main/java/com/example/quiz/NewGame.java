package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class NewGame extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int currentQuestionIndex, totalCorrect,counter;
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
        setContentView(R.layout.new_game);


        // View member variables of activity_main
        questionImageView = findViewById(R.id.iv_main_quiz_image);
        questionTextView = findViewById(R.id.tv_main_quiz_questions);
        questionRemainingTextView= findViewById(R.id.tv_main_questions_out_of);
        answer1Button = findViewById(R.id.btn_main_question_1);
        answer2Button = findViewById(R.id.btn_main_question_2);
        answer3Button = findViewById(R.id.btn_main_question_3);
        answer4Button = findViewById(R.id.btn_main_question_4);
        submitButton = findViewById(R.id.btn_main_submit_button);

        // set ups 4 main buttons
        setClick();

        // onClickListener for the submit answer Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswersSubmission();
            }
        });

        //Starts game
        startNewGame();
    }

    // Displays image, question and answers
    void displayQuestion(Question question){
        question.displayQuestion(questionTextView,questionImageView,answer1Button,answer2Button,answer3Button,answer4Button);
    }

    // Sets text of remaining questions
    void displayQuestionsRemaining(){
        questionRemainingTextView.setText(Question.numberQuestion +"/"+ Question.totalQuestions);
    }


    void startNewGame(){
        //initializing
        questions= new ArrayList<>();
        //Resetting for new game
        counter=1;
        Question.totalCorrect=0;
        Question.numberQuestion=1;
        currentQuestionIndex=0;



        // Creates each question
        Question question1 = new Question(R.drawable.anime1, "What's the name of the Anime?", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 3);
        Question question2 = new Question(R.drawable.anime2, "What's the name of the Anime?", "Naruto", "Full metal Alchemist", "Promissed Neverland", "My hero Academia", 2);
        Question question3 = new Question(R.drawable.anime3, "What's the name of the Anime?", "Sailor Moon", "One Piece", "Promissed Neverland", "My hero Academia", 1);
        Question question4 = new Question(R.drawable.anime4, "What's the name of the Anime?", "Naruto", "One Piece", "Attack on Titan", "My hero Academia", 3);
        Question question5 = new Question(R.drawable.anime5, "What's the name of the Anime?", "Naruto", "Death Note", "Promissed Neverland", "My hero Academia", 2);
        Question question6 = new Question(R.drawable.anime6, "What's the name of the Anime?", "Naruto", "One Piece", "Promissed Neverland", "My hero Academia", 4);


        //add all questions to list
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);

        // TODO check size of all answers to change the size of box of all if needed
        //checkSizeOfAnswers(questions);

        //TODO update description of each picture
        Question firstQuestion = chooseNewQuestion();


        // gets number of question an updates it on screen
        displayQuestionsRemaining();

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



    //After user submits answer everything gets updated
    public void onAnswersSubmission(){
        Question answer = getCurrentQuestion();

        answer.isCorrect();//check if answer is correct
        if(!answer.playerAnswered()) // checks if player choose any options
            return;

        questions.remove(answer);

        if(answer.gameIsFinished()) {
            Intent myIntent = new Intent(NewGame.this, GameOver.class);
            myIntent.putExtra("TotalQuestions", Question.totalQuestions);
            myIntent.putExtra("TotalCorrect", Question.totalCorrect);
            startActivity(myIntent);
            (new Handler()).postDelayed(this::startNewGame, 200);

        }
        else{
            // updates number of questions remaining
            displayQuestionsRemaining();
            // randomly chooses new question
            chooseNewQuestion();
            // updates question
            displayQuestion(getCurrentQuestion());
        }

    }

    //Generates a Random Number
    public int generateRandomNumber(int max){
        double randomNum=Math.random()*max;
        return (int) randomNum;
    }

    // adds a ✔ to represent the selected button
    void onAnswerSelected(int answerSelected){
        Question current =getCurrentQuestion();
        current.selectingButton(answer1Button, answer2Button, answer3Button, answer4Button,answerSelected);
    }

    // Sets the 4 buttons for choice uses OnAnswerSelected
    public void setClick(){
        // onClickListener for each answer Button
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(1);
            }});

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(2);
            }});

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(3);
            }});

        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(4);
            }});

    }







}


