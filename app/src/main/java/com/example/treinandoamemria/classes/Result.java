package com.example.treinandoamemria.classes;

public class Result {
    private String signo;
    private boolean correct;

    public Result(String signo, boolean correct) {
        this.signo = signo;
        this.correct = correct;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
