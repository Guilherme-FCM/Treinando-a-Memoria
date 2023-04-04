package com.example.treinandoamemria.classes;

import java.io.Serializable;
import java.util.Calendar;

public class Player implements Serializable {
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private double score;

    public Player(String name, int birthDay, int birthMonth, int birthYear) {
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public double getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getAge() {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        return anoAtual - this.birthYear;
    }

    public void incrementScore(double value) {
        this.score += value;
    }
}
