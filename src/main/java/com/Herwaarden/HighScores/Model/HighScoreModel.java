package com.Herwaarden.HighScores.Model;

public class HighScoreModel {

    public String name;
    public int power;

    public HighScoreModel() {
    }

    public HighScoreModel(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
