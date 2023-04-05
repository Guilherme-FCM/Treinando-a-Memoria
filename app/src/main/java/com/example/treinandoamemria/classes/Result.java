package com.example.treinandoamemria.classes;

public class Result {
    private String answer;
    private String correct;

    public Result(String answer, String correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return this.answer.equals(this.correct);
    }
}
