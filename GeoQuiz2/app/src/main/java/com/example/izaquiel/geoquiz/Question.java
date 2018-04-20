package com.example.izaquiel.geoquiz;

/**
 * Created by Izaquiel on 07/03/2018.
 */

public class Question {
private int idTextRes;
private boolean answerTrue;

Question(int idtext, boolean answertrue){
    this.idTextRes = idtext;
    this.answerTrue = answertrue;
}
    public int getIdTextRes() {
        return idTextRes;
    }

    public void setIdTextRes(int idTextRes) {
        this.idTextRes = idTextRes;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
