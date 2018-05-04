package com.example.izaquiel.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button bTrue;
    private Button bFalse;
    private Button bNext;
    private Button bBack;
    private TextView questionTextView;
    private int currentIndex =0;

    //Questões estão aqui!!!
    Question[] questionBank= new Question[]{
            new Question(R.string.question1, false),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        bBack = (Button) findViewById(R.id.backbuttonId);
        bTrue = (Button) findViewById(R.id.Btrue);
        bFalse = (Button) findViewById(R.id.Bfalse);
        bNext = (Button) findViewById(R.id.nextbuttonId);
        questionTextView = (TextView) findViewById(R.id.textviewid);

        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex+1)%questionBank.length;
                updateQuestion();
            }
        });

        bTrue.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        bFalse.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        //Seta a questão atual!
        updateQuestion();

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex+1)%questionBank.length;
                updateQuestion();
            }

        });
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 0){
                    CurrentIndex = questionBank.hashCode();
                }

                currentIndex = (currentIndex-1)%questionBank.length;
                updateQuestion();

            }
        });
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();
        int messageId = (answerIsTrue==userPressedTrue)?
                R.string.t_correto:
                R.string.t_incorreto;
        Toast.makeText(this, messageId,  Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion(){
        int question = questionBank[currentIndex] .getIdTextRes();
        questionTextView.setText(question);
    }
}