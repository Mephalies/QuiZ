package com.example.quiz;

public class Question {
    public boolean getPlayersAnswer;
    private int correctAnswer;
    private int playersAnswer;
    private int imageId;
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int totalQuestions;
    private int numberQuestion;



    public Question(int imageId, String questionText, String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
        this.imageId = imageId;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.playersAnswer = -1;
        this.totalQuestions=3;
        this.setNumberQuestion(1);
    }

    public boolean isCorrect(){
        return this.correctAnswer == this.playersAnswer;
    }

    public boolean isFinished(){
        return getNumberQuestion() == totalQuestions + 1;
    }

    public boolean playerAnswered() {
        return playersAnswer != -1;
    }

    private int getCorrectAnswer() {
        return correctAnswer;
    }
    private void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    private int getPlayersAnswer() {
        return playersAnswer;
    }

    public void setPlayersAnswer(int playersAnswer) {
        this.playersAnswer = playersAnswer;
    }

    public int getImageId() {
        return imageId;
    }

    private void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getQuestionText() {
        return questionText;
    }

    private void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    private void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    private void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    private void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    private void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    private void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }
}
