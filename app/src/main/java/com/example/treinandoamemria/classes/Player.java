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

    public int getSigno() {
//        String signo = "";
//        switch(this.birthYear) {
//            case 1:
//                signo = (this.birthDay >= 20) ? "Aquário" : "Capricórnio";
//                break;
//            case 2:
//                signo = (this.birthDay >= 19) ? "Peixes" : "Aquário";
//                break;
//            case 3:
//                signo = (this.birthDay >= 21) ? "Áries" : "Peixes";
//                break;
//            case 4:
//                signo = (this.birthDay >= 20) ? "Touro" : "Áries";
//                break;
//            case 5:
//                signo = (this.birthDay >= 21) ? "Gêmeos" : "Touro";
//                break;
//            case 6:
//                signo = (this.birthDay >= 22) ? "Câncer" : "Gêmeos";
//                break;
//            case 7:
//                signo = (this.birthDay >= 23) ? "Leão" : "Câncer";
//                break;
//            case 8:
//                signo = (this.birthDay >= 23) ? "Virgem" : "Leão";
//                break;
//            case 9:
//                signo = (this.birthDay >= 23) ? "Libra" : "Virgem";
//                break;
//            case 10:
//                signo = (this.birthDay >= 23) ? "Escorpião" : "Libra";
//                break;
//            case 11:
//                signo = (this.birthDay >= 22) ? "Sagitário" : "Escorpião";
//                break;
//            case 12:
//                signo = (this.birthDay >= 22) ? "Capricórnio" : "Sagitário";
//                break;
//            default:
//                signo = "Mês de nascimento inválido";
//        }
//        return signo;
        int[] limits = {20, 19, 20, 20, 21, 21, 22, 23, 23, 23, 22, 22};
        int positionSigno = this.birthMonth - 1;
        if (this.birthDay >= limits[positionSigno]) {
            positionSigno = (positionSigno + 1) % 12;
        }
        return positionSigno;
    }
}
