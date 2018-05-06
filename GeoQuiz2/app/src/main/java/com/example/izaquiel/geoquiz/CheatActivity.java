package com.example.izaquiel.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheatActivity extends AppCompatActivity {

	private static final String extra_answer_is_true;

	private TextView answerTextView;
	private Button bShowAnswer;

	private boolean answerIsTrue;
	
	
	public static Intent newIntent(QuizActivity qa, boolean answerIsTrue){
		Intent intent = new Intent(qa, CheatActivity.class);
		
		intent.putExtra(extra_answer_is_true, answerIsTrue);
		
		return intent;
	}

	//public boolean getExtraBoolean(String nome, boolean padron){  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

//answerIsTrue = getIntent.getExtraBoolean(extra_answer_is_true, false);

		answerTextView = (TextView) findViewById(R.id.answer_text_view);

		bShowAnswer = (Button) findViewById(R.id.show_answer_button);
		
		answerIsTrue.setOnClickListener(new View.OnClickListener() {
            @Override
		public void onClick(View view) {
			
			if (answerIsTrue){
				answerTextView.setText(R.string.t_correto);
			}else{
				answerTextView.setText(R.string.t_incorreto);
			}
			
		}
		
		});

	}
	
	   }
}
